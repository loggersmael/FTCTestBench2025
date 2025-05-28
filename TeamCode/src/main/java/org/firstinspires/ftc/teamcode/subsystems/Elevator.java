package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.utilities.constants.ElevatorConstants.bucketAttachmentHeight;
import static org.firstinspires.ftc.teamcode.utilities.constants.ElevatorConstants.elevatorClearenceHeight;
import static org.firstinspires.ftc.teamcode.utilities.constants.ElevatorConstants.maximumExtension;
import static org.firstinspires.ftc.teamcode.utilities.constants.ElevatorConstants.minimumExtension;

import com.bylazar.ftcontrol.panels.Panels;
import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.bylazar.ftcontrol.panels.integration.TelemetryManager;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.Range;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.solversHardware.SolversMotor;
import com.seattlesolvers.solverslib.solversHardware.SolversServo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.utilities.constants.ElevatorConstants.*;
import org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants;

public class Elevator extends SubsystemBase {
    public enum ElevatorState {
        RETRACTED,
        TRANSFER,
        SPECIMAN_READY,
        SPECIMAN_SCORE,
        SAMPLE_SCORE
    }

    private Motor elevatorMotor;
    private Motor.Encoder elevatorEncoder;
    private TouchSensor homingSwitch;

    public double target;

    private static PIDFController elevatorPIDController = new PIDFController(0.007,0, 0, 0);
    public boolean slidesReached;
    public boolean slidesRetracted;
    public boolean clawOpen;

    private Telemetry telemetry;
    private TelemetryManager panelTelemetry;

    public Elevator(HardwareMap aHardwareMap, Telemetry telemetry) {
        elevatorMotor = new Motor(aHardwareMap, "elevatorMotor", Motor.GoBILDA.RPM_312);
        elevatorMotor.stopAndResetEncoder();
        elevatorEncoder = elevatorMotor.encoder;

        homingSwitch = aHardwareMap.get(TouchSensor.class, "elevatorLimitSwitch");
        panelTelemetry = Panels.getTelemetry();
        panelTelemetry.update();

        this.telemetry = telemetry;
    }

    public int getLiftScaledPosition() {
        return elevatorEncoder.getPosition();
    }

    public void setSlideTarget(double target) {
        this.target = Range.clip(target, minimumExtension, maximumExtension);
        elevatorPIDController.setSetPoint(target);
    }

    public void autoUpdateSlides() {
        /*

        if (this.target == BACK_HIGH_SPECIMEN_ATTACH_HEIGHT && !slidesReached) {
            slidePIDF.setP(0.01);
        } else {
            slidePIDF.setP(0.007);
        }

         */

        double power = elevatorPIDController.calculate(getLiftScaledPosition(), target);
        slidesReached = elevatorPIDController.atSetPoint()
                || (target == 0 && getLiftScaledPosition() < 15)
                || (getLiftScaledPosition() >= target && target == bucketAttachmentHeight)
                || (target == elevatorClearenceHeight + 50 && getLiftScaledPosition() > elevatorClearenceHeight && getLiftScaledPosition() < elevatorClearenceHeight + 65);

        slidesRetracted = (target <= 0) && slidesReached;

        // Just make sure it gets to fully retracted if target is 0
        if (target == 0 && !slidesReached) {
            power -= 0.1;
        }

        if (slidesRetracted) {
            elevatorMotor.set(0);
        } else {
            elevatorMotor.set(power);
        }
    }

    @Override
    public void periodic() {
        autoUpdateSlides();
        telemetry.addData("Elevator Position", getLiftScaledPosition());
        panelTelemetry.graph("Target Position", target);
        panelTelemetry.graph("Current Position", getLiftScaledPosition());
        panelTelemetry.update(telemetry);
    }
}

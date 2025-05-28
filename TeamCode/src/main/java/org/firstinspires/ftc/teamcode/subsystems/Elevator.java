package org.firstinspires.ftc.teamcode.subsystems;

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
import org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants;

public class Elevator extends SubsystemBase {
    public enum ElevatorState {
        RETRACTED,
        TRANSFER,
        SPECIMAN_READY,
        SPECIMAN_SCORE,
        SAMPLE_SCORE
    }

    private SolversMotor elevatorMotor;
    private TouchSensor homingSwitch;

    public double target;

    private static final PIDFController elevatorPIDController = new PIDFController(0.007,0, 0.00017, 0.00023);
    public boolean slidesReached;
    public boolean slidesRetracted;
    public boolean clawOpen;

    private Telemetry telemetry;

    public Elevator(HardwareMap aHardwareMap, Telemetry telemetry) {
        elevatorMotor = new SolversMotor(aHardwareMap.get(DcMotor.class, "elevatorMotor"), 0.01);
        elevatorMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevatorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        homingSwitch = aHardwareMap.get(TouchSensor.class, "elevatorLimitSwitch");
        this.telemetry = telemetry;
    }

    public int getLiftScaledPosition() {
        return elevatorMotor.getPosition();
    }

    public void setSlideTarget(double target) {
        this.target = Range.clip(target, 0, 10000.0);
        elevatorPIDController.setSetPoint(target);
    }

    public void autoUpdateSlides() {
        double power = elevatorPIDController.calculate(getLiftScaledPosition(), target);
        slidesReached = elevatorPIDController.atSetPoint()
                || (target == 0 && getLiftScaledPosition() < 15)
                || (getLiftScaledPosition() >= target && target == 3700)
                || (target == 300 + 50 && getLiftScaledPosition() > 300 && getLiftScaledPosition() < 300 + 65);


        slidesRetracted = (target <= 0) && slidesReached;

        // Just make sure it gets to fully retracted if target is 0
        if (target == 0 && !slidesReached) {
            power -= 0.1;
        }

        if (slidesRetracted) {
            elevatorMotor.setPower(0);
        } else {
            elevatorMotor.setPower(power);
        }
    }

    @Override
    public void periodic() {
        //autoUpdateSlides();
        telemetry.addData("Elevator Position", getLiftScaledPosition());
        elevatorMotor.setPower(0.5);
    }
}

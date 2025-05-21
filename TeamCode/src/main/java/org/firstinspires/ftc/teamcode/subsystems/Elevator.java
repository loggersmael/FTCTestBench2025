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

import org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants;

public class Elevator extends SubsystemBase {
    public enum ElevatorState {
        RETRACTED,
        TRANSFER,
        SPECIMAN_READY,
        SPECIMAN_SCORE,
        SAMPLE_SCORE
    }

    public enum ManipulatorState {
        TRANSFER,
        SPECIMAN_READY,
        SPECIMAN_SCORE,
        SAMPLE,
        WALL
    }

    private SolversMotor elevatorMotor;
    private SolversServo leftPivotingServo;
    private SolversServo rightPivotingServo;
    private SolversServo wristServo;
    private SolversServo clawServo;

    private Motor.Encoder elevatorEncoder;

    private TouchSensor homingSwitch;
    public double target;

    private static final PIDFController elevatorPIDController = new PIDFController(0.007,0, 0.00017, 0.00023);
    public boolean slidesReached;
    public boolean slidesRetracted;
    public boolean clawOpen;

    public static ManipulatorState manipulatorState;

    public Elevator(HardwareMap aHardwareMap) {
        elevatorMotor = new SolversMotor(aHardwareMap.get(DcMotor.class, "elevatorMotor"), 0.01);
        homingSwitch = aHardwareMap.get(TouchSensor.class, "elevatorLimitSwitch");
        elevatorEncoder = new Motor(aHardwareMap, "elevatorMotor").encoder;

        leftPivotingServo = new SolversServo(aHardwareMap.get(Servo.class, "leftElevatorArm"), 0.01);
        rightPivotingServo = new SolversServo(aHardwareMap.get(Servo.class, "rightElevatorArm"), 0.01);
        wristServo = new SolversServo(aHardwareMap.get(Servo.class, "wristElevator"), 0.01);
        clawServo = new SolversServo(aHardwareMap.get(Servo.class, "elevatorClaw"), 0.01);

        leftPivotingServo.setDirection(Servo.Direction.REVERSE);

        if (GlobalConstants.currentOpMode.equals(GlobalConstants.OpModeType.AUTO)) {
            setPivot(ManipulatorState.SPECIMAN_READY);
            setClawOpen(false);
        } else if (GlobalConstants.currentOpMode.equals(GlobalConstants.OpModeType.TELEOP)) {
            setPivot(ManipulatorState.TRANSFER);
            setClawOpen(true);
        }
    }

    public int getLiftScaledPosition() {
        return (elevatorEncoder.getPosition() / 30);
    }

    public void setSlideTarget(double target) {
        this.target = Range.clip(target, 0, 10000.0);
        elevatorPIDController.setSetPoint(target);
    }

    public void autoUpdateSlides() {
        double power = elevatorPIDController.calculate(getLiftScaledPosition(), target);
        slidesReached = elevatorPIDController.atSetPoint()
                || (target == 0 && getLiftScaledPosition() < 15)
                || (getLiftScaledPosition() >= target && target == HIGH_BUCKET_HEIGHT)
                || (target == SLIDES_PIVOT_READY_EXTENSION + 50 && getLiftScaledPosition() > SLIDES_PIVOT_READY_EXTENSION && getLiftScaledPosition() < SLIDES_PIVOT_READY_EXTENSION + 65);
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

    public void setClawOpen(boolean open) {
        if (open) {
            clawServo.setPosition(0.0);
        } else {
            clawServo.setPosition(0.0);
        }

        this.clawOpen = open;
    }

    @Override
    public void periodic() {
        autoUpdateSlides();
    }
}

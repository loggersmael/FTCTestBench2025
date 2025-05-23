package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.localization.Localizer;
import com.pedropathing.localization.Pose;
import com.pedropathing.localization.PoseUpdater;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import com.seattlesolvers.solverslib.geometry.Pose2d;
import com.seattlesolvers.solverslib.solversHardware.SolversMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.utilities.constants.DrivetrainConstants;
import org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants;
import org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants.OpModeType;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class Drivetrain extends SubsystemBase {
    private SolversMotor leftFront;
    private SolversMotor rightFront;
    private SolversMotor leftRear;
    private SolversMotor rightRear;

    private IMU imu;
    public Follower follower;
    private PoseUpdater poseUpdater;

    private Telemetry telemetry;

    public Drivetrain(HardwareMap aHardwareMap, Telemetry telemetry) {
        leftFront = new SolversMotor(aHardwareMap.get(DcMotor.class, DrivetrainConstants.fLMotorID), 0.01);
        rightFront = new SolversMotor(aHardwareMap.get(DcMotor.class, DrivetrainConstants.fRMotorID), 0.01);
        leftRear = new SolversMotor(aHardwareMap.get(DcMotor.class, DrivetrainConstants.bLMotorID), 0.01);
        rightRear = new SolversMotor(aHardwareMap.get(DcMotor.class, DrivetrainConstants.bRMotorID), 0.01);

        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        leftRear.setDirection(DcMotorSimple.Direction.FORWARD);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);

        initializeImu(aHardwareMap);

        follower = new Follower(aHardwareMap);
        FollowerConstants.useBrakeModeInTeleOp = false;
        poseUpdater = new PoseUpdater(aHardwareMap);

        initializeImu(aHardwareMap);

        this.telemetry = telemetry;
    }

    @Override
    public void periodic() {
        telemetry.addData("Drivetrain Pose X", follower.getPose().getX());
        telemetry.addData("Drivetrain Pose Y", follower.getPose().getY());
        telemetry.addData("Drivetrain Heading", follower.getPose().getHeading());
    }

    public void setMovementVectors(double strafe, double forward, double rotation, BooleanSupplier feildCentric) {
        follower.setTeleOpMovementVectors(forward, -strafe, -rotation, !feildCentric.getAsBoolean());
    }

    public void setMovementVectors(double strafe, double forward, double rotation) {
        follower.setTeleOpMovementVectors(forward, -strafe, -rotation);
    }

    public void setPose(Pose pose) {
        follower.setPose(pose);
    }

    public void enableTeleop() {
        follower.startTeleopDrive();
        follower.setStartingPose(new Pose(0,0,0));
    }

    public void initializeImu(HardwareMap hardwareMap) {
        imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP)
        );

        imu.initialize(parameters);
    }

    public double getYawDegrees() {
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }

    public double getPitchDegrees() {
        return imu.getRobotYawPitchRollAngles().getPitch(AngleUnit.DEGREES);
    }

    public double getRollDegrees() {
        return imu.getRobotYawPitchRollAngles().getRoll(AngleUnit.DEGREES);
    }

    public void resetYaw() {
        imu.resetYaw();
    }
}

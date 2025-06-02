package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.utilities.constants.DrivetrainConstants.startPose;

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


    public Follower follower;
    private Pose reset;

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



        follower = new Follower(aHardwareMap);
        FollowerConstants.useBrakeModeInTeleOp = true;
        poseUpdater = new PoseUpdater(aHardwareMap);

        reset= new Pose(0,0,0);

        this.telemetry = telemetry;
    }

    @Override
    public void periodic() {
        follower.update();
        reset.setX(follower.getPose().getX());
        reset.setY(follower.getPose().getY());
        telemetry.addData("Drivetrain Pose X", follower.getPose().getX());
        telemetry.addData("Drivetrain Pose Y", follower.getPose().getY());
        telemetry.addData("Drivetrain Heading", follower.getPose().getHeading());
    }

    public void setMovementVectors(double strafe, double forward, double rotation, boolean feildCentric) {
        follower.setTeleOpMovementVectors(forward, -strafe, -rotation, !feildCentric);
    }

    public void setMovementVectors(double strafe, double forward, double rotation) {
        follower.setTeleOpMovementVectors(forward, -strafe, -rotation, false);
    }

    public void setPose(Pose pose) {
        follower.setPose(pose);
    }

    public void enableTeleop() {
        follower.startTeleopDrive();
        follower.setStartingPose(startPose);
    }

    public void resetHeading()
    {
        follower.setPose(reset);
    }

    public void hold()
    {
        follower.holdPoint(follower.getPose());
    }
}

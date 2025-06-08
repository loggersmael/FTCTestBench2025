package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class DrivetrainController extends CommandBase
{
    private Drivetrain drivetrain;
    private double forward;
    private double strafe;
    private double rotation;

    public DrivetrainController(Drivetrain drivetrain, double forward, double strafe, double rotation) {
        this.drivetrain = drivetrain;
        this.forward = forward;
        this.strafe = strafe;
        this.rotation = rotation;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.enableTeleop();
    }

    @Override
    public void execute() {
        drivetrain.setMovementVectors(strafe, forward, rotation);
    }
}

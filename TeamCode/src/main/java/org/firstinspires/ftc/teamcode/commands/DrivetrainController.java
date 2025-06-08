package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class DrivetrainController extends CommandBase
{
    private Drivetrain drivetrain;

    private GamepadEx driver1;

    public DrivetrainController(Drivetrain drivetrain, GamepadEx d1) {
        this.drivetrain = drivetrain;
        driver1= d1;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.enableTeleop();
    }

    @Override
    public void execute() {
        drivetrain.setMovementVectors(driver1.getLeftX(), driver1.getLeftY(), driver1.getRightX());
        drivetrain.follower.update();
    }
}

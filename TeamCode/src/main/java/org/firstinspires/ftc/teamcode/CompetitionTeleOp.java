package org.firstinspires.ftc.teamcode;

import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants;

public class CompetitionTeleOp extends CommandOpMode {
    private Drivetrain drivetrain;
    private GamepadEx driverController;

    public void initialize() {
        drivetrain = new Drivetrain(hardwareMap);
        driverController = new GamepadEx(gamepad1);

        drivetrain.setDefaultCommand(drivetrain.setMovementVectors(
                driverController.getLeftX(),
                driverController.getLeftY(),
                driverController.getRightX(),
                () -> true
        ));
    }
}

package org.firstinspires.ftc.teamcode;

import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.RunCommand;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.commands.DrivetrainController;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants;

@TeleOp(name="CompetitionTeleOp")
public class CompetitionTeleOp extends CommandOpMode {
    private Drivetrain drivetrain;
    private GamepadEx driverController;

    @Override
    public void initialize() {
        drivetrain = new Drivetrain(hardwareMap, telemetry);
        driverController = new GamepadEx(gamepad1);

        register(drivetrain);
        schedule(new RunCommand(telemetry::update));

        drivetrain.setDefaultCommand(new DrivetrainController(
                drivetrain,
                driverController::getLeftY,
                driverController::getLeftX,
                driverController::getRightX
        ));
    }

    @Override
    public void runOpMode() {
        initialize();

        while (!opModeIsActive()) {}

        waitForStart();

        // run the scheduler
        while (!isStopRequested() && opModeIsActive()) {
            run();
        }

        reset();
    }
}

package org.firstinspires.ftc.teamcode;

import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.RunCommand;
import com.seattlesolvers.solverslib.command.button.GamepadButton;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.DrivetrainController;
import org.firstinspires.ftc.teamcode.commands.ElevatorController;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants;


@TeleOp(name="CompetitionTeleOp")
public class CompetitionTeleOp extends CommandOpMode {
    private Drivetrain drivetrain;
    private Elevator elevator;
    private Arm arm;

    private GamepadEx driverController;
    private GamepadButton a, b, x, y;

    private double target;

    @Override
    public void initialize() {
        drivetrain = new Drivetrain(hardwareMap, telemetry);
        elevator = new Elevator(hardwareMap, telemetry);
        arm = new Arm(hardwareMap, telemetry);

        driverController = new GamepadEx(gamepad1);
        a = new GamepadButton(driverController, GamepadKeys.Button.A);
        b = new GamepadButton(driverController, GamepadKeys.Button.B);
        x = new GamepadButton(driverController, GamepadKeys.Button.X);
        y = new GamepadButton(driverController, GamepadKeys.Button.Y);

        target = 1000;

        register(drivetrain, elevator, arm);
        schedule(new RunCommand(telemetry::update));

        a.whenPressed(() -> elevator.setSlideTarget(1000));
        b.whenPressed(() -> elevator.setSlideTarget(0));
        x.whenPressed(() -> elevator.setSlideTarget(1500));
        y.whenPressed(() -> elevator.setSlideTarget(4000));

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
            telemetry.addData("Local Progress", target);
        }

        reset();
    }
}

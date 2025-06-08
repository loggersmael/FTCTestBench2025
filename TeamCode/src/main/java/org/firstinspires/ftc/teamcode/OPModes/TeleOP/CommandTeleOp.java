package org.firstinspires.ftc.teamcode.OPModes.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Bot;
import org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants;
@TeleOp(name = "CommandOP")
public class CommandTeleOp extends LinearOpMode
{
    private Bot robot;

    @Override
    public void runOpMode()
    {
        robot= new Bot(hardwareMap,telemetry,gamepad1,gamepad2, GlobalConstants.OpModeType.TELEOP);

        waitForStart();

        while(!isStopRequested() && opModeIsActive())
        {
            robot.enable();
            robot.run();
            telemetry.update();
        }

    }
}

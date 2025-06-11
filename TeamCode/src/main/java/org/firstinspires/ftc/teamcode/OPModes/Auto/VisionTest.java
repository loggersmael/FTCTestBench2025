package org.firstinspires.ftc.teamcode.OPModes.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.LEDs;
import org.firstinspires.ftc.teamcode.subsystems.Vision;

@Autonomous(name="VisionTest")
public class VisionTest extends OpMode
{
    private Drivetrain drivetrain;
    private Elevator lift;
    private Vision cams;
    private LEDs lights;
    private Claw claw;
    private GamepadEx d1;
    private GamepadEx d2;

    public void aPeriodic()
    {
        cams.periodic();
        drivetrain.periodic();
        lift.periodic();
    }

    public void init()
    {
        d1=new GamepadEx(gamepad1);
        drivetrain= new Drivetrain(hardwareMap, telemetry);
        claw= new Claw(hardwareMap, telemetry);
        lift= new Elevator(hardwareMap, telemetry);
        cams= new Vision(hardwareMap, drivetrain, claw, telemetry);
        lights= new LEDs(hardwareMap, telemetry);
        lights.setColor(LEDs.Color.WHITE);
    }

    public void start()
    {
        drivetrain.enableTeleop();
    }
    public void loop()
    {
        if(d1.getButton(GamepadKeys.Button.A)) {
            cams.followBlock(cams.redBlocks);
        }

        if(d1.getButton(GamepadKeys.Button.B))
        {
            cams.followBlock(cams.blueBlocks);
        }
        if(d1.getButton(GamepadKeys.Button.X))
        {
            cams.followBlock(cams.yellowBlocks);
        }

        cams.exactYaw(cams.redBlocks);
        aPeriodic();
    }
}

package org.firstinspires.ftc.teamcode.OPModes.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

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

    public void aPeriodic()
    {
        cams.periodic();
        drivetrain.periodic();
        lift.periodic();
    }

    public void init()
    {
        drivetrain= new Drivetrain(hardwareMap, telemetry);
        lift= new Elevator(hardwareMap, telemetry);
        cams= new Vision(hardwareMap, drivetrain, telemetry);
        lights= new LEDs(hardwareMap, telemetry);
        lights.setColor(LEDs.Color.WHITE);
    }

    public void start()
    {
        drivetrain.enableTeleop();
    }
    public void loop()
    {
        cams.followBlock(cams.blueBlocks);
        aPeriodic();
    }
}

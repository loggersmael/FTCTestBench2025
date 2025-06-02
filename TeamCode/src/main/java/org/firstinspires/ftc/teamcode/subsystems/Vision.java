package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.utilities.constants.VisionConstants.fD;
import static org.firstinspires.ftc.teamcode.utilities.constants.VisionConstants.fF;
import static org.firstinspires.ftc.teamcode.utilities.constants.VisionConstants.fI;
import static org.firstinspires.ftc.teamcode.utilities.constants.VisionConstants.fP;
import static org.firstinspires.ftc.teamcode.utilities.constants.VisionConstants.lD;
import static org.firstinspires.ftc.teamcode.utilities.constants.VisionConstants.lF;
import static org.firstinspires.ftc.teamcode.utilities.constants.VisionConstants.lI;
import static org.firstinspires.ftc.teamcode.utilities.constants.VisionConstants.lP;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;

public class Vision extends SubsystemBase
{
    private HuskyLens camera;
    private Telemetry telemetry;
    private Drivetrain drivetrain;
    public HuskyLens.Block[] redBlocks;
    public HuskyLens.Block[] yellowBlocks;
    public HuskyLens.Block[] blueBlocks;

    private PIDFController lateral= new PIDFController(lP,lI,lD,lF);
    private PIDFController forward= new PIDFController(fP,fI,fD,fF);
    private int redCount;
    private int yellowCount;
    private int blueCount;
    private double currentX;
    private double currentY;
    private double targetX=160;
    private double targetY=180;
    private double strafe;
    private double forwards;

    public Vision(HardwareMap aHardwaremap,Drivetrain dt, Telemetry telemetry)
    {
        camera= aHardwaremap.get(HuskyLens.class, "huskylens");
        this.telemetry=telemetry;
        drivetrain=dt;
        camera.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);
        redBlocks=camera.blocks(1);
        yellowBlocks=camera.blocks(2);
        blueBlocks=camera.blocks(3);
        redCount= redBlocks.length;
        yellowCount= yellowBlocks.length;
        blueCount= blueBlocks.length;
    }

    public void listRed()
    {
        int counter=0;
        String output;
        if(counter<redCount)
        {
            output="Block "+counter+" ID: Red Xpos= "+redBlocks[counter].x+ " Ypos: ";
            telemetry.addData(output, redBlocks[counter].y);
            counter++;
        }
    }

    public void listYellow()
    {
        int counter=0;
        String output;
        if(counter<yellowCount)
        {
            output="Block "+counter+" ID: Yellow Xpos= "+yellowBlocks[counter].x+ " Ypos: ";
            telemetry.addData(output, yellowBlocks[counter].y);
            counter++;
        }
    }

    public void listBlue()
    {
        int counter=0;
        String output;
        if(counter<blueCount)
        {
            output="Block "+counter+" ID: Blue Xpos= "+blueBlocks[counter].x+ " Ypos: ";
            telemetry.addData(output, blueBlocks[counter].y);
            counter++;
        }
    }
    public void addTelemetry()
    {
        telemetry.addData("Block Count: ",redCount+yellowCount+blueCount);
        listRed();
        listYellow();
        listBlue();
    }

    public void followBlock(HuskyLens.Block[] target)
    {
        if(target.length>0 )
        {
            currentX= target[0].x;
            currentY= target[0].y;
            if(Math.abs(currentX-targetX)>10 || Math.abs(currentY-targetY)>10)
            {
                strafe = lateral.calculate(currentX, targetX);
                forwards = forward.calculate(currentY, targetY);
                drivetrain.setMovementVectors(-strafe, forwards, 0, false);
            }
            else
            {
                //drivetrain.setMovementVectors(0,0,0,false);
                drivetrain.hold();
            }
        }
        else
        {
            //drivetrain.setMovementVectors(0,0,0,false);
            drivetrain.hold();
        }
    }

    public void periodic()
    {
        redBlocks=camera.blocks(1);
        yellowBlocks=camera.blocks(2);
        blueBlocks=camera.blocks(3);
        redCount= redBlocks.length;
        yellowCount= yellowBlocks.length;
        blueCount= blueBlocks.length;
        addTelemetry();
    }

}

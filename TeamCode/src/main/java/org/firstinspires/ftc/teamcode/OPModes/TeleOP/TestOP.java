package org.firstinspires.ftc.teamcode.OPModes.TeleOP;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.bylazar.ftcontrol.panels.Panels;
import com.bylazar.ftcontrol.panels.integration.TelemetryManager;
import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.button.GamepadButton;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
@TeleOp(name="TestOP")
public class TestOP extends OpMode
{
    private Elevator viper;
    private Drivetrain drivetrain;
   private GamepadEx driver1;
   private GamepadEx driver2;

   public TelemetryManager panels;
   private Servo flap;


   private void aPeriodic()
   {
       viper.periodic();
       drivetrain.periodic();
   }

   public void init()
    {
        viper= new Elevator(hardwareMap, telemetry);
        drivetrain= new Drivetrain(hardwareMap, telemetry);
        driver1= new GamepadEx(gamepad1);
        driver2= new GamepadEx(gamepad2);
        flap= hardwareMap.get(Servo.class,"flap");
        panels= Panels.getTelemetry();
        viper.liftToPosition(Elevator.liftState.RETRACTED);
    }

    public void start()
    {
        drivetrain.enableTeleop();
    }

    public void loop()
    {
       drivetrain.setMovementVectors(driver1.getLeftX(),driver1.getLeftY(),driver1.getRightX());

        if(driver2.getButton(GamepadKeys.Button.A))
       {
          viper.liftToPosition(Elevator.liftState.MAX);
       }

       if(driver2.getButton(GamepadKeys.Button.B))
       {
          viper.liftToPosition(Elevator.liftState.RETRACTED);
       }

       if(driver2.getButton(GamepadKeys.Button.X))
       {
          viper.liftToPosition(Elevator.liftState.MID);
       }

       if(driver1.getButton(GamepadKeys.Button.TOUCHPAD))
       {
           drivetrain.resetHeading();
       }

       if(driver1.getButton(GamepadKeys.Button.A))
       {
           flap.setPosition(0);
       }
       if(driver1.getButton(GamepadKeys.Button.B))
       {
           flap.setPosition(1);
       }
    /*
       if(driver1.getButton(GamepadKeys.Button.Y))
       {
           drivetrain.hold();
       }
       else
       {
           drivetrain.setMovementVectors(driver1.getLeftX(),driver1.getLeftY(),driver1.getRightX());
       }
    */
       aPeriodic();
    }
}
 
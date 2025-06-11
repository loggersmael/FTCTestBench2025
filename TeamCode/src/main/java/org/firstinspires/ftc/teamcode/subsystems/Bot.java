package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants.OpModeType.AUTO;
import static org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants.OpModeType.TELEOP;
import static org.openftc.easyopencv.OpenCvCameraRotation.UPRIGHT;

//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.Robot;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.Camera;
import org.firstinspires.ftc.teamcode.commands.DrivetrainController;
import org.firstinspires.ftc.teamcode.utilities.ButtonMap;
import org.firstinspires.ftc.teamcode.utilities.constants.GlobalConstants;

public class Bot extends Robot
{
    OpenCVVision camera;
    private Drivetrain drivetrain;
    private Elevator lift;
    private LEDs headLights;
    //private Vision camera;
    private Claw claw;
    private Arm arm;
    private Telemetry telemetry;
    private GamepadEx driver1;
    private GamepadEx driver2;
    private ButtonMap buttons;
    private HardwareMap hmap;

    public Bot(HardwareMap aHardwaremap, Telemetry telemetry, Gamepad d1, Gamepad d2, GlobalConstants.OpModeType type)
    {
        drivetrain= new Drivetrain(aHardwaremap,telemetry);
        lift= new Elevator(aHardwaremap,telemetry);
        headLights= new LEDs(aHardwaremap,telemetry);
        claw= new Claw(aHardwaremap,telemetry);
        //camera= new Vision(aHardwaremap,drivetrain,claw,telemetry);
        camera= new OpenCVVision(aHardwaremap,telemetry);
        arm= new Arm(aHardwaremap,telemetry);
        driver1= new GamepadEx(d1);
        driver2= new GamepadEx(d2);
        buttons= new ButtonMap(driver1,driver2);
        this.telemetry=telemetry;
        hmap=aHardwaremap;
        register(drivetrain,lift,headLights,claw,arm);
        if(type== GlobalConstants.OpModeType.TELEOP)
        {
            drivetrain.setDefaultCommand(new DrivetrainController(drivetrain,driver1));
            initTeleop(TELEOP);
        }
        else if(type== AUTO)
        {
            initAuto();
        }
    }

    public void dualDrive()
    {
        buttons.retractLift.whenPressed(new InstantCommand(()->lift.liftToPosition(Elevator.liftState.RETRACTED),lift));
        buttons.maxLift.whenPressed(new InstantCommand(()->lift.liftToPosition(Elevator.liftState.MAX),lift));
        buttons.midLift.whenPressed(new InstantCommand(()->lift.liftToPosition(Elevator.liftState.MID),lift));
        buttons.resetLift.whenPressed(new InstantCommand(()->lift.resetLift(),lift));
        buttons.resetLift.whenReleased(new InstantCommand(()->lift.unResetLift(),lift));
        buttons.resetHeading.whenPressed(new InstantCommand(()->drivetrain.resetHeading(),drivetrain));
    }
    public void initTeleop(GlobalConstants.OpModeType opModeType)
    {
        if (opModeType == GlobalConstants.OpModeType.TELEOP) {
            camera.streamToHub();
        }

        dualDrive();
    }

    public void initAuto()
    {

    }
}

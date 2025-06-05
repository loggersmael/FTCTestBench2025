package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.utilities.constants.ArmConstants.D;
import static org.firstinspires.ftc.teamcode.utilities.constants.ArmConstants.F;
import static org.firstinspires.ftc.teamcode.utilities.constants.ArmConstants.I;
import static org.firstinspires.ftc.teamcode.utilities.constants.ArmConstants.P;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class Arm extends SubsystemBase
{
    private MotorEx armMotor;
    private MotorEx.Encoder armEncoder;
    private double target;
    private Telemetry telemetry;
    private PIDFController armController= new PIDFController(P,I,D,F);
    public Arm(HardwareMap aHardwaremap, Telemetry telemetry)
    {
        armMotor=new MotorEx(aHardwaremap, "arm", MotorEx.GoBILDA.RPM_60);
        armEncoder= armMotor.encoder;
        this.telemetry=telemetry;
        armMotor.stopAndResetEncoder();
        armMotor.setZeroPowerBehavior(MotorEx.ZeroPowerBehavior.BRAKE);
        target=0;
    }

    public int getEncoderPosition()
    {
        return armEncoder.getPosition();
    }
    private void setTarget(double tar)
    {
        target=tar;
    }

    public void update()
    {
        armMotor.motorEx.setPower(armController.calculate(getEncoderPosition(),target));
    }

    @Override
    public void periodic()
    {
        update();
        telemetry.addData("Current Arm Position: ", getEncoderPosition());
        telemetry.addData("Target Arm Position: ", target);
        telemetry.addData("Arm Motor Current: ", armMotor.motorEx.getCurrent(CurrentUnit.AMPS));
    }
}

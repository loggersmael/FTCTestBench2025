package org.firstinspires.ftc.teamcode.subsystems;

import android.telephony.SubscriptionPlan;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Claw extends SubsystemBase
{
    private double currentPosition;
    private double targetPosition;
    private Telemetry telemetry;
    private Servo yaw;
    public Claw(HardwareMap aHardwareMap, Telemetry telemetry)
    {
        yaw= aHardwareMap.get(Servo.class,"flap");
        this.telemetry=telemetry;
    }

    public void setYaw(double position)
    {
        yaw.setPosition(position);
    }
}

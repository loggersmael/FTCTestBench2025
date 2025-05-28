package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.solversHardware.SolversServo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm extends SubsystemBase {
    private Motor armMotor;
    private Motor.Encoder armEncoder;

    private Telemetry telemetry;

    public Arm(HardwareMap aHardwareMap, Telemetry telemtry) {
        armMotor = new Motor(aHardwareMap, "arm", Motor.GoBILDA.RPM_60);
        armEncoder = armMotor.encoder;

        this.telemetry = telemtry;
    }

    @Override
    public void periodic() {
        telemetry.addData("Arm Position", armEncoder.getPosition());
    }
}

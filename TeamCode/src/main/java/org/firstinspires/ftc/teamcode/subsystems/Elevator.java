package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.bylazar.ftcontrol.panels.Panels;
import com.bylazar.ftcontrol.panels.integration.TelemetryManager;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.solversHardware.SolversMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.utilities.constants.ElevatorConstants;

public class Elevator extends SubsystemBase
{
    public enum liftState
    {
        MAX(ElevatorConstants.max),
        RETRACTED(ElevatorConstants.retracted),
        MID(ElevatorConstants.mid);

        private final int position;

        private liftState(int position)
        {
            this.position = position;
        }

        public int getPosition()
        {
            return position;
        }
    }
    private Motor liftMotor;
    private Motor.Encoder liftEncoder;
    private int targetPosition;
    private liftState viperState= liftState.RETRACTED;
    private static PIDFController liftController= new PIDFController(ElevatorConstants.P,ElevatorConstants.I,ElevatorConstants.D,ElevatorConstants.F);

    private Telemetry telemetry;
    public Elevator(HardwareMap aHardwaremap, Telemetry telemetry)
    {
        liftMotor= new Motor(aHardwaremap, "elevatorMotor", Motor.GoBILDA.RPM_312);
        liftMotor.stopAndResetEncoder();
        liftMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        liftMotor.setRunMode(Motor.RunMode.RawPower);
        liftEncoder= liftMotor.encoder;
        this.telemetry=telemetry;
    }
    public void liftToPosition(liftState ls)
    {
        setLiftState(ls);
        targetPosition=viperState.getPosition();
    }
    public void setLiftState(liftState ls)
    {
        viperState=ls;
    }
    public liftState getLiftState()
    {
        return viperState;
    }
    public int getEncoderPosition()
    {
        return liftEncoder.getPosition();
    }

    private void update()
    {
        liftMotor.motor.setPower(liftController.calculate(getEncoderPosition(),targetPosition));
    }

    @Override
    public void periodic()
    {
        update();
        telemetry.addData("Lift position: ", getEncoderPosition());
        telemetry.addData("Target: ", getLiftState().getPosition());
    }
}

package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;

import java.util.function.DoubleSupplier;

public class ElevatorController extends CommandBase {
    private Elevator elevator;
    private DoubleSupplier target;

    public ElevatorController(Elevator elevator, DoubleSupplier target) {
        this.elevator = elevator;
        this.target = target;

        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        elevator.setSlideTarget(target.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;

public class ScoreHighBucket extends CommandBase
{
    private final Elevator lift;
    private final Claw claw;
    public ScoreHighBucket(Elevator lift, Claw claw)
    {
        this.lift=lift;
        this.claw=claw;
    }

    @Override
    public void initialize()
    {
        lift.liftToPosition(Elevator.liftState.MAX);
        claw.setYaw(90);
    }

    @Override
    public boolean isFinished()
    {
        return true;
    }
}

package org.firstinspires.ftc.teamcode.utilities;

public class HeadingPID
{
    private double kP;
    private double kD;
    private double lastError=0;
    private long lastTime= System.nanoTime();
    public HeadingPID(double kP, double kD)
    {
        this.kP=kP;
        this.kD=kD;
    }
    public double getWrappedError(double target, double current) {
        double error = target - current;
        error = (error + Math.PI) % (2 * Math.PI);  // normalize to [0, 2π)
        if (error < 0) error += 2 * Math.PI;        // ensure it's positive
        error -= Math.PI;                           // shift to [-π, π)
        return error;
    }

    public double calculate(double current, double target)
    {
        double error= getWrappedError(target,current);
        long now= System.nanoTime();
        double dt= (now-lastTime)/1e9;
        lastTime=now;
        double derivative= (dt>0)?(error-lastError)/dt:0.0;
        lastError=error;
        double output= kP*error + kD * derivative;
        return Math.max(-1.0, Math.min(1.0, output));
    }
}

package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.utilities.constants.LEDConstants;

public class LEDs extends SubsystemBase
{
    public enum Color
    {
        OFF(0.0),
        RED(LEDConstants.red),
        ORANGE(LEDConstants.orange),
        YELLOW(LEDConstants.yellow),
        SAGE(LEDConstants.sage),
        GREEN(LEDConstants.green),
        AZURE(LEDConstants.azure),
        BLUE(LEDConstants.blue),
        INDIGO(LEDConstants.indigo),
        VIOLET(LEDConstants.violet),
        WHITE(LEDConstants.white);

        private double pwm;
        private Color(double pwm)
        {
            this.pwm=pwm;
        }

        public double getPWM()
        {
            return pwm;
        }
    }
    private Telemetry telemetry;
    private Servo light;
    private Color color;
    public LEDs(HardwareMap aHardwareMap, Telemetry telemetry)
    {
        light= aHardwareMap.get(Servo.class, "led");
        this.telemetry=telemetry;
        color=Color.OFF;
    }

    public void setColor(Color col)
    {
        color=col;
        light.setPosition(color.getPWM());
    }
}

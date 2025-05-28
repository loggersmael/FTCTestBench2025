package org.firstinspires.ftc.teamcode.utilities.constants;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;

@Configurable
public class ElevatorConstants {
    public static int minimumExtension = 0;
    public static int maximumExtension = 4300;

    public static int elevatorClearenceHeight = 300;
    public static int bucketAttachmentHeight = 4200;

    public static double P = 0.007;
    public static double I = 0.000;
    public static double D = 0.000;
    public static double F = 0.000;
}

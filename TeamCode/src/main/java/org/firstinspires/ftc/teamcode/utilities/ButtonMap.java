package org.firstinspires.ftc.teamcode.utilities;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.seattlesolvers.solverslib.command.button.Button;
import com.seattlesolvers.solverslib.command.button.GamepadButton;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

public class ButtonMap
{
    public Button resetHeading;
    public Button maxLift;
    public Button retractLift;
    public Button midLift;
    public Button resetLift;

    public ButtonMap(GamepadEx d1, GamepadEx d2)
    {
        resetHeading= new GamepadButton(d1,GamepadKeys.Button.TOUCHPAD);
        maxLift= new GamepadButton(d2, GamepadKeys.Button.A);
        retractLift= new GamepadButton(d2, GamepadKeys.Button.B);
        midLift= new GamepadButton(d2,GamepadKeys.Button.X);
        resetLift= new GamepadButton(d2,GamepadKeys.Button.LEFT_BUMPER);
    }
}

package frc.team578.robot.utils;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

public class AnalogJoystickButton extends Button {
    private GenericHID joystick;
    private int axisNumber;
    private int threshold;

    public AnalogJoystickButton(GenericHID joystick, int axisNumber, int threshold) {
        this.joystick = joystick;
        this.axisNumber = axisNumber;
        this.threshold = threshold;
    }

    @Override
    public boolean get() {
        if(threshold == -1) {
            return joystick.getRawAxis(axisNumber) == -1;
        } else if(threshold == 1) {
            return joystick.getRawAxis(axisNumber) == 1;
        }

        return false;
    }
}

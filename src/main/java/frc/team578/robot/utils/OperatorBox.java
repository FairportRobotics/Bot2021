package frc.team578.robot.utils;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team578.robot.RobotMap;

public class OperatorBox {

    private final Gamepad operatorBox;
    public final JoystickButton one;
    public final JoystickButton two;
    public final JoystickButton three;
    public final JoystickButton four;
    public final JoystickButton five;
    public final JoystickButton six;
    public final JoystickButton seven;
    public final JoystickButton eight;
    public final JoystickButton nine;
    public final JoystickButton ten;


    public OperatorBox(int id) {
        operatorBox = new Gamepad(id);
        one = new JoystickButton(operatorBox, 1);
        two = new JoystickButton(operatorBox, 2);
        three = new JoystickButton(operatorBox, 3);
        four = new JoystickButton(operatorBox, 4);
        five = new JoystickButton(operatorBox, 5);
        six = new JoystickButton(operatorBox, 6);
        seven = new JoystickButton(operatorBox, 7);
        eight = new JoystickButton(operatorBox, 8);
        nine = new JoystickButton(operatorBox, 9);
        ten = new JoystickButton(operatorBox, 10);
    }

    public GenericHID getAnalogJoystick() {
        return operatorBox;
    }
}

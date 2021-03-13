package frc.team578.robot.utils;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team578.robot.RobotMap;

public class OperatorBox {

    private final Gamepad operatorBox1;
    private final Gamepad operatorBox2;

    public JoystickButton[][] buttons = new JoystickButton[4][4];

    

    public OperatorBox() {
        operatorBox1 = new Gamepad(RobotMap.OPERATORBOX1_ID);
        operatorBox2 = new Gamepad(RobotMap.OPERATORBOX2_ID);

        buttons[0][0] = new JoystickButton(operatorBox1,1);
        buttons[0][1] = new JoystickButton(operatorBox2,1);
        buttons[0][2] = new JoystickButton(operatorBox1,2);
        buttons[0][3] = new JoystickButton(operatorBox2,2);
        buttons[1][0] = new JoystickButton(operatorBox1,3);
        buttons[1][1] = new JoystickButton(operatorBox1,4);
        buttons[1][2] = new JoystickButton(operatorBox1,5);
        buttons[1][3] = new JoystickButton(operatorBox1,6);
        buttons[2][0] = new JoystickButton(operatorBox1,7);
        buttons[2][1] = new JoystickButton(operatorBox1,8);
        buttons[2][2] = new JoystickButton(operatorBox1,9);
        buttons[2][3] = new JoystickButton(operatorBox1,10);
        buttons[3][0] = new JoystickButton(operatorBox2,3);
        buttons[3][1] = new JoystickButton(operatorBox2,4);
        buttons[3][2] = new JoystickButton(operatorBox2,5);
        buttons[3][3] = new JoystickButton(operatorBox2,6);
    }

    public GenericHID getAnalogJoystick() {
        return operatorBox1;
    }

    public JoystickButton getButton(int x, int y) {
        return buttons[x-1][y-1];
    }
    
}

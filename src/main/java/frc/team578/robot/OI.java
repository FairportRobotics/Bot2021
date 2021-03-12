package frc.team578.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team578.robot.commands.*;
import frc.team578.robot.commands.debug.*;
import frc.team578.robot.subsystems.interfaces.Initializable;
import frc.team578.robot.utils.AnalogJoystickButton;
import frc.team578.robot.utils.OperatorBox;

public class OI implements Initializable {

    public Joystick leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK_ID);
    public Joystick rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK_ID);
    public OperatorBox ob1 = new OperatorBox(RobotMap.OPERATORBOX1_ID); // Operator box - main control functions w/ analog joystick
    public OperatorBox ob2 = new OperatorBox(RobotMap.OPERATORBOX2_ID); // Operator box - main control functions w/ analog joystick

    int JOYSTICK_TRIGGER_BUTTON_NUMBER = 1;
    JoystickButton leftTrigger = new JoystickButton(leftJoystick, JOYSTICK_TRIGGER_BUTTON_NUMBER);
    JoystickButton rightTrigger = new JoystickButton(rightJoystick, JOYSTICK_TRIGGER_BUTTON_NUMBER);

    public void initialize() {
        // /* Driver */
        // leftTrigger.whenPressed(new CentricModeRobotCommand());
        // rightTrigger.whenPressed(new CentricModeFieldCommand());

        /* Operator */
        // Big Boi
        // Hook commands
 //       ob1.one.whenPressed(new HookDeployCommand()); // Press to deploy hook
 //       ob2.one.whenPressed(new ClimberWinchUpCommand()); // Press to bring hook back downn

        ob1.nine.whileHeld(new AgitatorSpinOutCommand());
       // ob2.one.whenPressed(new AgitatorSpinInCommand());

//        ob1.two.whenPressed(new ClimberWinchBrakeExtendCommand()); // Press to extend winch brake
//        ob2.two.whenPressed(new HookDeployReverseCommand()); // Press to retract winch brake

        // Intake commands
        ob1.ten.whileHeld(new IntakeOutCommand()); // Hold to spin intake out
        ob2.six.whileHeld(new IntakeInCommand()); // Hold to spin intake in

        ob1.four.whenPressed(new ShooterToDefaultRPMCommand());
        ob1.five.whenPressed(new ShooterDebugStopCommand());

        ob2.three.whenPressed(new IntakeArmDownCommand());
        ob1.seven.whenPressed(new IntakeArmUpCommand());

//        ob1.four.whileHeld(new ClimberDebugWinchDownCommand());
//        ob1.five.whileHeld(new ClimberWinchBrakeRetractCommand());

        ob1.eight.whileHeld(new ConveyorDebugSpinForwardCommand());
        ob2.four.whileHeld(new ConveyorDebugSpinBackwardsCommand());


        // Shooter commands
//        ob1.eight.whenPressed(new ShooterSingleShotCommand()); // Press to shoot one ball
//        ob1.nine.whenPressed(new ToggleConveyorModeCommand()); // Hold to continuously shoot

        // Winch brake commands

        // Winch commands


        // Analog joystick stuff
        final AnalogJoystickButton LEFT = new AnalogJoystickButton(ob1.getAnalogJoystick(), 0, -1),
                RIGHT = new AnalogJoystickButton(ob1.getAnalogJoystick(), 0, 1),
                UP = new AnalogJoystickButton(ob1.getAnalogJoystick(), 1, -1),
                DOWN = new AnalogJoystickButton(ob1.getAnalogJoystick(), 1, 1);

        LEFT.whileHeld(new ClimberTraverseLeft());
        RIGHT.whileHeld(new ClimberTraverseRight());

        UP.whileHeld(new ShooterMoveRPMUpCommand());
        DOWN.whileHeld(new ShooterMoveRPMDownCommand());
    }

}
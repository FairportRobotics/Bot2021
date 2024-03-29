package frc.team578.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team578.robot.commands.debug.*;
import frc.team578.robot.commands.swerve.*;
import frc.team578.robot.commands.intake.*;
import frc.team578.robot.commands.shooter.*;
import frc.team578.robot.subsystems.interfaces.Initializable;
import frc.team578.robot.utils.AnalogJoystickButton;
import frc.team578.robot.utils.OperatorBox;

public class OI implements Initializable {

    public Joystick leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK_ID);
    public Joystick rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK_ID);
    public OperatorBox ob = new OperatorBox(); // Operator box - main control functions w/ analog joystick
    //top left is 1,1
    
    int JOYSTICK_TRIGGER_BUTTON_NUMBER = 1;
    JoystickButton leftTrigger = new JoystickButton(leftJoystick, JOYSTICK_TRIGGER_BUTTON_NUMBER);
    JoystickButton rightTrigger = new JoystickButton(rightJoystick, JOYSTICK_TRIGGER_BUTTON_NUMBER);
    JoystickButton rightJoystick3 = new JoystickButton(rightJoystick, 3);

    public void initialize() {


        /* Driver */

        //RobotMode Commands

        //swapped IF port 2/3 is swapped

        leftTrigger.whenPressed(new CentricModeRobotCommand());
        rightTrigger.whenPressed(new CentricModeFieldCommand());
        rightJoystick3.whenPressed(new CentricModeFieldCommand());

        /* Operator */

        // Hook commands
 //       ob1.one.whenPressed(new HookDeployCommand()); // Press to deploy hook
 //       ob2.one.whenPressed(new ClimberWinchUpCommand()); // Press to bring hook back down

        // Analog joystick stuff
        final AnalogJoystickButton LEFT = new AnalogJoystickButton(ob.getAnalogJoystick(), 0, -1),
                RIGHT = new AnalogJoystickButton(ob.getAnalogJoystick(), 0, 1),
                UP = new AnalogJoystickButton(ob.getAnalogJoystick(), 1, -1),
                DOWN = new AnalogJoystickButton(ob.getAnalogJoystick(), 1, 1);

        // Shooter

        ob.getButton(2,2).whenPressed(new ShooterToDefaultRPMCommand());
        ob.getButton(3,2).whenPressed(new ShooterStopCommand());
        ob.getButton(4,1).whenPressed(new ShooterToHighRPMCommand());
        ob.getButton(4,2).whenPressed(new ShooterToLowRPMCommand());

        // Intake Arm

        ob.getButton(1,3).whenPressed(new IntakeArmUpCommand());
        ob.getButton(1,4).whenPressed(new IntakeArmDownCommand());
        ob.getButton(4,3).whileHeld(new IntakeOutCommand());
        ob.getButton(4,4).whileHeld(new IntakeInCommand());

        // Feeder
        
        ob.getButton(2,3).whileHeld(new FeederInCommand());
        ob.getButton(2,4).whileHeld(new FeederOutCommand());

        // Agitator
        
        ob.getButton(3,3).whileHeld(new AgitatorSpinOutCommand());
        ob.getButton(3,4).whileHeld(new AgitatorSpinInCommand());


    }

}
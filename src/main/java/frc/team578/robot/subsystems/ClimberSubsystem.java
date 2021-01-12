package frc.team578.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team578.robot.RobotMap;
import frc.team578.robot.subsystems.interfaces.Initializable;

public class ClimberSubsystem extends Subsystem implements Initializable {

    private WPI_TalonSRX traverseTalon;
    private WPI_TalonSRX winchTalon;
    private DoubleSolenoid climberSolenoid;
    private DoubleSolenoid brakeSolenoid;

    private final double winchUpSpeed = .5;
    private final double winchDownSpeed = .25;

    private final double traverseSpeed = 1;

    @Override
    public void initialize() {
        winchTalon = new WPI_TalonSRX(RobotMap.WINCH_TALON);
        winchTalon.configFactoryDefault();
        winchTalon.set(ControlMode.Current,0);
        winchTalon.setNeutralMode(NeutralMode.Brake);

        traverseTalon = new WPI_TalonSRX(RobotMap.TRAVERSE_TALON);
        traverseTalon.configFactoryDefault();
        traverseTalon.set(ControlMode.Current,0);
        traverseTalon.setNeutralMode(NeutralMode.Brake);

        brakeSolenoid = new DoubleSolenoid(RobotMap.PCM1, RobotMap.PCM1_CLIMBER_BRAKE_EXTEND, RobotMap.PCM1_CLIMBER_BRAKE_RETRACT);
        climberSolenoid = new DoubleSolenoid(RobotMap.PCM1, RobotMap.PCM1_CLIMBER_UP, RobotMap.PCM1_CLIMBER_DOWN);
    }

    @Override
    protected void initDefaultCommand() {
    }

    public void deployClimber() {
        // Fast  -  Not sure how to make this fast or slow, it's a solenoid, it does whatever the air wants
        climberSolenoid.set(DoubleSolenoid.Value.kForward);
        // deployClimber and retractClimber should function, they may need to be switched after testing.
    }

    public void retractClimber() {
        // Slow  -  Not sure how to make this fast or slow, it's a solenoid, it does whatever the air wants
        climberSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    //Winch
    public void winchUp() {
        winchTalon.set(ControlMode.PercentOutput, winchUpSpeed);
    }
    public void winchDown() {
        winchTalon.set(ControlMode.PercentOutput, -winchDownSpeed);
    }
    public void winchStop() {
        winchTalon.set(ControlMode.PercentOutput, 0);
    }

    //Traverse
    public void traverseLeft() { traverseTalon.set(ControlMode.PercentOutput, -traverseSpeed); }
    public void traverseRight() { traverseTalon.set(ControlMode.PercentOutput, traverseSpeed); }
    public void traverseStop() { traverseTalon.set(ControlMode.PercentOutput, 0);}

    //Winch Brake
    public void winchBrakeExtend() {
        brakeSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void winchBrakeRetract() {
        brakeSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public boolean isClimberDeployed() {
        return climberSolenoid.get() != DoubleSolenoid.Value.kReverse && climberSolenoid.get() != DoubleSolenoid.Value.kOff;
    }


}

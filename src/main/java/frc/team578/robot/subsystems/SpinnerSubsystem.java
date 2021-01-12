package frc.team578.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team578.robot.RobotMap;
import frc.team578.robot.subsystems.interfaces.Initializable;

public class SpinnerSubsystem extends Subsystem implements Initializable {

    private WPI_TalonSRX spinnerTalon;
    private DoubleSolenoid spinnerSolenoid;

    @Override
    public void initialize() {
    }

    @Override
    protected void initDefaultCommand() {
        spinnerTalon = new WPI_TalonSRX(RobotMap.SPINNER_TALON);
        spinnerTalon.configFactoryDefault();
        spinnerTalon.set(ControlMode.Current,0);
        spinnerTalon.setNeutralMode(NeutralMode.Brake);
        spinnerSolenoid = new DoubleSolenoid(RobotMap.PCM1, RobotMap.PCM1_SPINNER_EXTENDED, RobotMap.PCM1_SPINNER_RETRACTED);
    }

    public void extendSpinnerArm() {
    }

    public void retractSpinnerArm() {
    }

    public void spinClockwise() {
    }

    public void spinCounterClockwise() {
    }

    public void runFullDistance() {
    }

    public void incrementColor() {
    }

    public boolean isSpinnerArmDeployed() {
        return false;
    }
}

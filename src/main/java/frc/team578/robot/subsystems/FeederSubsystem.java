package frc.team578.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team578.robot.RobotMap;
import frc.team578.robot.subsystems.interfaces.Initializable;

public class FeederSubsystem extends Subsystem implements Initializable {


    private WPI_TalonSRX feederTalon;

    private double spinFeederInPower = 0.35;
    private double spinFeederOutPower = 0.35;

    @Override
    protected void initDefaultCommand() {

    }

    @Override
    public void initialize() {
        feederTalon = new WPI_TalonSRX(RobotMap.CONVEYOR_FEEDER_TALON);

        feederTalon.configFactoryDefault();
        feederTalon.setNeutralMode(NeutralMode.Brake);
    }


    //Intake Motor
    public void feederSpinIn() { feederTalon.set(ControlMode.PercentOutput, spinFeederInPower);   }

    public void feederSpinOut() { feederTalon.set(ControlMode.PercentOutput, -spinFeederOutPower); }

    public void stop() {feederTalon.set(ControlMode.PercentOutput, 0);}

}

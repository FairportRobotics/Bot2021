package frc.team578.robot.utils;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SpeedController;

public class TalonUtil {
    public static WPI_TalonSRX getWPITalon(int deviceNumber) {
        var talon = new WPI_TalonSRX(deviceNumber);
        talon.configFactoryDefault();
        talon.set(ControlMode.Current,0);
        talon.setNeutralMode(NeutralMode.Brake);
        return talon;
    }


}
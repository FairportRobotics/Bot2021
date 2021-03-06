package frc.team578.robot.subsystems.swerve;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team578.robot.subsystems.interfaces.UpdateDashboard;

public class TalonSwerveEnclosure implements UpdateDashboard {

    private String name;

    private WPI_TalonSRX driveTalon;
    private WPI_TalonSRX steerTalon;

    private boolean reverseEncoder = false;
    private boolean reverseSteer = false;
    private int trueNorthEncoderOffset;
    private int outputAngleTest = 0;

    TalonSwerveEnclosure(String name, WPI_TalonSRX driveMotor, WPI_TalonSRX steerMotor, int trueNorth) {

        this.name = name;
        this.driveTalon = driveMotor;
        this.steerTalon = steerMotor;
        trueNorthEncoderOffset = trueNorth;
        driveMotor.setNeutralMode(NeutralMode.Brake);
    }

    public WPI_TalonSRX getDriveTalon() {
        return this.driveTalon;
    }

    public WPI_TalonSRX getSteerTalon() {
        return this.steerTalon;
    }

    public void stopAllTalons() {
        this.steerTalon.stopMotor();
        this.driveTalon.stopMotor();
    }

    public void setSensorToAnalogPos() {
        this.steerTalon.setSelectedSensorPosition(this.steerTalon.getSensorCollection().getAnalogInRaw());
    }

    public void orientSensor()
    {
        int where = this.steerTalon.getSensorCollection().getAnalogInRaw()-trueNorthEncoderOffset;
        where=((where%1024)+1024)%1024;
        this.steerTalon.setSelectedSensorPosition(where);
    }

    // ------------ Steer Related

    public void moveSteerToEncoderPosition(int encPos) {
        steerTalon.set(ControlMode.Position, encPos);
    }

    public void moveSteerTrueNorth() {
        this.moveSteerToEncoderPosition(trueNorthEncoderOffset);
    }

    public int getSteerEncPosition() {
        return steerTalon.getSelectedSensorPosition(0) * (reverseEncoder ? -1 : 1);
    }

    public void resetSteerEncPosition(int position) {
        steerTalon.setSelectedSensorPosition(position);
    }

    public void zeroSteerEncoder() {
        this.resetSteerEncPosition(0);
    }

    public double getSteerCLT(int id) {
        return this.steerTalon.getClosedLoopTarget(id);
    }

    public double getSteerTurnCLTError() {
        return this.steerTalon.getClosedLoopError();
    }

    public double getSteerCLTErrorAbs() {
        return Math.abs(this.getSteerTurnCLTError());
    }

    public double getSteerErrorDerivitive() {
        return this.steerTalon.getErrorDerivative();
    }

    public double getSteerErrorDerivitiveAbs() {
        return Math.abs(this.getSteerErrorDerivitive());
    }

    // ------------ Drive Related

    /**
     * Set the value of the drive motor
     *
     * @param speed the speed value to set: -1 - full backwards, 0 - stop, +1 - full forward
     */
    public void setDriveSpeed(double speed) {
        driveTalon.set(ControlMode.PercentOutput, speed);
    }
    
    public double getDriveCLT(int id) {
        return this.driveTalon.getClosedLoopTarget(id);
    }

    public double getDriveTurnCLTError(int id) {
        return this.driveTalon.getClosedLoopError(id);
    }


    /**
     * @param speed: the speed to move the wheel, -1.0 being full backwards, 0 being stop +1.0 being full forward
     * @param angle: the angle to turn the wheel, 0 being forward, -1.0 being full turn counterclockwise, +1.0 being full turn clockwise
     */
    public void move(double speed, double angle) {
        angle = angle*512/Math.PI;
        
        double diff = (angle - getSteerEncPosition())%1024;
        
        if(diff > 512) diff-=1024;          // go other way if greater than 180 degrees (512 angle units)
        if(diff < -512) diff += 1024;
        
        if(Math.abs(diff) > 256){           // if better to reverse motor direciton
            speed *= -1;
            diff += (diff>0 ? -512: 512);   // moves in other direction
        }

        setDriveSpeed(speed);
        if(speed != 0){
            steerTalon.set(ControlMode.Position, (diff + getSteerEncPosition()));
            outputAngleTest = (int)(diff + getSteerEncPosition());
        }
    }

    public String getName() {
        return name;
    }

    
    @Override
    public void updateDashboard() {
        SmartDashboard.putData(steerTalon);
        SmartDashboard.putData(driveTalon);

        SmartDashboard.putNumber(name + ".ultimateangle", outputAngleTest);


        SmartDashboard.putNumber(name + ".steert.araw", steerTalon.getSensorCollection().getAnalogInRaw());
        SmartDashboard.putNumber(name + ".steert.senspos", steerTalon.getSelectedSensorPosition());
        SmartDashboard.putNumber(name + ".steert.tn", trueNorthEncoderOffset);

        if (steerTalon.getControlMode() == ControlMode.Position) {
            SmartDashboard.putNumber(name + ".steer.encpos", this.getSteerEncPosition());
            SmartDashboard.putNumber(name + ".steert.CLT", steerTalon.getClosedLoopTarget());
            SmartDashboard.putNumber(name + ".steert.CLE", steerTalon.getClosedLoopError());
            SmartDashboard.putNumber(name + ".steert.errd", steerTalon.getErrorDerivative());
        }
//        SmartDashboard.putNumber(name + ".drivet.araw",driveTalon.getSensorCollection().getAnalogInRaw());
//        SmartDashboard.putNumber(name + ".drivet.senspos",driveTalon.getSelectedSensorPosition());
//        SmartDashboard.putNumber(name + ".drivet.CLE",driveTalon.getClosedLoopError());
//        SmartDashboard.putNumber(name + ".drivet.CLT",driveTalon.getClosedLoopTarget());


    }

    public SwerveModuleState getState() {
        return new SwerveModuleState(driveTalon.getSelectedSensorVelocity(), new Rotation2d(getSteerEncPosition()));
    }
}

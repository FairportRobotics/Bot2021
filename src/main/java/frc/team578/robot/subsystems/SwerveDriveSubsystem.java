package frc.team578.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team578.robot.commands.swerve.SwerveDriveCommand;
import frc.team578.robot.subsystems.interfaces.Initializable;
import frc.team578.robot.subsystems.interfaces.UpdateDashboard;
import frc.team578.robot.subsystems.swerve.SwerveDrive;

public class SwerveDriveSubsystem extends Subsystem implements Initializable, UpdateDashboard {

    private SwerveDrive swerveDrive;
    public SwerveDriveCommand swerveDriveCommand;

    @Override
    protected void initDefaultCommand() {
        // This is where the swerve command starts
        swerveDriveCommand = new SwerveDriveCommand();
        setDefaultCommand(swerveDriveCommand);
    }

    @Override
    public void initialize() {
        swerveDrive = SwerveDrive.create();
    }

    public void move(double fwd, double str, double rot, double angleDeg) {
        swerveDrive.move(fwd, str, rot, angleDeg);
    }

    public void zeroAllSteerEncoders() {
        swerveDrive.zeroAllSteerEncoders();
    }

    public void moveAllWheelsToTrueNorth() {
        swerveDrive.moveAllWheelsToTrueNorth();
    }

    public void stop() {
        swerveDrive.stop();
    }

    @Override
    public void updateDashboard() {

//        SmartDashboard.putNumber("sd.derivsum",getSteerErrorDerivitiveSum());

        swerveDrive.updateDashboard();
    }

    public double getSteerCLTErrorSum() {
        return swerveDrive.getSteerCLTErrorSum();
    }

    public double getSteerErrorDerivitiveSum() {
        return swerveDrive.getSteerErrorDerivitiveSum();
    }

    public void calibrateAllSteerEncoders() {
        swerveDrive.calibrateAllSteerEncoders();
    }

    public void setModeField() {swerveDrive.setModeField();}
    public void setModeRobot() {swerveDrive.setModeRobot();}
}

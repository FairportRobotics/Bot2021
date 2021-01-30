package frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team578.robot.Robot;
import frc.team578.robot.utils.ExpoScale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SwerveDriveCommand extends Command {

    private static final Logger log = LogManager.getLogger(SwerveDriveCommand.class);
    private static ExpoScale es;
    private static ExpoScale esRot;
    private double profilingPowerX = 0, profilingPowerY = 0, profilingPowerA = 0;

    public SwerveDriveCommand() {
        requires(Robot.swerveDriveSubsystem);
    }

    @Override
    protected void initialize() {
        es = new ExpoScale(0.1, .5); //NEVER set scale to > 1
        esRot = new ExpoScale(0.1, .2);
    }

    @Override
    protected void execute() {

        double fwd = Robot.oi.leftJoystick.getY();

        // double str = Robot.oi.getStrafe();
        double str = Robot.oi.leftJoystick.getX();

        double rot = Robot.oi.rightJoystick.getX();
        
        fwd += profilingPowerX;
        str += profilingPowerY;
        rot += profilingPowerA;

        if(fwd > 1)
            fwd = 1;
        if(fwd < -1)
            fwd = -1;                   //limiter was in swervedrive code,
        if(str > 1)                     //may or may not be needed
            str = 1;                    // ExpoScale may or may not have an effect, 
        if(str < -1)                    //should investigate if ExpoScale is applying a function on input strength,
            str = -1;                   //or if its serving as a limitor


//      fwd *= -1;
//		str *= -1;

        double angleDeg = Robot.gyroSubsystem.getHeading();

        Robot.swerveDriveSubsystem.move(es.apply(fwd), es.apply(str), esRot.apply(rot), angleDeg);

        SmartDashboard.putNumber("swrv.fwd", fwd);
        SmartDashboard.putNumber("swrv.str", str);
        SmartDashboard.putNumber("swrv.rot", rot);
        SmartDashboard.putNumber("swrv.angleDeg", angleDeg);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        log.debug("SwerveDriveCommand Ended");
    }

    @Override
    protected void interrupted() {
        log.debug("SwerveDriveCommand Interrupted");
    }
    public void setProfilingPowerX(double x){
        profilingPowerX = x;
    }
    public void setProfilingPowerY(double y){
        profilingPowerY = y;
    }
    public void setProfilingPowerA(double a){
        profilingPowerA = a;
    }
}

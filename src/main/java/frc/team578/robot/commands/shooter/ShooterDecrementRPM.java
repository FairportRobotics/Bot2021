package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShooterDecrementRPM extends Command {

    private static final Logger log = LogManager.getLogger(ShooterDecrementRPM.class);
    private static final double RPM_DECREMENT_VALUE = 10;

    public ShooterDecrementRPM() {
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ShooterDecrementRPM");
    }

    @Override
    protected void execute() {
        log.debug("Exec ShooterDecrementRPM");
        if(Robot.shooterSubsystem.getDefaultRPM() >= 4000) {
            Robot.shooterSubsystem.setDefaultRPM(Robot.shooterSubsystem.getDefaultRPM() - RPM_DECREMENT_VALUE);
        }
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted ShooterDecrementRPM");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        log.debug("Ending ShooterDecrementRPM " + timeSinceInitialized());
    }
}

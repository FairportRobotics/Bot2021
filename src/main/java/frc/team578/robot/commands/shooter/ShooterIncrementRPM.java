package frc.team578.robot.commands.shooter;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShooterIncrementRPM extends Command {

    private static final Logger log = LogManager.getLogger(ShooterIncrementRPM.class);
    private static final double RPM_INCREMENT_VALUE = 10;

    public ShooterIncrementRPM() {
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ShooterIncrementRPM");
    }

    @Override
    protected void execute() {
        log.debug("Exec ShooterIncrementRPM");
        if(Robot.shooterSubsystem.getDefaultRPM() <= 6500) {
            Robot.shooterSubsystem.setDefaultRPM(Robot.shooterSubsystem.getDefaultRPM() + RPM_INCREMENT_VALUE);
        }
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted ShooterIncrementRPM");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        log.debug("Ending ShooterIncrementRPM " + timeSinceInitialized());
    }
}

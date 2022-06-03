package frc.team578.robot.commands.shooter;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShooterStopCommand extends Command {

    private static final Logger log = LogManager.getLogger(ShooterStopCommand.class);

    public ShooterStopCommand() {
        requires(Robot.shooterSubsystem);
    }

    @Override
    protected void initialize() {
        log.info("Initializing ShooterStopCommand");
    }

    @Override
    protected void execute() {
        log.info("Exec ShooterStopCommand");
        Robot.shooterSubsystem.stop();
    }


    @Override
    protected void interrupted() {
        log.info("Interrupted ShooterStopCommand");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        log.info("Ending ShooterStopCommand " + timeSinceInitialized());
    }
}

package frc.team578.robot.commands.debug;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShooterDebugStopCommand extends Command {

    private static final Logger log = LogManager.getLogger(ShooterDebugStopCommand.class);

    public ShooterDebugStopCommand() {
        requires(Robot.shooterSubsystem);
    }

    @Override
    protected void initialize() {
        log.info("Initializing ShooterDebugStopCommand");
    }

    @Override
    protected void execute() {
        log.info("Exec ShooterDebugStopCommand");
        Robot.shooterSubsystem.stop();
    }


    @Override
    protected void interrupted() {
        log.info("Interrupted ShooterDebugStopCommand");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        log.info("Ending ShooterDebugStopCommand " + timeSinceInitialized());
    }
}

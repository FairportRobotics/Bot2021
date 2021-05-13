package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClimberWinchUpCommand extends Command {

    private static final Logger log = LogManager.getLogger(ClimberWinchUpCommand.class);

    public ClimberWinchUpCommand() {
        requires(Robot.climberSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ClimberWinchUpCommand");
    }

    @Override
    protected void execute() {
        log.debug("Exec ClimberWinchUpCommand");
        Robot.climberSubsystem.winchUp();
    }

    @Override
    protected void interrupted() {
        log.debug("Interrupted ClimberWinchUpCommand");
        Robot.climberSubsystem.winchStop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        log.debug("Ending ClimberWinchUpCommand " + timeSinceInitialized());
    }
}
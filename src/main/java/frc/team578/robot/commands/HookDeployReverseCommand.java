package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HookDeployReverseCommand extends Command {

    private static final Logger log = LogManager.getLogger(HookDeployReverseCommand.class);

    public HookDeployReverseCommand() {
        requires(Robot.climberSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing HookDeployReverseCommand");
    }

    @Override
    protected void execute() {
        log.debug("Exec HookDeployReverseCommand");
        Robot.climberSubsystem.retractClimber();
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted HookDeployReverseCommand");
    }

    @Override
    protected boolean isFinished() {
        return !Robot.climberSubsystem.isClimberDeployed(); // When the climber is NOT deployed this should be true
    }

    @Override
    protected void end() {
        log.debug("Ending HookDeployReverseCommand " + timeSinceInitialized());
    }
}

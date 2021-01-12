package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HookDeployCommand extends Command {

    private static final Logger log = LogManager.getLogger(HookDeployCommand.class);

    public HookDeployCommand() {
        requires(Robot.climberSubsystem);
    }

    @Override
    protected void initialize() {
        log.info("Initializing HookDeployCommand");
    }

    @Override
    protected void execute() {
        log.debug("Exec HookDeployCommand");
        Robot.climberSubsystem.deployClimber();
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted HookDeployCommand");
    }

    @Override
    protected boolean isFinished() {
        return Robot.climberSubsystem.isClimberDeployed();
    }

    @Override
    protected void end() {
        log.debug("Ending HookDeployCommand " + timeSinceInitialized());
    }
}

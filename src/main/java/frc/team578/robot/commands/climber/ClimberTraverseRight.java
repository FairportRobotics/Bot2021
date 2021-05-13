package frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClimberTraverseRight extends Command {

    private static final Logger log = LogManager.getLogger(ClimberTraverseRight.class);

    public ClimberTraverseRight() {
        requires(Robot.climberSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ClimberTraverseRight");
    }

    @Override
    protected void execute() {
        log.debug("Exec ClimberTraverseRight");
        Robot.climberSubsystem.traverseRight();
    }

    @Override
    protected void interrupted() {
        log.debug("Interrupted ClimberTraverseRight");
        Robot.climberSubsystem.traverseStop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        log.debug("Ending ClimberTraverseRight " + timeSinceInitialized());
    }
}

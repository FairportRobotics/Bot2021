package frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClimberTraverseLeft extends Command {

    private static final Logger log = LogManager.getLogger(ClimberTraverseLeft.class);

    public ClimberTraverseLeft() {
        requires(Robot.climberSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ClimberTraverseLeft");
    }

    @Override
    protected void execute() {
        log.debug("Exec ClimberTraverseLeft");
        Robot.climberSubsystem.traverseLeft();
    }

    @Override
    protected void interrupted() {
        log.debug("Interrupted ClimberTraverseLeft");
        Robot.climberSubsystem.traverseStop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        log.debug("Ending ClimberTraverseLeft " + timeSinceInitialized());
    }
}

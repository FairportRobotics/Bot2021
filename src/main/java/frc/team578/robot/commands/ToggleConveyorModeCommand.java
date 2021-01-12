package frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToggleConveyorModeCommand extends Command {
    private static final Logger log = LogManager.getLogger(ToggleConveyorModeCommand.class);

    public ToggleConveyorModeCommand() {
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ToggleConveyorModeCommand");
    }

    @Override
    protected void execute() {
        Robot.conveyorSubsystem.toggleConveyorLogic();
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted ToggleConveyorModeCommand");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        log.debug("Ending ToggleConveyorModeCommand " + timeSinceInitialized());
    }
}

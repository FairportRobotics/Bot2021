package frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConveyorAdvanceSingleBall extends Command {

    private static final Logger log = LogManager.getLogger(HookDeployReverseCommand.class);

    public ConveyorAdvanceSingleBall() {
        requires(Robot.conveyorSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ConveyorAdvanceSingleBall");
    }

    @Override
    protected void execute() {
        log.info("Exec ConveyorAdvanceSingleBall");
        Robot.conveyorSubsystem.moveOneBallIntoShooter();
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted ConveyorAdvanceSingleBall");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        log.debug("Ending ConveyorAdvanceSingleBall " + timeSinceInitialized());
    }
}

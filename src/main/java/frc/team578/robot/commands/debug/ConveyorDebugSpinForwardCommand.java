package frc.team578.robot.commands.debug;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConveyorDebugSpinForwardCommand extends Command {

    private static final Logger log = LogManager.getLogger(ConveyorDebugSpinForwardCommand.class);

    public ConveyorDebugSpinForwardCommand() {
        requires(Robot.conveyorSubsystem);
    }

    @Override
    protected void initialize() {
        log.info("Initializing ConveyorDebugSpinForwardCommand");
    }

    @Override
    protected void execute() {
        Robot.conveyorSubsystem.moveTowardsShooterSensor();
    }


    @Override
    protected void interrupted() {
        log.info("Interrupted ConveyorDebugSpinForwardCommand");
        Robot.conveyorSubsystem.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        log.info("Ending ConveyorDebugSpinForwardCommand " + timeSinceInitialized());
    }
}

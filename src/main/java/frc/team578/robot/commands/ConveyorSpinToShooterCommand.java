package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConveyorSpinToShooterCommand extends Command {

    private static final Logger log = LogManager.getLogger(ConveyorSpinToShooterCommand.class);

    public ConveyorSpinToShooterCommand() {
        requires(Robot.conveyorSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ConveyorSpinToShooterCommand");
    }

    @Override
    protected void execute() {
        Robot.conveyorSubsystem.moveTowardsShooterSensor();
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted ConveyorSpinToShooterCommand");
        Robot.conveyorSubsystem.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        log.debug("Ending ConveyorSpinToShooterCommand " + timeSinceInitialized());
    }
}

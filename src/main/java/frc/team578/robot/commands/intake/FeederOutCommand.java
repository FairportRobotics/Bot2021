package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FeederOutCommand extends Command {

    private static final Logger log = LogManager.getLogger(FeederOutCommand.class);
    boolean isFinished;

    public FeederOutCommand() {
//        requires(Robot.intakeSubsystem);
//        requires(Robot.conveyorSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing FeederOut Command");
    }

    @Override
    protected void execute() {
        log.debug("Exec FeederOut Command");

        Robot.feederSubsystem.feederSpinOut();

    }


    @Override
    protected void interrupted() {
        Robot.feederSubsystem.stop();
        log.debug("Interrupted IntakeInCommand");
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        log.debug("Ending IntakeInCommand " + timeSinceInitialized());
    }
}

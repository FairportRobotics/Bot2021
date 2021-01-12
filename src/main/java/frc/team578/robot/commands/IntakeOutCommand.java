package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntakeOutCommand extends Command {

    private static final Logger log = LogManager.getLogger(IntakeOutCommand.class);

    public IntakeOutCommand() {
        requires(Robot.intakeSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing IntakeOutCommand");
    }

    @Override
    protected void execute() {
        log.debug("Exec IntakeOutCommand");
        // TODO: This method SHOULD be a toggle method, so add code to stop spinning
        Robot.intakeSubsystem.intakeSpinOut();
    }


    @Override
    protected void interrupted() {
        Robot.intakeSubsystem.stop();
        log.debug("Interrupted IntakeOutCommand");
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        log.debug("Ending IntakeOutCommand " + timeSinceInitialized());
    }
}

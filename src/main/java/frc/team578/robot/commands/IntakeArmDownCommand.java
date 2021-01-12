package frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntakeArmDownCommand extends Command {
    private static final Logger log = LogManager.getLogger(IntakeArmDownCommand.class);

    public IntakeArmDownCommand() {
        log.debug("IntakeArmDownCommand Constructor");
    }

    @Override
    protected void initialize() {
        log.debug("Initializing IntakeArmDownCommand");
    }

    @Override
    protected void execute() {
        Robot.intakeSubsystem.intakeArmDown();
        log.debug("Exec IntakeArmDownCommand");
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted IntakeArmDownCommand");
    }

    @Override
    protected boolean isFinished() {

        boolean isFinished = true;
        log.debug("IntakeArmDownCommand is Finished : " + isFinished);
        return isFinished;
    }

    @Override
    protected void end() {

        log.info("Ending IntakeArmDownCommand " + timeSinceInitialized());

    }
}

package frc.team578.robot.commands.swerve;

import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CentricModeFieldCommand extends Command {

    private static final Logger log = LogManager.getLogger(CentricModeFieldCommand.class);

    public CentricModeFieldCommand() {
        log.debug("CentricModeFieldCommand Constructor");
    }

    @Override
    protected void initialize() {
        log.debug("Initializing CentricModeFieldCommand");
    }

    @Override
    protected void execute() {

        log.debug("Exec CentricModeFieldCommand");
        Robot.swerveDriveSubsystem.setModeField();
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted CentricModeFieldCommand");
    }

    @Override
    protected boolean isFinished() {

        boolean isFinished = true;
        log.debug("CentricModeFieldCommand is Finished : " + isFinished);
        return isFinished;
    }

    @Override
    protected void end() {

        log.debug("Ending CentricModeFieldCommand " + timeSinceInitialized());

    }
}

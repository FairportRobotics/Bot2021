package frc.team578.robot.commands.swerve;

import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CentricModeRobotCommand extends Command {

    private static final Logger log = LogManager.getLogger(CentricModeRobotCommand.class);

    public CentricModeRobotCommand() {
        log.debug("CentricModeRobotCommand Constructor");
    }

    @Override
    protected void initialize() {
        log.debug("Initializing CentricModeRobotCommand");
    }

    @Override
    protected void execute() {

        log.debug("Exec CentricModeRobotCommand");
        Robot.swerveDriveSubsystem.setModeRobot();
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted CentricModeRobotCommand");
    }

    @Override
    protected boolean isFinished() {

        boolean isFinished = true;
        log.debug("CentricModeRobotCommand is Finished : " + isFinished);
        return isFinished;
    }

    @Override
    protected void end() {

        log.debug("Ending CentricModeRobotCommand " + timeSinceInitialized());

    }
}

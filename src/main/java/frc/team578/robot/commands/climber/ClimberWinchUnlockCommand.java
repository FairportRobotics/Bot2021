package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClimberWinchUnlockCommand extends Command {

    private static final Logger log = LogManager.getLogger(ClimberWinchUnlockCommand.class);

    public ClimberWinchUnlockCommand() {
        requires(Robot.climberSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ClimberWinchBrakeRetractCommand");
    }

    @Override
    protected void execute() {
        log.debug("Exec ClimberWinchBrakeRetractCommand");
        Robot.climberSubsystem.winchBrakeRetract();
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted ClimberWinchBrakeRetractCommand");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        log.debug("Ending ClimberWinchBrakeRetractCommand " + timeSinceInitialized());
    }
}

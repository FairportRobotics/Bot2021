package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClimberWinchBrakeExtendCommand extends Command {

    private static final Logger log = LogManager.getLogger(ClimberWinchBrakeExtendCommand.class);

    public ClimberWinchBrakeExtendCommand() {
        requires(Robot.climberSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ClimberWinchBrakeExtendCommand");
    }

    @Override
    protected void execute() {
        log.debug("Exec ClimberWinchBrakeExtendCommand");
        Robot.climberSubsystem.winchBrakeExtend();
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted ClimberWinchBrakeExtendCommand");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        log.debug("Ending ClimberWinchBrakeExtendCommand " + timeSinceInitialized());
    }
}

package frc.team578.robot.commands.debug;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClimberDebugWinchDownCommand extends Command {

    private static final Logger log = LogManager.getLogger(ClimberDebugWinchDownCommand.class);

    public ClimberDebugWinchDownCommand() {
        requires(Robot.climberSubsystem);
    }

    @Override
    protected void initialize() {
        log.info("Initializing ClimberDebugWinchDownCommand");
    }

    @Override
    protected void execute() {
        log.info("Exec ClimberDebugWinchDownCommand");
        Robot.climberSubsystem.winchDown();
    }


    @Override
    protected void interrupted() {
        log.info("Interrupted ClimberDebugWinchDownCommand");
        Robot.climberSubsystem.winchStop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        log.info("Ending ClimberDebugWinchDownCommand " + timeSinceInitialized());
    }
}

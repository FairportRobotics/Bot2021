package frc.team578.robot.commands.intake;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FeederInCommand extends Command {

    private static final Logger log = LogManager.getLogger(FeederInCommand.class);
    boolean isFinished;

    public FeederInCommand() {
//        requires(Robot.intakeSubsystem);
//        requires(Robot.conveyorSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing FeederInCommand");
    }

    @Override
    protected void execute() {
        log.debug("Exec FeederInCommand");

        Robot.feederSubsystem.feederSpinIn();

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

package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntakeInCommand2 extends Command {

    private static final Logger log = LogManager.getLogger(IntakeInCommand2.class);
    boolean isFinished;

    public IntakeInCommand2() {
//        requires(Robot.intakeSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing IntakeInCommand2");
    }

    @Override
    protected void execute() {
        Robot.intakeSubsystem.intakeSpinIn();
    }


    @Override
    protected void interrupted() {
        Robot.intakeSubsystem.stop();
        log.debug("Interrupted IntakeInCommand2");
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        log.debug("Ending IntakeInCommand2 " + timeSinceInitialized());
    }
}

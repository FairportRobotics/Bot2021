package frc.team578.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AgitatorSpinInCommand extends Command {

    private static final Logger log = LogManager.getLogger(AgitatorSpinInCommand.class);

    public AgitatorSpinInCommand() {

        requires(Robot.intakeSubsystem);
    }

    @Override
    protected void initialize() {
        log.info("Initializing AgitatorSpinInCommand");
    }

    @Override
    protected void execute() {
        log.info("Exec AgitatorSpinInCommand");
        Robot.intakeSubsystem.agitatorSpinIn();

    }

    @Override
    protected void interrupted() {
        log.info("Interrupted AgitatorSpinInCommand");
        Robot.intakeSubsystem.stopAgitator();
    }

    @Override


    protected boolean isFinished() { return false; }

    protected void end() {
        log.info("Ending AgitatorSpinInCommand " + timeSinceInitialized());
    }

}

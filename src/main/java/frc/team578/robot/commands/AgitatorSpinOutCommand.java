package frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import frc.team578.robot.commands.debug.ConveyorDebugSpinBackwardsCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AgitatorSpinOutCommand extends Command {

    private static final Logger log = LogManager.getLogger(AgitatorSpinOutCommand.class);

    public AgitatorSpinOutCommand() {

        requires(Robot.intakeSubsystem);
    }

    @Override
    protected void initialize() {
        log.info("Initializing AgitatorSpinOutCommand");
    }

    @Override
    protected void execute() {
        log.info("Exec AgitatorSpinOutCommand");
//        Robot.intakeSubsystem.agitatorSpinIn();
        Robot.intakeSubsystem.agitatorSpinOut();

    }

    @Override
    protected void interrupted() {
        log.info("Interrupted AgitatorSpinOutCommand");
        Robot.intakeSubsystem.stopAgitator();
    }

    @Override


    protected boolean isFinished() { return false; }

    protected void end() {
        log.info("Ending AgitatorSpinOutCommand " + timeSinceInitialized());
    }

}

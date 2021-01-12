package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpinnerArmRetractCommand extends Command {

    private static final Logger log = LogManager.getLogger(SpinnerArmRetractCommand.class);

    public SpinnerArmRetractCommand() {
        requires(Robot.spinnerSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing SpinnerArmRetractCommand");
    }

    @Override
    protected void execute() {
        log.debug("Exec SpinnerArmRetractCommand");
        Robot.spinnerSubsystem.retractSpinnerArm();
    }


    @Override
    protected void interrupted() {
        log.info("Interrupted SpinnerArmRetractCommand");
    }

    @Override
    protected boolean isFinished() {
        return !Robot.spinnerSubsystem.isSpinnerArmDeployed(); // Will return true if spinner arm is not deployed
    }

    @Override
    protected void end() {
        log.info("Ending SpinnerArmRetractCommand " + timeSinceInitialized());
    }
}

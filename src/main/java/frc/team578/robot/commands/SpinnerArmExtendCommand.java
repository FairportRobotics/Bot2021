package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpinnerArmExtendCommand extends Command {

    private static final Logger log = LogManager.getLogger(SpinnerArmExtendCommand.class);

    public SpinnerArmExtendCommand() {
        requires(Robot.spinnerSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing SpinnerArmExtendCommand");
    }

    @Override
    protected void execute() {
        log.debug("Exec SpinnerArmExtendCommand");
        Robot.spinnerSubsystem.extendSpinnerArm();
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted SpinnerArmExtendCommand");
    }

    @Override
    protected boolean isFinished() {
        return Robot.spinnerSubsystem.isSpinnerArmDeployed();
    }

    @Override
    protected void end() {
        log.debug("Ending SpinnerArmExtendCommand " + timeSinceInitialized());
    }
}

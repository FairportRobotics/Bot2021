package frc.team578.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShooterWaitForSpinUp extends TimedCommand {

    private static final Logger log = LogManager.getLogger(ShooterWaitForSpinUp.class);

    public ShooterWaitForSpinUp(double timeoutSeconds) {
        super(timeoutSeconds);
    }

    @Override
    protected void initialize() {
        log.debug("Starting ShooterWaitForSpinUp ");
    }

    @Override
    protected void execute() {
    }

    @Override
    protected void interrupted() {
    }

    @Override
    protected boolean isFinished() {
        return Robot.shooterSubsystem.isAtTargetRPM();
    }

    @Override
    protected void end() {
        log.debug("Ending ShooterWaitForSpinUp " + timeSinceInitialized());
    }
}

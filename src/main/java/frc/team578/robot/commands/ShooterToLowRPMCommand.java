package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShooterToLowRPMCommand extends Command {

    private static final Logger log = LogManager.getLogger(ShooterToLowRPMCommand.class);

    public ShooterToLowRPMCommand() {
        requires(Robot.shooterSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ShooterShootAllCommand");
    }

    @Override
    protected void execute() {
        log.debug("Exec ShooterShootAllCommand");
        Robot.shooterSubsystem.spinToLowRPM();
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted ShooterShootAllCommand");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        log.debug("Ending ShooterShootAllCommand " + timeSinceInitialized());
    }
}

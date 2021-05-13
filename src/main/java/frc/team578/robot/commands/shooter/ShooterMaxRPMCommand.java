package frc.team578.robot.commands.debug;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShooterMaxRPMCommand extends Command {

    private static final Logger log = LogManager.getLogger(ShooterMaxRPMCommand.class);

    public ShooterMaxRPMCommand() {
        requires(Robot.shooterSubsystem);
    }

    @Override
    protected void initialize() {
        log.info("Initializing ShooterShootAllCommand");
    }

    @Override
    protected void execute() {
        log.info("Exec ShooterShootAllCommand");
        Robot.shooterSubsystem.spinToMaxRPM();
    }


    @Override
    protected void interrupted() {
        log.info("Interrupted ShooterShootAllCommand");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        log.info("Ending ShooterShootAllCommand " + timeSinceInitialized());
    }
}

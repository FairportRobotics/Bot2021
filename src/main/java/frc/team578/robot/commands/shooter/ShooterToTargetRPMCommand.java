package frc.team578.robot.commands.shooter;


import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShooterToTargetRPMCommand extends Command {

    private static final Logger log = LogManager.getLogger(ShooterToTargetRPMCommand.class);
    private int targetRPM;

    public ShooterToTargetRPMCommand(Integer targetRPM) {
        requires(Robot.shooterSubsystem);
        this.targetRPM = targetRPM;
    }

    @Override
    protected void initialize() {
        log.debug("Initializing ShooterToRPMCommand");
    }

    @Override
    protected void execute() {
        log.debug("Exec ShooterToRPMCommand");
        Robot.shooterSubsystem.spinToRPM(targetRPM);
    }


    @Override
    protected void interrupted() {
        log.debug("Interrupted ShooterToRPMCommand");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        log.debug("Ending ShooterToRPMCommand " + timeSinceInitialized());
    }
}

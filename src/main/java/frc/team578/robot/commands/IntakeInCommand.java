package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team578.robot.Robot;
import frc.team578.robot.utils.Timer2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntakeInCommand extends Command {

    private static final Logger log = LogManager.getLogger(IntakeInCommand.class);
    boolean isFinished;

    public IntakeInCommand() {
//        requires(Robot.intakeSubsystem);
//        requires(Robot.conveyorSubsystem);
    }

    @Override
    protected void initialize() {
        log.debug("Initializing IntakeInCommand");
    }

    @Override
    protected void execute() {
//        SmartDashboard.putBoolean("Intake",Robot.conveyorSubsystem.isIntakeSensorTripped());
        log.debug("Exec IntakeInCommand");
/*        if(Robot.conveyorSubsystem.isIntakeSensorTripped()) {
            Robot.intakeSubsystem.stop();
        } else {
            Robot.intakeSubsystem.intakeSpinIn();
        }*/

        Robot.intakeSubsystem.intakeSpinIn();

    }


    @Override
    protected void interrupted() {
        Robot.intakeSubsystem.stop();
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

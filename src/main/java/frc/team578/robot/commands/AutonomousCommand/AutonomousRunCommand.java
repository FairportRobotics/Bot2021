package frc.team578.robot.commands.AutonomousCommand;

import edu.wpi.first.wpilibj.command.Command;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AutonomousRunCommand extends Command {
    boolean firstSecond;
    public AutonomousRunCommand(boolean firstSecond) {
        this.firstSecond = firstSecond;

        requires(Robot.swerveDriveSubsystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {


        if (firstSecond) {
            Robot.swerveDriveSubsystem.move(-.5, 0, 0, 0);
        } else {
            Robot.swerveDriveSubsystem.move(0,0,0,0);
        }
    }

    @Override
    protected void interrupted() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }
}
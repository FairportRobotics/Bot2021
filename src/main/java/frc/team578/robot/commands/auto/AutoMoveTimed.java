package frc.team578.robot.commands.auto;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.team578.robot.Robot;

public class AutoMoveTimed extends TimedCommand {


    private final String name;
    private final double fwd;
    private final double strafe;
    private final double rotation;
    private final double timeoutSeconds;

    public AutoMoveTimed(String name, double fwd, double strafe, double rotation, double timeoutSeconds) {
        super(name, timeoutSeconds);
        this.name = name;
        this.fwd = fwd;
        this.strafe = strafe;
        this.rotation = rotation;
        this.timeoutSeconds = timeoutSeconds;
        requires(Robot.swerveDriveSubsystem);
    }

    @Override
    protected void execute() {
        Robot.swerveDriveSubsystem.move(fwd,strafe,rotation,Robot.gyroSubsystem.getHeading());
    }

    @Override
    protected void interrupted() {
        Robot.swerveDriveSubsystem.stop();
    }

    @Override
    protected void end() {
        Robot.swerveDriveSubsystem.stop();
    }

}

package frc.team578.robot.commands.auto;


import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.team578.robot.Robot;

public class AutoTurnToHeading extends PIDCommand {

    private final double heading;

    private static final double kP = 0.04;
    private static final double kI = 0.00;
    private static final double kD = 0.075;

    private final double kTolerancePercent = 1.0;

    private boolean hasRunReturnPidInputAtLeastOnce;

    public AutoTurnToHeading(double heading) {

        super("turn to " + heading, kP, kI, kD);
        this.heading = heading;
        requires(Robot.swerveDriveSubsystem);
        setInputRange(0.f, 360.f);
        getPIDController().setPercentTolerance(kTolerancePercent);
        getPIDController().setContinuous(true);
        getPIDController().setOutputRange(-.3,.3);
        setSetpoint(heading);
    }

    @Override
    protected void initialize() {
        hasRunReturnPidInputAtLeastOnce = false;
    }

    @Override
    protected boolean isFinished() {
        return this.getPIDController().onTarget() && hasRunReturnPidInputAtLeastOnce && Math.abs(Robot.gyroSubsystem.getRate()) <= 0.3;
    }

    @Override
    protected double returnPIDInput() {
        if (!hasRunReturnPidInputAtLeastOnce)
            hasRunReturnPidInputAtLeastOnce = true;
        return Robot.gyroSubsystem.getHeading();
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.swerveDriveSubsystem.move(0, 0, output, Robot.gyroSubsystem.getHeading());
    }
}

package frc.team578.robot.commands.shooter;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team578.robot.Robot;

public class ShooterMoveRPMDownCommand extends CommandGroup {
    public ShooterMoveRPMDownCommand() {
//        requires(Robot.shooterSubsystem);

        addSequential(new ShooterDecrementRPM());
        addSequential(new ShooterToDefaultRPMCommand());
    }

}

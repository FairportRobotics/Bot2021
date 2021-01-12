package frc.team578.robot.commands.auto.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team578.robot.commands.ShooterSingleShotCommand;
import frc.team578.robot.commands.auto.AutoTurnToHeading;

public class MoveTurnShootTest extends CommandGroup {
    public MoveTurnShootTest() {
        addSequential(new MoveBackwardOffLine());
        addSequential(new AutoTurnToHeading(45));
        addSequential(new ShooterSingleShotCommand());
    }


}

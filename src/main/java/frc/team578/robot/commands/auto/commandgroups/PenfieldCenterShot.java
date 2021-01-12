package frc.team578.robot.commands.auto.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team578.robot.commands.ShooterSingleShotCommand;
import frc.team578.robot.commands.auto.AutoMoveTimed;
import frc.team578.robot.commands.auto.AutoTurnToHeading;

public class PenfieldCenterShot extends CommandGroup {

    public PenfieldCenterShot(int shooterRPM) {
        addSequential(new MoveBackwardOffLine());
        addSequential(new AutoTurnToHeading(17.9));
        addSequential(new ShooterSingleShotCommand(shooterRPM));
    }

    public PenfieldCenterShot() {
        addSequential(new MoveBackwardOffLine());
        addSequential(new AutoTurnToHeading(17.9));
        addSequential(new ShooterSingleShotCommand());

    }
}

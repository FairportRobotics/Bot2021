package frc.team578.robot.commands.auto.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team578.robot.commands.ConveyorAdvanceSingleBall;
import frc.team578.robot.commands.ShooterSingleShotCommand;
import frc.team578.robot.commands.ShooterToTargetRPMCommand;
import frc.team578.robot.commands.auto.AutoTurnToHeading;

public class PenfieldLeftShot extends CommandGroup {

    public PenfieldLeftShot(int shooterRPM) {
        addSequential(new MoveBackwardOffLine());
        addSequential(new AutoTurnToHeading(40)); // 32.86
        addSequential(new ShooterSingleShotCommand(shooterRPM));
    }

    public PenfieldLeftShot() {
        addSequential(new MoveBackwardOffLine());
        addSequential(new AutoTurnToHeading(40));
        addSequential(new ShooterSingleShotCommand());
    }


}

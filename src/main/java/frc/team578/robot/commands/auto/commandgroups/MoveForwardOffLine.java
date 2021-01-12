package frc.team578.robot.commands.auto.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team578.robot.commands.auto.AutoMoveTimed;

public class MoveForwardOffLine extends CommandGroup {
    public MoveForwardOffLine() {
        addSequential(new AutoMoveTimed("AutoMoveForward", -0.5, 0, 0, 1));
    }
}

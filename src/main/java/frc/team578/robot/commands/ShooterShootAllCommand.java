package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShooterShootAllCommand extends CommandGroup {

public ShooterShootAllCommand() {
    addSequential(new ShooterToDefaultRPMCommand());
    addSequential(new ConveyorSpinToShooterCommand());
}


}

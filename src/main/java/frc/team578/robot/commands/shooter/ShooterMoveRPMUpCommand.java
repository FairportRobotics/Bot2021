package frc.team578.robot.commands.shooter;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ShooterMoveRPMUpCommand extends CommandGroup {

    private static final Logger log = LogManager.getLogger(ShooterMoveRPMUpCommand.class);

    public ShooterMoveRPMUpCommand() {
//        requires(Robot.shooterSubsystem);

        addSequential(new ShooterIncrementRPM());
        addSequential(new ShooterToDefaultRPMCommand());
    }

}

package frc.team578.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team578.robot.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShooterSingleShotCommand extends CommandGroup {

    public ShooterSingleShotCommand(int shooterRPM) {
        addSequential(new ShooterToTargetRPMCommand(shooterRPM));
        addSequential(new ConveyorAdvanceSingleBall());
    }


    public ShooterSingleShotCommand() {
        addSequential(new ShooterToDefaultRPMCommand());
//        addSequential(new ShooterWaitForSpinUp(2));
        addSequential(new ConveyorAdvanceSingleBall());
        // TODO : Spin Down Shooter?
    }

}

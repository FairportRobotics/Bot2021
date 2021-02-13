package frc.team578.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.shuffleboard.EventImportance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.team578.robot.commands.auto.commandgroups.*;
import frc.team578.robot.commands.auto.enums.AutoActionEnum;
import frc.team578.robot.commands.auto.enums.AutoStartingPositionEnum;
import frc.team578.robot.subsystems.*;
import frc.team578.robot.utils.ChooserUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static frc.team578.robot.commands.auto.enums.AutoActionEnum.PENFIELD_CENTER;

public class Robot extends TimedRobot {

    private static final Logger log = LogManager.getLogger(Robot.class);

    // Operator Interface
    public static OI oi;

    // Subsystem
    public static SwerveDriveSubsystem swerveDriveSubsystem;
    public static IntakeSubsystem intakeSubsystem;
    public static ShooterSubsystem shooterSubsystem;
    public static ClimberSubsystem climberSubsystem;
    public static SpinnerSubsystem spinnerSubsystem;
    public static GyroSubsystem gyroSubsystem;
    public static UsbCamera camera;
    public static ConveyorSubsystem conveyorSubsystem;

    private SendableChooser<AutoStartingPositionEnum> startingPositionChooser;
    private SendableChooser<AutoActionEnum> autoActionChooser;
    Command autonomousCommand;




    @Override
    public void robotInit() {

        try {
            Shuffleboard.addEventMarker("Command initialized", "Robot Init", EventImportance.kNormal);

            log.info("Starting Robot Init");

            gyroSubsystem = new GyroSubsystem("gyro");
            gyroSubsystem.initialize();
            log.info("Gyro Subsystem Initialized");

            swerveDriveSubsystem = new SwerveDriveSubsystem();
            swerveDriveSubsystem.initialize();
            log.info("Swerve Drive Subsystem Initialized");

            intakeSubsystem = new IntakeSubsystem();
            intakeSubsystem.initialize();
            log.info("Intake Subsystem Initialized");

            conveyorSubsystem = new ConveyorSubsystem();
            conveyorSubsystem.initialize();
            log.info("Conveyor Subsystem Initialized");

            shooterSubsystem = new ShooterSubsystem();
            shooterSubsystem.initialize();
            log.info("Shooter Subsystem Initialized");

            climberSubsystem = new ClimberSubsystem();
            climberSubsystem.initialize();
            log.info("Climber Subsystem Initialized");

//            spinnerSubsystem = new SpinnerSubsystem();
//            spinnerSubsystem.initialize();
//            log.info("Spinner Subsystem Initialized");

//            camera = CameraServer.getInstance().startAutomaticCapture();
//            // cam.setResolution(100, 75);
//            // cam.setFPS(-1);
//            log.info("Initialized Camera");

            oi = new OI();
            oi.initialize();
            log.info("OI Subsystem Initialized");

            autoActionChooser = ChooserUtil.initializeAutoActionChooser();
            log.info("Initialized Auto Action Chooser");

        } catch (Throwable t) {
            log.error("Error In Robot Initialization : " + t.getMessage(), t);
            throw t;
        }

        log.info("Robot Init Complete");
    }

    @Override
    public void robotPeriodic() {

        Scheduler.getInstance().run();
    }


    @Override
    public void autonomousInit() {

        Robot.swerveDriveSubsystem.stop();
        Robot.swerveDriveSubsystem.moveAllWheelsToTrueNorth();

        /*
          TODO : Do we want to lower the arm at the beginning (or is this manual)
         */

        DriverStation.Alliance color = DriverStation.getInstance().getAlliance();
        log.info("Alliance Color [" + color.name() + "]");

        AutoActionEnum autoActionEnum = autoActionChooser.getSelected();

        // TODO: Find an rpm
        switch (autoActionEnum) {
            case PENFIELD_LEFT:
                autonomousCommand = new PenfieldLeftShot(6000);
                break;
            case PENFIELD_CENTER:
                autonomousCommand = new PenfieldCenterShot(4350);
                break;
            case PENFIELD_RIGHT:
                autonomousCommand = new PenfieldRightShot(4240);
                break;
            case CROSS_LINE_FORWARD:
                autonomousCommand = new MoveForwardOffLine();
                break;
            default:
                autonomousCommand = new MoveBackwardOffLine();
                break;
        }

        log.info("Autonomous Command : " + autonomousCommand.getName());

        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
    }

    @Override
    public void autonomousPeriodic() {

        updateAllDashboards();
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
        Robot.swerveDriveSubsystem.stop();
        Robot.swerveDriveSubsystem.setModeField();
    }

    @Override
    public void teleopPeriodic() {
        updateAllDashboards();
        Scheduler.getInstance().run();
    }

    @Override
    public void testInit() {
    }

    @Override
    public void testPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
        super.disabledInit();
        Robot.shooterSubsystem.stop();
        Robot.swerveDriveSubsystem.stop();
        Robot.conveyorSubsystem.stop();
        Robot.intakeSubsystem.stop();
    }

    @Override
    public void disabledPeriodic() {
        updateAllDashboards();
        Scheduler.getInstance().run();
    }


    public void updateAllDashboards() {
//        Robot.swerveDriveSubsystem.updateDashboard();
//        Robot.gyroSubsystem.updateDashboard();
//        Robot.conveyorSubsystem.updateDashboard();
        Robot.shooterSubsystem.updateDashboard();
    }

    public void handleGameData() {
        String gameData = DriverStation.getInstance().getGameSpecificMessage();
        if(gameData.length() > 0)
        {
            switch (gameData.charAt(0))
            {
                case 'B' :
                    //Blue case code
                    break;
                case 'G' :
                    //Green case code
                    break;
                case 'R' :
                    //Red case code
                    break;
                case 'Y' :
                    //Yellow case code
                    break;
                default :
                    //This is corrupt data
                    break;
            }
        } else {
            //Code for no data received yet
        }
    }
}

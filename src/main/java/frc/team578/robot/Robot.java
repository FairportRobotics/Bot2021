package frc.team578.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.shuffleboard.EventImportance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.team578.robot.subsystems.*;
import frc.team578.robot.subsystems.swerve.motionProfiling.FieldPosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    public static FeederSubsystem feederSubsystem;
    public static Steer steer;



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

            motionProfiling = new MotionProfiling();

            intakeSubsystem = new IntakeSubsystem();
            intakeSubsystem.initialize();
            log.info("Intake Subsystem Initialized");

            feederSubsystem = new FeederSubsystem();
            feederSubsystem.initialize();
            log.info("Feeder Subsystem Initialized");

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

        MotionProfiling.resetProfiling();

        /*
          TODO : Do we want to lower the arm at the beginning (or is this manual)
         */

        DriverStation.Alliance color = DriverStation.getInstance().getAlliance();
        log.info("Alliance Color [" + color.name() + "]");

    }

    @Override
    public void autonomousPeriodic() {

        updateAllDashboards();
        Scheduler.getInstance().run();
        FieldPosition.periodic();
        motionProfiling.periodic();
    }

    @Override
    public void teleopInit() {
        Robot.swerveDriveSubsystem.stop();
        Robot.swerveDriveSubsystem.setModeField();
        Robot.gyroSubsystem.reset();
        MotionProfiling.resetProfiling();

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
        Robot.feederSubsystem.stop();
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

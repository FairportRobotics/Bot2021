package frc.team578.robot.subsystems.swerve.motionProfiling;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.drive.Vector2d;
import frc.team578.robot.Robot;
import frc.team578.robot.subsystems.swerve.Steer;

import java.util.ArrayList;

public class MoveStrength {

    private double angDeriv = 10;
    private long prevTime;
    private double  angle, prevHeading;
    double iTotal;
    private Steer steer;

    public MoveStrength(){
        steer = new Steer();
        prevTime = System.currentTimeMillis();
        prevHeading = Robot.gyroSubsystem.getHeading();
    }


    public void move(Vector2d pos, double rot){
        
        long time = System.currentTimeMillis();

        double px = FieldPosition.getBotXPosition() - pos.x;
        double py = FieldPosition.getBotYPosition() - pos.y;
        double dx = FieldPosition.getBotXSpeed();
        double dy = FieldPosition.getBotYSpeed();
       
        
        double p = Points.pidValues[0];
        double i = 0;  // not functional
        double d = Points.pidValues[2];

        double dl = d*Math.sqrt(dx*dx + dy*dy);
        //Vector2d power = new Vector2d(px*p + dx*d + iTotal*i/1.4142, py*p + dy*d + iTotal*i/1.4142);
        Vector2d power = new Vector2d(px*p + iTotal*i/1.4142, py*p + iTotal*i/1.4142);
        double a = Math.atan2(power.y, power.x);
        
        double heading = Math.toRadians(Robot.gyroSubsystem.getHeading());
        double anglePower =  heading - angle;
        anglePower %= 2*Math.PI;
        if(Math.abs(anglePower) > Math.PI)                                     //TODO: compare to swervebot code!!!
            anglePower += 2*Math.PI*(anglePower<0? 1: -1);
        if(Math.abs(anglePower) > 1)
            anglePower = (anglePower<0? -1: 1);
        double angSpeed = (heading-prevHeading)/(time-prevTime)*angDeriv;
        anglePower -= angSpeed;
        
        setBotPower(new Vector2d(power.x - dl*Math.cos(a), power.y - dl*Math.sin(a)), anglePower);
        prevTime = time;
        prevHeading = heading;
    }

    private void setBotPower(Vector2d vec, double angle){

        if(vec.magnitude() > 1)
            vec = new Vector2d(vec.x/vec.magnitude(), vec.y/vec.magnitude());  // normalizing

        Robot.swerveDriveSubsystem.move(vec.x, vec.y, angle, Robot.gyroSubsystem.getHeading());

    }
    

    public static void resetProfiling(){
        FieldPosition.resetBotPosition();
        FieldPosition.resetBotSpeed();
    }
}
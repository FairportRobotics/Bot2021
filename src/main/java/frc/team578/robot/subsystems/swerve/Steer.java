package frc.team578.robot.subsystems.swerve;

import edu.wpi.first.wpilibj.drive.Vector2d;
import frc.team578.robot.Robot;
import frc.team578.robot.subsystems.swerve.motionProfiling.FieldPosition;
import frc.team578.robot.subsystems.swerve.motionProfiling.MoveStrength;
import frc.team578.robot.subsystems.swerve.motionProfiling.Points;

public class Steer{    

    MoveStrength moveStrength;

    ControlMode controlMode;
    private final double CONTROLLER_DISTANCE = 3; // max conponent distance controller can set point.
    private Vector2d[] botPath;
    private double[] botRot;
    private long timeInit;

        // reads/resets points, resets bot position to origin
    public void init(){
        moveStrength = new MoveStrength();
        readPts();
        restart();
    }

    Vector2d autoPos, pos;  // desired position on field
    double autoRot, rot;

    protected void periodic(){
        if(controlMode == ControlMode.AUTO){
            if(botPath != null){
                int ind = (int)((System.currentTimeMillis() - timeInit)
                    *((double)Points.CURVES_PER_SECOND)*((double)Points.POINTS_PER_CURVE)/1000);
                
                if(ind < botPath.length){
                    autoPos = botPath[ind];
                    autoRot = botRot[ind];
                }
                pos = new Vector2d(autoPos.x - botPath[0].x, autoPos.y - botPath[0].y);
                rot = autoRot;
            }
        }
        if(controlMode == ControlMode.USER){
            pos = new Vector2d(Robot.oi.leftJoystick.getY(), Robot.oi.leftJoystick.getX());
            rot = deadband(Robot.oi.rightJoystick.getX());

            double mag = pos.magnitude();
            double ratio = 0;
            if(mag > .001)
                ratio = deadband(mag)/mag * CONTROLLER_DISTANCE;
            pos = new Vector2d(pos.x*ratio + FieldPosition.getBotXPosition(), pos.y*ratio + FieldPosition.getBotXPosition());
        }
        moveStrength.move(pos, rot);
    }

    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

    final double DEADBAND = .2;

    private double deadband(double value) {
        if (Math.abs(value) < DEADBAND) return 0.0;
        return (1/(1-DEADBAND) - DEADBAND/(1-DEADBAND)/Math.abs(value))*value;
    }
    
    public void setControlMode(ControlMode cm){
        controlMode = cm;
    }



    private void readPts(){
        double[] pathIn = Points.getTotalPoints();
        botPath = new Vector2d[pathIn.length/3];
        botRot = new double[pathIn.length/3];
        for(int i = 0; i < pathIn.length/3; i++){
            botPath[i] = new Vector2d(pathIn[3*i], pathIn[3*i + 1]);
            botRot[i] = pathIn[3*i + 2];
        }
    }

    public void restart(){  // pure pursuit
        timeInit = System.currentTimeMillis();
        MoveStrength.resetProfiling();
    }
}

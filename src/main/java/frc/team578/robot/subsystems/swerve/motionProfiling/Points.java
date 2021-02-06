package frc.team578.robot.subsystems.swerve.motionProfiling;

import java.util.ArrayList;
import frc.team578.robot.commands.*;

public class Points{
public static final double curvesPerSec = 0.42;
public static final int pointsPerCurve = 10;
public static final double[] pidValues = {1.0, 0.0, 0.07999999821186066};

protected static class TimedCommand{
public String name;
public double t;

protected TimedCommand(String name, double t){
this.name = name;
this.t = t;
}
public double getT(){
return t;
}
public String getName(){
return name;
}
}

public static TimedCommand[] commands = {};
private static class p0{
private static double[] getPoints0(){
double[] d = {2.461538553237915, 10.0, 0.0, 4.963076591491699, 10.00304889678955, 0.0, 7.464615345001221, 10.006097793579102, 0.0, 9.966153144836426, 10.009146690368652, 0.0, 12.467692375183105, 10.012195587158203, 0.0, 14.969230651855469, 10.015243530273438, 0.0, 17.470767974853516, 10.018293380737305, 0.0, 19.972307205200195, 10.021341323852539, 0.0, 22.473846435546875, 10.024391174316406, 0.0, 24.975385665893555, 10.02743911743164, 0.0};
return d;
}
public static double[] getTotalPoints(){
double[] d0 = getPoints0();
double[] d = new double[d0.length];
ArrayList<double[]> dd = new ArrayList<double[]>();
dd.add(d0);
int ind = 0;
for(int i = 0; i < dd.size(); i++){
double[] ddd = dd.get(i);
for(int j = 0; j < ddd.length; j++){
d[ind] = ddd[j];
ind++;
}
}
return d;
}
}
public static double[] getTotalPoints(){
double[] d0 = p0.getTotalPoints();
double[] d = new double[d0.length];
ArrayList<double[]> dd = new ArrayList<double[]>();
dd.add(d0);
int ind = 0;
for(int i = 0; i < dd.size(); i++){
double[] ddd = dd.get(i);
for(int j = 0; j < ddd.length; j++){
d[ind] = ddd[j];
ind++;
}
}
return d;
}
}

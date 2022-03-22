package org.usfirst.frc.team399.Utilities;

import org.usfirst.frc.team399.Config.Constants;

public class Follower {

	Segment[] trajectory;
	double kP,kI,kD,setPoint;
	double prevError = 0.0;
	
	double sumOfErrors = 0.0;
	public Follower() {
		
	}
	
	public double calcFeedForward(double velocity, double acceleration) {
		return ((velocity * Constants.MotionProfile.kV)+(acceleration * Constants.MotionProfile.kA));
	}
	
	public void setPID(double p, double i, double d){
		kP = p;
		kI = i;
		kD = d;
	}
	
	public double getPIDOutput(double sp, double currentPosition,double time) {
		setPoint = sp;
		double error = setPoint - currentPosition;
		sumOfErrors += error;
		
		double changeInError = (error - prevError)/time;
		double output = (kP * error) + (kI * sumOfErrors) + (kD * changeInError);
		prevError = error;
		return output;
		
		
	}
	
	public double getMotorOutput(double currentInches, Segment seg, double time, boolean inReverse) {
		Segment point = seg;
		double velocity = point.getVelocity();
		double acceleration = point.getAcceleration();
		double position = point.getPosition();
		double finalMotorOutput = calcFeedForward(velocity,acceleration) + getPIDOutput(setPoint,currentInches,time);
		return (inReverse ? -finalMotorOutput : finalMotorOutput);
		
	}
	
}

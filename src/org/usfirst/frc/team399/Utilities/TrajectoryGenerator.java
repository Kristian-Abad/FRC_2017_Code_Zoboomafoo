package org.usfirst.frc.team399.Utilities;

import org.usfirst.frc.team399.Config.Constants;
import org.usfirst.frc.team399.Utilities.Segment;

public class TrajectoryGenerator {
	
	double rMaxVelocity,
		   rMaxAcceleration;
	
    public TrajectoryGenerator(double maximumVelocity, double maximumAcceleration){
		rMaxVelocity = maximumVelocity;
		rMaxAcceleration = maximumAcceleration;
		
	}
	
	public double getMaximumVelocity(double distance){
		//Check math on getting the maximum velocity in the distance we are given or desire, might have to multiply by 2
		double calculatedVelocity = Math.sqrt(2*rMaxAcceleration*distance);
		double max = Math.min(rMaxVelocity, calculatedVelocity);
		return max;
	}
	
	public Segment[] generateTrajectory(double desiredDistance,int desiredPoints){
		double maximumVelocity = getMaximumVelocity(desiredDistance);
		double accelerationTime = (maximumVelocity - Constants.MotionProfile.initialVelocity)/rMaxAcceleration;
		double accelerationDistance = Constants.MotionProfile.initialVelocity * accelerationTime + 0.5 * rMaxAcceleration * Math.pow(accelerationTime, 2);
		double decelerationTime = (maximumVelocity - Constants.MotionProfile.finalVelocity)/rMaxAcceleration;
		double decelerationDistance = maximumVelocity * decelerationTime - 0.5 * rMaxAcceleration * Math.pow(decelerationTime, 2);
		double cruiseDistance = desiredDistance - (accelerationDistance + decelerationDistance);
		double cruiseTime = cruiseDistance/maximumVelocity;
		double totalTime = accelerationTime + cruiseTime + decelerationTime;
		
		int modifiedPoints = desiredPoints * 2;
//		int totalPoints = (totalTime/modifiedPoints);
		
		Segment[] trajectory = new Segment[modifiedPoints];
		double time = 0.0;
		
		for(int i = 0; i<= modifiedPoints; i++){
			double velocity,
				   acceleration,
				   position;
			
		    if(time <= accelerationTime){
		        velocity = Constants.MotionProfile.initialVelocity + rMaxAcceleration * time;
		        acceleration = rMaxAcceleration;
		        position = 0.5 * acceleration * Math.pow(time,2);
		    }else if(time >= accelerationTime && time <= accelerationTime+cruiseTime){
		        velocity = maximumVelocity;
		        acceleration = 0;
		        position = velocity*time;
		    }else{
		        double partOfTime = (time - (accelerationTime+cruiseDistance));
		        velocity = maximumVelocity - (rMaxAcceleration * partOfTime);
		        acceleration = -rMaxAcceleration;
		        position = (accelerationDistance + cruiseDistance) + (0.5 * rMaxAcceleration * Math.pow(partOfTime,2));
		    }
		    
		    time += modifiedPoints;
		    Segment toTrajectory = new Segment(velocity,acceleration,position);
		    trajectory[i] = toTrajectory;
		    
		    //Conditional operator version
		}
		
		return trajectory;
	}
}

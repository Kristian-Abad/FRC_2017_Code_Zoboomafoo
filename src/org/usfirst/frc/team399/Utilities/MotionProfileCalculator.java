package org.usfirst.frc.team399.Utilities;

public class MotionProfileCalculator {

//	double avgVelocity, 
//		   desiredTimeElapsed, 
//		   maxVelocity,
//		   constantVelocity,
//		   acceleration,
//		   distanceGiven,
//		   distancePointInTime,
//		   velocityPointInTimeWheels,
//		   accelerationPointInTime;
	double recordedDistanceInInches,
		   avgRobotVelocity,
		   recordedTime,
		   maxRobotVelocity,
		   robotAcceleration,
		   avgProfileVelocity,
		   maxProfileVelocity,
		   profileTimeInSeconds,
		   cruiseVelocity,
		   profileAcceleration,
		   profileDeceleration,
		   distanceCalculatedFromVInitialtoVCruise,
		   timeSpentDuringCruiseVelocity,
		   onethirtiethprofileTimeInSeconds,
		   distancePointInTime,
		   velocityPointInTime,
		   accelerationPointInTime;
	
	
	public MotionProfileCalculator(double distanceInInches, double timeInSeconds){
		recordedDistanceInInches = distanceInInches;
		recordedTime = timeInSeconds;
		avgRobotVelocity = distanceInInches/timeInSeconds;
		
		
		System.out.println("Robot velocity is:" + avgRobotVelocity + "inches per second");
	}
	
	public void calculate(double profileDistanceInInches){
		maxRobotVelocity = 1.5 * recordedDistanceInInches/recordedTime;
		robotAcceleration = 4.5 * recordedDistanceInInches/Math.pow(recordedTime, 2);
		
		
		profileTimeInSeconds = avgRobotVelocity/profileDistanceInInches;
		avgProfileVelocity = profileDistanceInInches/profileTimeInSeconds;
		maxProfileVelocity = 1.5 * profileDistanceInInches/profileTimeInSeconds;
		profileAcceleration = 4.5 * profileDistanceInInches/Math.pow(profileTimeInSeconds, 2);
		
		//Not sure if deceleration is correct
		profileDeceleration = -profileAcceleration;
		cruiseVelocity = Math.min(maxRobotVelocity, maxProfileVelocity);
		
		//I think this is distance calculated from v initial to v cruise not the segment before the flat line
		distanceCalculatedFromVInitialtoVCruise = avgProfileVelocity * 
												  profileTimeInSeconds + 1/2 * 
												  profileAcceleration * Math.pow(profileTimeInSeconds, 2);
		timeSpentDuringCruiseVelocity = cruiseVelocity/distanceCalculatedFromVInitialtoVCruise;
		
		onethirtiethprofileTimeInSeconds = profileTimeInSeconds/30;
		
		for(double i = profileTimeInSeconds/30; i <= profileTimeInSeconds; i += onethirtiethprofileTimeInSeconds ){
			//velocity, distance and acceleration for given time i
			
			velocityPointInTime = (velocityPointInTime == cruiseVelocity? cruiseVelocity : distancePointInTime/i);
			distancePointInTime = velocityPointInTime * 
					  i + 1/2 * 
					  accelerationPointInTime * Math.pow(i, 2);
			accelerationPointInTime = velocityPointInTime/Math.pow(i, 2);
			
			System.out.println("Current Second:" + i + 
							   "Velocity:" + velocityPointInTime + 
							   "Acceleration:" + accelerationPointInTime + 
							   "Distance:" + distancePointInTime);
		}
	}
	
//	public void calculate(/*double currentDistance, double currentTime*/){
//		maxVelocity = 1.5 * avgVelocity;
//		acceleration = 4.5 * distanceGiven/ Math.pow(desiredTimeElapsed, 2);
//		constantVelocity = maxVelocity;
//		for(int i = 1; i <= desiredTimeElapsed; i++){
//			distancePointInTime = avgVelocity * i;
//			velocityPointInTimeWheels = (velocityPointInTimeWheels >= constantVelocity? constantVelocity: distancePointInTime/i );//distancePointInTime/i;
//			accelerationPointInTime = (velocityPointInTimeWheels == constantVelocity ? 0 :velocityPointInTimeWheels/Math.pow(i, 2));
//			
//			
//			System.out.println("Point in time (in seconds)" + i + "Distance:" + distancePointInTime + "Acceleration:" + accelerationPointInTime);
//			
//		}
//	}
	
}

package org.usfirst.frc.team399.Config;

public class Constants {
	
	public static class Drivetrain{
// 		Might need these if we decide to switch to not setting the distance per pulse in initialization on the encoders		
//		public static final int WHEEL_DIAMETER_IN_INCHES = 4;
//		public static final int WHEEL_RADIUS_IN_INCHES = 2;
//		public static double PULSES_IN_ONE_REVOLUTION = 13;
//		public static double CIRCUMFERENCE_OF_WHEEL_IN_INCHES = 2*Math.PI*WHEEL_RADIUS_IN_INCHES;
		
		public static final double INCHES_PER_PULSE = 0.07479982508630952380952380952381;
		
	}
	
	public static class Shooter{
		public static double RPM_IN_FRONT_OF_BOILER;
	}
	
	public static class Distances{

		
	}
	
	public static class MotionProfile{
		/**Max velocity calculated on the premise that when recording it looked like the 
		robot could not have gone any faster, even when we stopped. In other words the robot reached the max velocity
		when we**/
		public static final double maxRobotVelocity = 83;
		public static final double maxAcceleration = 26;
		public static final double initialVelocity = 0;
		public static final double finalVelocity = 0;
		
		
		public static final int TotalPoints = 200;
		public static final double kV = 0.0120481928;
		public static final double kA = 0.0384615385;
	}

}

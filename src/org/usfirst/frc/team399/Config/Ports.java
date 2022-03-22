package org.usfirst.frc.team399.Config;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;

public class Ports {
	public static class Controls{
		public static int Driver_Joystick_1 = 0;
		public static int Driver_Joystick_2 = 1;
		public static int Driver_Joystick_OperatorGamepad = 2;
		
	}
	
	public static class DriveTrain{
		public static int Drive_Ports[] = {11,12,4,5};
		
	
		public static int Left_1_ID = 11;
		public static int Left_2_ID = 12;
		public static int Right_1_ID = 4;
		public static int Right_2_ID = 5;
		public static int LeftEnc_A = 2;
		public static int LeftEnc_B = 3;
		public static int RightEnc_A = 0;
		public static int RightEnc_B = 1;
		public static Port GYRO_ID = SPI.Port.kMXP;
	} 
	
	public static class Intake{
//		public static int Intake_Ports[] = {1,8};
		public static int Intake_1_ID = 1;
		public static int Intake_2_ID = 8;
		public static int Solenoid_Pivot_1_ID = 1;
	}
	
	public static class GearPickup{
		//wheel was 7
		public static int GearPickup_Pivot_1_ID = 0;
		public static int GearPickup_Wheel1_ID = 14;
	}
		
	public static class Shooter{
//		public static int Shooter_Ports[] = {3,10};
		public static int Shooter_1_ID = 3;
		public static int Shooter_2_ID = 10;
		
		public static int Feeder_1_ID = 2;
		public static int Feeder_2_ID = 9;
		public static int Feeder_3_ID = 7;
	}
	
	public static class Hanger{
//		public static int Hanger_Ports[] = {6,13};
		public static int Hanger_1_ID = 6;
		public static int Hanger_2_ID = 13;
	}
	
	public static class Spare{
//		public static int Spare_1_ID = 14;
		
	}
	
}

package org.usfirst.frc.team399.Systems;

import org.usfirst.frc.team399.Config.Constants;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.FeedbackDeviceStatus;
import com.ctre.CANTalon.TalonControlMode;

public class Shooter {
	
	public CANTalon shooter1,shooter2,feed1,feed2,feed3;
	
	//just to test
	public static final int RUN_SHOOT = -1;
	public static final int REVERSE_SHOOT = 1;
	public static final int RUN_FEED = -1;
	public static final int REVERSE_FEED = 1;
	public static final int DISABLED = 0;
	
	//FIX NAMES BECAUSE FEED IS ACTUALLY SHOOTER< AND SHOOTER IS ACTUALLY FEEDER
	public Shooter(int fee1, int fee2,int fee3,int sh1, int sh2 ){
		feed1= new CANTalon(sh1);
		feed2 = new CANTalon(sh2);
		feed3 = new CANTalon(fee3);
		shooter1 = new CANTalon(fee1);
		shooter2 = new CANTalon(fee2);
	}
	
	
	public void runSubsystem(boolean shoot, boolean feed){
	
		shooter1.set(shoot? RUN_SHOOT : DISABLED);
		shooter2.set(shoot? RUN_SHOOT : DISABLED);
		
		feed3.set(feed? RUN_FEED: DISABLED);
		feed1.set(feed ? RUN_FEED : DISABLED);
		feed2.set(feed ? RUN_FEED : DISABLED);
	}
	
//	public void runSubsystem2(boolean revup){
//		FeedbackDeviceStatus status = shooter1.isSensorPresent(FeedbackDevice.CtreMagEncoder_Relative);
//		switch(status){
//		case FeedbackStatusPresent:
//			System.out.println("Encoder is present!");
//			break;
//		case FeedbackStatusNotPresent:
//			System.out.println("Encoder is not present!");
//			break;
//		case FeedbackStatusUnknown:
//			System.out.println("I can't tell if the encoder is plugged in...");
//			break;
//		}
//		
//		shooter1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
//		shooter2.changeControlMode(TalonControlMode.Follower);
//		
//		shooter1.setSetpoint(Constants.Shooter.RPM_IN_FRONT_OF_BOILER);
//		shooter2.set((revup ? shooter1.getDeviceID() : 0 ));
//		
//	}
}

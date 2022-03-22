package org.usfirst.frc.team399.Systems;

import com.ctre.CANTalon;

/**
 * Class for the hanger or climber
 * 
 * **/
public class Hanger {
	private CANTalon hang1 = null;
	private CANTalon hang2 = null;
	private CANTalon hanger[];
	
	
	public static final int CLIMB = 1;
	public static final int REVERSE_CLIMB = -1;
	public static final int DISABLED = 0;

	
	/**
	 * Constructor for the class
	 * @param climb1 The CANTalon id for a Talon SRX
	 * @param climb2 The CANTalon id for a Talon SRX
	 * **/
	public Hanger(int climb1, int climb2){
		
		hang1 = new CANTalon(climb1);
		hang2 = new CANTalon(climb2);
		
		hang1.setInverted(true);
	}
	/**
	 * Simplified Constructor
	 * Test Needed
	 * @param Ports[] Port numbers in the Config.Ports class
	 * **/
//	public void hanger(int Ports[]){
//		for(int i =0; i<=1; i++){
//			hanger[i] = new CANTalon(Ports[i]);
//		}
//	}
	
	/**
	 * Method for actually running the climber
	 * 
	 * @param value Returned value from conditional operator run in the Robot class. 
	 * **/
	public void runSubsystem(boolean value){
//		Test this later
		
		
		hang1.set(value? CLIMB : DISABLED);
		hang2.set(value? CLIMB : DISABLED);
//		if(value){
//			hang1.set(CLIMB);
//			hang2.set(CLIMB);
//		}else{
//			hang1.set(0.0);
//			hang2.set(0.0);
//		}
	}
	
	public void setMotors(boolean val){
		for(int i = 0; i <=1; i++){
			hanger[i].set(val? CLIMB : DISABLED);
		}
	}
	
}

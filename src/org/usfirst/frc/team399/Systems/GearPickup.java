package org.usfirst.frc.team399.Systems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;

public class GearPickup {
	public Solenoid pivotSolenoid;
	public CANTalon wheels;
	boolean toggle = false;
	
	public static final double REVERSE = 0.5;
	public static final double RUN = -1;
	public static final int DISABLED = 0;
	
	public GearPickup(int pivot, int wheelsid){
		pivotSolenoid = new Solenoid(pivot);
		wheels = new CANTalon(wheelsid);
	}
	
	public void runSubsystem(boolean verify, boolean getGear, boolean putGear){
//		pivotSolenoid.set(verify ? /*verify : false*/!toggle : toggle ? toggle : false);
		pivotSolenoid.set(verify ? false : true);
		wheels.set( getGear ? RUN : putGear ? REVERSE : 0);
	}
	
	public void disabled(){
		pivotSolenoid.set(false);
	}
	
	public void enabled(){
		pivotSolenoid.set(true);
	}
	
	public void placeGear(){
		wheels.set(REVERSE);
	}
	
	public void intakeGear(){
		wheels.set(-0.10);
	}
}

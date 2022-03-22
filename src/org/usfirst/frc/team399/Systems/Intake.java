package org.usfirst.frc.team399.Systems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
public class Intake {
	private CANTalon left = null;
	private CANTalon right = null;
//	private CANTalon Intake[];
//	private Solenoid Solenoids[];
	private Solenoid pivotSol;
	boolean toggle = false;
	
	public static final int RUN = -1;
	public static final int REVERSE = 1;
	public static final int DISABLED = 0;
	
	public Intake(int leftmotor, int rightmotor,int pivot){
		left = new CANTalon(leftmotor);
		right = new CANTalon(rightmotor);
		pivotSol = new Solenoid(pivot);
		
		left.setInverted(true);
	}
	
//	public Intake(int motors[], int solenoids[]){
//		for(int i = 0; i<= 1; i++){
//			Intake[i] = new CANTalon(motors[i]);
//		}
//		
//		for(int i = 0; i<= 1; i++){
//			Solenoids[i] = new Solenoid(solenoids[i]);
//		}
//	}
	
//	public void runIntake(boolean value){
////		Test later
////		left.setInverted(true);
//		
//		left.set(value? RUN : DISABLED);
//		right.set(value? RUN : DISABLED);
//	}
	
	public void runSubSystem(int pov,boolean verify){
		boolean toggle = false;
		
		
		
		left.set(pov == 180 ? RUN : pov == 0 ? REVERSE : DISABLED);
		right.set(pov == 180 ? RUN : pov == 0 ? REVERSE : DISABLED);
		
//		pivotSol.set(verify ? !toggle : !verify ? toggle : false);
//		pivotSol.set(verify ? !toggle : !verify ? false : toggle ? toggle : false);
		pivotSol.set(verify);
//		for(int i = 0; i<= 1; i++){
//			Intake[i].set(run? RUN : DISABLED);
//		}
//		
//		for(int i = 0 ; i<=1; i++){
//			Solenoids[i].set(verify ? !toggle : /*!verify ? toggle :*/ false);
//		}
	}

}

package org.usfirst.frc.team399.Config;
/** 
 * Aaron's Subsystem Interface
 * 
 * 
 * **/
public abstract class Subsystem {
	public int state = 0;
	
	public abstract void run();
	
	public class states{
		public static final int DISABLED = 0;
	}
	
	public void setState(int value){
		state = value;
	}
	
	public int getState(){
		return state;
	}
}

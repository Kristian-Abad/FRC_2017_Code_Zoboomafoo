package org.usfirst.frc.team399.Systems;

import org.usfirst.frc.team399.Systems.Supersystem;
import org.usfirst.frc.team399.Config.Ports;
public class Supersystem {
	
	public static Supersystem instance = null;
	
	public TankDrive drive;
	public Intake intake;
	public GearPickup gearpickup;
	public Shooter shooter;
	public Hanger hanger;
	
	private Supersystem(){

		
		drive = new TankDrive(Ports.DriveTrain.Left_1_ID, 
							  Ports.DriveTrain.Left_2_ID, 
							  Ports.DriveTrain.Right_1_ID,
							  Ports.DriveTrain.Right_2_ID,
							  Ports.DriveTrain.LeftEnc_A,
							  Ports.DriveTrain.LeftEnc_B,
							  Ports.DriveTrain.RightEnc_A,
							  Ports.DriveTrain.RightEnc_B,
							  Ports.DriveTrain.GYRO_ID);
		
		intake = new Intake(Ports.Intake.Intake_1_ID,
							Ports.Intake.Intake_2_ID,
							Ports.Intake.Solenoid_Pivot_1_ID);
		
		gearpickup = new GearPickup(Ports.GearPickup.GearPickup_Pivot_1_ID,
									Ports.GearPickup.GearPickup_Wheel1_ID);
		
		shooter = new Shooter(Ports.Shooter.Shooter_1_ID,
							  Ports.Shooter.Shooter_2_ID,
							  Ports.Shooter.Feeder_3_ID,
							  Ports.Shooter.Feeder_1_ID,
							  Ports.Shooter.Feeder_2_ID);
		
		hanger = new Hanger(Ports.Hanger.Hanger_1_ID,
							Ports.Hanger.Hanger_2_ID);
		
//		drive = new TankDrive(Ports.DriveTrain.Drive_Ports);
		
	}
	
	public static Supersystem getInstance(){
		if (instance == null){
			instance = new Supersystem();
		}
		
		return instance; 
	}

}

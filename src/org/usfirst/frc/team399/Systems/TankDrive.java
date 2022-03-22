package org.usfirst.frc.team399.Systems;

import org.usfirst.frc.team399.Config.Constants;
import org.usfirst.frc.team399.Utilities.PIDController;
import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;

public class TankDrive {
	
	private CANTalon lefta = null;
	private CANTalon leftb = null;
	private CANTalon righta = null;
	private CANTalon rightb = null;
	private Encoder leftEnc, rightEnc;
	
	AHRS ahrs;
	
	
//	PIDController PID_Drive = new PIDController(0.003, 0.0, 0.00000000000000001);
	
	public TankDrive(int la, int lb, int ra, int rb, int leftenc_a, int leftenc_b,int rightenc_a, int rightenc_b,Port port) {
		
		lefta = new CANTalon(la);
		leftb = new CANTalon(lb);
		
		righta = new CANTalon(ra);
		rightb = new CANTalon(rb);
		
		leftEnc = new Encoder(leftenc_a,leftenc_b,false,Encoder.EncodingType.k4X);
		rightEnc = new Encoder(rightenc_a,rightenc_b,false,Encoder.EncodingType.k4X);
		rightEnc.setReverseDirection(true);
		
//		leftEnc.setDistancePerPulse(Constants.Drivetrain.INCHES_PER_PULSE);
//		rightEnc.setDistancePerPulse(Constants.Drivetrain.INCHES_PER_PULSE);
		
		leftEnc.setDistancePerPulse(1);
		rightEnc.setDistancePerPulse(1);
		
		
		ahrs = new AHRS(port);
		
		lefta.setInverted(true);
		leftb.setInverted(true);
	}
	
//	public TankDrive(int Ports[]){
//		for(int i = 0 ; i <= 4; i++){
//			drive[i] = new CANTalon(Ports[i]);
//		}
//		
//		for(int i = 0 ; i <= 1 ; i++){
//			for(int j = 0; j <= 1; j++){
//				Encoders[i][j] = new Encoder(Encoder_Ports[i][j],Encoder_Ports[i][j + 1]);
//			}
//		}
//	}
	/**
	 * Method for making the drivetrain run
	 * 
	 * @param leftv Decimal number returned by the Joystick as it is used in the robot class
	 * @param rightv Decimal number returned by the Joystick as it is used in the robot class
	 * **/
	public void setMotors(double leftv, double rightv) {
			
		lefta.set(leftv);
		leftb.set(leftv);
		righta.set(rightv);
		rightb.set(rightv);
		
	}
	
	public void getDistance(){
		System.out.println("Left: " + "\t"+ getLeftDistance() + "Right: " +"\t"+ getRightDistance());
	}
	
	public double getLeftDistance(){
		return leftEnc.getDistance() * 0.07479982508630952380952380952381;
	}
	
	public double getRightDistance(){
		return rightEnc.getDistance() * 0.07479982508630952380952380952381;
	}
	
	public double getAverageDistance(){
		double left = leftEnc.getDistance() * 0.07479982508630952380952380952381;
		double right = rightEnc.getDistance() * 0.07479982508630952380952380952381;
		return (left + right)/2;
	}
	
	public double getCurrentAngle(){
		return ahrs.getAngle();
		
	}
	
	public double getCurrentRadians(){
		return Math.toRadians(getCurrentAngle());
	}
	
	public void resetSensors(){
		leftEnc.reset();
		rightEnc.reset();
		ahrs.reset();
	}
	
//451.00858210293888888888888888889 in/s - avg velocity ( Recorded dist: 1055.360082120877 in Recorded Time: 2.34 s)	
	/**
	 * Cleaner version for tank drive. Will need to test though
	 * Taken from Aaron's 2014 Code
	 * @param speed The value that we will get from the left joystick in the Robot class
	 * @param speed2 The value that we will get from the right joystick in the Robot class
	 * **/
//	public void setMotors(double speed, double speed2){
//		
//		for(int j = 0; j <= 1; j++){
//			drive[j].setInverted(true);
//		}
//		
//		for(int i = 0; i <= 1; i++){
//			drive[i].set(speed);
//		}
//		
//		for(int k = 2; k <= 3; k++){
//			drive[k].set(speed2);
//		}
//	}
	
//	public double getAveragePosition(){
//		double leftDist = leftEnc.getDistance() * Constants.Drivetrain.INCHES_PER_PULSE;
//		double rightDist = rightEnc.getDistance() * Constants.Drivetrain.INCHES_PER_PULSE;
//		double avgDist = leftDist + rightDist / 2;
//		return avgDist;
//		
//	}
	
//	public void pidDrive(double distanceInInches){
//		double averagePulses = leftenc.getDistance() + rightenc.getDistance() /2;
////		double distanceInMeters = distanceInInches/3;
//		double requiredPulses = 4 * distanceInInches;
//		PID_Drive.calculate(averagePulses, requiredPulses);
//		
//		for(int i = 0; i <= 1; i++){
//			drive[i].set(PID_Drive.calculate(averagePulses, requiredPulses));
//		}
//		
//		for(int i = 2; i <= 2; i++){
//			drive[i].set(PID_Drive.calculate(averagePulses, requiredPulses));
//		}
//	}

}

package org.usfirst.frc.team9399.robot;

import org.usfirst.frc.team399.Config.Ports;
import org.usfirst.frc.team399.Systems.Supersystem;
import org.usfirst.frc.team399.Auton.Baseline;
import org.usfirst.frc.team399.Auton.CenterGear;
import org.usfirst.frc.team399.Auton.DoNothing;
import org.usfirst.frc.team399.Config.Constants;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;




public class Robot extends IterativeRobot {
//	final String defaultAuto = "Default";
//	final String customAuto = "My Auto";
//	String autoSelected;
//	SendableChooser<String> chooser = new SendableChooser<>();
	
	SendableChooser autonchooser = new SendableChooser();
	Command autonomousCommand;
	Supersystem Zoboomafoo = Supersystem.getInstance();
	Joystick Driverleft = new Joystick(Ports.Controls.Driver_Joystick_1);
	Joystick Driverright = new Joystick(Ports.Controls.Driver_Joystick_2);
	Joystick OperatorGamepad = new Joystick(Ports.Controls.Driver_Joystick_OperatorGamepad);
	
	
	@Override
	public void robotInit() {
		autonchooser.addDefault("Do Nothing", new DoNothing());
		autonchooser.addObject("Baseline", new Baseline());
		autonchooser.addObject("Center Gear", new CenterGear());
		
		SmartDashboard.putData("Auto choices", autonchooser);
		
		CameraServer.getInstance().startAutomaticCapture();
		
		
	}

	
	@Override
	public void autonomousInit() {
		autonomousCommand = (Command) autonchooser.getSelected();
		if(autonomousCommand != null){
			autonomousCommand.start();
			System.out.println("Chosen auton:" + autonomousCommand);
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void disabledPeriodic(){
		Zoboomafoo.gearpickup.disabled();
	}
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Zoboomafoo.drive.setMotors(Driverleft.getRawAxis(1), Driverright.getRawAxis(1));
//		Zoboomafoo.drive.setMotors(OperatorGamepad.getRawAxis(1), OperatorGamepad.getRawAxis(3));
		Zoboomafoo.gearpickup.runSubsystem(OperatorGamepad.getRawButton(2), OperatorGamepad.getRawButton(7), OperatorGamepad.getRawButton(8));
		Zoboomafoo.intake.runSubSystem(OperatorGamepad.getPOV() == 180 ? 180 : OperatorGamepad.getPOV() == 0 ? 0 : 5, OperatorGamepad.getRawButton(5));
		Zoboomafoo.hanger.runSubsystem(OperatorGamepad.getRawButton(4));
		Zoboomafoo.shooter.runSubsystem(OperatorGamepad.getRawButton(1), OperatorGamepad.getRawButton(3));
		
//		Timer timer = new Timer();
//		if(OperatorGamepad.getRawButton(6)){
//			timer.start();
//		}else {
//			timer.delay(1);
//		}
//		
//		System.out.println(timer.getFPGATimestamp());
//		double time;
//		
//		if(OperatorGamepad.getRawButton(4)){
//			timer.reset();
//			timer.start();
//			time = timer.getFPGATimestamp();
//			
//			System.out.println(time);
////			Zoboomafoo.drive.setMotors(1.0, 1.0);
////			System.out.println("Dist traveled:" + Zoboomafoo.drive.getAveragePosition() + "Time elapsed:" + timer.get());
//			
//		} else{
//			timer.stop();
//			time = 0.0;
//			System.out.println(timer.getFPGATimestamp() - timer.getFPGATimestamp());
//			//System.out.println(timer.getFPGATimestamp());
//		}
		
//		if(OperatorGamepad.getRawButton(4)){
//			Zoboomafoo.drive.resetSensors();
//		}else{
//			
//		}else if(OperatorGamepad.getRawButton(3)){
//			Zoboomafoo.drive.setMotors(-1.0, -1.0);
//		}else{
//			Zoboomafoo.drive.setMotors(0.0, 0.0);
//		}
		
//		System.out.println("Left dist:" + Zoboomafoo.drive.getLeftDistance() + 
//					       "Right dist:" + Zoboomafoo.drive.getRightDistance() + 
//					       "Avg. Dist:" + Zoboomafoo.drive.getAverageDistance());
//		System.out.println(Zoboomafoo.drive.getCurrentAngle());
	
	}

	/**
	 * This function is called periodically during test mode
	 */

	@Override
	public void testPeriodic() {

	}
}


package org.usfirst.frc.team399.Commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team399.Systems.Supersystem;
import org.usfirst.frc.team399.Systems.TankDrive;



public class TimedStraightGearIn extends Command {
	private double leftpower;
	private double rightpower;
	private double timeout;
	
	public TimedStraightGearIn(double lpow, double rpow, double timeout){
		this.leftpower = lpow;
		this.rightpower = rpow;
		this.timeout = timeout;
		
	}
	
	@Override
	protected void initialize() {
		//Supersystem.getInstance().drive.distancedBackwardStraightDrive(leftpower, rightpower, targetDistance, currentAngle, pulse, subtract, decaynum);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Supersystem.getInstance().drive.setMotors(leftpower, rightpower);
		//middle parameter false for Baseline
		Supersystem.getInstance().gearpickup.runSubsystem(true, true, false);
		setTimeout(timeout);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}

	@Override
	protected void end() {
		Supersystem.getInstance().drive.setMotors(0.0,0.0);
		Supersystem.getInstance().gearpickup.runSubsystem(true, true, false);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().drive.setMotors(0.0,0.0);
		Supersystem.getInstance().gearpickup.runSubsystem(true, true, false);
		// TODO Auto-generated method stub
		
	}

}

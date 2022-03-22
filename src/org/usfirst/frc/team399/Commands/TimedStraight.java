package org.usfirst.frc.team399.Commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team399.Systems.Supersystem;
import org.usfirst.frc.team399.Systems.TankDrive;



public class TimedStraight extends Command {
	private double leftpower;
	private double rightpower;
	private double timeout;
	
	public TimedStraight(double lpow, double rpow, double timeout){
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
	
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().drive.setMotors(0.0,0.0);
		// TODO Auto-generated method stub
		
	}

}

package org.usfirst.frc.team399.Commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team399.Systems.Supersystem;
import org.usfirst.frc.team399.Systems.TankDrive;



public class PlaceGearPickup extends Command {
	private double timeout;
	
	public PlaceGearPickup(double timeout){
		this.timeout = timeout;
		
	}
	
	@Override
	protected void initialize() {
		//Supersystem.getInstance().drive.distancedBackwardStraightDrive(leftpower, rightpower, targetDistance, currentAngle, pulse, subtract, decaynum);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		
		//middle parameter false for Baseline
		Supersystem.getInstance().gearpickup.disabled();
		Supersystem.getInstance().gearpickup.placeGear();
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
		
		Supersystem.getInstance().gearpickup.disabled();
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().gearpickup.disabled();
		// TODO Auto-generated method stub
		
	}

}

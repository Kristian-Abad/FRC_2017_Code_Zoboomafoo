package org.usfirst.frc.team399.Auton;

import org.usfirst.frc.team399.Commands.ActuateGearPickup;
import org.usfirst.frc.team399.Commands.PlaceGearPickup;
import org.usfirst.frc.team399.Commands.TimedStraight;
import org.usfirst.frc.team399.Commands.TimedStraightGearIn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterGear extends CommandGroup{
	public CenterGear(){
		this.addParallel(new TimedStraight(0.5, 0.5, 1.975));
		this.addSequential(new ActuateGearPickup(1.975));
		this.addSequential(new PlaceGearPickup(0.5));
		this.addSequential( new TimedStraight(-0.5,-0.5,1.0));
	}
	
}

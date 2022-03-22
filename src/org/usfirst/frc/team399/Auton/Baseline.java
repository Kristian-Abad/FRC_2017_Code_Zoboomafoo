package org.usfirst.frc.team399.Auton;

import org.usfirst.frc.team399.Commands.ActuateGearPickup;
import org.usfirst.frc.team399.Commands.TimedStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Baseline extends CommandGroup{
	public Baseline(){
		double time = 3;
		this.addParallel(new TimedStraight(0.7, 0.7, 3));
		this.addSequential(new ActuateGearPickup(3));
	}
	
}

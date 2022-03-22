package org.usfirst.frc.team399.Utilities;

import edu.wpi.first.wpilibj.Timer;
public class Stopwatch {
	double time = 0;
	double prevTime;
	Timer timeX;
	public Stopwatch() {
		
	}
	
	public double getTime(){
		return time;
	}
	
	public void pause() {
		time = prevTime;
	}
	
	public void start() {
		time = timeX.getFPGATimestamp();
		prevTime = time;
	}
	
	public void resume() {
		time = timeX.getFPGATimestamp() - prevTime;
	}
	
	public void reset() {
		time = 0.0;
	}
}

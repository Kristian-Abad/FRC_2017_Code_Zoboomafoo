package org.usfirst.frc.team399.Utilities;

public class Segment {
	double velocity,
    acceleration,
    position;
    
    public Segment(double vel, double accel, double pos){
    	velocity = vel;
    	acceleration = accel;
    	position = pos;
    }

    public double getVelocity(){
    	return velocity;

    }

    public double getAcceleration(){
    	return acceleration;
    }

    public double getPosition(){
    	return position;
    }

}

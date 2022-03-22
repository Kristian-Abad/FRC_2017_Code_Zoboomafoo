package org.usfirst.frc.team399.Commands;

import org.usfirst.frc.team399.Config.Constants;
import org.usfirst.frc.team399.Systems.Supersystem;
import org.usfirst.frc.team399.Utilities.Follower;
import org.usfirst.frc.team399.Utilities.Segment;
import org.usfirst.frc.team399.Utilities.TrajectoryGenerator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class MotionProfileStraight extends Command{
	double timeout;
	boolean inReverse;
	Timer timer = new Timer();
	Follower follow;
	TrajectoryGenerator tra = new TrajectoryGenerator(Constants.MotionProfile.maxRobotVelocity,Constants.MotionProfile.maxAcceleration);
	Segment[] traj;
	
	public MotionProfileStraight(double distanceInInches,double timeout,boolean inReverse){
		this.timeout = timeout;
		this.inReverse = inReverse;
		traj = tra.generateTrajectory(distanceInInches, Constants.MotionProfile.TotalPoints);
	}
	
	@Override
	protected void initialize() {
		timer.stop();
		timer.reset();
		
		Supersystem.getInstance().drive.resetSensors();
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		timer.start();
//		Supersystem.getInstance().drive.setMotors(follow.getMotorOutput(Supersystem.getInstance().drive.getAverageDistance(), traj, timer.get(), inReverse), rightv);;
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
		Supersystem.getInstance().gearpickup.runSubsystem(true, false, false);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().drive.setMotors(0.0,0.0);
		Supersystem.getInstance().gearpickup.runSubsystem(true, false, false);
		// TODO Auto-generated method stub
		
	}
}

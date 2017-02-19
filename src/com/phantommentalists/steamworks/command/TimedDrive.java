package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.subsystem.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class TimedDrive extends Command{
	private double speed;
	
	private Drivetrain drivetrain;
	
	public TimedDrive(Drivetrain drive, double sec, double sp)
	{
		drivetrain = drive;
		this.requires(drivetrain);
		this.setTimeout(sec);
		speed = sp;
	}
	
	@Override
	protected void execute()
	{
		drivetrain.crabDrive(Parameters.STEERING_STRAIGHT_AHEAD, speed);
	}
	
	@Override
	protected void end()
	{
		drivetrain.crabDrive(0.0, 0.0);
	}
	
	@Override
	protected boolean isFinished() 
	{
		return this.isTimedOut();
	}

}

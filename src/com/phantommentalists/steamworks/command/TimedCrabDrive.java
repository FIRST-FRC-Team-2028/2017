package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.subsystem.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class TimedCrabDrive extends Command{
	private double speed;
	private double angle;
	
	private Drivetrain drivetrain;
	
	public TimedCrabDrive(Drivetrain drive, double sec, double angle, double sp)
	{
		drivetrain = drive;
		this.requires(drivetrain);
		this.setTimeout(sec);
		speed = sp;
		this.angle = angle;
	}
	
	@Override
	protected void execute()
	{
		drivetrain.crabDrive(angle, speed);
	}
	
	@Override
	protected void end()
	{
		drivetrain.crabDrive(angle, 0.0);
	}
	
	@Override
	protected boolean isFinished() 
	{
		return isTimedOut();
	}

}

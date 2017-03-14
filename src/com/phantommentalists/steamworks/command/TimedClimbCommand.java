package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.subsystem.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedClimbCommand extends Command {
	Climber climber;
    public TimedClimbCommand(Climber climber, double second) 
    {
    	this.climber = climber;
    	requires(climber);
    	setTimeout(second);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	climber.turnOn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	
    }
}

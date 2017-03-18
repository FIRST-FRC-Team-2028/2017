package com.phantommentalists.steamworks.command.drive;

import com.phantommentalists.steamworks.subsystem.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GradualTimedCrabDrive extends Command {

	Drivetrain drive;
	double startAngle, endAngle,sec,speed,delta,increment;
    public GradualTimedCrabDrive(Drivetrain drive, double startAngle, double endAngle, double speed, double sec) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.drive = drive;
    	
    	requires(drive);
    	setTimeout(sec);
    	
    	this.startAngle = startAngle;
    	this.endAngle = endAngle;
    	this.sec = sec;
    	this.speed = speed;
    	delta = (endAngle-startAngle);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drive.crabDrive(startAngle, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	increment = timeSinceInitialized()/sec;
    	if(increment > 1)
    		increment = 1;
    	drive.crabDrive(startAngle +(delta*increment), speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

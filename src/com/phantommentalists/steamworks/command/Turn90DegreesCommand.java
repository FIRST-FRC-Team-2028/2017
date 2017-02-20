package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.subsystem.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn90DegreesCommand extends Command {

	Drivetrain drive;
	boolean turnLeft = false;
    public Turn90DegreesCommand(Drivetrain drive, boolean turnLeft) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drive);
    	setTimeout(0);
    	this.drive = drive;
    	this.turnLeft = turnLeft;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(turnLeft)
    		drive.spinOnAxis(0);
    	else
    		drive.spinOnAxis(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.crabDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

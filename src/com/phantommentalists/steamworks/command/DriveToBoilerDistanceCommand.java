package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.subsystem.Drivetrain;
import com.phantommentalists.steamworks.subsystem.Ultrasonic;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToBoilerDistanceCommand extends Command {
		Ultrasonic ultrasonic;
		Drivetrain drivetrain;
    public DriveToBoilerDistanceCommand(Drivetrain drivetrain, Ultrasonic ultrasonic) {
    	this.ultrasonic = ultrasonic;
    	this.drivetrain = drivetrain;
    	requires(ultrasonic);
    	requires(drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
  
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.crabDrive(0, 0.25);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ultrasonic.getDistance() < 6;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

package com.phantommentalists.steamworks.command.shooter;

import com.phantommentalists.steamworks.subsystem.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoadGateCommand extends Command {

	Shooter shooter;
	
    public LoadGateCommand(Shooter shooter) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis)
    	this.shooter = shooter;
    	requires(shooter);
    	setTimeout(1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shooter.setLoaderGatePosition();
//    	shooter.turnOnConveyorReverse();
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

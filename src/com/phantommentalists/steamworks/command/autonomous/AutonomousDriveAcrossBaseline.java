package com.phantommentalists.steamworks.command.autonomous;

import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.command.drive.TimedCrabDrive;
import com.phantommentalists.steamworks.subsystem.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousDriveAcrossBaseline extends CommandGroup {

    public AutonomousDriveAcrossBaseline(Drivetrain drive) {
    	drive.setLowGear();
    	addSequential(new TimedCrabDrive(drive, Parameters.AUTONOMOUS_DRIVE_ACROSS_BASELINE_TIME, Parameters.STEERING_STRAIGHT_AHEAD ,Parameters.AUTONOMOUS_DRIVE_SPEED));
    }
}

package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.subsystem.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousDriveAcrossBaseline extends CommandGroup {

    public AutonomousDriveAcrossBaseline(Drivetrain drive) {
    	addSequential(new TimedDrive(drive, Parameters.AUTONOMOUS_DRIVE_ACROSS_BASELINE_TIME, Parameters.AUTONOMOUS_DRIVE_SPEED));
    }
}

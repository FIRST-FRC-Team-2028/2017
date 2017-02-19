package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.subsystem.Drivetrain;
import com.phantommentalists.steamworks.subsystem.GearGobbler;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCenterPeg extends CommandGroup {

    public AutonomousCenterPeg(Drivetrain drive, GearGobbler gearGobbler, boolean turnLeft) {
    	addSequential(new TimedDrive(drive, Parameters.AUTONOMOUS_DRIVE_CENTER_PEG_TIME, Parameters.AUTONOMOUS_DRIVE_SPEED));
    	addSequential(new AutonomousHangPeg());
    	addSequential(new OpenGearGobblerCommand(gearGobbler));
    	addSequential(new TimedDrive(drive, 0.5, -Parameters.AUTONOMOUS_DRIVE_SPEED));
    	addParallel(new CloseGearGobblerCommand(gearGobbler));
    	addSequential(new Turn90Degrees(drive, turnLeft));
    	addSequential(new SlewDriveCommand(drive, !turnLeft, Parameters.AUTONOMOUS_CENTER_PEG_SLEW_TIME));
    	addSequential(new TimedDrive(drive, 0.5, Parameters.AUTONOMOUS_DRIVE_SPEED));
    }
}

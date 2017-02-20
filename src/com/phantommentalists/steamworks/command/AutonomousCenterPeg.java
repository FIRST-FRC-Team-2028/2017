package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.subsystem.Drivetrain;
import com.phantommentalists.steamworks.subsystem.GearGobbler;
import com.phantommentalists.steamworks.subsystem.PixyCamera;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCenterPeg extends CommandGroup {

    public AutonomousCenterPeg(Drivetrain drive, GearGobbler gearGobbler,PixyCamera pixy, boolean turnLeft) {
    	addSequential(new TimedCrabDrive(drive, Parameters.AUTONOMOUS_DRIVE_CENTER_PEG_TIME, Parameters.STEERING_STRAIGHT_AHEAD, Parameters.AUTONOMOUS_DRIVE_SPEED));
    	addSequential(new AutonomousPlaceGear(pixy,drive));
    	addSequential(new OpenGearGobblerCommand(gearGobbler));
    	addSequential(new TimedCrabDrive(drive, 0.5, Parameters.STEERING_STRAIGHT_AHEAD, -Parameters.AUTONOMOUS_DRIVE_SPEED));
    	addParallel(new CloseGearGobblerCommand(gearGobbler));
    	addSequential(new Turn90DegreesCommand(drive, turnLeft));
    	addSequential(new TimedCrabDrive(drive, 1.0, (turnLeft)?0.25:0.75,Parameters.AUTONOMOUS_DRIVE_SPEED ));
    	addSequential(new TimedCrabDrive(drive, 0.5, Parameters.STEERING_STRAIGHT_AHEAD, Parameters.AUTONOMOUS_DRIVE_SPEED));
    }
}

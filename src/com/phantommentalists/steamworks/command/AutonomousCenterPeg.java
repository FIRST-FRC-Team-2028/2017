package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.subsystem.Drivetrain;
import com.phantommentalists.steamworks.subsystem.GearGobbler;
import com.phantommentalists.steamworks.subsystem.PixyCamera;
import com.phantommentalists.steamworks.subsystem.Ultrasonic;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCenterPeg extends CommandGroup {

    public AutonomousCenterPeg(Drivetrain drive, GearGobbler gearGobbler,PixyCamera pixy,Ultrasonic ultrasonic, boolean turnLeft) {
    	requires(drive);
    	addSequential(new TimedCrabDrive(drive, Parameters.AUTONOMOUS_DRIVE_CENTER_PEG_TIME, Parameters.STEERING_STRAIGHT_AHEAD, Parameters.AUTONOMOUS_DRIVE_SPEED));
    	addSequential(new AutonomousPlaceGear(pixy,drive,ultrasonic));
    	addSequential(new OpenGearGobblerCommand(gearGobbler));
    	addSequential(new TimedCrabDrive(drive, Parameters.AUTONOMOUS_DRIVE_CENTER_PEG_TIME/2, Parameters.STEERING_STRAIGHT_AHEAD, -Parameters.AUTONOMOUS_DRIVE_SPEED));
//    	addParallel(new CloseGearGobblerCommand(gearGobbler));
//    	addSequential(new GradualTimedCrabDrive(drive, (turnLeft)?0.25:0.75, 0.5,Parameters.AUTONOMOUS_DRIVE_SPEED,1));
//    	addSequential(new TimedCrabDrive(drive, 0.5, Parameters.STEERING_STRAIGHT_AHEAD, Parameters.AUTONOMOUS_DRIVE_SPEED));
    }
}

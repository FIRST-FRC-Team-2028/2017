package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.subsystem.Climber;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoClimb extends CommandGroup {

	Climber climber;
    public AutoClimb(Climber climber) 
    {
    	this.climber = climber;
    	addSequential(new ClimbTilSwitchCommand(climber));
    	addSequential(new TimedClimbCommand(climber, 0.1));
    }
}

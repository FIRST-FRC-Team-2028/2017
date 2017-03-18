package com.phantommentalists.steamworks.command.climber;

import com.phantommentalists.steamworks.Parameters;
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
    	addSequential(new TimedClimbCommand(climber, Parameters.AUTONOMOUS_CLIMB_TIME));
    }
}

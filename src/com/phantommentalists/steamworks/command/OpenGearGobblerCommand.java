package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.subsystem.GearGobbler;

import edu.wpi.first.wpilibj.command.Command;

@objid ("eb9893a0-8204-45e2-b4f4-495e68722db2")
public class OpenGearGobblerCommand extends Command 
{
	
	private GearGobbler gearGobbler;
	
	public OpenGearGobblerCommand(GearGobbler gearGobbler) 
	{
		this.gearGobbler = gearGobbler;
		requires(gearGobbler);
		setTimeout(Parameters.GEAR_GOBBLER_OPEN_TIME);
	}

    @Override
    protected void execute() 
    {
    	gearGobbler.openFlap();
    }

    @Override
    protected boolean isFinished() 
    {
    	return isTimedOut();
    }
}

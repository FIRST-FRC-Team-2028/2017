package com.phantommentalists.steamworks.command.gearGobbler;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.subsystem.GearGobbler;

import edu.wpi.first.wpilibj.command.Command;

@objid ("e28aeac1-45b8-4214-af6e-f2e12786452f")
public class CloseGearGobblerCommand extends Command 
{
	
	private GearGobbler gearGobbler;
	
	public CloseGearGobblerCommand(GearGobbler gearGobbler) 
	{
		this.gearGobbler = gearGobbler;
		requires(gearGobbler);
		setTimeout(Parameters.GEAR_GOBBLER_CLOSE_TIME);
	}
	
    @Override
    protected void execute() 
    {
    	gearGobbler.closeFlap();
    }

    @Override
    protected boolean isFinished() 
    {
        return isTimedOut();
    }
}

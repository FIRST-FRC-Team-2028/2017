package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.GearGobbler;

import edu.wpi.first.wpilibj.command.Command;

@objid ("e28aeac1-45b8-4214-af6e-f2e12786452f")
public class CloseGearGobblerCommand extends Command {
	
	private GearGobbler gearGobbler;
	
	public CloseGearGobblerCommand(GearGobbler gearGobbler) {
	}
	
    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void initialize() {
    }

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}

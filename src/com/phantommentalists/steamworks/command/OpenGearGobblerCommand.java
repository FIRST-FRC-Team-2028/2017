package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.GearGobbler;

import edu.wpi.first.wpilibj.command.Command;

@objid ("eb9893a0-8204-45e2-b4f4-495e68722db2")
public class OpenGearGobblerCommand extends Command {
	
	private GearGobbler gearGobbler;
	
	public OpenGearGobblerCommand(GearGobbler gearGobbler) {
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

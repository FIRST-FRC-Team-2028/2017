package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.GearGobbler;

import edu.wpi.first.wpilibj.command.CommandGroup;

@objid ("5eb7dc3b-6a5f-49c4-9c98-bb07aaefd0ec")
public class CenterOnLiftPegCommand extends CommandGroup {
	
	private GearGobbler gearGobbler;
	
	public CenterOnLiftPegCommand(GearGobbler gearGobbler) {
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
    
}

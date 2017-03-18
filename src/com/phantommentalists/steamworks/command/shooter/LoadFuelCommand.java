package com.phantommentalists.steamworks.command.shooter;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

@objid ("9721ec9f-3e0f-493b-936f-b821d846a5a7")
public class LoadFuelCommand extends CommandGroup {
	
	private Shooter shooter;
	
	public LoadFuelCommand(Shooter shooter) {
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

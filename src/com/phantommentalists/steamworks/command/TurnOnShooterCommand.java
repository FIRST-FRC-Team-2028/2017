package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Shooter;

import edu.wpi.first.wpilibj.command.Command;

@objid ("ea30a50c-4f2d-4553-b07f-73af66a1c537")
public class TurnOnShooterCommand extends Command {
	
	private Shooter shooter;
	
	public TurnOnShooterCommand(Shooter shooter) {
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
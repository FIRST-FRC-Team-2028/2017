package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Shooter;

import edu.wpi.first.wpilibj.command.Command;

@objid ("10e4643d-7662-4b91-afd6-b09e93ce6467")
public class TurnOnLoaderCommand extends Command {
	
	private Shooter shooter;
	
	public TurnOnLoaderCommand(Shooter shooter) 
	{
		this.shooter = shooter;
		requires(shooter);
	}
	
    @Override
    protected void execute() 
    {
    	shooter.setLoaderGatePosition();
    	shooter.turnOnConveyor();
    	shooter.turnOnWheelToLoad();
    }

    @Override
    protected boolean isFinished() {
    	return true;
//        return shooter.isShooterUpToSpeed();
    }
}
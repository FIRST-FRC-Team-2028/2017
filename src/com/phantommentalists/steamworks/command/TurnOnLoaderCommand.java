package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Shooter;

import edu.wpi.first.wpilibj.command.Command;

@objid ("10e4643d-7662-4b91-afd6-b09e93ce6467")
public class TurnOnLoaderCommand extends Command {
	
	private Shooter shooter;
	
	public TurnOnLoaderCommand(Shooter shooter) {
	}
	
    @Override
    protected void execute() 
    {
    	shooter.setLoaderGatePosition();
    	shooter.turnOnConveyor();
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

    /**  stuff done when initialized currently nothing  */
    @Override
    protected void initialize() {
    	// This method intentionally left blank
    }

    /**  stuff done when end currently nothing   */
	@Override
	protected void end() 
	{
    	// This method intentionally left blank
	}

	/**  stuff done when interrupted currently nothing  */
	@Override
	protected void interrupted() {
    	// This method intentionally left blank
	}
}

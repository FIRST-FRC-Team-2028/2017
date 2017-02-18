package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Shooter;

import edu.wpi.first.wpilibj.command.Command;

@objid ("b9e78b1e-efbd-443c-bb65-8d4f0dbbb737")
public class TurnOffShooterCommand extends Command {
	/** variable for this command*/
	private Shooter shooter;
	/**
	 * Constructor.  It MUST initialize all class memebers.
	 * 
	 * @param shooter - access to do shooter stuff
	 */
	public TurnOffShooterCommand(Shooter shooter) {
		this.shooter=shooter;
	}
	
	/**  tells the shooter to stop  */
    @Override
    protected void execute() 
    {
    	shooter.turnOffShooterWheel();
    }

    
    /**  determines if this code should stop  */
    @Override
    protected boolean isFinished() {
        return shooter.isShooterOff();
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

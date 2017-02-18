package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Shooter;

import edu.wpi.first.wpilibj.command.Command;

@objid ("ea30a50c-4f2d-4553-b07f-73af66a1c537")
public class TurnOnShooterCommand extends Command {
	/** variable for this command  */
	private Shooter shooter;
	
	/**
	 * Constructor.  It MUST initialize all class memebers.
	 * 
	 * @param shooter - access to do shooter stuff
	 */
	public TurnOnShooterCommand(Shooter shooter) 
	{
		this.shooter = shooter;
	}
	
	/** starts wheel spining   */
    @Override
    protected void execute()
    {
    	shooter.turnOnWheelToShoot();
    }

    /** tells running till command is retired   */
    @Override
    protected boolean isFinished() {
        return shooter.isShooterUpToSpeed();
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

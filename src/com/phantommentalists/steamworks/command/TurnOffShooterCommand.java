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
		requires(shooter);
	}
	
	/**  tells the shooter to stop  */
    @Override
    protected void execute() 
    {
//    	System.out.println("shooter off");
    	shooter.turnOffShooterWheel();
    	shooter.turnOffConveyor();
    }

    
    /**  determines if this code should stop  */
    @Override
    protected boolean isFinished() {
    	return true;
//        return shooter.isShooterOff();
    }
}
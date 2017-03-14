package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		requires(shooter);
	}
	
	/** starts wheel spining   */
    @Override
    protected void execute()
    {
//    	System.out.println("shooter on");
//    	shooter.setShooterGatePosition();
//    	System.out.println("Speed: "+shooter.getSpeed());
    	shooter.turnOnWheelToShoot();
    	shooter.turnOnConveyor();
    }

    /** tells running till command is retired   */
    @Override
    protected boolean isFinished() {
    	return true;
//        return shooter.isShooterUpToSpeed();
    }
}
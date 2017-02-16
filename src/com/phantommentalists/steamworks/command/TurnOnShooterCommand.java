package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Shooter;

import edu.wpi.first.wpilibj.command.Command;

@objid ("ea30a50c-4f2d-4553-b07f-73af66a1c537")
public class TurnOnShooterCommand extends Command {
	
	private Shooter shooter;
	
	public TurnOnShooterCommand(Shooter shooter) 
	{
		
	}
	
    @Override
    protected void execute()
    {
    	shooter.turnOnWheelToShoot();
    }

    @Override
    protected boolean isFinished() {
        return isShooterWheelUpToSpeed();
    }

    @Override
    protected void initialize() {
    }

	@Override
	protected void end() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isShooterWheelUpToSpeed() {
		return shooter.isShooterUpToSpeed();
	}
}

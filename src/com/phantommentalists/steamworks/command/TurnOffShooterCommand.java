package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Shooter;

import edu.wpi.first.wpilibj.command.Command;

@objid ("b9e78b1e-efbd-443c-bb65-8d4f0dbbb737")
public class TurnOffShooterCommand extends Command {
	
	private Shooter shooter;
	
	public TurnOffShooterCommand(Shooter shooter) {
	}
	
    @Override
    protected void execute() 
    {
    	shooter.turnOffShooterWheel();
    }

    @Override
    protected boolean isFinished() {
        return isShooterWheelOff();
    }

    
    private boolean isShooterWheelOff()
    {
    	return shooter.isShooterOff();
    }
    
    @Override
    protected void initialize() 
    {
    	
    }

	@Override
	protected void end()
	{
		// TODO Auto-generated method stub
	}

	@Override
	protected void interrupted()
	{
		// TODO Auto-generated method stub
	}
}

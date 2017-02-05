package src.com.phantommentalists.steamworks.command;

import src.com.phantommentalists.steamworks.subsystem.GearGobbler;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import edu.wpi.first.wpilibj.command.Command;

@objid ("e28aeac1-45b8-4214-af6e-f2e12786452f")
public class CloseGearGobblerCommand extends Command 
{
	
	private GearGobbler gearGobbler;
	
	public CloseGearGobblerCommand(GearGobbler gearGobbler) 
	{
		this.gearGobbler = gearGobbler;
	}
	
    @Override
    protected void execute() 
    {
    	gearGobbler.closeFlap();
    }

    @Override
    protected boolean isFinished() 
    {
        // TODO Auto-generated method stub
        return false;
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

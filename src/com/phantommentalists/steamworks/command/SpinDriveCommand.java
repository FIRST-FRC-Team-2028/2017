package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

@objid ("69202510-07b0-4448-9cbd-416d3ecb8065")
public class SpinDriveCommand extends Command {
    @objid ("66ff4920-96a1-467a-ad3c-bb50990b81df")
    private Drivetrain drivetrain;
    
    private double speed = 0;

    @objid ("f2d35b3a-3101-46a5-a3e2-9059937876aa")
    public SpinDriveCommand(Drivetrain drivetrain) 
    {
    	requires(drivetrain);
    }
    
    public void setSpinOnAxis(double speed)
    {
    	this.speed = speed;
    }

    @objid ("466a72af-b6ee-4972-af60-a28f55d4519c")
    @Override
    protected void execute() 
    {
    	drivetrain.spinOnAxis(speed);
    }

    @objid ("6fd88522-18af-43d3-b8f9-914123d07910")
    @Override
    protected void initialize() {
    }

    @objid ("84d8ec15-e6cd-4ebf-87b9-e67457afeaf0")
    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}

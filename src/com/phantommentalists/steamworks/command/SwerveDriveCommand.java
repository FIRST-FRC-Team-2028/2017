package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

@objid ("53f6ee2f-f169-41e7-befc-9980c988db16")
public class SwerveDriveCommand extends Command {
    @objid ("641d3251-1090-451d-b93a-c206a85911fb")
    private Drivetrain drivetrain;

    @objid ("00b91e7c-ab38-48bd-af48-154b963a0c8a")
    public SwerveDriveCommand(Drivetrain drivetrain) {
    }

    @objid ("9b82a2dc-27c2-4cfa-9b0f-4fa677d27cdb")
    @Override
    protected void execute() {
    }

    @objid ("40908158-8438-4870-afdf-4a50a13996b0")
    @Override
    protected void initialize() {
    }

    @objid ("8c9c53b4-7e00-445e-b34a-0473a93c94a4")
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

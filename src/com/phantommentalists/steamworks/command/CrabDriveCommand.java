package com.phantommentalists.steamworks.command;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.subsystem.Drivetrain;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

@objid ("9fa60e62-3aa8-4cba-95d7-0fa18c5388a6")
public class CrabDriveCommand extends Command {
    @objid ("82003ad0-b55d-4027-b1bf-c19f6b3d0f16")
    private Drivetrain drivetrain;

    @objid ("1e72b4ad-7dfd-4b83-84be-fa89d3252097")
    public CrabDriveCommand(Drivetrain drivetrain) {
    }

    @objid ("541d2e03-3fdd-4cfa-9d1e-d2aa9f5c7a3a")
    @Override
    protected void execute() {
    }

    @objid ("f3162078-8211-432f-9b18-0690658db05f")
    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

    @objid ("f6732873-ee2c-406b-a251-0da95d1d2e0d")
    @Override
    protected void initialize() {
    }

}

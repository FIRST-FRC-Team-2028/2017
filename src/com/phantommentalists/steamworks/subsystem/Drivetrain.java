package com.phantommentalists.steamworks.subsystem;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.component.DriveSide;
import edu.wpi.first.wpilibj.command.Subsystem;

@objid ("f83fed2a-c93a-4529-87d2-2c458cd5d09e")
public class Drivetrain extends Subsystem {
    @objid ("055cc2c0-36ba-42d6-975e-661074ba6451")
    private DriveSide leftSide;

    @objid ("d695e0ae-d79b-4e54-86e2-c5d628a64e28")
    private DriveSide rightSide;

    @objid ("ae9970ca-0edb-45bf-847b-2edc45564f8d")
    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
    }

}

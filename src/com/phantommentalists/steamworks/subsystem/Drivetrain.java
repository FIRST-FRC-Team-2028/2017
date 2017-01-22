package com.phantommentalists.steamworks.subsystem;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.DriveSide;
import edu.wpi.first.wpilibj.command.Subsystem;

@objid ("f83fed2a-c93a-4529-87d2-2c458cd5d09e")
public class Drivetrain extends Subsystem {
    @objid ("0b8b1b74-bc35-4f58-8db4-05cde213582e")
    private DriveSide leftSide;

    @objid ("df7bc954-ab43-4d4f-b770-7f7e37af812b")
    private DriveSide rightSide;

}

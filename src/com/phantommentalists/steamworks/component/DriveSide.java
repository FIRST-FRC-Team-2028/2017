package com.phantommentalists.steamworks.component;

import com.ctre.CANTalon;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.Parameters.CanId;
import com.phantommentalists.steamworks.Parameters.SideOfRobot;
import com.phantommentalists.steamworks.Parameters.SteeringOffset;

@objid ("38bc95f2-27cd-419f-bb2d-8b152ecc87e9")
public class DriveSide {
    @objid ("6bf0ea78-47be-4842-a005-e90a57b4407b")
    private Wheel frontWheel;

    @objid ("2ba11a31-ab1e-43e2-ae46-26b179e6db9c")
    private Wheel rearWheel;

    @objid ("bdfb3d5e-7db7-4618-845e-465ab6ecfa06")
    private CANTalon masterMotor;

    @objid ("72f08bc9-85ba-475a-9954-6a0937e05288")
    private CANTalon followerMotor;

    @objid ("98ac2b28-8b68-492e-a31c-8c2da6913de5")
    public DriveSide(SideOfRobot side) {
        switch(side)
        {
        case RIGHT:
            masterMotor = new CANTalon(CanId.DRIVE_RIGHT_MASTER.getId());
            followerMotor = new CANTalon(CanId.DRIVE_RIGHT_FOLLOWER.getId());
            frontWheel = new Wheel(CanId.STEERING_RIGHT_FRONT,SteeringOffset.LEFT_FRONT.getOffset());
            rearWheel = new Wheel(CanId.STEERING_RIGHT_REAR,SteeringOffset.LEFT_REAR.getOffset());
            break;
        case LEFT:
            masterMotor = new CANTalon(CanId.DRIVE_LEFT_MASTER.getId());
            followerMotor = new CANTalon(CanId.DRIVE_LEFT_FOLLOWER.getId());
            frontWheel = new Wheel(CanId.STEERING_LEFT_FRONT, SteeringOffset.RIGHT_FRONT.getOffset());
            rearWheel = new Wheel(CanId.STEERING_LEFT_REAR,SteeringOffset.RIGHT_REAR.getOffset());
            break;
        default:
            throw new IllegalArgumentException("Invalid side of robot");
        }
    }

}

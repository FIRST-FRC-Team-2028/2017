package com.phantommentalists.steamworks.component;

import com.ctre.CANTalon;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.Parameters.CanId;
import com.phantommentalists.steamworks.Parameters;

@objid ("f16bbd7c-a0a7-48f8-bff4-440291cc5fb4")
public class Wheel {
    @objid ("c51f6222-37e6-4b90-a9e7-aa55341e4c1f")
    private double offset = 0;

    @objid ("752bc667-4374-47ce-9e64-f1310aa4b836")
    private CANTalon steeringMotor;

    /**
     * Initializes the Wheel class
     * @param canId The can ID of the motor that controls the wheel
     * @param offset The position offset of the encoder position to the forward position
     */
    @objid ("a7009927-85e8-4b44-a156-5439f5a6ddf5")
    public Wheel(CanId canId, double offset) {
        steeringMotor = new CANTalon(canId.getId());
    }

    @objid ("41f4a243-6a60-4c8f-9a1c-444c58a88d60")
    public void setPosition(double angle) {
    }

    /**
     * 
     * @return The absolute position of the encoder from the Talon
     */
    @objid ("835093a9-45b7-4c75-bb28-d664e4daa57b")
    public double getPosition() {
        return steeringMotor.getPosition();
    }

    /**
     * Takes the absolute position and adds the offset. This returns a value where 0 is forward
     * @return Absolute position with offset
     */
    public double getNormalizedPosition()
    {
    	return steeringMotor.getPosition()+offset;
    }
}

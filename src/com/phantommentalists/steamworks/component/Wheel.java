package com.phantommentalists.steamworks.component;

import com.ctre.CANTalon;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("f16bbd7c-a0a7-48f8-bff4-440291cc5fb4")
public class Wheel {
    @objid ("edfbe244-8bf7-4a5b-9a6a-a15fa68dea9a")
    private CANTalon steeringMotor;
    
    private double offset = 0;

    public Wheel(int canId, double offset)
    {
    	steeringMotor = new CANTalon(canId);
    }
    
    public void setPosition()
    {
    	
    }
    
    public double getPosition()
    {
    	return 0;
    }
    
}

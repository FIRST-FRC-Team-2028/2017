package com.phantommentalists.steamworks.component;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.Parameters.CanId;

@objid ("f16bbd7c-a0a7-48f8-bff4-440291cc5fb4")
public class Wheel {
    @objid ("c51f6222-37e6-4b90-a9e7-aa55341e4c1f")
    private double offset = 0;

    @objid ("752bc667-4374-47ce-9e64-f1310aa4b836")
    private CANTalon steeringMotor;

	/**
	 * declares the p
	 */
	private double p = 9;
	
	/**
	 * declares the i
	 */
	private double i = 0.0002;
	
	/**
	 * declares the d
	 */
	private double d = 0.0;
	
	/**
	 * allows to access the identity of the current canid
	 */
	private int canId = 0;
	
    /**
     * Initializes the Wheel class
     * @param canId The can ID of the motor that controls the wheel
     * @param offset The position offset of the encoder position to the forward position
     */
    @objid ("a7009927-85e8-4b44-a156-5439f5a6ddf5")
    public Wheel(CanId canId, double offset) {
    	steeringMotor = new CANTalon(canId.getId());
		steeringMotor.changeControlMode(TalonControlMode.Position);
		steeringMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		steeringMotor.setPID(p, i, d);
		steeringMotor.enable();
		this.offset = offset;
		this.canId = canId.getId();
    }

    @objid ("41f4a243-6a60-4c8f-9a1c-444c58a88d60")
    public void setPosition(double angle) {
    	double startingpos = getPosition();					
		double distance = 0;	
		
    	startingpos = roundOffToFourDigits(startingpos);
    	angle = roundOffToFourDigits(angle);
    	
    	System.out.println("pos" + angle);
    	System.out.println("startingpos" + startingpos);
    	
    			if (startingpos > angle)
    			{
    				distance = startingpos - angle;						
    			}
    			else if (startingpos < angle)
    			{
    				distance = angle - startingpos;
    			}
    			else
    			{
    				distance = 0;}
    			
    			if (distance >= 1)
    			{
    				int distance2 = (int) distance;
    				distance = distance - distance2;
    			}
    			
    			if(distance > 0.5)
    			{
    				angle = startingpos - (1 - distance);
    			}
    			else if (distance <= 0.5 && startingpos > 1)
    			{
    				startingpos -= distance;
    			}
    			else if (distance <= 0.5)
    			{
    				startingpos += distance;
    			}
    			
    			System.out.println ("pos" + angle);
    	    	System.out.println ("startingpos" + startingpos);
    			
    	angle += offset;	
    	angle = roundOffToFourDigits(angle);
    	steeringMotor.set(angle);								
    	//current is that 1=-1
    }

    /**
     * 
     * @return The absolute position of the encoder from the Talon
     */
    @objid ("835093a9-45b7-4c75-bb28-d664e4daa57b")
    public double getPosition() {
        return steeringMotor.getPosition();
    }
    
    public double getPositionWithOffset()
	{
		return steeringMotor.getPosition()-offset;
	}

	public void printNeededOffsets() 
	{
		double num = steeringMotor.getPosition()-0.5;
		System.out.println(canId + " offset needed " + num );
		System.out.println("\t "+getPosition());
	}
	
	public void enableTurning(boolean enable)
	{
		if(enable)
		{
			steeringMotor.enableControl();
		}
		else
		{
			System.out.println("Disabled "+canId);
			steeringMotor.disableControl();
		}
	}
	
	public void center()
	{
		if(isPastCenter())
		{
			setPosition(0);
		}
		else
		{
			setPosition(1);
		}
	}
	
	public boolean isPastCenter()
	{
		return steeringMotor.getPosition() < getOffsetPosition(0.5);
	}
	
	private double roundOffToFourDigits(double pos) {
    	pos *= 10000.0;
    	pos = (int)pos;
    	pos /= 10000.0;
    	return pos;
	}
	
	public void disableControl()
	{
		steeringMotor.disableControl();
	}
	
	public double getOffsetPosition(double pos)
	{
		pos += offset;
		return roundOffToFourDigits(pos);
	}
	
	public boolean atSetpoint()
    {
    	if(Math.abs(steeringMotor.getPosition()-steeringMotor.getSetpoint()) <= 0.01)
    		return true;
    	return false;
    }
	
    /**
     * Takes the absolute position and adds the offset. This returns a value where 0 is forward
     * @return Absolute position with offset
     */
    public double getNormalizedPosition()
    {
    	return steeringMotor.getPosition()+offset;
    }
    
	public String toString()
	{
		String rc = "";
		rc += canId+ ": "+getPosition();
		return rc;
	}
}

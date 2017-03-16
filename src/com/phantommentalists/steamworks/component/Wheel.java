package com.phantommentalists.steamworks.component;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.Parameters.CanId;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@objid ("f16bbd7c-a0a7-48f8-bff4-440291cc5fb4")
public class Wheel {
    @objid ("c51f6222-37e6-4b90-a9e7-aa55341e4c1f")
    private double offset = 0;

    @objid ("752bc667-4374-47ce-9e64-f1310aa4b836")
    private CANTalon steeringMotor;

	/**
	 * declares the p
	 */
	private double p = 5;
	
	/**
	 * declares the i
	 */
	private double i = 0.00015;
	
	/**
	 * declares the d
	 */
	private double d = 0.0002;
	
	/**
	 * allows to access the identity of the current canid
	 */
	private int canId = 0;
	
	private int constRev =0;
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
//		steeringMotor.configMaxOutputVoltage(12);
		steeringMotor.enable();
		this.offset = offset;
		this.canId = canId.getId();
    }

    @objid ("41f4a243-6a60-4c8f-9a1c-444c58a88d60")
    public void setPosition(double angle) {
    	double currentpos = steeringMotor.getPosition()-offset;
		constRev = (int)currentpos;
		double nextRev;
		double currentRev;
		double prevRev;
		
		if(currentpos < 0)
		{
			constRev-=1;
		}
		
		nextRev = constRev+1.0+angle;
		currentRev = constRev+angle;
		prevRev = constRev-1.0+angle;
		
//		System.out.println("Motor: "+canId);
//		System.out.println("Goal: "+angle);
//		System.out.println("Const: "+constRev);
//		System.out.println("Current pos"+currentpos);
//		System.out.println("Next rotg"+nextRev);
//		System.out.println("Current rotg"+currentRev);
//		System.out.println("Prev rotg"+prevRev);
//		System.out.println("-------------------------------");

		double dnext = Math.abs(nextRev-currentpos);
		double dcurr = Math.abs(currentRev-currentpos);
		double dprev = Math.abs(prevRev-currentpos);
//		System.out.println("Next: "+dnext);
//		System.out.println("Curr: "+dcurr);
//		System.out.println("Prev: "+dprev);
		if(dnext < dcurr && dnext < dprev)
			angle = nextRev;
		else if(dcurr < dnext && dcurr < dprev)
			angle = currentRev;
		else if(dprev < dcurr && dprev < dnext)
			angle = prevRev;
//		double d0 = Math.abs((wheelMotor.getPosition()-offset)-constRot);
//		double d1 = Math.abs((wheelMotor.getPosition()-offset)-(constRot+1));
		
		//		if(d1 < d0)
//		{
//			System.out.println("here");
//			constRot++;
//		}
    	angle +=offset;
    	
//	    	System.out.println("Offset: "+pos);
    	angle *= Math.pow(10, 3);
//	    	System.out.println("AM: "+pos);
    	angle = (int)angle;
//	    	System.out.println("Int: "+pos);
    	angle /= Math.pow(10, 3);
//	    	System.out.println("Div: "+pos);
    	
    	steeringMotor.set(angle);
//    	return angle;
//	    wheelMotor.setPosition(pos);
//	   	{
//	   	if(wheelMotor != null)
//	   		wheelMotor.setPosition(0);
//	  		else
//   			return pos;
//		}
			
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
		SmartDashboard.putNumber(""+canId+" pos", getPosition());
		double num = steeringMotor.getPosition()-0.5;
//		System.out.println(canId + " offset needed " + num );
//		System.out.println("\t "+getPosition());
		steeringMotor.set(0.5);
	}
	
	public void enableTurning(boolean enable)
	{
		if(enable)
		{
			steeringMotor.changeControlMode(TalonControlMode.Position);
			steeringMotor.enableControl();
			steeringMotor.enable();
		}
		else
		{
			System.out.println("Disabled "+canId);
			steeringMotor.disable();
			steeringMotor.changeControlMode(TalonControlMode.Voltage);
			steeringMotor.enable();
			steeringMotor.set(Parameters.STEERING_MOTOR_SPEED);
//			steeringMotor.disableControl();
//			steeringMotor.disable();
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
    	pos *= 1000.0;
    	pos = (int)pos;
    	pos /= 1000.0;
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

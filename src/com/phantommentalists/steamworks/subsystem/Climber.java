package com.phantommentalists.steamworks.subsystem;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.command.TurnOffClimberCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

@objid ("7f4cd058-1d2d-4a6d-9a50-a3ac0c4836b4")
public class Climber extends Subsystem
{
	@objid ("25dc6539-fcd9-48bd-8998-b7361199f269")
    private CANTalon winchMotor;
	
	private TurnOffClimberCommand climberOff;

    @objid ("8e83bd89-9266-4bb6-a84f-11ea55ce94ed")
    public void turnOn() 
    {
    	winchMotor.set(0.85);
    }

    @objid ("93882f5d-5d77-43a5-81a7-07515550eaf6")
    public void turnOff() 
    {
    	winchMotor.set(0.0);
    }

    public TurnOffClimberCommand getDefaultClimberCommand()
    {
    	return climberOff;
    }
    
    /*@objid ("353bc7be-0076-4b3a-afbc-c8771233e264")
    public boolean isAtTouchpad() 
    {
        // TODO Auto-generated method stub
        return false;
    }
	*/
    
    @objid ("b83276d0-5ca4-4d75-b6df-35cd80becd12")
    @Override
    protected void initDefaultCommand() 
    {
        climberOff = new TurnOffClimberCommand(this);
        setDefaultCommand(climberOff);
    }

    @objid ("f4e055f9-36cc-43d2-98f4-640805a1ab15")
    public Climber() 
    {
    	winchMotor = new CANTalon(Parameters.CanId.CLIMBER_MOTOR.getId());
    	winchMotor.changeControlMode(TalonControlMode.PercentVbus);
    	winchMotor.enableBrakeMode(true);
//    	winchMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//    	winchMotor.configEncoderCodesPerRev(1024);
    	winchMotor.enable();
    	getDefaultCommand();
    }
}

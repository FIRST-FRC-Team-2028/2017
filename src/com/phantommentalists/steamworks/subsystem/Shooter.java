package com.phantommentalists.steamworks.subsystem;

import com.ctre.CANTalon;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.Parameters.CanId;
import com.phantommentalists.steamworks.Parameters.Pid;
import com.phantommentalists.steamworks.Parameters.PneumaticChannel;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for robot's shooter.
 * 
 * This class encapsulates all of the hardware that represents the shooter/infeed mechanism.  The same
 * mechanism can pickup fuel off the floor and store them in the robot's internal hopper, and extract
 * fuel from the hopper and shoot it into the boiler's high goal.
 */
@objid ("5b3b8d0c-a5f0-4e9a-801d-7122a1a4eaa9")
public class Shooter extends Subsystem {
	
    /**
     * Motor controller for wheel motor.  Shooter's wheel motor can be run forward to propel fuel
     * into the high goal and in reverse to direct fuel into the robot's fuel hopper.
     */
    @objid ("c89532f8-ad05-46f5-8c40-8834ab21f172")
    private CANTalon wheelMotor;

    /**
     * 
     */
    @objid ("39f50a55-9553-4bf4-8026-d40058cb7a83")
    private CANTalon conveyorMotor;

    /**
     * 
     */
    private Solenoid gateOpenSolenoid;
    
    /**
     * 
     */
    private Solenoid gateCloseSolenoid;

	private boolean shooting = false;
	
	private boolean amIOff = false;
    
    /**
     * Constructor.  This method is responsible for initializing a new Shooter instance.
     */
    
    @objid ("732b1b92-b601-477c-ab75-004c7e1b6814")
    public Shooter(CanId wheelCanId, CanId conveyorCanId, PneumaticChannel openSolenoid, PneumaticChannel closeSolenoid, Pid shooterWheelPid) {
    	wheelMotor = new CANTalon(wheelCanId.getId());
    	wheelMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
    	wheelMotor.enableBrakeMode(true);
    	wheelMotor.setF(shooterWheelPid.getF());
    	wheelMotor.setP(shooterWheelPid.getP());
    	wheelMotor.setI(shooterWheelPid.getI());
    	wheelMotor.setD(shooterWheelPid.getD());
    	wheelMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
//    	wheelMotor.set
    	conveyorMotor = new CANTalon(conveyorCanId.getId());
    	conveyorMotor.enableBrakeMode(true);
    	
    	gateOpenSolenoid = new Solenoid(openSolenoid.getChannel());
    	
    	gateCloseSolenoid = new Solenoid(closeSolenoid.getChannel());
    }
    
    /*
     * This method will turn on the conveyor belt.
     */
    @objid ("abb1320d-1f8b-4314-99f3-3b7aecfb78d2")
    public void turnOnConveyor() 
    {
    	conveyorMotor.set(Parameters.CONVEYOR_SET_SPEED);
    }

    /*
     * This method will turn off the conveyor belt.
     */
    @objid ("e600c4f6-8c96-4d44-a8ac-86765608dc1d")
    public void turnOffConveyor() 
    {
    	conveyorMotor.set(0);
    }

    /*
     * This method will turn on the shooter wheel at the shooting RPM.
     */
    @objid ("68e94877-afe1-4880-9814-1f35bbd1f035")
    public void turnOnWheelToShoot() 
    {
    	wheelMotor.set(Parameters.SHOOTER_WHEEL_SHOOT_SPEED);
    	shooting = true;
    	amIOff=false;
    }
    
    /*
     * This method will turn on the shooter wheel at the loading RPM.
     */
    @objid ("68e94877-afe1-4880-9814-1f35bbd1f035")
    public void turnOnWheelToLoad() 
    {
    	wheelMotor.set(Parameters.SHOOTER_WHEEL_LOAD_SPEED);
    	shooting = false;
    	amIOff=false;
    }
    
    /*
     * This method will turn off the shooter
     */
    @objid ("40c04284-806b-48b3-b931-0b218d8e2495")
    public void turnOffShooterWheel() 
    {
    	wheelMotor.set(0);
    	shooting = false;
    	amIOff=true;
    }

    /**
     * This method will turn the ball input gate into the shoot position.
     */
    @objid ("32229ab9-6b1e-4e5c-a7e2-2c2d2732d395")
    public void setShooterGatePosition() 
    {
    	gateOpenSolenoid.set(true);
    	gateCloseSolenoid.set(false);
    }

    /**
     * This method will turn the ball input gate into the loading position.
     */
    @objid ("9693c056-380d-4c68-ac14-4cd2b1e48dd2")
    public void setLoaderGatePosition() 
    {
    	gateOpenSolenoid.set(false);
    	gateCloseSolenoid.set(true);
    }

    @objid ("ba8d49b7-1823-482d-bd89-e96e6ac9370c")
    public boolean isShooterUpToSpeed() 
    {
    	boolean upToSpeed = false;
    	if (isShooterWheelRunning()) {
    		// We know the shooter wheel is running
    		if (shooting)
    		{
    			// Compare shooter wheel's speed to shoot setpoint
    			upToSpeed = isSpeedCloseEnough(Parameters.SHOOTER_WHEEL_SHOOT_SPEED);
    		}
    		else
    		{
    			// Compare shooter wheel's speed to load setpoint
    			upToSpeed = isSpeedCloseEnough(Parameters.SHOOTER_WHEEL_LOAD_SPEED);
    		}
    	}
    	return upToSpeed;
    }
    
    private boolean isSpeedCloseEnough(double setpoint) {
    	boolean closeEnough = false;
    	double currentSpeed = wheelMotor.get();
    	
    	if (Math.abs(currentSpeed - setpoint) <= Parameters.SHOOTER_WHEEL_SHOOT_SPEED_CLOSE_ENOUGH) 
    	{
    		closeEnough = true;
    	}
    	
    	return closeEnough;
    }
    
    private boolean isShooterWheelRunning() {
    	boolean running = false;
    	
    	if (shooting = true)
    	{
    		running = true;
    	}
    	
    	return running;
    }
    public boolean isShooterOff()
    {
    	boolean isOff=false;
    	
    	if (amIOff)
    	{
    		isOff=true;
    	}
    	
    	return isOff;
    }
}

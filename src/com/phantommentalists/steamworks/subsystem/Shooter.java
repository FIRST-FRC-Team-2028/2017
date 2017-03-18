package com.phantommentalists.steamworks.subsystem;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.command.shooter.TurnOffShooterCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

    /**   can id of wheel motor  */
    @objid ("39f50a55-9553-4bf4-8026-d40058cb7a83")
    private CANTalon conveyorMotor;
    
    /**							*/
    private CANTalon augerMotor;

    /**   solinoid variable for gate*/
    private Solenoid gateOpenSolenoid;
    
    /**  soliniod variable for gate   */
    private Solenoid gateCloseSolenoid;

    /**  notifies commands if shooting  */
	private boolean amIShooting = false;
	
	/** class member that indicates if the shooter wheel is off */
	private boolean amIOff = true;
    
	/** notifies commands if loading  */
	protected boolean amILoading = false;
	
	protected double p = .005, i= 0.00000005,d =0.00000005;
	
	private TurnOffShooterCommand shooterOff;

	private boolean gateLoad = false;
    /**
     * Constructor.  This method is responsible for initializing a new Shooter instance.
     */
    @objid ("732b1b92-b601-477c-ab75-004c7e1b6814")
    public Shooter() {
    	wheelMotor = new CANTalon(Parameters.CanId.SHOOTER_WHEEL.getId());
    	wheelMotor.changeControlMode(TalonControlMode.PercentVbus);
//    	wheelMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
    	wheelMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
    	wheelMotor.configEncoderCodesPerRev(4096);
    	wheelMotor.enableBrakeMode(true);
//    	wheelMotor.setP(p);
//    	wheelMotor.setI(i);
//    	wheelMotor.setD(d);
    	conveyorMotor = new CANTalon(Parameters.CanId.SHOOTER_CONVEYOR.getId());
    	conveyorMotor.enableBrakeMode(true);
    	conveyorMotor.changeControlMode(TalonControlMode.PercentVbus);
    	augerMotor = new CANTalon(Parameters.CanId.SHOOTER_AUGER.getId());
    	augerMotor.enableBrakeMode(true);
    	augerMotor.changeControlMode(TalonControlMode.PercentVbus);
    	gateOpenSolenoid = new Solenoid(Parameters.PneumaticChannel.SHOOTER_GATE_OPEN.getChannel());
    	gateCloseSolenoid = new Solenoid(Parameters.PneumaticChannel.SHOOTER_GATE_CLOSE.getChannel());
    	
    	wheelMotor.enable();
    	
    	conveyorMotor.enable();
    	
    	augerMotor.enable();
    	getDefaultCommand();
    }
   
    public double getP()
    {
    	return p;
    }
    
    public double getI()
    {
    	return i;
    }
    
    public double getD()
    {
    	return d;
    }
    
    public void setPID(double p, double i, double d)
    {
    	this.p = p;
    	this.i = i;
    	this.d = d;
    	wheelMotor.setPID(p, i, d);
    }
    // auger code by Ricky if it messes up it's Moose's code.
    public void turnOnAuger()
    {
    	augerMotor.set(Parameters.AUGER_ON_VOLTAGE);
    }
    
    public void turnOffAuger()
    {
    	augerMotor.set(0.0);
    }
    /*
     * This method will turn on the conveyor belt.
     */
    @objid ("abb1320d-1f8b-4314-99f3-3b7aecfb78d2")
    public void turnOnConveyor() 
    {
    	conveyorMotor.set(Parameters.CONVEYOR_SPEED);
    }
    
    public void turnOnConveyorReverse()
    {
    	conveyorMotor.set(-Parameters.CONVEYOR_SPEED);
    }

    /*
     * This method will turn off the conveyor belt.
     */
    @objid ("e600c4f6-8c96-4d44-a8ac-86765608dc1d")
    public void turnOffConveyor() 
    {
    	conveyorMotor.set(0.0);
    }

    /*
     * This method will turn on the shooter wheel at the shooting RPM.
     */
    @objid ("68e94877-afe1-4880-9814-1f35bbd1f035")
    public void turnOnWheelToShoot() 
    {
    	SmartDashboard.putNumber("Current",wheelMotor.getOutputCurrent());
    	SmartDashboard.putNumber("Speed", wheelMotor.getSpeed());
    	wheelMotor.set(Parameters.SHOOTER_WHEEL_SHOOT_SETPOINT);
    	amIShooting = true;
    	amIOff=false;
    	amILoading=false;
    }
    
    /*
     * This method will turn on the shooter wheel at the loading RPM.
     */
    @objid ("68e94877-afe1-4880-9814-1f35bbd1f035")
    public void turnOnWheelToLoad() 
    {
    	wheelMotor.set(Parameters.SHOOTER_WHEEL_LOAD_SETPOINT);
    	amIShooting = false;
    	amIOff=false;
    	amILoading=true;
    }
    
    /*
     * This method will turn off the shooter
     */
    @objid ("40c04284-806b-48b3-b931-0b218d8e2495")
    public void turnOffShooterWheel() 
    {
    	wheelMotor.set(0);
    	amIShooting = false;
    	amIOff=true;
    	amILoading=false;
    }

    /**
     * This method will turn the ball input gate into the shoot position.
     */
    @objid ("32229ab9-6b1e-4e5c-a7e2-2c2d2732d395")
    public void setShooterGatePosition() 
    {
    	gateOpenSolenoid.set(true);
    	gateCloseSolenoid.set(false);
    	gateLoad = false;
    }

    /**
     * This method will turn the ball input gate into the loading position.
     */
    @objid ("9693c056-380d-4c68-ac14-4cd2b1e48dd2")
    public void setLoaderGatePosition() 
    {
    	gateOpenSolenoid.set(false);
    	gateCloseSolenoid.set(true);
    	gateLoad = true;
    }

    /**
     * determines if the shooter is fast enough 
     * @return  that the shooter is fast enough
     */
    @objid ("ba8d49b7-1823-482d-bd89-e96e6ac9370c")
    public boolean isShooterUpToSpeed() 
    {
    	boolean upToSpeed = false;
    	if (isShooterWheelRunning()) {
    		// We know the shooter wheel is running
    		if (amIShooting)
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
    
    /**
     * 
     * @param setpoint speed that is close enough
     * @return if speed is close enough
     */
    
    protected boolean isSpeedCloseEnough(double setpoint) {
    	boolean closeEnough = false;
    	double currentSpeed = wheelMotor.get();
    	
    	if (Math.abs(currentSpeed - setpoint) <= Parameters.SHOOTER_WHEEL_SHOOT_SPEED_CLOSE_ENOUGH) 
    	{
    		closeEnough = true;
    	}
    	
    	return closeEnough;
    }
    
    public double getSpeed()
    {
    	return wheelMotor.get();
//    	wheelMotor.get
    }
    
    public boolean isGateInLoadPosition()
    {
    	return gateLoad;
    }
    
    /**
     * determines if the shooting wheel is in the running state
     * @return if the shooting wheel is in the running state
     */
    
    protected boolean isShooterWheelRunning() 
    {
    	return !amIOff;
    }
    
    /**
     * 
     * @return
     */
    public boolean isShooterOff()
    {
    	return amIOff;
    }

    /**
     * Shooter does not have a default command
     */
	@Override
	protected void initDefaultCommand() {
		shooterOff = new TurnOffShooterCommand(this);
		setDefaultCommand(shooterOff);
		
	}
	
	public TurnOffShooterCommand getDefaultShooterCommand()
	{
		return shooterOff;
	}
}
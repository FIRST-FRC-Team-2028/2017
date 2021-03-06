package com.phantommentalists.steamworks;

import java.io.File;
import java.io.FileOutputStream;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("147601fc-4964-44fd-9205-76f83e66cb5d")
public class Parameters {
	
	public static File file;
	
	public static FileOutputStream outStream;
	
	public final static double STEERING_MOTOR_SPEED = 0.25;
	
	public final static double CLIMBER_ON_CLIMB_VOLTAGE = 0.85;
	
	public final static double DRIVE_FAN_SET = 0.625;
	
	public final static double AUGER_ON_VOLTAGE = 0.5;
	
	public final static double FAN_MAX_VOLTAGE = 7.5;
	
	public final static double AUTONOMOUS_CLIMB_TIME = 0.1;
	
	public final static double AUTONOMOUS_DRIVE_ACROSS_BASELINE_TIME = 3;
	
	public final static double AUTONOMOUS_DRIVE_SPEED = -0.6;

	public final static double AUTONOMOUS_DRIVE_CENTER_PEG_TIME = 1;
	
	public final static double AUTONOMOUS_CENTER_PEG_SLEW_TIME =0;

	public final static double STEERING_STRAIGHT_AHEAD = 0.5;
	
	// TODO - Replace with actual values
	public final static double SHOOTER_WHEEL_SHOOT_SPEED = 10.0;

	// TODO - Replace with actual values
	public final static double SHOOTER_WHEEL_LOAD_SPEED = 2.0;

	// TODO - Replace with actual values
	public final static double CONVEYOR_SET_SPEED = 2.0;

	// TODO - Replace with actual values
	public final static double SHOOTER_WHEEL_SHOOT_SPEED_CLOSE_ENOUGH = 0.1;
		
	public final static double SHOOTER_WHEEL_LOAD_SETPOINT = -0.13;
	public final static double SHOOTER_WHEEL_SHOOT_SETPOINT = -0.45;//-0.43 -6300 rpms
	public final static double CONVEYOR_SPEED = 0.85;
	
	public final static double GEAR_GOBBLER_CLOSE_TIME =0;
	public final static double GEAR_GOBBLER_OPEN_TIME =5;

	public static final int ULTRASONIC_PORT = 0;
	
    @objid ("53c209e9-b5d2-4210-a4ad-4673956bef36")
    public enum CanId {
    	DRIVE_RIGHT_MASTER (23, false),
        DRIVE_RIGHT_FOLLOWER (32, false),
        DRIVE_LEFT_MASTER (14, false),
        DRIVE_LEFT_FOLLOWER (41, false),
        STEERING_LEFT_FRONT (10, false),
        STEERING_RIGHT_FRONT (20, false),
        STEERING_LEFT_REAR (40, false),
        STEERING_RIGHT_REAR (30, false),
        SHOOTER_WHEEL (52, false),
        SHOOTER_CONVEYOR (51, false),
        SHOOTER_AUGER (60, false),
        CLIMBER_MOTOR (50, false),
    	FAN(53, false);

        @objid ("c7fdac8d-8d3f-466c-99bb-871eee680012")
        private int canID;

        @objid ("7c341f93-138f-429d-9042-d43a1d19a4eb")
        private boolean reversed;

        @objid ("8da67a3c-7cf5-4243-b307-f917b1c2c2f0")
        private CanId(int id, boolean rev) {
            canID = id;
            reversed = rev;
        }

        @objid ("4e239d4c-c92b-48f4-935d-dca68efb45eb")
        public int getId() {
            return canID;
        }

        @objid ("0e74f615-901d-4142-ad87-a01a46fd1e88")
        public boolean isReversed() {
            return reversed;
        }

    }

    @objid ("9ad1c688-70b9-44a6-9d6d-9f13129086ec")
    public enum SteeringOffset {
        LEFT_FRONT (0.05),//10 (-0.42)
        RIGHT_FRONT (0.24),//20 (-.27)
        RIGHT_REAR (0.29),//30 (-.21)
        LEFT_REAR (0.11);//40 (.005)

        @objid ("18ad7371-c09e-43bd-a188-c5e708656a77")
        private double offset;

        @objid ("86239260-4ec6-4919-b6f7-259b36e0a395")
        private SteeringOffset(double offset) {
            this.offset = offset;
        }

        @objid ("86d83446-c8bd-4d8c-98f9-f558a038129e")
        public double getOffset() {
            return offset;
        }

    }

    @objid ("6b486b3b-6299-402c-8fc5-a2be872d3ea6")
    public enum SideOfRobot {
        RIGHT,
        LEFT;
    }

    @objid ("bbc5f44b-b03f-477c-a1d7-8f1206abeff7")
    public enum Buttons {
        SWEARVE(2),
        SPIN_ON_AXIS(1),
        SHIFT_LOW_GEAR(3),
        SHIFT_HIGH_GEAR(4);
        
        private int id;
        
        private Buttons(int id)
        {
     	   this.id = id;
        }
        
        public int getID()
        {
     	   return id;
        }
     }

    @objid ("27e8d34d-3b02-4e82-9351-eaba0bd459d2")
    public enum PneumaticChannel {
    	SHOOTER_GATE_OPEN(2),
    	SHOOTER_GATE_CLOSE(3),
    	GEAR_GOBBLER_FLAP_OPEN(5),
    	GEAR_GOBBLER_FLAP_CLOSE(4),
    	DRIVE_LOW_GEAR(0),
    	DRIVE_HIGH_GEAR(1);
//    	OPEN_LOADER_WHEEL_HOLDER(7),
//    	CLOSE_LOADER_WHEEL_HOLDER(6);
        
        private int channel;
        
        private PneumaticChannel(int channel)
        {
        	this.channel = channel;
        }
        
        public int getChannel()
        {
        	return channel;
        }
    }
    
    public enum DigitalInput {
    	LIMIT_SWITCH_LEFT(0),
    	LIMIT_SWITCH_RIGHT(1);
    	
    	private int input;
    	
    	private DigitalInput(int input)
    	{
    		this.input = input;
    	}
    	
    	public int getChannel()
    	{
    		return input;
    	}
    }
    
    public enum Pid {
    	/**
    	 * PID Values to automatically control steering angle 
    	 * 
    	 * TODO - Replace with actual values
    	 */
    	DRIVE_STEERING(0.0, 0.0, 0.0, 0.0),
    	
    	/**
    	 * PID values to maintain a constant shooter wheel speed
    	 * 
    	 * TODO - Replace with actual values
    	 */
    	SHOOTER_WHEEL(0.0, 0.0, 0.0, 0.0);
    	
    	private double f;
    	private double p;
    	private double i;
    	private double d;
    	
    	private Pid(double f, double p, double i, double d) {
    		this.f = f;
    		this.p = p;
    		this.i = i;
    		this.d = d;
    	}
    	
    	public double getF() {
    		return f;
    	}
    	public double getP() {
    		return p;
    	}
    	
    	public double getI() {
    		return i;
    	}
    	
    	public double getD() {
    		return d;
    	}
    }

    

    public static int pixyResx = 320; //Could be 320 or 640 
    public static int pixyResy = 200; //Could be 200 or 400
    //Field of view in degrees
    public static int xPixyFOV = 75;
    public static int yPixyFOV = 47;

    
}

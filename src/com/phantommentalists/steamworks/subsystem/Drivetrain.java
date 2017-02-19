package com.phantommentalists.steamworks.subsystem;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.Parameters;
import com.phantommentalists.steamworks.command.DriveCommand;
import com.phantommentalists.steamworks.component.DriveSide;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
//github.com/FIRST-FRC-Team-2028/2017.git
import edu.wpi.first.wpilibj.command.Subsystem;

@objid ("f83fed2a-c93a-4529-87d2-2c458cd5d09e")
public class Drivetrain extends Subsystem {
    @objid ("055cc2c0-36ba-42d6-975e-661074ba6451")
    private DriveSide leftSide;

    @objid ("d695e0ae-d79b-4e54-86e2-c5d628a64e28")
    private DriveSide rightSide;

    private Solenoid lowGear,highGear;
    
    private DriveCommand defaultCommand;
    
    public Drivetrain()
    {
    	leftSide = new DriveSide(Parameters.SideOfRobot.LEFT);
    	rightSide = new DriveSide(Parameters.SideOfRobot.RIGHT);
    	
    	lowGear = new Solenoid(Parameters.PneumaticChannel.DRIVE_LOW_GEAR.getChannel());
    	highGear = new Solenoid(Parameters.PneumaticChannel.DRIVE_RIGHT_GEAR.getChannel());
    	
    	highGear.set(false);
    	lowGear.set(true);
    	getDefaultCommand();
    }
    
    public void crabDrive(double angle, double speed)
    {
//    	System.out.println("crab "+angle);
//    	angle += 0.5;
//    	System.out.println("crab aft"+angle);

    	leftSide.crabDrive(angle, speed);
    	rightSide.crabDrive(angle, speed);
    	
//		double sumCurAngle =0;
//		double angle = 0;
//		double sumPrevQuarterAngle = 0;
//		double prevQuarterAngle = angle-0.25;
//		double sumNextQuarterAngle = 0;
//		double nextQuarterAngle = angle+0.25;
		
////		Beginning of test code
//		if(sumCurAngle >= 0.5)
//		{
////			System.out.println("Positive");;
//		}
//		else if(sumCurAngle <= 0.5)
//		{
////			System.out.println("Negative");
//		}
//		else
//		{
////			System.out.println("Failed");
//		}
////		Ending of test code
    	
//    	if(stick.getRawAxis(0) > 0)
//    	{
//    		speed = -speed
//    	} 
//    	else if(stick.getRawAxis(0) < 0)
//    	{
//    		speed = speed
//    	}
//    	else
//    	{
//    		System.out.println(Failed);
//    	}
    }
    
    public void swerveDrive(double angle, double speed)
    {
    	
//    	angle*=0.125;
//    	angle += 0.5;
//    	System.out.println("Sw: "+angle);
//    	System.out.println("SW After: "+angle);
		double in = ((45.0/360.0)*(angle));
		double out = ((16.97/360.0)*(angle));
		in += 0.5;
		out += 0.5;
		if(angle > 0)
		{
//			System.out.println("here");
			leftSide.swerveDrive(in, speed);
			rightSide.swerveDrive(out, speed);
		}
		else
		{
			leftSide.swerveDrive(out, speed);
			rightSide.swerveDrive(in, speed);
		}
    }
    
    public void spinOnAxis(double speed)
    {
    	leftSide.spinOnAxis(speed);
    	rightSide.spinOnAxis(speed);
    }
    
    public void setLowGear()
    {
    	highGear.set(false);
    	lowGear.set(true);
//    	System.out.println("Hi");
    }
    
    public void setHighGear()
    {
    	lowGear.set(false);
    	highGear.set(true);
    }
    
    public void printNeededOffsets()
    {
    	leftSide.printNeededOffsets();
    	rightSide.printNeededOffsets();
    }
    
    public void enableTurning(boolean enable)
    {
    	leftSide.enableTurngin(enable);
    	rightSide.enableTurngin(enable);
    }

    
    @objid ("ae9970ca-0edb-45bf-847b-2edc45564f8d")
    @Override
    protected void initDefaultCommand() {
    	defaultCommand = new DriveCommand(this);
//		System.out.println("InitDef");
		setDefaultCommand(defaultCommand);
		System.out.println("drive: "+defaultCommand);
    }

    public DriveCommand getDefCommand()
    {
    	return defaultCommand;
    }
}

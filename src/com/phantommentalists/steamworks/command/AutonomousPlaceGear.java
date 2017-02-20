package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.subsystem.Drivetrain;
import com.phantommentalists.steamworks.subsystem.PixyCamera;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousPlaceGear extends CommandGroup {
	
	boolean done = false;
	int num = 0;
	
	PixyCamera pixy;
	Drivetrain drive;
	
	public AutonomousPlaceGear(PixyCamera pixy, Drivetrain drive) {
		this.pixy = pixy;
		this.drive = drive;
		requires(pixy);
		requires(drive);
	}
    protected void execute() {
//    	System.out.println("Finding");
    	pixy.getTargets();
    	if(!pixy.isCloseEnough() && pixy.hasTarget())
    	{
    		drive.swerveDrive(-pixy.getTargetAngle(), 0.25);
    		done = false;
    		num = 0;
    	} 
    	else
    	{
    		if(pixy.hasTarget())
    		{
    			drive.swerveDrive(0, 0);
    			done = true;
    		}
    		else
    		{
    			num++;
    			if(num >= 20)
    			{
    				System.out.println("Canceled");
    		    	drive.swerveDrive(0, 0);
    				cancel();
    			}
    		}
    	}
    }

    protected boolean isFinished() {
        // TODO Auto-generated method stub
    	if(done)System.out.println("Finished");
        return done;
    }

    public void setup()
    {
    	done = false;
    	num = 0;
    }
    
    protected void initialize() {
//    	System.out.println("");
    	done = false;
    	num = 0;
    }

}

package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.subsystem.Drivetrain;
import com.phantommentalists.steamworks.subsystem.PixyCamera;
import com.phantommentalists.steamworks.subsystem.Ultrasonic;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousPlaceGear extends CommandGroup {
	
	boolean done = false;
	int num = 0;
	
	PixyCamera pixy;
	Drivetrain drive;
	Ultrasonic ultrasonic;
	
	public AutonomousPlaceGear(PixyCamera pixy, Drivetrain drive, Ultrasonic ultrasonic) {
		this.pixy = pixy;
		this.drive = drive;
		this.ultrasonic = ultrasonic;
		requires(pixy);
		requires(drive);
		requires(ultrasonic);
	}
    protected void execute() {
//    	System.out.println("Finding");
    	pixy.getTargets();
    	if(pixy.hasTarget())
    	{
    		System.out.println("found target");
    		if(ultrasonic.getDistance() > 14)
    		{
	    		drive.swerveDrive(-pixy.getTargetAngle(), -0.25);
	    		done = false;
	    		num = 0;
    		}
    		else
    		{
    			System.out.println("Done at: "+ultrasonic.getDistance());
    			drive.swerveDrive(0, 0);
    			done = true;
    		}
    	} 
    	else
    	{
			num++;
			if(num >= 100)
			{
				System.out.println("Canceled");
		    	drive.swerveDrive(0, 0);
		    	done =true;
//				cancel();
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
    	System.out.println("Starting");
    	done = false;
    	num = 0;
    }

}

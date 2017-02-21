package com.phantommentalists.steamworks.command;

import com.phantommentalists.steamworks.DriveType;
import com.phantommentalists.steamworks.Parameters.Buttons;
import com.phantommentalists.steamworks.subsystem.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

	Drivetrain drive;
	
	static double angle= 0, speed=0, swerveangle =0, swervespeed =0;
	
	static DriveType drivetype = DriveType.CRAB;
	
    public DriveCommand(Drivetrain drive) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drive);
    	this.drive = drive;
//    	this.stick = stick;
//    	fans = Robot.fans;//                       				For Fans
//    	System.out.println("got here");
    }
    
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	System.out.println("Comm init");
    }

    
    
    public void setDrive(double x, double y, double z)
    {
    	double[] polar = getPolarCoords(x,y);
    	angle = polar[0];
    	speed = polar[1];
    	swervespeed = y;
//    	System.out.println("Swerve "+swerveangle);
    	swerveangle = z;
    }
    
    public void setDriveType(DriveType type)
    {
    	drivetype = type;
    }
    
    public void setHighGear(boolean highGear)
    {
    	if(highGear)
    	{
    		drive.setHighGear();
    	}
    	else
    	{
    		drive.setLowGear();
    	}
    }
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
//    	System.out.println("here");
//    	fans.changeControlMode(TalonControlMode.PercentVbus);//    For Fans
//    	fans.setVoltageRampRate(7);//								For Fans
//    	fans.enable();// 											For Fans
    	
    	switch(drivetype)
    	{
    	case CRAB:
//    		System.out.println(angle);
    		drive.crabDrive(angle, speed);
    		break;
    	case SWERVE:
    		drive.swerveDrive(swerveangle, swervespeed);
    		break;
    	case SPIN:
    		drive.spinOnAxis(swerveangle);
    		break;
    	}
    	
//    	System.out.println("I AM HERE");
    	
    }
    
    public double[] getPolarCoords(double argx, double argy)
    {
    	double x = normalizeInput(argx);
		double y = normalizeInput(argy);

		double degrees = Math.toDegrees(Math.atan2(x,y));
    	degrees += 180;
    	degrees /= 360;
    	double volts = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
    	
//    	Beginning of possible part of solution
//		if(stick.getRawAxis(0) > 0)
//    	{
//    		drive.crabDrive(0, -x);
//    	}
//    	else if(stick.getRawAxis(0) < 0)
//    	{
//    		drive.crabDrive(.5, x);
//    	}
//    	else
//    	{
//    		System.out.println("Failed");
//    	}
//		End of possible part of solution
    	
//    	System.out.println("Degree: "+degrees);
    	return new double[] {degrees,volts};
    }
    
    public double normalizeInput(double pos)
    {
    	if(isWithinDeadband(pos))
    		return 0;
    	return pos;
    }
    
    public boolean isWithinDeadband(double pos)
    {
    	return Math.abs(pos)<0.09;
    }
    
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
//    	System.out.println("isfinished");
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	System.out.println("end");

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	System.out.println("ive been ...");

    }
}

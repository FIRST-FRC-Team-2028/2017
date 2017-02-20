package com.phantommentalists.steamworks;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.command.DriveCommand;
import com.phantommentalists.steamworks.subsystem.Climber;
import com.phantommentalists.steamworks.subsystem.Drivetrain;
import com.phantommentalists.steamworks.subsystem.GearGobbler;
import com.phantommentalists.steamworks.subsystem.PixyCamera;
import com.phantommentalists.steamworks.subsystem.Shooter;

import edu.wpi.first.wpilibj.Compressor;
//github.com/FIRST-FRC-Team-2028/2017.git
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

@objid ("595898a6-dbcb-4cef-ba25-a6e7f7e35190")
public class Telepath extends IterativeRobot {
    @objid ("3d9689ff-e81e-487e-aefa-4f78e43f6106")
    private Drivetrain drivetrain;

    @objid ("dcd9b9f0-7d96-4ba2-9a01-3d65faed9160")
    private Shooter shooter;

    @objid ("101fbe46-417e-4fee-a962-1d74188860fd")
    private Climber climber;

    @objid ("0b633498-f0d6-4075-a2be-968bcbc09caa")
    private GearGobbler gearGobbler;

    @objid ("bcc723c9-717e-4ede-9db3-fbeeb0df0fe5")
    private PixyCamera pixyCamera;
    
    private DriveCommand drivecommand;
    
    private CommandGroup auto;
    
    public Joystick onestick;
    
    private Compressor comp;

    @Override
    @objid ("0b53ecde-257f-466b-bcef-43fce4dbdc95")
    public void robotInit() {
    	System.out.println("here robot init");
    	drivetrain = new Drivetrain();
//    	drivetrain.get
//    	Scheduler.getInstance().enable();
    	drivecommand = drivetrain.getDefCommand();
//    	System.out.println("Drive command: "+drivecommand);
//    	crabCommand = (CrabDriveCommand)drivetrain.
//    	pixyCamera = new PixyCamera();
    	
    	

//    	autoPlaceGear = new AutonomousPlaceGear();
    	
//    	pixyCamera.setDefaultCommand(autoPlaceGear);
    	
//    	placeGear = new PlaceGearButton();
    	
//    	placeGear.whenPressed(autoPlaceGear);
    }

    @Override
    @objid ("dab887d4-4871-4722-aa13-e9fed526eebe")
    public void autonomousInit() { 
    	//TODO:Get auto mode from driver station and setup auto
    	auto.start();
    }

    @Override
    @objid ("198d6d2d-b717-47a0-9406-b8edadcc5497")
    public void teleopInit() {
    	System.out.println("Tele init");
    	drivetrain.enableTurning(true);
    	comp.start();
    }

    @Override
    @objid ("77311426-3d0c-409a-a086-2bc92e6e89bd")
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    	
    }

    @Override
    @objid ("87edd468-04be-4afb-8fa3-cb14e164c58d")
    public void teleopPeriodic() {
    	
    	Scheduler.getInstance().run();
    	comp.start();
    	if(onestick.getRawButton(3))
    	{
    		drivecommand.setHighGear(false);
    	}
    	else if(onestick.getRawButton(4))
    	{
    		drivecommand.setHighGear(true);
    	}
    	
    	drivecommand.setDrive(onestick.getRawAxis(0), -onestick.getRawAxis(1), -onestick.getRawAxis(2));
    	if(onestick.getRawButton(2))
    	{
    		drivecommand.setDriveType(DriveType.SWERVE);
    	}
    	else if(onestick.getRawButton(1))
    	{
    		drivecommand.setDriveType(DriveType.SPIN);
    	}
    	else
    	{
    		drivecommand.setDriveType(DriveType.CRAB);
    	}
    }

//    @Override
//    @objid ("d4573f62-3f85-40b0-94f2-673a79e3d9d8")
//    public void startCompetition() {
//    }

    @Override
    @objid ("ca63651a-1b48-4fda-9a4d-649cf66bba2f")
    public void disabledInit() {
    }

    @Override
    @objid ("8777cba3-4287-482a-9b97-9e306b902160")
    public void robotPeriodic() {
    }

    @Override
    @objid ("a343a83d-cc3b-43a0-979e-e09e44143476")
    public void disabledPeriodic() {
    }

    @Override
    public void testInit()
    {
    	drivetrain.enableTurning(false);
    }
    
    @Override
    public void testPeriodic()
    {
    	Scheduler.getInstance().run();
    	drivetrain.printNeededOffsets();
    }
    
    @objid ("aed20313-389b-4a3c-b333-d763e6cd1572")
    public Telepath() {
    	onestick = new Joystick(5);
    	comp = new Compressor();
    }

}

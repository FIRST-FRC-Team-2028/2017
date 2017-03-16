package com.phantommentalists.steamworks;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.command.AutoClimb;
import com.phantommentalists.steamworks.command.AutonomousCenterPeg;
import com.phantommentalists.steamworks.command.AutonomousDriveAcrossBaseline;
import com.phantommentalists.steamworks.command.AutonomousPlaceGear;
import com.phantommentalists.steamworks.command.CloseGearGobblerCommand;
import com.phantommentalists.steamworks.command.DriveCommand;
import com.phantommentalists.steamworks.command.DriveToBoilerDistanceCommand;
import com.phantommentalists.steamworks.command.LoadGateCommand;
import com.phantommentalists.steamworks.command.OpenGearGobblerCommand;
import com.phantommentalists.steamworks.command.ShootGateCommand;
import com.phantommentalists.steamworks.command.TurnOffClimberCommand;
import com.phantommentalists.steamworks.command.TurnOffShooterCommand;
import com.phantommentalists.steamworks.command.TurnOnClimberCommand;
import com.phantommentalists.steamworks.command.TurnOnLoaderCommand;
import com.phantommentalists.steamworks.command.TurnOnShooterCommand;
import com.phantommentalists.steamworks.subsystem.Climber;
import com.phantommentalists.steamworks.subsystem.Drivetrain;
import com.phantommentalists.steamworks.subsystem.GearGobbler;
import com.phantommentalists.steamworks.subsystem.PixyCamera;
import com.phantommentalists.steamworks.subsystem.Shooter;
import com.phantommentalists.steamworks.subsystem.Ultrasonic;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
//github.com/FIRST-FRC-Team-2028/2017.git
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    
    private Ultrasonic ultrasonic;
    
    private DriveCommand drivecommand;
    
    private CommandGroup auto;
    
    public Joystick onestick,buttonstick;
    
    private Compressor comp;
    
    private CameraServer server;
    
    private SendableChooser<CommandGroup> autoChooser;
    
    private AutonomousPlaceGear autoPlaceGear;
    private AutoClimb autoClimb;
    private DriveToBoilerDistanceCommand driveToBoiler;
    
    private TurnOnClimberCommand climberOn;
    private TurnOffClimberCommand climberOff;
    
    private TurnOnShooterCommand shooterOn;
    private ShootGateCommand setGateShoot;
    private LoadGateCommand setGateLoad;
    private TurnOnLoaderCommand shooterLoad;
    private TurnOffShooterCommand shooterOff;
    
    private OpenGearGobblerCommand openGear;
    private CloseGearGobblerCommand closeGear;
    
    int num =0;

    @Override
    @objid ("0b53ecde-257f-466b-bcef-43fce4dbdc95")
    public void robotInit() {
//    	server = CameraServer.getInstance();
//    	UsbCamera cam = new UsbCamera("cam0", 0);
//    	cam.setFPS(30);
//    	server.addCamera(cam);
//    	server.startAutomaticCapture(cam);
//    	cam.setVideoMode(VideoMode.PixelFormat.)
    	System.out.println("here robot init");
    	drivetrain = new Drivetrain();
    	shooter = new Shooter();
    	gearGobbler = new GearGobbler();
    	climber = new Climber();
    	ultrasonic = new Ultrasonic();
//    	drivetrain.get
//    	Scheduler.getInstance().enable();
    	drivecommand = drivetrain.getDefCommand();
//    	System.out.println("Drive command: "+drivecommand);
//    	crabCommand = (CrabDriveCommand)drivetrain.
    	pixyCamera = new PixyCamera();
    	
    	SmartDashboard.putNumber("P", shooter.getP());
    	SmartDashboard.putNumber("I",shooter.getI());
    	SmartDashboard.putNumber("D", shooter.getD());
    	

    	autoPlaceGear = new AutonomousPlaceGear(pixyCamera, drivetrain, ultrasonic);
    	autoClimb = new AutoClimb(climber);
    	driveToBoiler = new DriveToBoilerDistanceCommand(drivetrain, ultrasonic);
    	
    	
    	climberOn = new TurnOnClimberCommand(climber);
    	climberOff = climber.getDefaultClimberCommand();
    	
    	shooterOn = new TurnOnShooterCommand(shooter);
    	setGateShoot = new ShootGateCommand(shooter);
//    	setShooter = new SetShooterShoot(shooter);
    	shooterLoad = new TurnOnLoaderCommand(shooter);
    	setGateLoad = new LoadGateCommand(shooter);
    	
    	autoChooser = new SendableChooser<CommandGroup>();
    	autoChooser.addDefault("Baseline",new AutonomousDriveAcrossBaseline(drivetrain));
    	autoChooser.addObject("Center Peg", new AutonomousCenterPeg(drivetrain,gearGobbler,pixyCamera,ultrasonic,false));
    
    	openGear = new OpenGearGobblerCommand(gearGobbler);
    	closeGear = new CloseGearGobblerCommand(gearGobbler);
    	
//    	autoChooser.initTable(table);
    	//    	auto = new AutonomousDriveAcrossBaseline(drivetrain);
//    	auto = new AutonomousCenterPeg(drivetrain,gearGobbler,pixyCamera,ultrasonic,false);
//    	pixyCamera.setDefaultCommand(autoPlaceGear);
    	
//    	placeGear = new PlaceGearButton();
    	
//    	placeGear.whenPressed(autoPlaceGear);
    }

    @Override
    @objid ("dab887d4-4871-4722-aa13-e9fed526eebe")
    public void autonomousInit() { 
    	//TODO:Get auto mode from driver station and setup auto
    	
//    	auto = new AutonomousDriveAcrossBaseline(drivetrain);
//    	auto = new AutonomousCenterPeg(drivetrain,gearGobbler,pixyCamera,ultrasonic,false);
    	auto = null;
    	switch(getAutoState())
    	{
    	case 0:
    		auto = new AutonomousDriveAcrossBaseline(drivetrain);
    		break;
    	case 1:
    		break;
    	case 2:
    		break;
    	case 3:
    		break;
    	case 4:
    		break;
    	case 5:
    		break;
    	case 6:
    		break;
    	case 7:
    		break;
    	case 8:
    		break;
    	case 9:
    		break;
    	}
//    	auto = autoChooser.getSelected();
    	if(auto != null)
    	{
    		auto.start();
    	}
    }

    @Override
    @objid ("198d6d2d-b717-47a0-9406-b8edadcc5497")
    public void teleopInit() {
    	System.out.println("Tele init");
    	drivetrain.enableTurning(true);
    	double p=0,i=0,d=0;
    	p = SmartDashboard.getNumber("P", shooter.getP());
    	i = SmartDashboard.getNumber("I",shooter.getI());
    	d = SmartDashboard.getNumber("D", shooter.getD());
    	shooter.setPID(p, i, d);
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
    	
    	drivecommand.setDrive(-onestick.getRawAxis(0), -onestick.getRawAxis(1), buttonstick.getRawAxis(4));
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
    	if(onestick.getRawButton(12))
    	{
    		autoPlaceGear.start();
    	}
    	else if(onestick.getRawButton(11))
    	{
    		autoPlaceGear.cancel();
    	}
    	if (onestick.getRawButton(10))
    	{
    		driveToBoiler.start();
    	}
    	if (onestick.getRawButton(9))
    	{
    		driveToBoiler.cancel(); 
    	}
    	
    	if(buttonstick.getRawButton(3))
    	{
    		climberOn.start();
    	}
    	else
    	{
    		climberOn.cancel();
    	}
    	
    	if(buttonstick.getRawButton(5))
    	{
    		openGear.start();
    	}	
    	else
    	{
    		closeGear.start();
    	}
    	//turns off and on the auger
    	if(buttonstick.getRawButton(4))
    	{
    		shooter.turnOnAuger();
    	}
    	else
    	{
    		shooter.turnOffAuger();
    	}
//    	if(buttonstick.getRawButton(2))
//    	{
////    		if(num ==0)
////    		{
////    			setGateShoot.start();
////    		}
////    		else
////    		{
//    			shooterOn.start();
////    		}
////    		setShooter.start();
//    		num++;
//    		if(num%10 ==0)
//    		{
//    			SmartDashboard.putNumber("Speed", shooter.getSpeed());
//    		}
//
//    	}
//    	else
//    	{
//    		num = 0;
//    	}
    	switch(getShootingState())
    	{
    	case -1:
    		shooterLoad.start();
    		break;
    	case 0:
    		shooterLoad.cancel();
//    		shooterOff.start();
    		break;
    	case 1:
    		shooterOn.start();
    		break;
    	default:
    	}
    	if(buttonstick.getRawButton(6) && shooter.isGateInLoadPosition())
    	{
    		
    		setGateShoot.start();
    	}
    	else if(!buttonstick.getRawButton(6) && !shooter.isGateInLoadPosition())
    	{
    		setGateLoad.start();
    	}
    	
    	if (buttonstick.getRawButton(2))
    	{
    		autoClimb.start();
    	}
    	else
    	{
    		autoClimb.cancel();
    	}
//		if(buttonstick.getRawAxis(num) == -1)
//    	{
//    		//auto cross base line code
//    	}
//    	else if(buttonstick.getRawAxis(num) == -0.8)
//    	{
//    		//auto left gear code
//    	}
//    	else if(buttonstick.getRawAxis(num) == -0.6)
//    	{
//    		//auto center left gear code
//    	}
//    	else if(buttonstick.getRawAxis(num) == -0.4)
//    	{
//    		//auto center right gear code
//    	}
//    	else if(buttonstick.getRawAxis(num) == -0.2)
//    	{
//    		//auto right gear code
//    	}
//    	else if(buttonstick.getRawAxis(num) == 0)
//    	{
//    		//    Nothing
//    	}
//    	else if(buttonstick.getRawAxis(num) == 0.2)
//    	{
//    		//auto Shoot Left/Blue or Red
//    	}
//    	else if(buttonstick.getRawAxis(num) == 0.4)
//    	{
//    		//auto Shoot Right/Blue or Red
//    	}

    	SmartDashboard.putNumber("Auto", getAutoState());
    	SmartDashboard.putBoolean("Limit Switch Left: ", climber.getLeftLimitSwitch());
    	SmartDashboard.putBoolean("Limit Switch Right: ", climber.getRightLimitSwitch());


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
    	
//    	if(onestick.getRawButton(1))
//    	{
//    		autoPlaceGear.start();
//    	}
//    	else if(onestick.getRawButton(3))
//    	{
//    		autoPlaceGear.cancel();
//    	}
    		
    	
//    	System.out.println("Distance: "+ultrasonic.getDistance());
    }
    
    public int getShootingState()
    {
    	double y = buttonstick.getRawAxis(1);
//    	System.out.println(y);
    	if(y < -0.15)
    	{
    		return -1;
    	}
    	else if(y > 0.15)
    	{
    		return 1;
    	}
    	else
    	{
    		return 0;
    	}
    }
    
    public int getAutoState()
    {
    	double i = buttonstick.getRawAxis(0);
    	
    	if(i < -0.9)
    	{
    		return 0;
    	}
    	else if(i < -0.7)
    	{
    		return 1;
    	}
        else if(i < -0.5)
        {
    		return 2;
        }
    	else if(i < -0.3)
    	{
    		return 3;
    	}
    	else if(i < -0.1)
    	{
    		return 4;
    	}
    	else if(i > 0.15 && i < 0.35)
    	{
    		return 5;
    	}
    	else if(i > 0.35 && i < 0.55)
    	{
    		return 6;
    	}
    	else if(i > 0.55 && i < 0.85)
    	{
    		return 7;
    	}
    	else if(i > 0.85)
    	{
    		return 8;
    	}
    	else
    	{
    		return 9;
    	}


    }
    
    @objid ("aed20313-389b-4a3c-b333-d763e6cd1572")
    public Telepath() {
    	onestick = new Joystick(5);
    	buttonstick = new Joystick(2);
    	comp = new Compressor();
    }

}

package com.phantommentalists.steamworks.subsystem;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Ultrasonic extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	AnalogInput sensor;
	public Ultrasonic()
	{
		sensor = new AnalogInput(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getDistance()
    {
    	double avg =0;
    	for(int i =0;i<10;i++)
    		avg += sensor.getAverageVoltage();
    	avg /=10;
    	return avg/(Math.pow(10.5, -2));
    }
}


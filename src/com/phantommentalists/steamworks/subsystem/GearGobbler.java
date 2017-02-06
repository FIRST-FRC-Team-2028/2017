package com.phantommentalists.steamworks.subsystem;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.Parameters;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

@objid ("064c011c-a2a8-421b-86d8-6f532e9b4881")
public class GearGobbler extends Subsystem 
{
    @objid ("864a1060-eb54-405b-9237-9e9e8995a6a6")
    private Solenoid solenoid;

    @objid ("3328d132-187e-4cc6-9d63-ce44b0ea9735")
    public void openFlap() 
    {
    	solenoid.set(true);
    }

    @objid ("6f534bc0-46ef-46f3-8a16-d55f5ffa98f2")
    public void closeFlap() 
    {
    	solenoid.set(false);
    }

    @objid ("606b5fbd-c3bf-4891-8766-319edb78bea8")
    @Override
    protected void initDefaultCommand()
    {
        // TODO Auto-generated method stub
    }

    @objid ("3ca51cff-918c-4555-93bf-a7c789eb3010")

    public GearGobbler() 
    {
    	solenoid = new Solenoid(Parameters.PneumaticChannel.GEAR_GOBBLER_FLAP.getChannel());
    }
}

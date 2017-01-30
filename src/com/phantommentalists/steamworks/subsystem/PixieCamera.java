package com.phantommentalists.steamworks.subsystem;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import com.phantommentalists.steamworks.VisionTarget;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

@objid ("437b9966-7b5f-40bb-9acf-3acf8e1547ed")
public class PixieCamera extends Subsystem {
    @objid ("6b77207f-a693-4fea-845b-572561a55f86")
    private SerialPort serialPort;

    @objid ("82433d0b-6d5e-45fd-a756-e3cc6fbc31b6")
    public PixieCamera() {
    }

    @objid ("43757b14-7a22-4b4a-ad72-3cf2f472f4f0")
    public int getFuelCount() {
        // TODO Auto-generated method stub
    	return 0;
    }

    @objid ("5067c774-bee7-4115-a637-5f46ea946936")
    public int getTapeCount() {
        // TODO Auto-generated method stub
    	return 0;
    }

    @objid ("24a00ca6-3bd3-4c9b-9730-83db53641e6a")
    public List<VisionTarget> getAllFuel() {
        // TODO Auto-generated method stub
    	return null;
    }

    @objid ("0c4c5356-d529-4076-bc11-5f437a1048c6")
    public List<VisionTarget> getAllTape() {
        // TODO Auto-generated method stub
    	return null;
    }

}

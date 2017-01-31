package com.phantommentalists.steamworks.subsystem;

import com.ctre.CANTalon;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for robot's shooter.
 * 
 * This class encapsulates all of the hardware that represents the shooter/infeed mechanism.  The same
 * mechanism can pickup fuel off the floor and store them in the robot's internal hopper, and extract
 * fuel from the hopper and shoot it into the boiler's high goal.
 */
@objid ("5b3b8d0c-a5f0-4e9a-801d-7122a1a4eaa9")
public class Shooter extends Subsystem {
    /**
     * Motor controller for wheel motor.  Shooter's wheel motor can be run forward to propel fuel
     * into the high goal and in reverse to direct fuel into the robot's fuel hopper.
     */
    @objid ("c89532f8-ad05-46f5-8c40-8834ab21f172")
    private final CANTalon wheelMotor;

    @objid ("39f50a55-9553-4bf4-8026-d40058cb7a83")
    private final CANTalon conveyorMotor;

    @objid ("abb1320d-1f8b-4314-99f3-3b7aecfb78d2")
    public void turnOnConveyor() {
    }

    @objid ("e600c4f6-8c96-4d44-a8ac-86765608dc1d")
    public void turnOffConveyor() {
    }

    @objid ("68e94877-afe1-4880-9814-1f35bbd1f035")
    public void turnOnShooterWheel() {
    }

    @objid ("40c04284-806b-48b3-b931-0b218d8e2495")
    public void turnOffShooterWheel() {
    }

    @objid ("ddc2d195-e75a-46c0-a585-628acfb8e660")
    public void turnOnLoaderWheel() {
    }

    @objid ("32229ab9-6b1e-4e5c-a7e2-2c2d2732d395")
    public void setShooterGatePosition() {
    }

    @objid ("9693c056-380d-4c68-ac14-4cd2b1e48dd2")
    public void setLoaderGatePosition() {
    }

    @objid ("ba8d49b7-1823-482d-bd89-e96e6ac9370c")
    public boolean isShooterUpToSpeed() {
        // TODO Auto-generated method stub
        return false;
    }

    @objid ("4d2905ae-6240-4a38-a21a-68aefe11c32f")
    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
    }

    @objid ("732b1b92-b601-477c-ab75-004c7e1b6814")
    public Shooter() {
    	wheelMotor = new CANTalon(0);
    	conveyorMotor = new CANTalon(0);
    }

}

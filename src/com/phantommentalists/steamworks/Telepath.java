package src.com.phantommentalists.steamworks;

import src.com.phantommentalists.steamworks.subsystem.Climber;
import src.com.phantommentalists.steamworks.subsystem.Drivetrain;
import src.com.phantommentalists.steamworks.subsystem.GearGobbler;
import src.com.phantommentalists.steamworks.subsystem.PixieCamera;
import src.com.phantommentalists.steamworks.subsystem.Shooter;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import edu.wpi.first.wpilibj.IterativeRobot;

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
    private PixieCamera pixieCamera;

    @objid ("0b53ecde-257f-466b-bcef-43fce4dbdc95")
    public void robotInit() {
    }

    @objid ("dab887d4-4871-4722-aa13-e9fed526eebe")
    public void autonomousInit() {
    }

    @objid ("198d6d2d-b717-47a0-9406-b8edadcc5497")
    public void teleopInit() {
    }

    @objid ("77311426-3d0c-409a-a086-2bc92e6e89bd")
    public void autonomousPeriodic() {
    }

    @objid ("87edd468-04be-4afb-8fa3-cb14e164c58d")
    public void teleopPeriodic() {
    }

    @objid ("d4573f62-3f85-40b0-94f2-673a79e3d9d8")
    public void startCompetition() {
    }

    @objid ("ca63651a-1b48-4fda-9a4d-649cf66bba2f")
    public void disableInit() {
    }

    @objid ("8777cba3-4287-482a-9b97-9e306b902160")
    public void robotPeriodic() {
    }

    @objid ("a343a83d-cc3b-43a0-979e-e09e44143476")
    public void disablePeriodic() {
    }

    @objid ("aed20313-389b-4a3c-b333-d763e6cd1572")
    public Telepath() {
    }

}

package src.com.phantommentalists.steamworks.command;

import src.com.phantommentalists.steamworks.subsystem.Shooter;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import edu.wpi.first.wpilibj.command.Command;

@objid ("b9e78b1e-efbd-443c-bb65-8d4f0dbbb737")
public class TurnOffShooterCommand extends Command {
	
	private Shooter shooter;
	
	public TurnOffShooterCommand(Shooter shooter) {
	}
	
    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void initialize() {
    }

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}

package src.com.phantommentalists.steamworks.command;

import src.com.phantommentalists.steamworks.subsystem.Shooter;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import edu.wpi.first.wpilibj.command.Command;

@objid ("10e4643d-7662-4b91-afd6-b09e93ce6467")
public class TurnOnLoaderCommand extends Command {
	
	private Shooter shooter;
	
	public TurnOnLoaderCommand(Shooter shooter) {
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

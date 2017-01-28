package com.phantommentalists.steamworks;

public class Parameters {

	public enum CanId {
		
		DRIVE_RIGHT_MASTER(12, false),
		DRIVE_RIGHT_FOLLOWER(21, false),
		DRIVE_LEFT_MASTER(13, false),
		DRIVE_LEFT_FOLLOWER(31, false),
		STEERING_LEFT_FRONT(41, false),
		STEERING_RIGHT_FRONT(42, false),
		STEERING_LEFT_REAR(43, false),
		STEERING_RIGHT_REAR(44, false),
		SHOOTER_WHEEL(51, false),
		SHOOTER_CONVEYOR(52, false),
		CLIMBER_MOTOR(61, false);
		
		
		private int canID;
		
		private boolean reversed;
		
		private CanId(int id, boolean rev) {
			canID = id;
			reversed = rev;
		}
		
		public int getId() {
			return canID;
		}
		
		public boolean isReversed() {
			return reversed;
		}
	}
	
	public enum SteeringOffset
	{
		LEFT_FRONT(0),
		LEFT_REAR(0),
		RIGHT_FRONT(0),
		RIGHT_REAR(0);
		
		private double offset;
		
		private SteeringOffset(double offset)
		{
			this.offset = offset;
		}
		
		public double getOffset()
		{
			return offset;
		}
	}
	
	public enum SideOfRobot {
		RIGHT,
		LEFT
	}
	
	public enum Buttons {
		
	}
	
	public enum PneumaticChannel {
		
	}
}

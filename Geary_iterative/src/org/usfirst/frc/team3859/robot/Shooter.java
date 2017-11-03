package org.usfirst.frc.team3859.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter {
	private CANTalon shootMotor1 = new CANTalon(6);
	private CANTalon shootMotor2 = new CANTalon(7);
	
	public enum shootState{
		SHOOT,
		DISABLE
		
	}
	
	public double speed() {
		return shootMotor1.getSpeed();
	}
	public void Set(shootState state, double shootSpeed) {
		
//		double shootSpeed = SmartDashboard.getNumber("Shooter Speed", 70);
		switch(state) {
		case SHOOT:
			shootMotor1.changeControlMode(CANTalon.TalonControlMode.Speed);
			shootMotor2.changeControlMode(CANTalon.TalonControlMode.Follower);
			shootMotor1.setProfile(0);
			shootMotor1.reverseSensor(true);
			shootMotor2.set(shootMotor1.getDeviceID());
			shootMotor1.set(shootSpeed);
			SmartDashboard.putNumber("Shooter Speed", shootMotor1.getSpeed());
			
		break;
		case DISABLE:
			shootMotor1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
			shootMotor2.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
			shootMotor1.set(0);
			shootMotor2.set(0);
		break;
		}
}
}

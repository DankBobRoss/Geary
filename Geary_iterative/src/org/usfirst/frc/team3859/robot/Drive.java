package org.usfirst.frc.team3859.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive {
	private DoubleSolenoid shifter = new DoubleSolenoid(1, 6, 7);
	public enum driveMode {
		LOWGEAR, HIGHGEAR, TEST
	}
//	public boolean isHigh = true;
//	public void setGear(boolean isHigh) {	
//		this.isHigh = isHigh;
//	}
//	public boolean getGear() {
//		
//		return isHigh;
//	}
	public void SetUp() {
		Storage.leftFront.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		Storage.rightFront.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		Storage.leftBack.changeControlMode(CANTalon.TalonControlMode.Follower);
		Storage.rightBack.changeControlMode(CANTalon.TalonControlMode.Follower);

		Storage.leftBack.set(Storage.leftFront.getDeviceID());
		Storage.rightBack.set(Storage.rightFront.getDeviceID());

	}

	public void Set(driveMode state) {
		SetUp();
		// Storage.rightFront.set(Storage.Xbox1.getY(Hand.kRight));
		// Storage.leftFront.set(Storage.Xbox1.getY(Hand.kLeft));
		switch (state) {
		case TEST:
			Storage.leftFront.set(.4);
			Storage.rightFront.set(.4);
			break;
		case LOWGEAR:
			shifter.set(DoubleSolenoid.Value.kReverse);
			Storage.leftFront.set(Storage.Xbox1.getY(Hand.kLeft));
			Storage.rightFront.set(Storage.Xbox1.getY(Hand.kRight));
			
			break;
		case HIGHGEAR:
			shifter.set(DoubleSolenoid.Value.kForward);
			Storage.leftFront.set(Storage.Xbox1.getY(Hand.kLeft));
			Storage.rightFront.set(Storage.Xbox1.getY(Hand.kRight));
			
			break;
		}
	}

	public void Move(double leftSpeed, double rightSpeed) {
		SetUp();
		Storage.leftFront.set(leftSpeed);
		Storage.rightFront.set(rightSpeed);
	}
}

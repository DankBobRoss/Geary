package org.usfirst.frc.team3859.robot;

import com.ctre.CANTalon;

public class Encoders {
	public void Set(double value) {
		double value_ = value;
		
		Storage.leftFront.changeControlMode(CANTalon.TalonControlMode.Position);
		Storage.leftFront.set(value_);

		Storage.rightFront.changeControlMode(CANTalon.TalonControlMode.Position);
		Storage.rightFront.set(value_);

	}
}

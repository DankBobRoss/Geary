package org.usfirst.frc.team3859.robot;

import com.ctre.CANTalon;

public class Climb {

	CANTalon climb1 = new CANTalon(12);
//	CANTalon climb2 = new CANTalon(12);

	private void setUp() {
		climb1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
//		climb2.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}

	enum climbMode {
		UP, DISABLE
	}

	public void Set(climbMode state, double speed) {

		switch (state) {
		case UP:
			setUp();
			climb1.set(speed);
//			climb2.set(speed);
			break;
		case DISABLE:
			setUp();
			climb1.set(0);
//			climb2.set(0);

			break;

		}

	}
}

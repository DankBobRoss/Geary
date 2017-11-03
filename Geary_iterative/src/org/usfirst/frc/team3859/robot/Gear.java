package org.usfirst.frc.team3859.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class Gear {
	private static Solenoid slide = new Solenoid(1,2);
	private static Solenoid shux = new Solenoid(2,0);
	private static DoubleSolenoid position = new DoubleSolenoid(1,0,1);
	 static CANTalon geary = new CANTalon(9);
	private static CANTalon left = new CANTalon(8);

	enum gearMode {
		HOLD, 
		SCORE, 
		INTAKE,
		DISABLE,
		BALLINTAKE
	}

	public void Set(gearMode state) {
		switch (state) {
		case HOLD:
			left.set(0);
			position.set(DoubleSolenoid.Value.kReverse);
			slide.set(true);
			geary.set(0);
			shux.set(false);
			break;
			
		case SCORE:
			left.set(0);
			position.set(DoubleSolenoid.Value.kForward);			
			geary.set(-1);
			slide.set(true);
			shux.set(false);
			break;
		case INTAKE:
			left.set(0);
			position.set(DoubleSolenoid.Value.kForward);			
			geary.set(1);
			slide.set(true);
			shux.set(false);
			break;
		case DISABLE:
			left.set(0);
			position.set(DoubleSolenoid.Value.kForward);			
			geary.set(0);
			slide.set(false);
			shux.set(true);
			break;
		case BALLINTAKE:
			left.set(1);
			position.set(DoubleSolenoid.Value.kReverse);			
			geary.set(0);
			slide.set(true);
			shux.set(false);
		break;
		}
	}
}

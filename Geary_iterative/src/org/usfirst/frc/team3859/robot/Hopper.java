package org.usfirst.frc.team3859.robot;

import com.ctre.CANTalon;
public class Hopper {
	private CANTalon hopperMotor = new CANTalon(15);
    enum HopperStates{
		ON,
		OFF,
		UNJAM
	}
	
	public double speed() {
		return hopperMotor.get();
	}
	public void set(HopperStates state, double hopperSpeed) {
		
//		double hopperSpeed = SmartDashboard.getNumber("Hopper Speed", .5);
		switch(state) {
		
		case ON:
			hopperMotor.set(hopperSpeed);
			
		break;
		
		case OFF:
			hopperMotor.set(0);
		break;
		case UNJAM:
			hopperMotor.set(-hopperSpeed);
			
		break;
		
		
		
		
		}
		
		
	}
}

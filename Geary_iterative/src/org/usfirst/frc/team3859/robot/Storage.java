package org.usfirst.frc.team3859.robot;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Solenoid;

public class Storage {
	static final CANTalon leftFront = new CANTalon(2);
	static final CANTalon leftBack = new CANTalon(1);
	static final CANTalon rightFront = new CANTalon(5);
	static final CANTalon rightBack = new CANTalon(4);
//	static Joystick Xbox1 = new Joystick(0);
//	static Joystick Xbox2 = new Joystick(1);
	static XboxController Xbox1 = new XboxController(0);
	static XboxController Xbox2 = new XboxController(1);
}

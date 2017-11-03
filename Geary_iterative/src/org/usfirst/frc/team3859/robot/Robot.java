package org.usfirst.frc.team3859.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	Auto auto = new Auto();
	SendableChooser choose = new SendableChooser();

	@Override
	public void robotInit() {
		SmartDashboard.putNumber("automode", 0);
		CameraServer.getInstance().startAutomaticCapture(0);
		CameraServer.getInstance().startAutomaticCapture(1);

	}

	@Override
	public void autonomousInit() {
		// auto.auto
	}

	@Override
	public void autonomousPeriodic() {
		
		SmartDashboard.putNumber("Auto Current Order", 1);
		SmartDashboard.putBoolean("init", auto.init);
		SmartDashboard.putNumber("Timer", auto.autoTimer.get());
		// auto.autoMode = SmartDashboard.getString("Auto Mode", "Test");

		// auto.oi.driver.SetUp();

		// auto.autoSet();

		// RED:

		// auto.shoot(7, 160, 1);
		// auto.drive(1, .45, 2);
		// auto.rightTurn(2.1, .8, 3);
		// auto.drive(2, .45, 4);

		// BLUe
		auto.shoot(7, 160, 1);
		auto.drive(1, -.45, 2);
		auto.rightTurn(1.4, .9, 3);
		auto.drive(2, -.35, 4);
		
		// NOTHING

		// CROSS
		// auto.oi.geary.Set(Gear.gearMode.HOLD);
		// auto.drive(1, .7, 1);
		// CENTERPEG
		// auto.oi.geary.Set(Gear.gearMode.HOLD);
		// auto.drive(2, .7, 1);

		// auto.shoot(2, 70, 2);
		// autoMode = SmartDashboard.getString("Auto Mode", "Test");
	}

	@Override
	public void teleopPeriodic() {
		auto.oi.Enable();
		SmartDashboard.putNumber("Left Front Drive", Storage.leftFront.getOutputCurrent());
		SmartDashboard.putNumber("Right Front Drive", Storage.rightFront.getOutputCurrent());
		SmartDashboard.putNumber("Left Back Drive", Storage.leftBack.getOutputCurrent());
		SmartDashboard.putNumber("Right Back Drive", Storage.rightBack.getOutputCurrent());

	}

	@Override
	public void testPeriodic() {

	}

}


package org.usfirst.frc.team3859.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class OI {
	Gear geary = new Gear();
	Drive driver = new Drive();
	Shooter shoot = new Shooter();
	Hopper hopper = new Hopper();
	Climb climb = new Climb();
	Encoders encode = new Encoders();

	public void Enable() {
		driver.Set(Drive.driveMode.HIGHGEAR);
		// if (Storage.Xbox1.getBumper(Hand.kLeft) && driver.getGear() == true) {
		// driver.setGear(false);
		// if (driver.getGear() == true) {
		// driver.Set(Drive.driveMode.HIGHGEAR);
		// }else if(driver.getGear() == false) {
		// driver.Set(Drive.driveMode.LOWGEAR);
		// }
		// }else {
		// driver.setGear(true);
		// if (driver.getGear() == true) {
		// driver.Set(Drive.driveMode.HIGHGEAR);
		// }else if(driver.getGear() == false) {
		// driver.Set(Drive.driveMode.LOWGEAR);
		// }
		//
		// }
		if (Storage.Xbox1.getTriggerAxis(Hand.kRight) > .6) {
			shoot.Set(Shooter.shootState.SHOOT, 160);
			if (shoot.speed() >= 160) {
				hopper.set(Hopper.HopperStates.ON,.5);
			}
		} else if (Storage.Xbox1.getBumper(Hand.kLeft) == true) {
			hopper.set(Hopper.HopperStates.UNJAM,.4);
		} else {
			shoot.Set(Shooter.shootState.DISABLE, 0);
			hopper.set(Hopper.HopperStates.OFF,0);
		}

		// if (Storage.Xbox2.getTriggerAxis(Hand.kLeft) >= .4) {
		// geary.Set(Gear.gearMode.BALLINTAKE);
		// } else {
		// geary.Set(Gear.gearMode.HOLD);
		// }

		if (Storage.Xbox2.getBumper(Hand.kRight) == true) {
			climb.Set(Climb.climbMode.UP, Storage.Xbox2.getY(Hand.kLeft));
			// shoot.Set(Shooter.shootState.DISABLE, 0);
			// geary.Set(Gear.gearMode.DISABLE);
		} else {
			climb.Set(Climb.climbMode.DISABLE, 0);
		}

		// if (Storage.Xbox2.getTriggerAxis(Hand.kRight) > .3 &&
		// Storage.Xbox2.getTriggerAxis(Hand.kRight) < .5) {
		// geary.Set(Gear.gearMode.IN_OFF);
		// }else {
		// geary.Set(Gear.gearMode.HOLD);
		//

		// }
		// if (Storage.Xbox2.getTriggerAxis(Hand.kRight) > .5) {
		// geary.Set(Gear.gearMode.IN_OFF);
		// }
		if (Storage.Xbox2.getTriggerAxis(Hand.kRight) > .51) {
			geary.Set(Gear.gearMode.INTAKE);
		} else if (Storage.Xbox2.getBumper(Hand.kLeft)) {
			geary.Set(Gear.gearMode.SCORE);
		} else if (Storage.Xbox2.getTriggerAxis(Hand.kLeft) >= .4) {
			geary.Set(Gear.gearMode.BALLINTAKE);
		} else if (Storage.Xbox2.getAButton() == true) {
			geary.Set(Gear.gearMode.DISABLE);
		} else {
			geary.Set(Gear.gearMode.HOLD);
		}

	}
}

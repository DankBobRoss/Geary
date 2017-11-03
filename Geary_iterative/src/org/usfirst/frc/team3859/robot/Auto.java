package org.usfirst.frc.team3859.robot;

import edu.wpi.first.wpilibj.Timer;
//
//package org.usfirst.frc.team3859.robot;
//
//import edu.wpi.first.wpilibj.Timer;
//
//public class Auto {
//
//	OI oi = new OI();
//	Timer AutoTimer = new Timer();
//	int i = 0;
//
//	enum autoMode {
//		CROSS, CPEG, RPEG, LPEG;
//	}
//
//	public void Set(autoMode mode) {
//		boolean initialize = false;
// ,]]]]]]]]]]]]]]]]]]]]]]]]]]]]'''''''''''''''''''''''''
//
//		System.out.print(AutoTimer.get());
////		switch (mode) {
////		case CROSS:
////			if (initialize == false) {
////				AutoTimer.reset();
////				 
////				initialize = true;
////			}
////			if (AutoTimer.get() < 1) {
////				Storage.leftFront.set(-.425);
////				Storage.rightFront.set(-.425);
////			}else {
////				Storage.leftFront.set(0);
////				Storage.rightFront.set(0);
////			}
////
////			break;
//		
//		switch (mode) {
//		case CROSS:
//			if (initialize == false) {
//				AutoTimer.reset();
//				 
//				initialize = true;
//			}
//			if (i <= 50) {
////				Storage.leftFront.set(-.425);
////				Storage.rightFront.set(-.425);
//				oi.gearControl.geary.set(.5);
//			}else if(i > 60 && i < 100) {
//				oi.gearControl.geary.set(-.5);	
//			}else {
//				oi.gearControl.geary.set(0);
//				
//			}
//
//			break;
//		}
//		
//		i++;
//	}
//}import java.util.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auto {

	Timer autoTimer = new Timer();
	OI oi = new OI();
	boolean init = false;
	double order_ = 1;
	public int  autoMode;

	public void drive(double time, double speed, double order) {
		// oi.driver.SetUp();
		if (init == false) {
			if (order_ == 1.0) {
				autoTimer.start();
			}
			autoTimer.reset();
			init = true;
		}

		// SmartDashboard.putNumber("Auto Time", autoTimer.get());
		if (order == order_) {
			if (autoTimer.get() <= time) {
				Storage.leftFront.set(-speed);
				Storage.rightFront.set(-speed);
			} else {
				Storage.leftFront.set(0);
				Storage.rightFront.set(0);
				order_++;
				init = false;
				// SmartDashboard.putNumber("Auto Current Order", order);
			}
		}
	}

	public void shoot(double time, double speed, double order) {
		if (init == false) {
			if (order == 1) {
				autoTimer.start();
			}
			autoTimer.reset();
			init = true;
		}
		if (order == order_) {
			if (autoTimer.get() < time) {
				oi.shoot.Set(Shooter.shootState.SHOOT, speed);
				if (oi.shoot.speed() >= 158) {
					oi.hopper.set(Hopper.HopperStates.ON, .5);
				}
			} else if (autoTimer.get() >= time) {
				oi.shoot.Set(Shooter.shootState.DISABLE, 0);
				oi.hopper.set(Hopper.HopperStates.OFF, 0);
				order_++;
				init = false;
				// SmartDashboard.putNumber("Auto Current Order", order);
			}
		}
	}

	public void leftTurn(double time, double speed, int order) {
		if (init == false) {
			if (order_ == 1) {
				autoTimer.start();
			}
			autoTimer.reset();
			init = true;
		}
		if (order == order_) {
			if (autoTimer.get() < time) {
				Storage.leftFront.set(speed);
				Storage.rightFront.set(-speed);

			} else if (autoTimer.get() >= time) {
				Storage.leftFront.set(0);
				Storage.rightFront.set(0);
				order_++;
				init = false;
				// SmartDashboard.putNumber("Auto Current Order", order);
			}
		}
	}

	public void rightTurn(double time, double speed, double order) {
		if (init == false) {
			if (order_ == 1) {
				autoTimer.start();
			}
			autoTimer.reset();
			init = true;
		}
		if (order == order_) {
			if (autoTimer.get() < time) {
				// Storage.leftFront.set(-speed);
				Storage.rightFront.set(speed);
			} else if (autoTimer.get() >= time) {
				Storage.leftFront.set(0);
				Storage.rightFront.set(0);
				order_++;
				init = false;
				// SmartDashboard.putNumber("Auto Current Order", order);
			}
		}
	}

	public void nothing(double time, double order) {
		if (init == false) {
			if (order_ == 1) {
				autoTimer.start();
			}
			autoTimer.reset();
			init = true;
		}
		if (order == order_) {
			if (autoTimer.get() < time) {

			} else if (autoTimer.get() >= time) {
				order_++;
				init = false;
				// SmartDashboard.putNumber("Auto Current Order", order);
			}
		}
	}

	// public String autoMode = "Test";
	// CANTalon geary = new CANTalon(9);

	boolean init1 = false;

	/**
	 * Input mode first and the value after, for turn it is how long to turn then 0.
	 * For Forward it is how long to go forward and how fast. And For shoot it is
	 * how long to shoot and how fast.
	 * 
	 * @param autoMode
	 */
	public void autoSet() {
			 autoMode = (int) SmartDashboard.getNumber("automode", 0);

		// if(RobotState.isEnabled() && RobotState.isAutonomous()) {
		switch (autoMode) {
		case 1:
			// REDSHOOTCROSS
			// shot forward right forward
			shoot(7, 160, 1);
			drive(.6, .45, 2);
			rightTurn(1, .45, 3);
			drive(1.5, .45, 4);

			break;

		case 2:
			// BLUESHOOTCROSS
			// shoot back right back
			shoot(7, 160, 1);
			drive(1, -.45, 2);
			rightTurn(1.25, .45, 3);
			drive(1.5, -.45, 4);
			// autoStates(choice1.SHOOT, 7, 160, choice2.BACKWARD, .3, .5, choice3.T_LEFT,
			// 2, .4, choice4.FORWARD, 4, .6);

			break;

		case 3:
			// SHOOT
			// autoStates(choice1.SHOOT, 8, 160, choice2.NOTHING, 0, 0, choice3.NOTHING, 0,
			// 0, choice4.NOTHING, 0, 0);
			shoot(7, 160, 1);

			break;

		case 4:
			// CROSS:
			// autoStates(choice1.SHOOT, 7, 160, choice2.BACKWARD, .3, .5, choice3.T_LEFT,
			// 2, .4, choice4.FORWARD, 4,.6);
			// autoStates(choice1.FORWARD, 5, .5, choice2.NOTHING, 0, 0, choice3.NOTHING, 0,
			// 0, choice4.NOTHING, 0, 0);
			drive(2.2, .5, 1);

			break;
		case 5:
			// NOTHING
			// autoStates(choice1.NOTHING, 0, 0, choice2.NOTHING, 0, 0, choice3.NOTHING, 0,
			// 0, choice4.NOTHING, 0, 0);
			nothing(15, 1);

			break;
		}
	}
}

// /**
// * Enter how long to shoot and how fast. Enter which way and how long to turn.
// * Enter how long to go forward
// */
// public void shootCross(double shootT, double shootv, direction Direction,
// double turnT, double fort, double forv) {
// boolean init = false;
// int phase = 1;
// switch (phase) {
// case 1:
// if (init == false) {
// autoTimer.reset();
//
// init = true;
// }
// if (autoTimer.get() < shootT) {
// oi.shoot.Set(Shooter.shootState.SHOOT, shootv);
// } else if (autoTimer.get() > shootT) {
// oi.shoot.Set(Shooter.shootState.DISABLE, 0);
// phase = 2;
// }
// break;
// case 2:
// autoTimer.reset();
//
// switch (Direction) {
// case LEFT:
// if (autoTimer.get() < turnT) {
// Storage.leftFront.set(-.4);
// Storage.rightFront.set(.4);
// } else if (autoTimer.get() >= turnT) {
// Storage.leftFront.set(0);
// Storage.rightFront.set(0);
// phase = 3;
// }
// break;
// case RIGHT:
// if (autoTimer.get() < turnT) {
// Storage.leftFront.set(.4);
// Storage.rightFront.set(-.4);
// } else if (autoTimer.get() >= turnT) {
// Storage.leftFront.set(0);
// Storage.rightFront.set(0);
// phase = 3;
// }
// break;
//
// }
// break;
// case 3:
// autoTimer.reset();
//
// int buffer = 1;
// if (autoTimer.get() >= buffer) {
// if (autoTimer.get() < fort) {
// Storage.leftFront.set(forv);
// Storage.rightFront.set(forv);
// } else if (autoTimer.get() >= fort) {
// Storage.leftFront.set(0);
// Storage.rightFront.set(0);
// }
// }
// break;
// }
//
// }

// public void Set(automode mode) {
//
// Timer AutoTimer = new Timer();
// boolean initialize;
// switch (mode) {
// case CROSS:
// state.oi.encode.Set(10);
// break;
// // case CPEG:
// // reset.timer();
// // drive.Move(.5, .5);
// // gear.Set(SCORE);
// //
// //
// //
// // break;
// //
// // case RPEG:
// //
// // if (initialize == false) {
// // AutoTimer.reset();
// //
// // initialize = true;
// // }
// // if (AutoTimer.Get() < 2) {
// // Map::LeftFront.Set(-.425);
// // Map::RightFront.Set(-.425);
// // }
// // if (AutoTimer.Get() > 2) {
// // Map::LeftFront.Set(0);
// // Map::RightFront.Set(0);
// // }
// //
// // break;
// //
// // case LPEG:
// // reset.timer();
// // drive.Move(.5, .5);
// // drive.Move(-.5, .5);
// // drive.Move(.5, .5);
// // gear.Set(SCORE);
// //
// // break;
// //
//
// }
// }

//package org.usfirst.frc.team3859.robot;
//
//import edu.wpi.first.wpilibj.Timer;
//
//public class AutoStates {
//	enum choice1 {
//		T_LEFT, T_RIGHT, FORWARD, BACKWARD, SHOOT;
//	}
//
//	enum choice2 {
//		T_LEFT, T_RIGHT, FORWARD, BACKWARD, SHOOT;
//	}
//
//	enum choice3 {
//		T_LEFT, T_RIGHT, FORWARD, BACKWARD, SHOOT;
//	}
//
//	enum choice4 {
//		T_LEFT, T_RIGHT, FORWARD, BACKWARD, SHOOT;
//	}
//
//	OI oi = new OI();
//	Timer autoTimer = new Timer();
//
//	public void autoStates(choice1 choice1, double time1, double value1, choice2 choice2, double time2, double value2,
//			choice3 choice3, double time3, double value3, choice4 choice4, double time4, double value4) {
//
//		switch (choice1) {
//
//		case T_LEFT:
//			boolean init1 = false;
//			if (init1 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(-value1);
//					Storage.rightFront.set(value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case T_RIGHT:
//			boolean init2 = false;
//			if (init2 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(value1);
//					Storage.rightFront.set(-value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case FORWARD:
//			boolean init3 = false;
//			if (init3 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(value1);
//					Storage.rightFront.set(value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case BACKWARD:
//			boolean init4 = false;
//			if (init4 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(-value1);
//					Storage.rightFront.set(-value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case SHOOT:
//			boolean init5 = false;
//			if (init5 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() < time1) {
//				oi.shoot.Set(Shooter.shootState.SHOOT, value1);
//			} else if (autoTimer.get() > time1) {
//				oi.shoot.Set(Shooter.shootState.DISABLE, 0);
//			}
//
//			break;
//		}
//
//		switch (choice2) {
//
//		case T_LEFT:
//			boolean init1 = false;
//			if (init1 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(-value1);
//					Storage.rightFront.set(value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case T_RIGHT:
//			boolean init2 = false;
//			if (init2 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(value1);
//					Storage.rightFront.set(-value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case FORWARD:
//			boolean init3 = false;
//			if (init3 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(value1);
//					Storage.rightFront.set(value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case BACKWARD:
//			boolean init4 = false;
//			if (init4 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(-value1);
//					Storage.rightFront.set(-value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case SHOOT:
//			boolean init5 = false;
//			if (init5 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() < time1) {
//				oi.shoot.Set(Shooter.shootState.SHOOT, .51);
//			} else if (autoTimer.get() > time1) {
//				oi.shoot.Set(Shooter.shootState.DISABLE, 0);
//			}
//
//			break;
//		}
//
//		switch (choice3) {
//
//		case T_LEFT:
//			boolean init1 = false;
//			if (init1 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(-value1);
//					Storage.rightFront.set(value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case T_RIGHT:
//			boolean init2 = false;
//			if (init2 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(value1);
//					Storage.rightFront.set(-value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case FORWARD:
//			boolean init3 = false;
//			if (init3 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(value1);
//					Storage.rightFront.set(value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case BACKWARD:
//			boolean init4 = false;
//			if (init4 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(-value1);
//					Storage.rightFront.set(-value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case SHOOT:
//			boolean init5 = false;
//			if (init5 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() < time1) {
//				oi.shoot.Set(Shooter.shootState.SHOOT, .51);
//			} else if (autoTimer.get() > time1) {
//				oi.shoot.Set(Shooter.shootState.DISABLE, 0);
//			}
//
//			break;
//		}
//
//		switch (choice4) {
//
//		case T_LEFT:
//			boolean init1 = false;
//			if (init1 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(-value1);
//					Storage.rightFront.set(value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case T_RIGHT:
//			boolean init2 = false;
//			if (init2 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(value1);
//					Storage.rightFront.set(-value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case FORWARD:
//			boolean init3 = false;
//			if (init3 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(value1);
//					Storage.rightFront.set(value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case BACKWARD:
//			boolean init4 = false;
//			if (init4 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() > .3) {
//				if (autoTimer.get() < time1 + .3) {
//					Storage.leftFront.set(-value1);
//					Storage.rightFront.set(-value1);
//				} else if (autoTimer.get() > time1 + .3) {
//					Storage.leftFront.set(0);
//					Storage.rightFront.set(0);
//				}
//			}
//
//			break;
//
//		case SHOOT:
//			boolean init5 = false;
//			if (init5 == false) {
//				autoTimer.reset();
//				autoTimer.start();
//			}
//			if (autoTimer.get() < time1) {
//				oi.shoot.Set(Shooter.shootState.SHOOT, .51);
//			} else if (autoTimer.get() > time1) {
//				oi.shoot.Set(Shooter.shootState.DISABLE, 0);
//			}
//
//			break;
//		}
//
//	}
//}

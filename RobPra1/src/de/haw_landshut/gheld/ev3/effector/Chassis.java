package de.haw_landshut.gheld.ev3.effector;

import de.haw_landshut.gheld.ev3.common.Wish;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Chassis extends Effector {

	final RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
	final RegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);

	@Override
	public void accept(Wish command) {
		if (command == Wish.FORWARD) {
			motorA.forward();
			motorD.forward();
		} else if (command == Wish.STOP) {
			motorA.stop();
			motorD.stop();
		} else if (command == Wish.BACKWARD) {
			motorA.backward();
			motorD.backward();
		} else if (command == Wish.TURNRIGHT) {
			motorA.stop();
			motorD.forward();
		} else if (command == Wish.TURNLEFT) {
			motorA.forward();
			motorD.stop();
		} else if (command == Wish.ROTATECW) {
			motorA.backward();
			motorD.forward();
		} else if (command == Wish.ROTATECCW) {
			motorA.forward();
			motorD.backward();
		}
	}
}

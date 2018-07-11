package de.haw_landshut.gheld.ev3.effector;

import de.haw_landshut.gheld.ev3.common.Wish;
import lejos.hardware.Button;

class Lamp extends Effector {

	@Override
	public void accept(Wish command) {
		switch (command) {
		case LEDGREEN:
			Button.LEDPattern(1);
			break;
		case LEDORANGE:
			Button.LEDPattern(3);
			break;
		case LEDRED:
			Button.LEDPattern(5);
			break;
		case LEDOFF:
			Button.LEDPattern(0);
			break;
		default: // not my command
			break;
		}
	}
}
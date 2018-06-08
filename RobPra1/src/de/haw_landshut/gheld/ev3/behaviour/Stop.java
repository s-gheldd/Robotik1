package de.haw_landshut.gheld.ev3.behaviour;

import de.haw_landshut.gheld.ev3.arbitrator.Arbitrator;
import de.haw_landshut.gheld.ev3.common.Reading;
import de.haw_landshut.gheld.ev3.common.Wish;
import lejos.hardware.Button;

public class Stop extends Behavior {

	public Stop(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Button);
	}

	@Override
	public void run() {
		while (getReadingValue() != Button.ID_DOWN)
			;
		sendWish(Wish.STOP);
		sendWish(Wish.LEDOFF);
	}
}
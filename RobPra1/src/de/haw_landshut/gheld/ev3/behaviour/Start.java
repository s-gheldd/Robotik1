package de.haw_landshut.gheld.ev3.behaviour;

import de.haw_landshut.gheld.ev3.arbitrator.Arbitrator;
import de.haw_landshut.gheld.ev3.common.Reading;
import de.haw_landshut.gheld.ev3.common.Wish;
import lejos.hardware.Button;

public class Start extends Behavior {

	public Start(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Button);
	}

	@Override
	public void run() {
		sendWish(Wish.LEDORANGE);
		while(getReadingValue() != Button.ID_ENTER) {
			sendWish(Wish.LEDORANGE);
		}
		sendWish(Wish.NOTHING);
	}
	
}

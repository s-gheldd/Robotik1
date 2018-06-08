package de.haw_landshut.gheld.ev3.behaviour;

import de.haw_landshut.gheld.ev3.arbitrator.Arbitrator;
import de.haw_landshut.gheld.ev3.common.Reading;
import lejos.hardware.Button;

public class Killer extends Behavior {

	public Killer(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Button);
		setDaemon(false);
	}

	@Override
	public void run() {
		while (getReadingValue() != Button.ID_ESCAPE)
			;

	}
}
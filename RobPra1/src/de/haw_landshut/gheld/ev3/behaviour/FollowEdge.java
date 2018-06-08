package de.haw_landshut.gheld.ev3.behaviour;

import de.haw_landshut.gheld.ev3.arbitrator.Arbitrator;
import de.haw_landshut.gheld.ev3.common.Reading;
import de.haw_landshut.gheld.ev3.common.Wish;
import lejos.utility.Delay;

public class FollowEdge extends Behavior {

	public FollowEdge(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Ultrasonic);
	}

	@Override
	public void run() {
		int rv = getReadingValue();
		while (true){
			if (rv == 0) {
				sendWish(Wish.TURNLEFT);
				Delay.msDelay(100);
			} else if(rv == 1) {
				sendWish(Wish.FORWARD);
				Delay.msDelay(900);
			} else if(rv == 2) {
				sendWish(Wish.TURNRIGHT);
				Delay.msDelay(100);
			} else if(rv == 3) {
				sendWish(Wish.FORWARD);
				Delay.msDelay(900);
			}
			rv = getReadingValue();
		}
	}

}

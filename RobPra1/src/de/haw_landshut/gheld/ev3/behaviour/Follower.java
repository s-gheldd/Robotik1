package de.haw_landshut.gheld.ev3.behaviour;

import de.haw_landshut.gheld.ev3.arbitrator.Arbitrator;
import de.haw_landshut.gheld.ev3.common.Reading;
import de.haw_landshut.gheld.ev3.common.Wish;
import lejos.utility.Delay;

public class Follower extends Behavior {

	public Follower(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Brightness);
	}

	@Override
	public void run() {
		while(true){
			sendWish(Wish.LEDGREEN);
			final int lightValue = getReadingValue();
			
			if (lightValue < 20) {
				sendWish(Wish.TURNLEFT);
			} else {
				sendWish(Wish.TURNRIGHT);
			}
			
			//Delay.msDelay(10);
		}
	}
	
	/*class Calibrator {
		void watchLight(int millis) {
			
		}
	}*/

}

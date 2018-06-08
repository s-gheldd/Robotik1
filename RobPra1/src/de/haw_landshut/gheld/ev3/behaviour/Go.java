package de.haw_landshut.gheld.ev3.behaviour;

import de.haw_landshut.gheld.ev3.arbitrator.Arbitrator;
import de.haw_landshut.gheld.ev3.common.Reading;
import de.haw_landshut.gheld.ev3.common.Wish;
import lejos.hardware.Button;

public class Go extends Behavior
{

 public Go(Arbitrator arbitrator, int priority) {
     super(arbitrator, priority, Reading.Button);
 }
   @Override
    public void run()
    {
       	int button = getReadingValue();
        while (button != Button.ID_ENTER) {
            System.out.println("Go got:" + button );
            button = getReadingValue();
        }

	sendWish(Wish.FORWARD);
    }
}
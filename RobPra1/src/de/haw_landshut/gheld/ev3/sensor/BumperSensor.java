package de.haw_landshut.gheld.ev3.sensor;

import de.haw_landshut.gheld.ev3.behaviour.Behavior;
import de.haw_landshut.gheld.ev3.common.Reading;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class BumperSensor extends SubSensor {

	private final EV3TouchSensor right;
	private final EV3TouchSensor left;

	public BumperSensor(Behavior[] behaviors) {
		super(behaviors, Reading.Bumper);

		this.right = new EV3TouchSensor(SensorPort.S1);
		this.left = new EV3TouchSensor(SensorPort.S4);
	}

	public void run() {
		final SampleProvider rightProvider = right.getMode("Touch");
		final SampleProvider leftProvider = left.getMode("Touch");

		float pressedLeft = 0;
		float pressedRight = 0;

		float sampleLeft[] = new float[leftProvider.sampleSize()];
		float sampleRight[] = new float[rightProvider.sampleSize()];

		while (true) {
			Delay.msDelay(10);
			leftProvider.fetchSample(sampleLeft, 0);
			rightProvider.fetchSample(sampleRight, 0);

			pressedLeft = sampleLeft[0];
			pressedRight = sampleRight[0];

			if (pressedLeft != 0 || pressedRight != 0) {
				System.out.println("Bumper left:" + pressedLeft + " right:" + pressedRight);
				send(1);
			} else {
				send(0);
			}
		}
	}
}

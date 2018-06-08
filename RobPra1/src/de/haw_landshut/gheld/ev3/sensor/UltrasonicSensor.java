package de.haw_landshut.gheld.ev3.sensor;

import de.haw_landshut.gheld.ev3.behaviour.Behavior;
import de.haw_landshut.gheld.ev3.common.Reading;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class UltrasonicSensor extends SubSensor {

	private final EV3UltrasonicSensor sensor;
	
	public UltrasonicSensor(Behavior[] behaviors) {
		super(behaviors, Reading.Ultrasonic);
		sensor = new EV3UltrasonicSensor(SensorPort.S3);
	}
	
	public void run() {
		final SampleProvider sampleProvider = sensor.getMode("Distance");
		final float[] sample = new float[sampleProvider.sampleSize()];
		
		// Korridor Definition
		final float middle = 0.20F;
		final float outer = 0.40F;
		
		while(true) {
			sampleProvider.fetchSample(sample, 0);
			Delay.msDelay(30);
			System.out.println("ultrasonic: "+sample[0]);
			if(sample[0] <= middle) {
				send(0);
			} else if(sample[0] <= outer) {
				send(1);
			} else if(!Float.isInfinite(sample[0])) {
				send(2);
			} else {
				send(3);
			}
		}
	}


}

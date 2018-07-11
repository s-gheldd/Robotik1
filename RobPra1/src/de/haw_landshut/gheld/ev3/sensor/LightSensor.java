package de.haw_landshut.gheld.ev3.sensor;

import de.haw_landshut.gheld.ev3.behaviour.Behavior;
import de.haw_landshut.gheld.ev3.common.Reading;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class LightSensor extends SubSensor {

	final EV3ColorSensor colorSensor;
	public LightSensor(Behavior[] behaviors) {
		super(behaviors, Reading.Brightness);
		colorSensor = new EV3ColorSensor(SensorPort.S2);
	}
	
	
	public void run() {
		final SampleProvider light = colorSensor.getRedMode();
		final float[] sample = new float [colorSensor.sampleSize()];
		
		while (true) {
			light.fetchSample(sample, 0);
			final float value = sample[0];
			
			send((int) (value * 100));
			Delay.msDelay(10);
		}
	}
}

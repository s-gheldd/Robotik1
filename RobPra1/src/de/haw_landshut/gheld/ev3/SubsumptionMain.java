package de.haw_landshut.gheld.ev3;

import de.haw_landshut.gheld.ev3.arbitrator.Arbitrator;
import de.haw_landshut.gheld.ev3.behaviour.Behavior;
import de.haw_landshut.gheld.ev3.effector.Effector;
import de.haw_landshut.gheld.ev3.sensor.SubSensor;

public class SubsumptionMain {
	public static void main(String... args) {
		Effector[] effectors = { Effector.make("Lamp"), Effector.make("Chassis") };
		Arbitrator arbitrator = new Arbitrator(effectors);

		// Array aller Verhalten
		// jedes Mal, wenn man eine Priority verwendet hat, hochzählen
		// fuer das nächste Verhalten.

		int priority = 1;
		Behavior[] behaviors = { 
				//Behavior.make("Go", arbitrator, priority++),
				//Behavior.make("Blink", arbitrator, priority++),
				Behavior.make("FollowEdge", arbitrator, priority++),
				Behavior.make("BumperHitBackAndTurnRight", arbitrator, priority++),
				Behavior.make("Follower", arbitrator, priority++),
				Behavior.make("Stop", arbitrator, priority++),
				Behavior.make("Killer", arbitrator, priority++),
				Behavior.make("Start", arbitrator, priority++)
				};

		// Konkrete Sensoren wie hier ButtonSensor erzeugen
		SubSensor[] sensors = {
				SubSensor.make("ButtonSensor", behaviors),
				SubSensor.make("BumperSensor", behaviors),
				SubSensor.make("UltrasonicSensor", behaviors),
				SubSensor.make("LightSensor", behaviors)};

		// Starten aller Threads
		for (Behavior behavior : behaviors)
			behavior.start();
		for (SubSensor sensor : sensors)
			sensor.start();
	}
}
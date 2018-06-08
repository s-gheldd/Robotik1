package de.haw_landshut.gheld.ev3.effector;

import de.haw_landshut.gheld.ev3.common.Wish;

public abstract class Effector {
	public abstract void accept(Wish command);

	public static Effector make(String typeName) {
		switch (typeName) {
		case "Lamp":
			return new Lamp();
		case "Chassis":
			return new Chassis();
		default:
			throw new IllegalArgumentException("falscher Effektor");
		}
	}
}

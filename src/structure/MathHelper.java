package structure;

import java.util.Random;

public class MathHelper {
	public static Random rand = new Random();

	public static int plusOrMinus(int amount) {
		return (rand.nextBoolean() ? 1 : -1) * (1 + rand.nextInt(amount));
	}

	public static int constrain(int num, int min, int max) {
		return Math.min(Math.max(num, min), max);
	}

	// Y = (X-A)/(B-A) * (D-C) + C, thank you StackOverflow!
	// http://stackoverflow.com/questions/345187/math-mapping-numbers
	public static double map(double num, double fromMin, double fromMax, double toMin, double toMax) {
		return (num - fromMin) / (fromMax - fromMin) * (toMax - toMin) + toMin;
	}

	public static void main(String[] args) {
		System.out.println(map(5.8, 2, 6, 10, 70) + " " + map(map(5.8, 2, 6, 10, 70), 10, 70, 2, 6));
	}
}

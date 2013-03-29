package structure;

import java.util.Random;

public class MathHelper {
	public static Random rand = new Random();

	public static int plusOrMinus(int amount) {
		return (rand.nextBoolean() ? 1 : -1) * (1 + rand.nextInt(amount));
	}
}

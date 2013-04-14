package mathResources;

import static structure.GlobalConstants.log;

import interfaces.IDataHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import structure.DataNode;

public class MathHelper {
	public static Random rand = new Random();

	/**
	 * @param amount
	 * @return Return {-1, 1} * amount
	 */
	public static int plusOrMinus(int amount) {
		return (rand.nextBoolean() ? 1 : -1) * (1 + rand.nextInt(amount));
	}

	/**
	 * Constrain a number between two other numbers.
	 * 
	 * @example A[] = {1,2,3,2,5,6,3,7,1} <br />
	 *          constrain on A <br />
	 *          min:2 <br />
	 *          max:4 <br />
	 *          yields: {2,2,3,2,4,4,3,4,2}
	 * @param num
	 * @param min
	 * @param max
	 * @return
	 */
	public static int constrain(int num, int min, int max) {
		return Math.min(Math.max(num, min), max);
	}

	/**
	 * Map a value from one number space to another number space.<br />
	 * <br />
	 * Y = (X-A)/(B-A) * (D-C) + C, thank you StackOverflow!<br />
	 * http://stackoverflow.com/questions/345187/math-mapping-numbers
	 * 
	 * @param num
	 * @param fromMin
	 * @param fromMax
	 * @param toMin
	 * @param toMax
	 * @return
	 */
	public static double map(double num, double fromMin, double fromMax, double toMin, double toMax) {
		return (num - fromMin) / (fromMax - fromMin) * (toMax - toMin) + toMin;
	}

	/**
	 * Get the lowest number from a range of data
	 * 
	 * @param dataToCheck
	 * @return
	 */
	public static DataNode getLowestInRange(DataNode dataToCheck) {
		char min = Character.MAX_VALUE;
		for (Character ch : dataToCheck.getData().toCharArray()) {
			if (ch < min) {
				min = ch;
			}
		}
		log.finest(min + "");
		DataNode returner = new DataNode(min);
		return returner;
	}

	/**
	 * Get the highest from a range of data
	 * 
	 * @param dataToCheck
	 * @return
	 */
	public static DataNode getHighestInRange(DataNode dataToCheck) {
		char max = Character.MIN_VALUE;
		for (Character ch : dataToCheck.getData().toCharArray()) {
			if (ch > max) {
				max = ch;
			}
		}
		log.finest(max + "");
		DataNode returner = new DataNode(max);
		return returner;
	}

	/**
	 * this takes a class map and fills it with the number of each occurance of each token. abcaa #
	 * of {a=3, b=1, c= 1}
	 */
	public static Map<Character, Integer> populateCountMap(IDataHolder data) {
		Map<Character, Integer> ret = new HashMap<Character, Integer>();
		for (Character ch : data.getData().toCharArray()) {
			if (ret.containsKey(ch)) {
				ret.put(ch, ret.get(ch) + 1);
			} else {
				ret.put(ch, 1);
			}
		}
		log.fine("countMap: " + ret);
		return ret;
	}

	/**
	 * @return the most often occurring character within the string
	 */
	public static DataNode getTokenToTrim(Map<Character, Integer> countMap) {
		Character returner = new Character('!');
		int currMax = -1;
		for (Character ch : countMap.keySet()) {
			if (countMap.get(ch) > currMax) {
				currMax = countMap.get(ch);
				returner = ch;
			}
		}
		log.fine("returner: " + returner);
		return new DataNode(returner);
	}

	public static DataNode circularRangeMap(int magnitude, DataNode dataToModify,
			DataNode topRange, DataNode bottomRange) {
		DataNode ret = new DataNode();
		int range = bottomRange.value() - topRange.value() + 1;
		for (char c : dataToModify.getData().toCharArray()) {
			char newchar = (char) ((c + magnitude - topRange.value() + range) % range + topRange
					.value());
			ret.add(newchar);
		}
		return ret;
	}

	public static void main(String[] args) {
		// System.out
		// .println(map(5.8, 2, 6, 10, 70) + " " + map(map(5.8, 2, 6, 10, 70), 10, 70, 2, 6));
		Matrix m = Matrix.random(3, 3, 5);
		System.out.println("b4:");
		m.show();
		m = m.transpose();
		System.out.println();
		System.out.println("after:");
		m.show();
	}
}

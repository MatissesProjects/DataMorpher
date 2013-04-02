package structure;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import enums.MorphType;

public class currMain {
	public static Logger log;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log = Logger.getGlobal();
		log.setLevel(Level.INFO);

		DataMorpher morphObject = new DataMorpher("abcdefghi");

		// System.out.println(DataMorpher.DataMorpherTypes.AddToStart.getNum());

		morphObject.doRandomMorphs();

		MorphType[] morphsToDo = { MorphType.AddToEnd, MorphType.BetterSmooth };

		System.out.println("\n\n");
		System.out.println(Arrays.toString(morphsToDo));
		morphObject.doSetMorphs(morphsToDo);
		// checkForErrors(10000);
	}

	public static void checkForErrors(int numberOfRuns) {
		for (int i = 0; i < numberOfRuns; ++i) {
			DataMorpher morpher = new DataMorpher("abcdefghi");
			morpher.doRandomMorphs();
		}
		System.out.println("No Errors!");
	}
}

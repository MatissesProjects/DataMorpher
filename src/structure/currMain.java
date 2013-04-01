package structure;

import java.util.logging.Level;
import java.util.logging.Logger;

import enums.MorpherType;


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

		MorpherType[] morphsToDo = { MorpherType.AddToEnd, MorpherType.AddToEnd };
		// morphsToDo.add(MorpherType.AddToEnd);
		// morphsToDo.add(MorpherType.BetterSmooth);
		// morphsToDo.add(MorpherType.AddToEnd);
		System.out.println("\n\n");
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

package structure;

import java.util.logging.Level;
import java.util.logging.Logger;

public class currMain {
	public static Logger log;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log = Logger.getGlobal();
		log.setLevel(Level.FINE);

		DataMorpher morphObject = new DataMorpher("abcdefghi");
		morphObject.doRandomMorphs();
		morphObject.doSetMorphs();
	}

	public static void checkForErrors(DataMorpher morpher, int numberOfRuns) {
		for (int i = 0; i < numberOfRuns; ++i) {
			morpher.doRandomMorphs();
		}
		System.out.println("No Errors!");
	}
}

package structure;

import java.util.logging.Level;
import java.util.logging.Logger;

import enums.MorphType;

public class currMain {
	public static Logger log;
	public static final String INITIAL_DATA = "abcdefghijklmnopqrxtuvwxyz";
	public static final int NUM_MORPHS_TO_RUN = 15;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log = Logger.getGlobal();
		log.setLevel(Level.CONFIG);

		DataMorpher morphObject = new DataMorpher(INITIAL_DATA);
		MorphType[] morphsToDo = { MorphType.getRandomMorpher(), MorphType.getRandomMorpher(),
				MorphType.Gradient, MorphType.TrimTheMode };

		morphObject.doRandomMorphs(NUM_MORPHS_TO_RUN);
		morphObject.doSetMorphs(morphsToDo);
		// checkForErrors(1000);
	}

	public static void checkForErrors(int numberOfRuns) {
		for (int i = 0; i < numberOfRuns; ++i) {
			DataMorpher morpher = new DataMorpher(INITIAL_DATA);
			morpher.doRandomMorphs(NUM_MORPHS_TO_RUN);
			System.out.println(morpher.getData());
		}
		System.out.println("No Errors!");
	}
}

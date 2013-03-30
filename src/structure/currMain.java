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
		log.setLevel(Level.OFF);

		GetMorpher morphObject = new GetMorpher("abcdefghi");

		morphObject.doRandomMorphs();
//		morphObject.doSetMorphs();

//		 for (int i = 0; i < 1000; ++i) {
//			 morphObject.doRandomMorphs();
//		 }
//		 System.out.println("No Errors!");

		log.info("\n---------------------------------------\n");
	}

}

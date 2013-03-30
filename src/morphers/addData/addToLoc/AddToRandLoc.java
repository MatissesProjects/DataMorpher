package morphers.addData.addToLoc;

import structure.DataNode;
import structure.MathHelper;
import morphers.abstracts.A_AddToLocationMorpher;

/**
 * This is an example of a note morphing rule.
 * 
 * It takes a character to identify it, and some ruleData it then takes this ruleData and
 * 
 * @author Matisse
 * 
 */
public class AddToRandLoc extends A_AddToLocationMorpher {

	/**
	 * This noteMorph does an addition of the string addToString into a random location in the
	 * string given to the noteMorph
	 * 
	 */
	public AddToRandLoc(DataNode ruleData) {
		super(ruleData, MathHelper.rand.nextInt(ruleData.length()));
	}
}

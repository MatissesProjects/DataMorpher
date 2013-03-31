package morphers;

import structure.DataNode;
import abstracts.MorpherRule;

/**
 * This is the answer to the null pointer error, lets just pass up a null morph
 * 
 * @author Matisse
 * 
 */
public class NullMorpher extends MorpherRule {

	/**
	 * This class really doesn't do anything, it is just a shell
	 * 
	 * @param ruleData
	 */
	public NullMorpher(DataNode ruleData) {
		super(ruleData);
	}

	/**
	 * does nothing
	 */
	@Override
	protected void noteMorph(DataNode input) {
	}

}

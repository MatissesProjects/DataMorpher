package abstracts;

import structure.DataNode;

/**
 * This contains the rules for the note morph concepts
 * 
 * there will be data in the morph call
 * 
 * @author Matisse
 * 
 */
public abstract class MorphRule extends Rule<DataNode> {

	/**
	 * 
	 * @param ruleData
	 * @param startIndex
	 *            - Beginning for this morph
	 * @param endIndex
	 *            - Ending for this morph
	 */
	public MorphRule(DataNode ruleData, int startIndex, int endIndex) {
		super(ruleData, startIndex, endIndex);
	}

	/**
	 * This is the generic base morph method, we have redefined it here to call our base noteMorph,
	 * which is defined by which
	 */
	@Override
	public void morph(DataNode input) {
		super.morph(input);
		noteMorph(input);
	}

	/**
	 * Abstract noteMorph, this is what we call to do an actual notemorph
	 * 
	 * @param inputStr
	 */
	protected abstract void noteMorph(DataNode input);
}

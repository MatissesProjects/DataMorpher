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

	public MorphRule(DataNode ruleData) {
		super(ruleData);
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

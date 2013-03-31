package morphers.addData.addToLoc;

import structure.DataNode;
import abstracts.MorpherRule;

public abstract class A_AddToLocationMorpher extends MorpherRule {

	private final int morphLocation;

	/**
	 * write to location within the data
	 * 
	 * @param ruleData
	 * @param morphLocation
	 */
	public A_AddToLocationMorpher(DataNode ruleData, int morphLocation) {
		super(ruleData);
		this.morphLocation = morphLocation;
	}

	/**
	 * This noteMorph does an addition of the string addToString into a given location in the string
	 * given to the noteMorph
	 * 
	 */
	@Override
	protected void noteMorph(DataNode input) {
		data.insertData(morphLocation, morphLocation, input);
	}

}

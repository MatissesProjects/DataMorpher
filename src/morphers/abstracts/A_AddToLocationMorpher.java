package morphers.abstracts;

import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;

public abstract class A_AddToLocationMorpher extends NoteMorpherRule {

	private int morphLocation;

	/**
	 * write to location within the data
	 * 
	 * @param ruleData
	 * @param morphLocation
	 */
	public A_AddToLocationMorpher(NoteData ruleData, int morphLocation) {
		super(ruleData);
		this.morphLocation = morphLocation;
	}

	/**
	 * This noteMorph does an addition of the string addToString into a given
	 * location in the string given to the noteMorph
	 * 
	 */
	@Override
	protected void noteMorph(NoteData input) {
		data.insertData(morphLocation, morphLocation, input);
	}

}

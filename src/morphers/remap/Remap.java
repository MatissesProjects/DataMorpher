package morphers.remap;

import structure.DataNode;
import abstracts.MorpherRule;

public class Remap extends MorpherRule {

	/**
	 * 
	 * @param ruleData
	 * @param topLimit
	 *            Currently should only be 1 data long. This is the top bounding limit
	 * @param bottomLimit Currently should be only 1 data long, this is the bottom bound
	 */
	public Remap(DataNode ruleData, DataNode topLimit, DataNode bottomLimit) {
		super(ruleData);
	}

	@Override
	protected void noteMorph(DataNode input) {
		// TODO takes in the range, either two characters that define the start and end, or an int
		// that declares the ending from 'a', then remap to this range
		// char a = (char)((((b + mag) - 'a') % ('z'-'a')) +'a');
	}

}

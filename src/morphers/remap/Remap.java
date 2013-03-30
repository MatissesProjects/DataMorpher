package morphers.remap;

import structure.DataNode;
import abstracts.MorpherRule;

public class Remap extends MorpherRule {

	public Remap(DataNode ruleData) {
		super(ruleData);
	}

	@Override
	protected void noteMorph(DataNode input) {
		// TODO takes in the range, either two characters that define the start and end, or an int
		// that declares the ending from 'a', then remap to this range
		// char a = (char)((((b + mag) - 'a') % ('z'-'a')) +'a');
	}

}

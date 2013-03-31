package morphers.addData.addToLoc;

import structure.DataNode;

public class AddToEnd extends A_AddToLocationMorpher {

	public AddToEnd(DataNode ruleData) {
		super(ruleData, ruleData.length());
	}
}

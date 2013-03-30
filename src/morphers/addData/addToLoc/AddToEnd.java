package morphers.addData.addToLoc;

import morphers.abstracts.A_AddToLocationMorpher;
import structure.DataNode;

public class AddToEnd extends A_AddToLocationMorpher {

	public AddToEnd(DataNode ruleData) {
		super(ruleData, ruleData.length());
	}
}

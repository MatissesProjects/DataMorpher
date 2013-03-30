package morphers.addData.addToLoc;

import structure.DataNode;
import morphers.abstracts.A_AddToLocationMorpher;

public class AddToEnd extends A_AddToLocationMorpher {

	public AddToEnd(DataNode ruleData) {
		super(ruleData, ruleData.length());
	}
}

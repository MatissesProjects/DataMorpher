package morphers.addData.addToLoc;

import structure.DataNode;

/**
 * Add your data to the end of the current data 
 */
public class AddToEnd extends A_AddToLocationMorpher {

	public AddToEnd(DataNode ruleData) {
		super(ruleData, ruleData.length());
	}
}

package morphers.addData.addToLoc;

import noteStuff.NoteData;
import morphers.abstracts.A_AddToLocationMorpher;

public class AddToEnd extends A_AddToLocationMorpher {

	public AddToEnd(NoteData ruleData) {
		super(ruleData, ruleData.length());
	}
}

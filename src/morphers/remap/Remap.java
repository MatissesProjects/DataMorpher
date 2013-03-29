package morphers.remap;

import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;

public class Remap extends NoteMorpherRule {

	public Remap(NoteData ruleData) {
		super(ruleData);
	}

	@Override
	protected void noteMorph(NoteData input) {
		// TODO takes in the range, either two characters that define the start and end, or an int
		// that declares the ending from 'a', then remap to this range
		// char a = (char)((((b + mag) - 'a') % ('z'-'a')) +'a');
	}

}

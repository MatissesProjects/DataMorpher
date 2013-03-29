package anticipators;

import morphers.addData.smooth.BasicSmooth;
import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;

public class Gradient extends NoteMorpherRule {
	int start, end;

	public Gradient(NoteData ruleData, int startIndex, int endIndex) {
		super(ruleData);
		this.start = startIndex;
		this.end = endIndex;
	}

	@Override
	protected void noteMorph(NoteData morphTo) {
		BasicSmooth smooth = new BasicSmooth(new NoteData(data.getRange(start, end)
				+ morphTo.getNoteData()));
		smooth.morph(null);
		data.insertData(start, end, smooth.data);
	}
}

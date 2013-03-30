package anticipators;

import structure.DataNode;
import abstracts.MorpherRule;
import morphers.addData.smooth.BasicSmooth;

public class Gradient extends MorpherRule {
	int start, end;

	public Gradient(DataNode ruleData, int startIndex, int endIndex) {
		super(ruleData);
		this.start = startIndex;
		this.end = endIndex;
	}

	@Override
	protected void noteMorph(DataNode morphTo) {
		BasicSmooth smooth = new BasicSmooth(new DataNode(data.getRange(start, end)
				+ morphTo.getNoteData()));
		smooth.morph(null);
		data.insertData(start, end, smooth.data);
	}
}

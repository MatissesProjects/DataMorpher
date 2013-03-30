package anticipators;

import morphers.addData.smooth.BasicSmooth;
import structure.DataNode;
import abstracts.MorpherRule;

public class Gradient extends MorpherRule {
	int start, end;

	public Gradient(DataNode ruleData, int startIndex, int endIndex) {
		super(ruleData);
		start = startIndex;
		end = endIndex;
	}

	@Override
	protected void noteMorph(DataNode morphTo) {
		BasicSmooth smooth = new BasicSmooth(new DataNode(data.getRange(start, end)
				+ morphTo.getNoteData()));
		smooth.morph(null);
		data.insertData(start, end, smooth.data);
	}
}

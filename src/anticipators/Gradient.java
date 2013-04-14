package anticipators;

import morphers.addData.smooth.BasicSmooth;
import structure.DataNode;
import abstracts.MorphRule;

public class Gradient extends MorphRule {

	public Gradient(DataNode ruleData, int startIndex, int endIndex) {
		super(ruleData, startIndex, endIndex);
	}

	@Override
	protected void noteMorph(DataNode morphTo) {
		BasicSmooth smooth = new BasicSmooth(new DataNode(data.getData()
				+ morphTo.getNoteData().substring(0, morphTo.length())), 0, data.length() + 1);
		smooth.morph(null);
		// smooth.data.setNoteData();
		smooth.setStart(data.length() - 1);
		smooth.setEnd(data.length() + morphTo.length() + 1);
		data.insertData(start, end, smooth.data);
	}
}

package morphers.addData.smooth;

import static structure.currMain.log;
import structure.DataNode;
import abstracts.MorpherRule;

public class BetterSmooth extends MorpherRule {

	public BetterSmooth(DataNode ruleData) {
		super(ruleData);
	}

	@Override
	protected void noteMorph(DataNode input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length() - 4; ++i) {
			sb.append(data.get(i));
			if (data.get(i) != data.get(i + 1) && data.get(i + 2) != data.get(i + 3))
				sb.append((char) ((data.get(i) + data.get(i + 1) + data.get(i + 2) + data
						.get(i + 3)) / 4));
		}
		BasicSmooth lastPieces = new BasicSmooth(new DataNode(data.getRange(data.length() - 4,
				data.length())));
		lastPieces.morph(null);
		sb.append(lastPieces.data.getNoteData());
		log.fine(sb.toString());
		data.setNoteData(sb.toString());
	}
}

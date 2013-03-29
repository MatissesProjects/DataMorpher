package morphers.addData.smooth;

import structure.currMain;
import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;

public class BetterSmooth extends NoteMorpherRule {

	public BetterSmooth(NoteData ruleData) {
		super(ruleData);
	}

	@Override
	protected void noteMorph(NoteData input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length() - 4; ++i) {
			sb.append(data.get(i));
			if (data.get(i) != data.get(i + 1) && data.get(i + 2) != data.get(i + 3))
				sb.append((char) ((data.get(i) + data.get(i + 1) + data.get(i + 2) + data
						.get(i + 3)) / 4));
		}
		BasicSmooth lastPieces = new BasicSmooth(new NoteData(data.getRange(data.length() - 4,
				data.length())));
		lastPieces.morph(null);
		sb.append(lastPieces.data.getNoteData());
		if (currMain.VERBOSE)
			System.out.println(sb);
		data.setNoteData(sb.toString());
	}
}

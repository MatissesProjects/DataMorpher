package morphers.addData.smooth;

import static structure.currMain.log;
import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;

public class BasicSmooth extends NoteMorpherRule {

	public BasicSmooth(NoteData ruleData) {
		super(ruleData);
	}

	@Override
	protected void noteMorph(NoteData DONT_CARE) {
		StringBuilder sb = new StringBuilder();
		//compares 2 at a time, so -1 to not compare against nothing at end
		for (int i = 0; i < data.length() - 1; ++i) {
			char curChar = data.get(i);
			char nextChar = data.get(i + 1);
			sb.append(curChar);
			
			if ((curChar != nextChar)) {
				char cData = (char) ((curChar + nextChar) / 2);
				if (sb.toString().charAt(sb.length() - 1) != cData) {
					sb.append(cData);
				}
			}
		}
		sb.append(data.get(data.length() - 1));
		log.fine(sb.toString());
		data.setNoteData(sb.toString());
	}
}

package morphers.addData.smooth;

import static structure.currMain.log;

import java.util.Collections;
import java.util.List;

import morphers.abstracts.A_ShuffleMorpher;
import noteStuff.NoteData;

public class Sort extends A_ShuffleMorpher {

	public Sort(NoteData ruleData, int start, int end) {
		super(ruleData, start, end);
		log.fine("start: " + start + " end: " + end);
	}

	@Override
	protected NoteData thisShuffle(List<NoteData> bag, int endShuffle) {
		Collections.sort(bag);
		NoteData returner = new NoteData();
		for (NoteData d : bag)
			returner.setNoteData(returner.getNoteData() + d);
		log.fine("returner: " + returner);
		return returner;
	}

}

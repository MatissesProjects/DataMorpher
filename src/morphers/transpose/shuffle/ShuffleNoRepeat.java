package morphers.transpose.shuffle;

import java.util.List;

import noteStuff.NoteData;

import structure.MathHelper;

import morphers.abstracts.A_ShuffleMorpher;

public class ShuffleNoRepeat extends A_ShuffleMorpher {

	public ShuffleNoRepeat(NoteData ruleData, int start, int end) {
		super(ruleData, start, end);
	}

	@Override
	protected NoteData thisShuffle(List<NoteData> bag, int endShuffle) {
		NoteData returner = new NoteData();
		for (int i = 0; i < endShuffle; ++i) {
			int randomGrab = MathHelper.rand.nextInt(bag.size());
			returner.add(bag.remove(randomGrab));
		}
		return returner;
	}

}

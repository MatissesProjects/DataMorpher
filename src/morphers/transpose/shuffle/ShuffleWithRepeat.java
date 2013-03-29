package morphers.transpose.shuffle;

import java.util.List;

import noteStuff.NoteData;

import structure.MathHelper;

import morphers.abstracts.A_ShuffleMorpher;

public class ShuffleWithRepeat extends A_ShuffleMorpher {

	public ShuffleWithRepeat(NoteData ruleData, int start, int end) {
		super(ruleData, start, end);
	}

	@Override
	protected NoteData thisShuffle(List<NoteData> bag, int endShuffle) {
		NoteData resultingData = new NoteData();
		for (int i = 0; i <= end; ++i) {
			int randomGrab = MathHelper.rand.nextInt(bag.size());
			resultingData.add(bag.get(randomGrab));
		} // shuffle the letters adding them into resultdata
		return resultingData;
	}
}

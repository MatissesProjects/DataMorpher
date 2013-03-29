package morphers.transpose.shuffle;

import java.util.ArrayList;
import java.util.List;

import noteStuff.NoteData;

import structure.MathHelper;

import morphers.abstracts.A_ShuffleMorpher;

public class ShuffleWithRepeatUsingAll extends A_ShuffleMorpher {

	public ShuffleWithRepeatUsingAll(NoteData ruleData, int start, int end) {
		super(ruleData, start, end);
	}

	@Override
	protected NoteData thisShuffle(List<NoteData> bag, int endShuffle) {
		List<NoteData> removeFromBag = new ArrayList<>(bag);//list of arbitrary type
		NoteData resultingData = new NoteData();
		while (!removeFromBag.isEmpty()) {
			int randomGrab = MathHelper.rand.nextInt(bag.size());
			resultingData.add(bag.get(randomGrab));
			// this can remove the same data that is no longer there, doesn't matter
			removeFromBag.remove(bag.get(randomGrab));
		} // shuffle the letters adding them into resultdata
		return resultingData;
	}

}

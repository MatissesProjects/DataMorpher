package morphers.transpose.shuffle;

import java.util.List;

import noteStuff.NoteData;

import structure.MathHelper;

import morphers.abstracts.A_ShuffleMorpher;

/**
 * This is a shuffle that goes from the start of the data to the end and randomly chooses which data
 * to put into the result, it can have repeats, and doesn't need to use all data given (and will
 * probably not)
 * 
 * @Example initialData = abcdefg <br />
 * 
 * 
 * @author Matisse
 * 
 */
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

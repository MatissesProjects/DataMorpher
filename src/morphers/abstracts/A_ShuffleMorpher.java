package morphers.abstracts;

import java.util.ArrayList;
import java.util.List;

import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;

/**
 * Abstract concept of a shuffle morph<br>
 * This takes some data and shuffles it in some way, to be defined by the
 * subclasses
 * 
 * @author Matisse
 * 
 */
public abstract class A_ShuffleMorpher extends NoteMorpherRule {

	protected int start, end;

	/**
	 * 
	 * @param ruleData
	 * @param start
	 * @param end
	 */
	public A_ShuffleMorpher(NoteData ruleData, int start, int end) {
		super(ruleData);
		this.start = Math.min(start, end);
		this.end = Math.max(start, end);
	}

	/**
	 * @param DONT_CARE
	 *            - not important for this morph
	 */
	@Override
	protected void noteMorph(NoteData DONT_CARE) {
		// Create bag to hold pieces of data we what "shuffled"
		List<NoteData> bag = new ArrayList<>(end - start + 1);
		NoteData resultingData = new NoteData();

		// get the letters to shuffle
		bag.addAll(getDataToShuffle());
		// add to our resulting data up to the start of our shuffle
		resultingData.add(setData(0, start));

		// shuffle the letters adding them into resultData
		resultingData.add(thisShuffle(bag, bag.size()));

		// add to our resulting data the rest of the data
		resultingData.add(setData(end, data.length()));

		data = resultingData;
	}

	/**
	 * gets the data to shuffle, potentially add rules into here, this would be
	 * an interesting morphing zone
	 * 
	 * @return
	 */
	protected List<NoteData> getDataToShuffle() {
		List<NoteData> returner = new ArrayList<>(end - start + 1);
		for (int i = start; i < Math.min(data.length(), end + 1); ++i) {
			returner.add(new NoteData(data.get(i)));
		}
		return returner;
	}

	/**
	 * add to our resulting data up to the start of our shuffle
	 * 
	 * @param beginning
	 * @param ending
	 * @return the data to be set
	 */
	protected NoteData setData(int beginning, int ending) {
		NoteData returner = new NoteData();
		for (int i = beginning; i < ending; ++i) {
			returner.add(new NoteData(data.get(i)));
		}
		return returner;
	}

	protected abstract NoteData thisShuffle(List<NoteData> bag, int endShuffle);
}

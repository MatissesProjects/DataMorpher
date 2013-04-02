package morphers.shuffle;

import static structure.currMain.log;

import java.util.ArrayList;
import java.util.List;

import structure.DataNode;
import abstracts.MorphRule;

/**
 * Abstract concept of a shuffle morph<br>
 * This takes some data and shuffles it in some way, to be defined by the subclasses
 * 
 * @author Matisse
 * 
 */
public abstract class A_ShuffleMorpher extends MorphRule {

	protected int start, end;

	/**
	 * 
	 * @param ruleData
	 * @param start
	 * @param end
	 */
	public A_ShuffleMorpher(DataNode ruleData, int start, int end) {
		super(ruleData);
		log.finest("Start: " + start + " end: " + end);
		this.start = Math.min(start, end);
		this.end = Math.max(start, end);
	}

	/**
	 * @param DONT_CARE
	 *            - not important for this morph
	 */
	@Override
	protected void noteMorph(DataNode DONT_CARE) {
		// Create bag to hold pieces of data we what "shuffled"
		List<DataNode> bag = new ArrayList<>(getDataToShuffle());
		DataNode resultingData = new DataNode();

		// get the letters to shuffle
//		bag.addAll(getDataToShuffle());
		// add to our resulting data up to the start of our shuffle
		resultingData.add(setData(0, start));

		// shuffle the letters adding them into resultData
//		resultingData.add(thisShuffle(bag, bag.size()));
		resultingData.add(thisShuffle(bag));

		// add to our resulting data the rest of the data
		resultingData.add(setData(end, data.length()));

		data = resultingData;
	}

	/**
	 * gets the data to shuffle, potentially add rules into here, this would be an interesting
	 * morphing zone
	 * 
	 * @return
	 */
	protected List<DataNode> getDataToShuffle() {
		int cappedEnd = Math.min(data.length(), end);
//		List<DataNode> returner = data.getRangeList(start, cappedEnd);
//				new ArrayList<>(end - start + 1);
//		for (int i = start; i < Math.min(data.length(), end); ++i) {
//			returner.add(new DataNode(data.get(i)));
//		}
		return data.getRangeList(start, cappedEnd);
	}

	/**
	 * add to our resulting data up to the start of our shuffle
	 * 
	 * @param beginning
	 * @param ending
	 * @return the data to be set
	 */
	protected DataNode setData(int beginning, int ending) {
		DataNode returner = new DataNode();
//		returner.add(new DataNode(data.getRange(beginning, ending)));
		for (int i = beginning; i < ending; ++i) {
			returner.add(new DataNode(data.charAt(i)));
		}
		return returner;
	}

	protected abstract DataNode thisShuffle(List<DataNode> bag);
}

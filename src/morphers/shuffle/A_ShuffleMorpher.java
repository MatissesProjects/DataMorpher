package morphers.shuffle;

import static structure.GlobalConstants.log;

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
	/**
	 * 
	 * @param ruleData
	 * @param start
	 * @param end
	 */
	public A_ShuffleMorpher(DataNode ruleData, int start, int end) {
		super(ruleData, start, end);
		log.finest("Start: " + start + " end: " + end);
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

		// add to our resulting data up to the start of our shuffle
		resultingData.add(setData(0, start));

		// shuffle the letters adding them into resultData
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
		for (int i = beginning; i < ending; ++i) {
			returner.add(new DataNode(data.charAt(i)));
		}
		return returner;
	}

	/**
	 * Generic shuffle, this is what is defined to create your shuffle. It will take from this list 
	 * @param bag
	 * @return
	 */
	protected abstract DataNode thisShuffle(List<DataNode> bag);
}

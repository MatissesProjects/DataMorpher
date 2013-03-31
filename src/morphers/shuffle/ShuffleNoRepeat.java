package morphers.shuffle;

import java.util.Collections;
import java.util.List;

import structure.DataNode;

/**
 * This takes the current data, from start to end, shuffles it
 * 
 * @Example abcdefg <br />
 *          start: 2 <br />
 *          end: 4 <br />
 *          abdecfg
 * 
 * @author Matisse
 * 
 */
public class ShuffleNoRepeat extends A_ShuffleMorpher {

	/**
	 * 
	 * @param ruleData
	 *            Data for this morph
	 * @param start
	 *            Start location of repeat
	 * @param end
	 *            End location for repeat
	 */
	public ShuffleNoRepeat(DataNode ruleData, int start, int end) {
		super(ruleData, start, end);
	}

	/**
	 * This shuffle takes the data that is required to shuffle and it calls the Collection shuffle
	 */
	@Override
	protected DataNode thisShuffle(List<DataNode> bag) {
		DataNode returner = new DataNode();
		Collections.shuffle(bag);
		while (!bag.isEmpty()) {
			returner.add(bag.remove(0));
		}
		return returner;
	}
}

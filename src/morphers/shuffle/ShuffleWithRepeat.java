package morphers.shuffle;

import java.util.List;

import mathResources.MathHelper;

import structure.DataNode;

/**
 * This is a shuffle that goes from the start of the data to the end and randomly chooses which data
 * to put into the result, it can have repeats, and doesn't need to use all data given (and will
 * probably not)
 * 
 * @Example initialData = adcbdehb <br />
 *          start:2<br />
 *          end:6<br />
 *          adeedebdb
 * 
 * @author Matisse
 * 
 */
public class ShuffleWithRepeat extends A_ShuffleMorpher {

	public ShuffleWithRepeat(DataNode ruleData, int start, int end) {
		super(ruleData, start, end);
	}

	@Override
	protected DataNode thisShuffle(List<DataNode> bag) {
		DataNode resultingData = new DataNode();
		for (int i = 0; i < bag.size(); ++i) {
			int randomGrab = MathHelper.rand.nextInt(bag.size());
			resultingData.add(bag.get(randomGrab));
		} // shuffle the letters adding them into resultdata
		return resultingData;
	}
}

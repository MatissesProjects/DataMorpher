package morphers.shuffle;

import java.util.ArrayList;
import java.util.List;

import mathResources.MathHelper;

import structure.DataNode;

/**
 * This takes the data a start and an end and store it into toshuffle. While adding the data back it
 * randomly selects from the "toshuffle" data and writes the data then deletes it from a separate
 * list that starts = to toshuffle, but gets its components removed from. The selection process
 * continues from toshuffle, if the item is not found in the separate data it is ignored. This is
 * done until the separate data is empty
 */
public class ShuffleWithRepeatUsingAll extends A_ShuffleMorpher {

	public ShuffleWithRepeatUsingAll(DataNode ruleData, int start, int end) {
		super(ruleData, start, end);
	}

	@Override
	protected DataNode thisShuffle(List<DataNode> bag) {
		List<DataNode> removeFromBag = new ArrayList<>(bag);// list of arbitrary type
		DataNode resultingData = new DataNode();
		while (!removeFromBag.isEmpty()) {
			int randomGrab = MathHelper.rand.nextInt(bag.size());
			resultingData.add(bag.get(randomGrab));
			// this can remove the same data that is no longer there, doesn't matter
			removeFromBag.remove(bag.get(randomGrab));
		} // shuffle the letters adding them into resultdata
		return resultingData;
	}

}

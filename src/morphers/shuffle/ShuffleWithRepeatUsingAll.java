package morphers.shuffle;

import java.util.ArrayList;
import java.util.List;

import morphers.abstracts.A_ShuffleMorpher;
import structure.DataNode;
import structure.MathHelper;

public class ShuffleWithRepeatUsingAll extends A_ShuffleMorpher {

	public ShuffleWithRepeatUsingAll(DataNode ruleData, int start, int end) {
		super(ruleData, start, end);
	}

	@Override
	protected DataNode thisShuffle(List<DataNode> bag, int endShuffle) {
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

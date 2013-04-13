package morphers.addData.smooth;

import static structure.GlobalConstants.log;

import java.util.Collections;
import java.util.List;

import morphers.shuffle.A_ShuffleMorpher;
import structure.DataNode;

/**
 * This takes the data and from start to end it sorts the data
 * 
 * @Example init: abefcgdhi <br />
 *          start: 2 <br />
 *          end: length <br />
 *          result: abcdefghi
 * @author Matisse
 * 
 */
public class Sort extends A_ShuffleMorpher {

	public Sort(DataNode ruleData, int start, int end) {
		super(ruleData, start, end);
		log.fine("start: " + start + " end: " + end);
	}

	@Override
	protected DataNode thisShuffle(List<DataNode> bag) {
		Collections.sort(bag);
		DataNode returner = new DataNode(bag);
		log.fine("returner: " + returner);
		return returner;
	}

}

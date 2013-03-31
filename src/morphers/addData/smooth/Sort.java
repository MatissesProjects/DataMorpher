package morphers.addData.smooth;

import static structure.currMain.log;

import java.util.Collections;
import java.util.List;

import morphers.abstracts.A_ShuffleMorpher;
import structure.DataNode;

public class Sort extends A_ShuffleMorpher {

	public Sort(DataNode ruleData, int start, int end) {
		super(ruleData, start, end);
		log.fine("start: " + start + " end: " + end);
	}

	@Override
	protected DataNode thisShuffle(List<DataNode> bag) {
		Collections.sort(bag);
//		Collections.reverse(bag);
		DataNode returner = new DataNode(bag);
		
//		returner.addAll(bag);
//		for (DataNode d : bag) {
//			returner.setNoteData(returner.getNoteData() + d);
//		}
		log.fine("returner: " + returner);
		return returner;
	}

}

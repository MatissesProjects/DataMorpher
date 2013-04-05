package morphers.addData.smooth;

import static structure.currMain.log;
import structure.DataNode;
import abstracts.MorphRule;

/**
 * This takes the data from startIndex to endIndex and smooths it. (assuming start = 0, end =
 * length) So if the data was acegi, the result would be abcdefghi. (assuming start = 0, end =
 * length) If you entered abefi you would get abcefgi
 * 
 * @author Matisse
 * 
 */
public class BasicSmooth extends MorphRule {

	int start, end;

	public BasicSmooth(DataNode ruleData, int startIndex, int endIndex) {
		super(ruleData);
		start = startIndex;
		end = endIndex;
	}

	@Override
	protected void noteMorph(DataNode DONT_CARE) {
		StringBuilder sb = new StringBuilder();
		sb.append(data.getRange(0, start));
		// compares 2 at a time, so -1 to not compare against nothing at end
		for (int i = start; i < Math.min(end, data.length() - 1); ++i) {
			DataNode currData = new DataNode(data.charAt(i));
			DataNode nextData = new DataNode(data.charAt(i + 1));
			DataNode aveData = DataNode.average(currData, nextData);

			sb.append(currData.getNoteData());

			if (!aveData.equals(nextData)) {
				sb.append(aveData.getNoteData());
			}
		}
		sb.append(data.getRange(Math.min(end, data.length() - 1), Math.max(end, data.length() - 1)));
		log.fine(sb.toString());
		data.setNoteData(sb.toString());
	}

	public void setStart(int startIndex) {
		start = startIndex;
	}
	
	public void setEnd(int endIndex) {
		end = endIndex;
	}
}

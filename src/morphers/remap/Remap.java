package morphers.remap;

import structure.DataNode;
import static structure.currMain.log;
import abstracts.MorphRule;

/**
 * Remaps the given data between the new top and bottom limits
 * 
 * @author Matisse
 * 
 */
public class Remap extends MorphRule {

	int top, bottom, start, end;

	/**
	 * 
	 * @param ruleData
	 * @param topLimit
	 *            This is the top bounding limit
	 * @param bottomLimit
	 *            This is the bottom bound
	 * @param startIndex
	 * @param endIndex
	 */
	public Remap(DataNode ruleData, int topLimit, int bottomLimit, int startIndex, int endIndex) {
		super(ruleData);
		top = topLimit;
		bottom = bottomLimit;
		start = startIndex;
		end = endIndex;
		if (top == bottom)
			bottom++;
		log.finest(top + " " + bottom + " " + start + " " + end);
	}

	@Override
	protected void noteMorph(DataNode input) {
		StringBuilder sb = new StringBuilder();
		sb.append(data.getRange(0, start));
		for (int i = start; i < Math.min(end, data.length()); ++i) {
			sb.append((char) (((data.get(i) - top) % (bottom - top)) + top));
		}
		sb.append(data.getRange(end, Math.max(end, data.length())));
		data.setNoteData(sb.toString());
	}

}

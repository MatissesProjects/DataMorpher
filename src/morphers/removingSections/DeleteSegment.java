package morphers.removingSections;

import structure.DataNode;
import static structure.MathHelper.rand;
import abstracts.MorphRule;

/**
 * Takes the rule data and deletes a segment from start to end.
 * 
 * @author Matisse
 * 
 */
public class DeleteSegment extends MorphRule {

	private final int start, end;

	/**
	 * Known location set, selected location or zone maybe?
	 * 
	 * @param ruleData
	 *            - Data for this morph
	 * @param start
	 *            - Start location for the deletion, inclusive
	 * @param end
	 *            - End location, inclusive
	 */
	public DeleteSegment(DataNode ruleData, int start, int end) {
		super(ruleData);
		this.start = start;
		this.end = end;
	}

	/**
	 * Random delete segment
	 * 
	 * @Note can select same number for a no deletion run
	 * 
	 * @param ruleData
	 *            - Data for this morph
	 */
	public DeleteSegment(DataNode ruleData) {
		super(ruleData);
		start = rand.nextInt(1 + data.length() / 4);
		end = start + rand.nextInt(1 + data.length() / 4);
	}

	/**
	 * This is the deletion morph, the entered notedata here is not needed
	 */
	@Override
	protected void noteMorph(DataNode NOT_USED) {
		data.setNoteData(data.getRange(0, start) + data.getRange(end, data.length()));
		if (data.length() < 4) {
			data.add(new DataNode("abcd"));
		}
	}
}

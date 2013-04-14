package morphers.transpose;

import mathResources.MathHelper;
import structure.DataNode;
import abstracts.MorphRule;

/**
 * Takes a segment of data and flips it around
 * 
 * @Example abcdefg start: 1 end: 4 aedcbfg
 * 
 * @author Matisse
 * 
 */
public class FlipSegment extends MorphRule {

	/**
	 * Takes data from a known {start, end}index and flips it
	 * 
	 * @param ruleData
	 *            - The data contained within this morph
	 * @param start
	 *            - Start index in the data for this morph
	 * @param end
	 *            - End index in the data
	 * @Note if start > end, this will automatically flip it
	 */
	public FlipSegment(DataNode ruleData, int start, int end) {
		super(ruleData, start, end);
	}

	/**
	 * Flips the data given within ruleData, however this is a random flip, start and end locations
	 * are randomly generated
	 * 
	 * @Note it can select the same index and not do a flip
	 * 
	 * @param ruleData
	 */
	public FlipSegment(DataNode ruleData) {
		super(ruleData, MathHelper.rand.nextInt(1 + ruleData.length() / 4), (ruleData.length() / 4)
				+ MathHelper.rand.nextInt(1 + ruleData.length() / 4));
	}

	/**
	 * Morph for flipSegment, this morph is simple using StringBuilder and a simple data substring
	 * we get our data to flip.
	 */
	@Override
	protected void noteMorph(DataNode NOT_USED) {
		data.flip(start, end);
	}
}
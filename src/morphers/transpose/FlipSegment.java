package morphers.transpose;

import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;
import structure.MathHelper;

/**
 * Takes a segment of data and flips it around
 * 
 * @Example abcdefg start: 1 end: 4 aedcbfg
 * 
 * @author Matisse
 * 
 */
public class FlipSegment extends NoteMorpherRule {
	private int start, end;

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
	public FlipSegment(NoteData ruleData, int start, int end) {
		super(ruleData);

		this.start = Math.min(start, end);
		this.end = Math.max(start, end);
	}

	/**
	 * Flips the data given within ruleData, however this is a random flip,
	 * start and end locations are randomly generated
	 * 
	 * @Note it can select the same index and not do a flip
	 * 
	 * @param ruleData
	 */
	public FlipSegment(NoteData ruleData) {
		super(ruleData);
		start = MathHelper.rand.nextInt(1 + data.length() / 4);
		end = start + MathHelper.rand.nextInt(1 + data.length() / 4);
	}

	/**
	 * Morph for flipSegment, this morph is simple using StringBuilder and a
	 * simple data substring we get our data to flip.
	 */
	@Override
	protected void noteMorph(NoteData NOT_USED) {
		data.flip(start, end);
	}
}
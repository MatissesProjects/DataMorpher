package morphers.transpose;

import static structure.MathHelper.rand;
import static structure.currMain.log;
import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;
import structure.MathHelper;

/**
 * Takes data and shifts a subset of it by the magnitude
 * 
 * @Example initial = abcdefghi<br>
 *          start = 1<br>
 *          end = 3<br>
 *          magnitude = 2<br>
 *          newData = adedefghi
 * @author Matisse
 * 
 */
public class ShiftDataToTheMag extends NoteMorpherRule {
	int start, end, newMagnitude;

	final int MAX_SHIFT = 2;

	/**
	 * the new magnitude is the direction the shift occurs in.
	 * 
	 * @Note If you use a negative magnitude it is possible to lose data because it will shift
	 *       beyond a, if using positive magnitude it can go beyond z and it gets cut out in either
	 *       case
	 * 
	 * @param ruleData
	 * @param start
	 *            - start index of the data to shift, inclusive
	 * @param end
	 *            - end index, exclusive
	 * @param newMagnitude
	 *            - direction to shift the data
	 */
	public ShiftDataToTheMag(NoteData ruleData, int start, int end, int newMagnitude) {
		super(ruleData);
		this.start = start;
		this.end = end;
		this.newMagnitude = Math.max(newMagnitude, MAX_SHIFT);
	}

	public ShiftDataToTheMag(NoteData ruleData) {
		super(ruleData);
		start = rand.nextInt(1 + data.length() / 4);
		end = start + rand.nextInt(1 + data.length() / 4);
		newMagnitude = MathHelper.plusOrMinus(MAX_SHIFT);
		log.fine("start: " + start + " end: " + end + " newMagnitude: " + newMagnitude);
	}

	@Override
	protected void noteMorph(NoteData DONT_CARE) {
		NoteData initialData = new NoteData();
		int range = 'z' - 'a' + 1;
		for (int i = start; i < end; ++i) {
			char newchar = (char) ((((data.get(i) + newMagnitude) - 'a' + range) % range) + 'a');
			initialData.add(new NoteData(newchar + ""));
		}
		data.insertData(start, end, initialData);
	}

}

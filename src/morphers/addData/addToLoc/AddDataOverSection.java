package morphers.addData.addToLoc;

import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;
import structure.currMain;

/**
 * Something like a paintbrush
 * 
 * @Example abcdefg<br>
 *          with inputdata = 'zy'<br>
 *          startIndex = 1<br>
 *          endIndex = 3<br>
 *          abzyczydefg
 * @author Matisse
 * 
 */
public class AddDataOverSection extends NoteMorpherRule {

	int start, end;

	/**
	 * Adds this data as if this were a paintbrush that is painting ontop of a background that you
	 * can see <br>
	 * <br>
	 * 
	 * TODO Implement 'transparency' currently 1 transparency, if 2 maybe let 2 through or something
	 * like this
	 * 
	 * @param ruleData
	 * @param startIndex
	 * @param endIndex
	 */
	public AddDataOverSection(NoteData ruleData, int startIndex, int endIndex) {
		super(ruleData);
		start = startIndex;
		end = endIndex;
		if (currMain.VERBOSE)
			System.out.println("start: " + start + " end: " + end);
	}

	@Override
	protected void noteMorph(NoteData input) {
		if (currMain.VERBOSE)
			System.out.println("input: " + input);
		
		//FIXME this only works for 1		
		String sb = appendAtInterval(input, 1);
		data.setNoteData(sb);
		if (currMain.VERBOSE)
			System.out.println(sb);
	}

	private String appendAtInterval(NoteData input, int interval) {
		StringBuilder sb = new StringBuilder(data.getRange(0, start));
		for (int i = start; i < end - interval; i += interval) {
			// for(int getData = i; getData < i+interval; ++getData)
			sb.append(data.getRange(i, i + interval));
			sb.append(input);
		}
		sb.append(data.getRange(end, data.length()));
		return sb.toString();
	}

}

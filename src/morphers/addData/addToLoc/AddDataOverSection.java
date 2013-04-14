package morphers.addData.addToLoc;

import static structure.GlobalConstants.log;
import structure.DataNode;
import abstracts.MorphRule;

/**
 * Something like a paintbrush
 * 
 * @Example abcdefg<br />
 *          with inputdata = 'zy'<br />
 *          startIndex = 1<br />
 *          endIndex = 3<br />
 *          abzyczydefg
 * @author Matisse
 * 
 */
public class AddDataOverSection extends MorphRule {
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
	public AddDataOverSection(DataNode ruleData, int startIndex, int endIndex) {
		super(ruleData, startIndex, endIndex);
		log.config("start: " + start + " end: " + end);
	}

	@Override
	protected void noteMorph(DataNode input) {
		log.fine("input: " + input);

		// FIXME this only works for 1
		String sb = appendAtInterval(input, 1);
		data.setNoteData(sb);
		log.fine(sb);
	}

	private String appendAtInterval(DataNode input, int interval) {
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

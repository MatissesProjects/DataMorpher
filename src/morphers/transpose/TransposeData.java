package morphers.transpose;

import static structure.GlobalConstants.log;
import mathResources.MathHelper;
import structure.DataNode;
import abstracts.MorphRule;

/**
 * This transpose is to take the data from one segment and move it to another segment.
 * 
 * Note that this does it a bit different that one might initially expect. It takes the segment from
 * begin to end and transposes it to the transposeTo location, the transposeTo location is what is
 * strange, it is including the data being transposed when calculating transposing location.
 * 
 * @author Matisse
 * 
 */
public class TransposeData extends MorphRule {

	int transposeLoc;

	/**
	 * This transpose is to take the data from one segment and move it to another segment of known
	 * location and size.
	 * 
	 * @param ruleData
	 *            - Data for this morph
	 * @param start
	 *            - Starting index for the data to move
	 * @param end
	 *            - End index of the data to move
	 * @param transposeTo
	 *            - Location within the current data to transpose the data selected by {begin,
	 *            end}index
	 */
	public TransposeData(DataNode ruleData, int start, int end, int transposeTo) {
		super(ruleData, start, end);
		transposeLoc = transposeTo;
	}

	/**
	 * This transpose is to take the data from one segment and move it to another segment of unknown
	 * location and size.
	 * 
	 * @param ruleData
	 */
	public TransposeData(DataNode ruleData) {
		super(ruleData, MathHelper.rand.nextInt(1 + ruleData.length() / 4), (ruleData.length() / 4)
				+ MathHelper.rand.nextInt(1 + ruleData.length() / 4));
		transposeLoc = MathHelper.rand.nextInt(data.length());
	}

	/**
	 * This morph is to take data from one location and move it to another.
	 */
	@Override
	protected void noteMorph(DataNode DONT_CARE) {
		DataNode transposedData = new DataNode(data.getRange(start, end));
		DataNode endData = new DataNode();
		DataNode startData = new DataNode(data.getRange(0, start));
		DataNode lastData = new DataNode(data.getRange(Math.max(transposeLoc, end),
				data.length()));

		if (end < transposeLoc) {
			endData.setNoteData(data.getRange(end, transposeLoc));
		}
		data.setNoteData("" + startData + endData + transposedData + lastData);

		log.finest("start: " + start + " end: " + end + " transposeTo: "
				+ transposeLoc + "\ntransposedData: " + transposedData + " startData: " + startData
				+ " endData: " + endData + " lastData: " + lastData);
		log.fine("resulting data:  " + data + "\n\n");
	}
}

package morphers.transpose;

import static structure.currMain.log;
import abstracts.MorpherRule;
import structure.DataNode;
import structure.MathHelper;

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
public class TransposeData extends MorpherRule {

	int beginIndex, endIndex, transposeTo;

	/**
	 * This transpose is to take the data from one segment and move it to another segment of known
	 * location and size.
	 * 
	 * @param ruleData
	 *            - Data for this morph
	 * @param beginIndex
	 *            - Starting index for the data to move
	 * @param endIndex
	 *            - End index of the data to move
	 * @param transposeTo
	 *            - Location within the current data to transpose the data selected by {begin,
	 *            end}index
	 */
	public TransposeData(DataNode ruleData, int beginIndex, int endIndex, int transposeTo) {
		super(ruleData);
		this.endIndex = Math.max(beginIndex, endIndex);
		this.beginIndex = Math.min(beginIndex, endIndex);
		this.transposeTo = transposeTo;
	}

	/**
	 * This transpose is to take the data from one segment and move it to another segment of unknown
	 * location and size.
	 * 
	 * @param ruleData
	 */
	public TransposeData(DataNode ruleData) {
		super(ruleData);
		this.beginIndex = MathHelper.rand.nextInt(1 + data.length() / 4);
		this.endIndex = beginIndex + MathHelper.rand.nextInt(1 + data.length() / 4);
		this.transposeTo = MathHelper.rand.nextInt(data.length());

		this.endIndex = Math.max(beginIndex, endIndex);
		this.beginIndex = Math.min(beginIndex, endIndex);

	}

	/**
	 * This morph is to take data from one location and move it to another.
	 */
	@Override
	protected void noteMorph(DataNode DONT_CARE) {
		DataNode transposedData = new DataNode(data.getRange(beginIndex, endIndex));
		DataNode endData = new DataNode();
		DataNode startData = new DataNode(data.getRange(0, beginIndex));
		DataNode lastData = new DataNode(data.getRange(Math.max(transposeTo, endIndex),
				data.length()));

		if (endIndex < transposeTo) {
			endData.setNoteData(data.getRange(endIndex, transposeTo));
		}
		data.setNoteData("" + startData + endData + transposedData + lastData);
		
		log.finest("beginIndex: " + beginIndex + " endIndex: " + endIndex + " transposeTo: "
				+ transposeTo + "\ntransposedData: " + transposedData + " startData: " + startData
				+ " endData: " + endData + " lastData: " + lastData);
		log.fine("resulting data:  " + data + "\n\n");
	}
}

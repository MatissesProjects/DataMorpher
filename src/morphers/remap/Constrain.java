package morphers.remap;

import structure.DataNode;
import structure.MathHelper;
import abstracts.MorphRule;

/**
 * Constrains the data given to a range of min to max.
 * 
 * @Example initial: abcdefghi <br />
 *          min = 'b'<br />
 *          max = 'g'<br />
 *          result: bbcdefggg
 * @author Matisse
 * 
 */
public class Constrain extends MorphRule {

	int min, max;

	public Constrain(DataNode ruleData, int min, int max) {
		super(ruleData);
		this.max = max;
		this.min = min;
	}

	@Override
	protected void noteMorph(DataNode input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length(); ++i) {
			sb.append((char) MathHelper.constrain(data.get(i), min, max));
		}
		data.setNoteData(sb.toString());
	}

}

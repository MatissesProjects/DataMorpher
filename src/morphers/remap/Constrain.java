package morphers.remap;

import mathResources.MathHelper;
import structure.DataNode;
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
		this(ruleData, min, max, MathHelper.rand.nextInt(1 + ruleData.length() / 4), (ruleData
				.length() / 4) + MathHelper.rand.nextInt(1 + ruleData.length() / 4));
	}

	public Constrain(DataNode ruleData, int min, int max, int startIndex, int endIndex) {
		super(ruleData, startIndex, endIndex);
		this.max = max;
		this.min = min;
//		System.out.println("min: " + min + " max: " + max + " " + startIndex + " " + endIndex);
	}

	@Override
	protected void noteMorph(DataNode input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length(); ++i) {
			sb.append((char) MathHelper.constrain(data.charAt(i), min, max));
		}
		data.setNoteData(sb.toString());
	}

}

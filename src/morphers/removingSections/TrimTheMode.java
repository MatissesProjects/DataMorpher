package morphers.removingSections;

import static structure.GlobalConstants.log;
import static structure.GlobalConstants.MIN_STRING_SIZE;
import static structure.GlobalConstants.STRING_REPLACED_TO_SHORT;

import java.util.Map;

import mathResources.MathHelper;
import structure.DataNode;
import abstracts.MorphRule;

/**
 * Takes the number of separate tokens and sums them, finding the greatest one (not caring about who
 * it is next to) and makes it so there is only 1 in a row instead of 2+
 * 
 * so abbabbddg removing: b trimming: b Results in ababddg
 * 
 * @author Matisse
 * 
 */
public class TrimTheMode extends MorphRule {
	Map<Character, Integer> countMap;

	/**
	 * Finds the mode of the data passed in and replaces every occurance with
	 * 
	 * @param ruleData
	 *            - Data for this morph
	 */
	public TrimTheMode(DataNode ruleData) {
		super(ruleData, MathHelper.rand.nextInt(1 + ruleData.length() / 4), (ruleData.length() / 4)
				+ MathHelper.rand.nextInt(1 + ruleData.length() / 4));
		countMap = MathHelper.populateCountMap(data);
	}

	@Override
	protected void noteMorph(DataNode DONT_CARE) {
		DataNode toTrim = MathHelper.getTokenToTrim(countMap);
		log.fine("trimming: " + toTrim);
		// toTrim+ = the regex 1 or more
		data.replaceAll(toTrim + "+", toTrim + "");
		if (data.length() < MIN_STRING_SIZE) {
			data.add(new DataNode(STRING_REPLACED_TO_SHORT));
		}
	}
}

package morphers.removingSections;

import static structure.currMain.log;

import java.util.HashMap;
import java.util.Map;

import structure.DataNode;

import abstracts.MorpherRule;

/**
 * Takes the number of separate tokens and sums them, finding the greatest one (not caring about who
 * it is next to) and makes it so there is only 1 in a row instead of 2+
 * 
 * so abbabbddg removing: b trimming: b Results in ababddg
 * 
 * @author Matisse
 * 
 */
public class TrimTheMode extends MorpherRule {

	private static final String STRING_REPLACED_TO_SHORT = "abcd";
	Map<Character, Integer> countMap;

	/**
	 * Finds the mode of the data passed in and replaces every occurance with
	 * 
	 * @param ruleData
	 *            - Data for this morph
	 */
	public TrimTheMode(DataNode ruleData) {
		super(ruleData);
		populateCountMap();
	}

	/**
	 * this takes a class map and fills it with the number of each occurance of each token. abcaa #
	 * of {a=3, b=1, c= 1}
	 */
	public void populateCountMap() {
		countMap = new HashMap<Character, Integer>();
		for (Character ch : data.getNoteData().toCharArray()) {
			if (countMap.containsKey(ch))
				countMap.put(ch, (countMap.get(ch) + 1));
			else
				countMap.put(ch, 1);
		}
		log.fine("countMap: " + countMap);
	}

	/**
	 * @return the most often occurring character within the string
	 */
	public char getTokenToTrim() {
		char returner = '!';// = new Character('!');
		int currMax = -1;
		for (Character ch : countMap.keySet()) {
			if (countMap.get(ch) > currMax) {
				currMax = countMap.get(ch);
				returner = ch;
			}
		}
		log.fine("returner: " + returner);
		return returner;
	}

	@Override
	protected void noteMorph(DataNode DONT_CARE) {
		char toTrim = getTokenToTrim();
		log.fine("trimming: " + toTrim);
		// toTrim+ = the regex 1 or more
		data.replaceAll((toTrim + "+"), toTrim + "");
		if (data.length() < 4)
			data.add(new DataNode(STRING_REPLACED_TO_SHORT));
	}
}

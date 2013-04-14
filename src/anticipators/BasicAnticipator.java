package anticipators;

import static structure.GlobalConstants.log;

import java.util.HashMap;
import java.util.Map;

import morphers.removingSections.TrimTheMode;
import structure.DataNode;
import abstracts.MorphRule;

public class BasicAnticipator extends MorphRule {

	Map<Character, Integer> countMap;

	public BasicAnticipator(DataNode ruleData, int startIndex, int endIndex) {
		super(ruleData, startIndex, endIndex);
	}

	public void populateCountMap() {
		countMap = new HashMap<Character, Integer>();
		for (int i = 0; i < end - start + 1; ++i) {
			Character ch = data.charAt(i);
			if (countMap.containsKey(ch)) {
				countMap.put(ch, countMap.get(ch) + 1);
			} else {
				countMap.put(ch, 1);
			}
		}
		log.fine("countMap: " + countMap);
	}

	/**
	 * @return the most often occurring character within the string
	 */
	public Character getTokenToTrim() {
		Character returner = new Character('!');
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
	protected void noteMorph(DataNode input) {
		// char toRemove = getTokenToTrim();
		TrimTheMode trimmer = new TrimTheMode(new DataNode(data.getRange(start, end)));
		trimmer.morph(null);
		data.setNoteData(trimmer.data.getNoteData());
		System.out.println("\t\t " + data);
	}

}

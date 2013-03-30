package morphers.removingSections;

import static structure.currMain.log;
import structure.DataNode;
import abstracts.MorpherRule;

/**
 * Remove all of a data token, for example
 * 
 * @Example1 initial: abcaefaei<br />
 *           remove: a<br />
 *           result: bcefei
 * @Example2 initial: abcaefaei<br />
 *           remove: ae<br />
 *           result: abcfi
 * @Example3 initial abcaefaei<br />
 *           remove: cf<br />
 *           result: abcaefaei
 * 
 * @author Matisse
 * 
 */
public class RemoveAllOfDataToken extends MorpherRule {

	/**
	 * Useful for removing an artifact or something that doesnt seem to fit nicely, that is easy to
	 * describe within a NoteData, data_type
	 * 
	 * @Note It is possible to create a delete that doesn't actually delete, this is the case in
	 *       example 3, when the pattern does not exist
	 * 
	 * @param ruleData
	 *            - Data for this morph
	 */
	public RemoveAllOfDataToken(DataNode ruleData) {
		super(ruleData);
	}

	/**
	 * Simple morph which takes the pattern given and looks for it within the data using the regex
	 * replaceAll
	 */
	@Override
	protected void noteMorph(DataNode dataToRemove) {
		data.removeAll(dataToRemove);
		if (data.length() < 4)
			data.add(new DataNode("abcd"));
		log.fine("dataToRemove: " + dataToRemove);
	}

}

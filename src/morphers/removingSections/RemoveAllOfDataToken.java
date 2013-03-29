package morphers.removingSections;

import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;
import structure.currMain;

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
public class RemoveAllOfDataToken extends NoteMorpherRule {

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
	public RemoveAllOfDataToken(NoteData ruleData) {
		super(ruleData);
	}

	/**
	 * Simple morph which takes the pattern given and looks for it within the data using the regex
	 * replaceAll
	 */
	@Override
	protected void noteMorph(NoteData dataToRemove) {
		data.removeAll(dataToRemove);
		if (data.length() < 4)
			data.add(new NoteData("abcd"));
		if (currMain.VERBOSE)
			System.out.println("dataToRemove: " + dataToRemove);
	}

}

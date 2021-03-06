package abstracts;

import static structure.GlobalConstants.log;
import interfaces.Morpher;

/**
 * A rule is something that has an identifier and holds some kind of data, the identifier could be
 * something like a character, and the data could be something like the expanded string meaning of
 * that single character
 * 
 * @author Matisse
 * 
 */
public abstract class Rule<T> implements Morpher<T> {
	/**
	 * data is the information contained within this rule
	 */
	public T data;
	/**
	 * usage state of this object
	 */
	private boolean morphHasOccured;
	/**
	 * Beginning and end of to morph, this allows the data to be sent and only a portion of it to be
	 * changed by the morph
	 */
	protected int start, end;

	/**
	 * Abstract Rule, this is the idea that there is a rule to change something like F -> f+S
	 * 
	 * @param ident
	 *            - identifier
	 * @param startIndex
	 *            - Beginning for this morph
	 * @param endIndex
	 *            - Ending for this morph
	 * @param ruleData
	 *            - Data
	 */
	public Rule(T ruleData, int startIndex, int endIndex) {
		data = ruleData;
		start = Math.min(startIndex, endIndex);
		end = Math.max(startIndex, endIndex);
		morphHasOccured = false;
		log.finest("data: " + data);
	}

	/**
	 * Morph is the abstract concept that we want to enact. It will, in some way or another morph
	 * the data.
	 * 
	 * @param morpher
	 */
	@Override
	public void morph(T input) {
		morphHasOccured = true;
		log.finest("input: " + input);
	}

	/**
	 * if this morph has been done it will be true, if it has not, it will still be false
	 * 
	 * @return morphHasOccured
	 */
	public boolean morphHasOccured() {
		log.finest("Morph has occured");
		return morphHasOccured;
	}

	/**
	 * "Rule: " + className + " Meaning: " + data;
	 */
	@Override
	public String toString() {
		return "Rule: " + getClass().getSimpleName() + "\n\tMeaning: " + data.toString();
	}
}

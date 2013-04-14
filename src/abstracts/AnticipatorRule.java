package abstracts;

import structure.DataNode;

public abstract class AnticipatorRule extends Rule<DataNode> {

	/**
	 * 
	 * @param ruleData
	 * @param startIndex
	 *            - Beginning for this morph
	 * @param endIndex
	 *            - Ending for this morph
	 */
	public AnticipatorRule(DataNode ruleData, int startIndex, int endIndex) {
		super(ruleData, startIndex, endIndex);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This is the generic base morph method, we have redefined it here to call our base noteMorph,
	 * which is defined by which
	 */
	@Override
	public void morph(DataNode input) {
		super.morph(input);
		anticipate();
	}

	/**
	 * This is an anticipation, called from morph, its idea is something like making the morphing
	 * building blocks into a stronger and better concept. This is done by either changing the morph
	 * call slightly or by adding some sort of intelligence for choosing the next morph or something
	 * along those lines.
	 */
	public abstract void anticipate();
}

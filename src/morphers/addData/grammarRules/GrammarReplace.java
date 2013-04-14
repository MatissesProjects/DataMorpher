package morphers.addData.grammarRules;

import static structure.GlobalConstants.log;
import mathResources.MathHelper;
import structure.DataNode;
import abstracts.MorphRule;

/**
 * Context free grammar type rule. This should allow for things like a -> bde <br />
 * <br />
 * Interesting note, this is able to be the same as an L-System! L-Systems are very interesting in
 * their capability to describe growth, usually shown with plants. If this sounds interesting I
 * HIGHLY recommend you check this out, it's one of the inspirations behind this project!
 * 
 * @Example rule:c->zim<br />
 *          initial=abcdefg<br />
 *          result=abzimdefg
 * @author Matisse
 */
public class GrammarReplace extends MorphRule {

	GrammarRule rule;

	/**
	 * 
	 * @param ruleData
	 * @param replacementStr
	 */
	public GrammarReplace(DataNode ruleData, String replacementStr, int startIndex, int endIndex) {
		super(ruleData, startIndex, endIndex);
		char toReplace = replacementStr.charAt(MathHelper.rand.nextInt(replacementStr.length()));
		rule = new GrammarRule(toReplace + "", replacementStr);
		log.fine("toReplace: " + toReplace);
		log.fine("replacementStr: " + replacementStr);
	}

	public GrammarReplace(DataNode ruleData, String replacementStr) {
		this(ruleData, replacementStr, MathHelper.rand.nextInt(1 + ruleData.length() / 4),
				(ruleData.length() / 4) + MathHelper.rand.nextInt(1 + ruleData.length() / 4));
	}

	/**
	 * With all known paramaters <br />
	 * this allows toReplace not to be within the replacement, however it may if you choose
	 * 
	 * 
	 * @param ruleData
	 * @param toReplace
	 * @param replacementStr
	 */
	public GrammarReplace(DataNode ruleData, String toReplace, String replacementStr,
			int startIndex, int endIndex) {
		super(ruleData, startIndex, endIndex);
		rule = new GrammarRule(toReplace, replacementStr);
		log.fine("toReplace: " + toReplace);
		log.fine("replacementStr: " + replacementStr);
	}

	public GrammarReplace(DataNode ruleData, String toReplace, String replacementStr) {
		this(ruleData, toReplace, replacementStr, MathHelper.rand.nextInt(1 + ruleData
				.length() / 4), (ruleData.length() / 4)
				+ MathHelper.rand.nextInt(1 + ruleData.length() / 4));
	}

	@Override
	protected void noteMorph(DataNode DONT_CARE) {
		log.finer(rule.getToReplace() + " :: " + rule.getReplacementStr());
		data.replaceAll(rule);
	}
}

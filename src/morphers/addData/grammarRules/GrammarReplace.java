package morphers.addData.grammarRules;

import static structure.currMain.log;
import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;

/**
 * Context free grammar type rule. This should allow for things like a -> bde
 * 
 * @Example rule:c->zim, initial=abcdefg, result=abzimdefg
 * @author Matisse
 * 
 */
public class GrammarReplace extends NoteMorpherRule {

	GrammarRule rule;

	public GrammarReplace(NoteData ruleData, String toReplace, String replacementStr) {
		super(ruleData);
		rule = new GrammarRule(toReplace, replacementStr);
		log.fine("toReplace: " + toReplace);
		log.fine("replacementStr: " + replacementStr);
	}

	@Override
	protected void noteMorph(NoteData DONT_CARE) {
		// System.out.println(rule.getToReplace() + " :: " + rule.getReplacementStr());
		data.replaceAll(rule.getToReplace(), rule.getReplacementStr());
	}
}

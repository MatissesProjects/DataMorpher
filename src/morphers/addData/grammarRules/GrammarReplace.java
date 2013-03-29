package morphers.addData.grammarRules;

import noteStuff.NoteData;
import noteStuff.NoteMorpherRule;
import structure.currMain;

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
		if (currMain.VERBOSE) {
			System.out.println("toReplace: " + toReplace);
			System.out.println("replacementStr: " + replacementStr);
		}
	}

	@Override
	protected void noteMorph(NoteData DONT_CARE) {
		// System.out.println(rule.getToReplace() + " :: " + rule.getReplacementStr());
		data.replaceAll(rule.getToReplace(), rule.getReplacementStr());
	}
}

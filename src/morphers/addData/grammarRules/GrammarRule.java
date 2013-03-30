package morphers.addData.grammarRules;

public class GrammarRule {
	private final String toReplace, replacementStr;

	public GrammarRule(String toReplace, String replacementStr) {
		this.toReplace = toReplace;
		this.replacementStr = replacementStr;
	}

	public String getToReplace() {
		return toReplace;
	}

	public String getReplacementStr() {
		return replacementStr;
	}
}

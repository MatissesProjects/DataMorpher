package noteStuff;

/**
 * This contains the rules for the note morph concepts
 * 
 * @author Matisse
 * 
 */
public abstract class NoteMorpherRule extends NoteRule {

	public NoteMorpherRule(NoteData ruleData) {
		super(ruleData);
	}

	/**
	 * This is the generic base morph method, we have redefined it here to call
	 * our base noteMorph, which is defined by which
	 */
	@Override
	public void morph(NoteData input) {
		super.morph(input);
		noteMorph(input);
	}

	/**
	 * Abstract noteMorph, this is what we call to do an actual notemorph
	 * 
	 * @param inputStr
	 */
	protected abstract void noteMorph(NoteData input);
}

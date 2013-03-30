package noteStuff;

import abstracts.Rule;

/**
 * This class defines what a note means in respect to a rule.
 * 
 * It takes the concept rule and makes it a concrete type
 * 
 * @author Matisse
 * 
 */
public abstract class NoteRule extends Rule<NoteData> {
	// This will be used at some point, so don't get rid of it
	// private String[] notesInRange;

	/**
	 * This constructor uses the default note range, which includes all possible notes
	 * 
	 * @param noteData
	 *            - Data for this rule, this is set in a higher super class.
	 */
	public NoteRule(NoteData noteData) {
		super(noteData);
		// notesInRange = // Default value assigned
		// new String[] { "Cb", "Gb", "Db", "Ab", "Eb", "Bb", "G#", "D#", "A#", "F#", "C#", "C",
		// "D",
		// "E", "F", "G", "A", "B", "R" };
	}

	/**
	 * Create a noteRule with new noteRange data, this could be useful for something like an
	 * instrument that only plays a specific subset of notes of the total notes, so instead of
	 * allowing them all, only allow what you need
	 * 
	 * @param ruleData
	 * @param noteRange
	 */
	public NoteRule(NoteData ruleData, String[] noteRange) {
		super(ruleData);
		// notesInRange = noteRange;
	}

	/**
	 * This is the idea of a morph() for a character and a string. This is the shell method that
	 * gets called, for now it is giving extra info
	 * 
	 * New rules and morphs could potentially be added to this level
	 */
	@Override
	public void morph(NoteData input) {
		super.morph(input);
	}
}

package enums;

import static mathResources.MathHelper.rand;

/**
 * There are the types of morphs that exist within this system.
 * 
 * @author Matisse
 * 
 */
public enum MorphType {
	/**
	 * Add your data to the start of the current data
	 */
	AddToStart,
	/**
	 * Add your data to the end of the current data
	 */
	AddToEnd,
	/**
	 * Takes data and shifts a subset of it by the magnitude
	 * 
	 * @Example initial = abcdefghi<br>
	 *          start = 1<br>
	 *          end = 3<br>
	 *          magnitude = 2<br>
	 *          newData = adedefghi
	 * 
	 */
	ShiftDataToTheMag,
	/**
	 * Takes the rule data and deletes a segment from start to end.
	 */
	DeleteSegment,
	/**
	 * This takes the data a start and an end and store it into toshuffle. While adding the data
	 * back it randomly selects from the "toshuffle" data and writes the data then deletes it from a
	 * separate list that starts = to toshuffle, but gets its components removed from. The selection
	 * process continues from toshuffle, if the item is not found in the separate data it is
	 * ignored. This is done until the separate data is empty
	 */
	ShuffleWithRepeatUsingAll,
	/**
	 * This takes the current data, from start to end, shuffles it
	 * 
	 * @Example abcdefg <br />
	 *          start: 2 <br />
	 *          end: 4 <br />
	 *          abdecfg
	 */
	ShuffleNoRepeat,
	/**
	 * This is a shuffle that goes from the start of the data to the end and randomly chooses which
	 * data to put into the result, it can have repeats, and doesn't need to use all data given (and
	 * will probably not)
	 * 
	 * @Example initialData = adcbdehb <br />
	 *          start:2<br />
	 *          end:6<br />
	 *          adeedebdb
	 */
	ShuffleWithRepeat,
	/**
	 * This is an example of a note morphing rule.
	 * 
	 * It takes a character to identify it, and some ruleData it then takes this ruleData and
	 */
	AddToRandLoc,
	/**
	 * Takes a segment of data and flips it around
	 * 
	 * @Example abcdefg start: 1 end: 4 aedcbfg
	 */
	FlipSegment,
	/**
	 * This transpose is to take the data from one segment and move it to another segment.
	 * 
	 * Note that this does it a bit different that one might initially expect. It takes the segment
	 * from begin to end and transposes it to the transposeTo location, the transposeTo location is
	 * what is strange, it is including the data being transposed when calculating transposing
	 * location.
	 */
	TransposeData,
	/**
	 * Takes the number of separate tokens and sums them, finding the greatest one (not caring about
	 * who it is next to) and makes it so there is only 1 in a row instead of 2+
	 * 
	 * so abbabbddg removing: b trimming: b Results in ababddg
	 */
	TrimTheMode,
	/**
	 * Context free grammar type rule. This should allow for things like a -> bde <br />
	 * <br />
	 * Interesting note, this is able to be the same as an L-System! L-Systems are very interesting
	 * in their capability to describe growth, usually shown with plants. If this sounds interesting
	 * I HIGHLY recommend you check this out, it's one of the inspirations behind this project!
	 * 
	 * @Example rule:c->zim<br />
	 *          initial=abcdefg<br />
	 *          result=abzimdefg
	 */
	GrammarReplace,
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
	 */
	RemoveAllOfDataToken,
	/**
	 * This takes the data from startIndex to endIndex and smooths it. (assuming start = 0, end =
	 * length) So if the data was acegi, the result would be abcdefghi. (assuming start = 0, end =
	 * length) If you entered abefi you would get abcefgi
	 */
	BasicSmooth,
	/**
	 * This takes the data and from start to end it sorts the data
	 * 
	 * @Example init: abefcgdhi <br />
	 *          start: 2 <br />
	 *          end: length <br />
	 *          result: abcdefghi
	 */
	Sort,
	/**
	 * Something like a paintbrush
	 * 
	 * @Example abcdefg<br>
	 *          with inputdata = 'zy'<br>
	 *          startIndex = 1<br>
	 *          endIndex = 3<br>
	 *          abzyczydefg
	 */
	AddDataOverSection,
	/**
	 * Should take a data and a start index, end index, and an insertion zone. It should then
	 * attempt to smooth from the start end to the inserted data (not smoothing the inserted data)
	 */
	Gradient,
	/**
	 * Constrains a the data within a range
	 */
	Constrain,
	/**
	 * Remaps the data from one number space to another ie (1-100 to 1-10)
	 */
	Remap,
	// /**
	// * This should set the value into a circular range, so if a number drops off either side it is
	// * then picked back up on the other. For example 'a' - 2 = 'y' and bottom limits
	// */
	// CircularRemap,
	/**
	 * This is the answer to the null pointer error, lets just pass up a null morph
	 */
	NullMorph;

	/**
	 * Get one of these morphers at random
	 * 
	 * @return a random MorphType
	 */
	public static MorphType getRandomMorpher() {
		return values()[rand.nextInt(values().length)];
	}
}

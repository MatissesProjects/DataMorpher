package enums;

import static structure.MathHelper.rand;;

public enum MorpherType {
	AddToStart, AddToEnd, ShiftDataToTheMag, DeleteSegment, ShuffleWithRepeatUsingAll,
	ShuffleNoRepeat, ShuffleWithRepeat, AddToRandLoc, FlipSegment, TransposeData, TrimTheMode,
	GrammarReplace, RemoveAllOfDataToken, BasicSmooth, Sort, BetterSmooth, AddDataOverSection,
	Gradient, NullMorph;

	public static MorpherType getMorpher(int i) {
		if (i < 0 || i >= values().length)
			return TransposeData;
		return values()[i];
	}

	public static MorpherType getRandomMorpher() {
		return getMorpher(rand.nextInt(values().length));
	}
}

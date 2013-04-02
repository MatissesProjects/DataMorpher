package enums;

import static structure.MathHelper.rand;

public enum MorphType {
	AddToStart, AddToEnd, ShiftDataToTheMag, DeleteSegment, ShuffleWithRepeatUsingAll,
	ShuffleNoRepeat, ShuffleWithRepeat, AddToRandLoc, FlipSegment, TransposeData, TrimTheMode,
	GrammarReplace, RemoveAllOfDataToken, BasicSmooth, Sort, BetterSmooth, AddDataOverSection,
	Gradient, NullMorph;

	public static MorphType getMorpher(int i) {
		if (i < 0 || i >= values().length)
			return NullMorph;
		return values()[i];
	}

	public static MorphType getRandomMorpher() {
		return getMorpher(rand.nextInt(values().length));
	}
}

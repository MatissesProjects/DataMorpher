package structure;

import static structure.MathHelper.rand;
import morphers.addData.addToLoc.AddDataOverSection;
import morphers.addData.addToLoc.AddToEnd;
import morphers.addData.addToLoc.AddToRandLoc;
import morphers.addData.addToLoc.AddToStart;
import morphers.addData.grammarRules.GrammarReplace;
import morphers.addData.smooth.BasicSmooth;
import morphers.addData.smooth.BetterSmooth;
import morphers.addData.smooth.Sort;
import morphers.removingSections.DeleteSegment;
import morphers.removingSections.RemoveAllOfDataToken;
import morphers.removingSections.TrimTheMode;
import morphers.transpose.FlipSegment;
import morphers.transpose.ShiftDataToTheMag;
import morphers.transpose.TransposeData;
import morphers.transpose.shuffle.ShuffleNoRepeat;
import morphers.transpose.shuffle.ShuffleWithRepeat;
import morphers.transpose.shuffle.ShuffleWithRepeatUsingAll;
import noteStuff.NoteData;
import noteStuff.NoteRule;

import noteStuff.NoteMorpherRule;
import anticipators.Gradient;

public class currMain {
	private final static int TOTAL_MORPHERS = 18;

	public final static boolean VERBOSE = false, DEBUG = true;

	private final static int[] runs = { 1, 3, 3, 3, 3, 3, 3, 3, 1 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		doRandomMorphs();
//		doSetMorphs();
		
		// for (int i = 0; i < 1000; ++i) {
		// doRandomMorphs();
		// if (DEBUG)
		// System.out.println("\n---------------------------------------\n");
		// }
		// System.out.println("No Errors!");
	}

	private static NoteRule doRandomMorphs() {
//		String initData = "abcdefghi";
		
		String initData = "sorahavok";
		
		NoteData initialNoteData = new NoteData(initData);
		NoteRule morphingRule = doRandomMorph(initialNoteData,
				new NoteData(getRandSet(initData, 3)));
		for (int i = 0; i < TOTAL_MORPHERS; ++i)
			morphingRule = doRandomMorph(morphingRule.data,
					new NoteData(getRandSet(initData, rand.nextInt(3))));
		morphingRule = morphData(new TrimTheMode(morphingRule.data),
				new NoteData(getRandSet(initData, 3)));
		return morphingRule;
	}

	private static NoteRule doSetMorphs() {
		String initData = "abcdefghi";
		NoteData initialNoteData = new NoteData(initData);
		NoteRule morphingRule = doMorph(initialNoteData,
				new NoteData(getRandSet(initData, 3)), 0);
		for (int i : runs)
			morphingRule = doMorph(morphingRule.data,
					new NoteData(getRandSet(initData, rand.nextInt(3))), i);
		morphingRule = morphData(new TrimTheMode(morphingRule.data),
				new NoteData(getRandSet(initData, 3)));
		return morphingRule;
	}

	private static String getRandSet(String seedData, int amount) {
		if (amount <= 1)
			return seedData.charAt(rand.nextInt(seedData.length())) + "";
		return seedData.charAt(rand.nextInt(seedData.length())) + getRandSet(seedData, amount - 1);
	}

	private static NoteRule morphData(NoteRule morpher, NoteData dataForMorph) {
		morpher.morph(dataForMorph);
		if (DEBUG)
			System.out.println(morpher);
		return morpher;
	}

	private static NoteRule doMorph(NoteData noteData, NoteData toAdd, int i) {
		return morphData(getMorph(i, noteData), toAdd);
	}

	private static NoteRule doRandomMorph(NoteData noteData, NoteData toAdd) {
		return morphData(getMorph(rand.nextInt(TOTAL_MORPHERS), noteData), toAdd);
	}

	private static NoteMorpherRule getMorph(int nextInt, NoteData noteData) {
		int first = rand.nextInt((noteData.length() / 4) + 1);
		int second = 1 + first + rand.nextInt((noteData.length() / 2) + 1);
		switch (nextInt) {
		case 0:
			return new AddToStart(noteData);
		case 1:
			return new AddToEnd(noteData);
		case 2:
			return new ShiftDataToTheMag(noteData);
		case 3:
			return new DeleteSegment(noteData);
		case 4:
			return new ShuffleWithRepeatUsingAll(noteData, first, second);
		case 5:
			return new ShuffleNoRepeat(noteData, first, second);
		case 6:
			return new ShuffleWithRepeat(noteData, first, second);
		case 7:
			return new AddToRandLoc(noteData);
		case 8:
			return new FlipSegment(noteData);
		case 9:
			return new TransposeData(noteData);
		case 10:
			return new TrimTheMode(noteData);
		case 11:
			return new GrammarReplace(noteData, getRandSet(noteData.getNoteData(), 1), getRandSet(
					noteData.getNoteData(), rand.nextInt(3)));
		case 12:
			return new RemoveAllOfDataToken(noteData);
		case 13:
			return new BasicSmooth(noteData);
		case 14:
			return new Sort(noteData, first, second);
		case 15:
			return new BetterSmooth(noteData);
		case 16:
			return new AddDataOverSection(noteData, first, second);
		case 17:
			return new Gradient(noteData, first, second);
		default:
			System.out.println("Do nothing this time");
			return null;
		}
	}
}

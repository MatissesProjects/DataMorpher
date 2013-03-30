package structure;

import static structure.currMain.log;
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
import noteStuff.NoteMorpherRule;
import noteStuff.NoteRule;
import anticipators.Gradient;

public class GetMorpher {

	private final static int TOTAL_MORPHERS = 18, MAX_MORPH_DATA = 3;

	private final static int[] runs = { 1, 3, 3, 3, 3, 3, 3, 3, 1 };
	String initData = "abcdefghi";

	public GetMorpher(String initData) {
		this.initData = initData;
	}

	private NoteMorpherRule getMorph(int nextInt, NoteData noteData) {
		int first = rand.nextInt((noteData.length() / 4) + 1);
		int second = 1 + first + rand.nextInt((noteData.length() / 2) + 1);
		log.info("Number for morph occurance: " + nextInt);
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
			log.info("no morph occured");
			return null;
		}
	}

	public NoteRule doRandomMorphs() {
		log.info("Initial Data: " + initData);
		NoteData initialNoteData = new NoteData(initData);
		NoteRule morphingRule = doRandomMorph(initialNoteData,
				new NoteData(getRandSet(initData, 3)));
		for (int i = 0; i < TOTAL_MORPHERS; ++i)
			morphingRule = doRandomMorph(morphingRule.data,
					new NoteData(getRandSet(initData, rand.nextInt(MAX_MORPH_DATA))));
		return morphingRule;
	}

	public NoteRule doSetMorphs() {
		log.info("Initial Data: " + initData);
		NoteData initialNoteData = new NoteData(initData);
		NoteRule morphingRule = doMorph(initialNoteData, new NoteData(getRandSet(initData, 3)), 0);
		for (int i : runs)
			morphingRule = doMorph(morphingRule.data,
					new NoteData(getRandSet(initData, rand.nextInt(3))), i);
		morphingRule = morphData(new TrimTheMode(morphingRule.data),
				new NoteData(getRandSet(initData, 3)));
		return morphingRule;
	}

	private String getRandSet(String seedData, int amount) {
		if (amount <= 1)
			return seedData.charAt(rand.nextInt(seedData.length())) + "";
		return seedData.charAt(rand.nextInt(seedData.length())) + getRandSet(seedData, amount - 1);
	}

	private NoteRule morphData(NoteRule morpher, NoteData dataForMorph) {
		morpher.morph(dataForMorph);
		System.out.println(morpher);
		return morpher;
	}

	private NoteRule doMorph(NoteData noteData, NoteData toAdd, int i) {
		return morphData(getMorph(i, noteData), toAdd);
	}

	private NoteRule doRandomMorph(NoteData noteData, NoteData toAdd) {
		return morphData(getMorph(rand.nextInt(TOTAL_MORPHERS), noteData), toAdd);
	}
}

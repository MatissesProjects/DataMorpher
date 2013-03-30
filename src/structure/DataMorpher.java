package structure;

import static structure.MathHelper.rand;
import static structure.currMain.log;

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
import morphers.shuffle.ShuffleNoRepeat;
import morphers.shuffle.ShuffleWithRepeat;
import morphers.shuffle.ShuffleWithRepeatUsingAll;
import morphers.transpose.FlipSegment;
import morphers.transpose.ShiftDataToTheMag;
import morphers.transpose.TransposeData;
import abstracts.MorpherRule;
import anticipators.Gradient;

public class DataMorpher {

	private final int TOTAL_MORPHERS = 18, MAX_MORPH_DATA = 3;
	private final int[] runs = { 10, 11, 10 };

	DataNode initData;

	public DataMorpher(String initData) {
		this.initData = new DataNode(initData);
	}

	private MorpherRule getMorph(int nextInt, DataNode noteData) {
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
			return new GrammarReplace(noteData, getRandSet(1),
					getRandSet(1 + rand.nextInt(MAX_MORPH_DATA)));
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

	public MorpherRule doRandomMorphs() {
		// System.out.println("\n\n\n\nInitial Data: " + initData);
		log.info("Initial Data: " + initData);
		MorpherRule morphingRule = doRandomMorph(initData,
				new DataNode(getRandSet(rand.nextInt(MAX_MORPH_DATA))));
		for (int i = 0; i < TOTAL_MORPHERS; ++i) {
			morphingRule = doRandomMorph(morphingRule.data,
					new DataNode(getRandSet(rand.nextInt(MAX_MORPH_DATA))));
			initData = morphingRule.data;
		}
		return morphingRule;
	}

	public MorpherRule doSetMorphs() {
		log.info("Initial Data: " + initData);
		MorpherRule morphingRule = doMorph(initData, new DataNode(getRandSet(3)), 0);
		for (int i : runs)
			morphingRule = doMorph(morphingRule.data,
					new DataNode(getRandSet(rand.nextInt(MAX_MORPH_DATA))), i);
		return morphingRule;
	}

	private String getRandSet(int amount) {
		if (amount <= 1)
			return initData.get(rand.nextInt(initData.length())) + "";
		return initData.get(rand.nextInt(initData.length())) + getRandSet(amount - 1);
	}

	private MorpherRule morphData(MorpherRule morpher, DataNode dataForMorph) {
		morpher.morph(dataForMorph);
		System.out.println(morpher);
		return morpher;
	}

	private MorpherRule doMorph(DataNode noteData, DataNode toAdd, int i) {
		return morphData(getMorph(i, noteData), toAdd);
	}

	private MorpherRule doRandomMorph(DataNode noteData, DataNode toAdd) {
		return morphData(getMorph(rand.nextInt(TOTAL_MORPHERS), noteData), toAdd);
	}
}

package structure;

import static structure.MathHelper.rand;
import static structure.currMain.log;
import morphers.NullMorpher;
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

	public enum DataMorpherTypes {
		AddToStart, AddToEnd, ShiftDataToTheMag, DeleteSegment, ShuffleWithRepeatUsingAll,
		ShuffleNoRepeat, ShuffleWithRepeat, AddToRandLoc, FlipSegment, TransposeData, TrimTheMode,
		GrammarReplace, RemoveAllOfDataToken, BasicSmooth, Sort, BetterSmooth, AddDataOverSection,
		Gradient;

		public static DataMorpherTypes getMorpher(int i) {
			if (i < 0 || i >= values().length)
				return TransposeData;
			return values()[i];
		}

		public static DataMorpherTypes getRandomMorpher() {
			return getMorpher(rand.nextInt(values().length));
		}
	}

	private final int TOTAL_MORPHERS = 18, MAX_MORPH_DATA = 3;
	private final int[] runs = { 10, 8, 10 };

	DataNode initData;

	public DataMorpher(String initData) {
		this.initData = new DataNode(initData);
	}

	private MorpherRule getMorph(DataMorpherTypes nextInt, DataNode noteData) {
		int first = rand.nextInt(noteData.length() / 4 + 1);
		int second = 1 + first + rand.nextInt(noteData.length() / 2 + 1);
		log.finest("Number for morph occurance: " + nextInt);
		switch (nextInt) {
		case AddToStart:
			return new AddToStart(noteData);
		case AddToEnd:
			return new AddToEnd(noteData);
		case ShiftDataToTheMag:
			return new ShiftDataToTheMag(noteData);
		case DeleteSegment:
			return new DeleteSegment(noteData);
		case ShuffleWithRepeatUsingAll:
			return new ShuffleWithRepeatUsingAll(noteData, first, second);
		case ShuffleNoRepeat:
			return new ShuffleNoRepeat(noteData, first, second);
		case ShuffleWithRepeat:
			return new ShuffleWithRepeat(noteData, first, second);
		case AddToRandLoc:
			return new AddToRandLoc(noteData);
		case FlipSegment:
			return new FlipSegment(noteData);
		case TransposeData:
			return new TransposeData(noteData);
		case TrimTheMode:
			return new TrimTheMode(noteData);
		case GrammarReplace:
			return new GrammarReplace(noteData, getRandSet(1),
					getRandSet(1 + rand.nextInt(MAX_MORPH_DATA)));
		case RemoveAllOfDataToken:
			return new RemoveAllOfDataToken(noteData);
		case BasicSmooth:
			return new BasicSmooth(noteData);
		case Sort:
			return new Sort(noteData, first, second);
		case BetterSmooth:
			return new BetterSmooth(noteData);
		case AddDataOverSection:
			return new AddDataOverSection(noteData, first, second);
		case Gradient:
			return new Gradient(noteData, first, second);
		default:
			log.warning("null morph occured");
			return new NullMorpher(noteData);
		}
	}

	/**
	 * This calls upon any one of the morphs that exist within the system so far.
	 * 
	 * @return
	 */
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
		MorpherRule morphingRule = doMorph(initData, new DataNode(getRandSet(MAX_MORPH_DATA)),
				DataMorpherTypes.getMorpher(TOTAL_MORPHERS));
		for (int i : runs) {
			morphingRule = doMorph(morphingRule.data,
					new DataNode(getRandSet(rand.nextInt(MAX_MORPH_DATA))),
					DataMorpherTypes.getMorpher(i));
		}
		return morphingRule;
	}

	private String getRandSet(int amount) {
		if (amount <= 1) {
			return initData.get(rand.nextInt(initData.length())) + "";
		}
		return initData.get(rand.nextInt(initData.length())) + getRandSet(amount - 1);
	}

	private MorpherRule morphData(MorpherRule morpher, DataNode dataForMorph) {
		morpher.morph(dataForMorph);
		log.info(morpher.toString());
		return morpher;
	}

	private MorpherRule doMorph(DataNode noteData, DataNode toAdd, DataMorpherTypes morphType) {
		return morphData(getMorph(morphType, noteData), toAdd);
	}

	private MorpherRule doRandomMorph(DataNode noteData, DataNode toAdd) {
		return doMorph(noteData, toAdd, DataMorpherTypes.getRandomMorpher());
	}
}

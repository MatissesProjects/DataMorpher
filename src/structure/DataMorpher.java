package structure;

import static mathResources.MathHelper.rand;
import static structure.GlobalConstants.log;

import abstracts.MorphRule;
import anticipators.Gradient;

import enums.MorphType;

import interfaces.IDataHolder;

import mathResources.MathHelper;

import morphers.NullMorpher;
import morphers.addData.addToLoc.AddDataOverSection;
import morphers.addData.addToLoc.AddToEnd;
import morphers.addData.addToLoc.AddToRandLoc;
import morphers.addData.addToLoc.AddToStart;
import morphers.addData.grammarRules.GrammarReplace;
import morphers.addData.smooth.BasicSmooth;
import morphers.addData.smooth.Sort;
import morphers.remap.Constrain;
import morphers.remap.Remap;
import morphers.removingSections.DeleteSegment;
import morphers.removingSections.RemoveAllOfDataToken;
import morphers.removingSections.TrimTheMode;
import morphers.shuffle.ShuffleNoRepeat;
import morphers.shuffle.ShuffleWithRepeat;
import morphers.shuffle.ShuffleWithRepeatUsingAll;
import morphers.transpose.FlipSegment;
import morphers.transpose.ShiftDataToTheMag;
import morphers.transpose.TransposeData;

public class DataMorpher {

	private final int MAX_MORPH_DATA = 3;
	// private final int[] runs = { 10, 8, 10 };

	private IDataHolder data;

	// private DataNode data;
	private MorphRule morphingRule;

	/**
	 * This is the object that should be delt with mostly. It is the container to the generic morphs
	 * 
	 * @param initData
	 *            This initial data is shared throughout the the livetime of this object so multiple
	 *            morphs over a long period of time is possible
	 */
	public DataMorpher(String initData) {
		data = new DataNode(initData);
		morphingRule = doMorph((DataNode) data, new DataNode(getRandSet(MAX_MORPH_DATA)),
				MorphType.NullMorph);
	}

	/**
	 * Get the data
	 * 
	 * @return current data contained within this object
	 */
	public IDataHolder getData() {
		return data;
	}

	/**
	 * This calls upon any one of the morphs that exist within the system so far.
	 * 
	 * @return
	 */
	public MorphRule doRandomMorphs(int runs) {
		log.info("Initial Data: " + data);
		for (int i = 0; i < runs; ++i) {
			morphingRule = doRandomMorph(morphingRule.data,
					new DataNode(getRandSet(rand.nextInt(MAX_MORPH_DATA))));
			data = morphingRule.data;
		}
		return morphingRule;
	}

	/**
	 * 
	 * @param morphsToRun
	 *            An array of MorpherType that tells this method what morphs to run
	 * @return
	 */
	public MorphRule doSetMorphs(MorphType[] morphsToRun) {
		log.info("Initial Data: " + data);
		for (MorphType morph : morphsToRun) {
			morphingRule = doMorph(morphingRule.data,
					new DataNode(getRandSet(rand.nextInt(MAX_MORPH_DATA))), morph);
		}
		return morphingRule;
	}

	private MorphRule getMorph(MorphType nextInt, DataNode noteData) {
		int first = rand.nextInt(noteData.length() / 4 + 1);
		int second = 1 + first + rand.nextInt(noteData.length() / 2 + 1);
		char charF = MathHelper.getLowestInRange(new DataNode(noteData.getRange(first, second)))
				.charAt(0), charS = MathHelper.getHighestInRange(
				new DataNode(noteData.getRange(first, second))).charAt(0);
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
			return new BasicSmooth(noteData, first, second);
		case Sort:
			return new Sort(noteData, first, second);
		case AddDataOverSection:
			return new AddDataOverSection(noteData, first, second);
		case Gradient:
			return new Gradient(noteData, first, second);
		case Constrain:
			if (second - first > 3 * data.length() / 4)
				System.out.println("Warning distructive to data!");
			return new Constrain(noteData, charF, charS);
		case Remap:
			if (second - first > 3 * data.length() / 4)
				System.out.println("Warning distructive to data!");
			return new Remap(noteData, charF, charS, first, second);
		case NullMorph:
			return new NullMorpher(noteData);
		default:
			log.warning("null morph occured");
			return new NullMorpher(noteData);
		}
	}

	private String getRandSet(int amount) {
		if (amount <= 1) {
			return data.get(rand.nextInt(data.length())) + "";
		}
		return data.get(rand.nextInt(data.length())) + getRandSet(amount - 1);
	}

	private MorphRule morphData(MorphRule morpher, DataNode dataForMorph) {
		morpher.morph(dataForMorph);
		log.info("(" + dataForMorph.getNoteData() + ")  " + morpher.toString());
		return morpher;
	}

	private MorphRule doMorph(DataNode noteData, DataNode toAdd, MorphType morphType) {
		return morphData(getMorph(morphType, noteData), toAdd);
	}

	private MorphRule doRandomMorph(DataNode noteData, DataNode toAdd) {
		return doMorph(noteData, toAdd, MorphType.getRandomMorpher());
	}
}

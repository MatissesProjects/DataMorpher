//package morphers.remap;
//
//import mathResources.MathHelper;
//import structure.DataNode;
//import static structure.GlobalConstants.log;
//import abstracts.MorphRule;
//
///**
// * 
// * This should set the value into a circular range, so if a number drops off either side it is then
// * picked back up on the other. For example 'a' - 2 = 'y' and bottom limits
// * 
// * @author Matisse
// */
//public class CircularRemap extends MorphRule {
//
//	int top, bottom;
//
//	/**
//	 * 
//	 * @param ruleData
//	 * @param topLimit
//	 *            This is the top bounding limit
//	 * @param bottomLimit
//	 *            This is the bottom bound
//	 * @param startIndex
//	 * @param endIndex
//	 */
//	public CircularRemap(DataNode ruleData, int topLimit, int bottomLimit, int startIndex,
//			int endIndex) {
//		super(ruleData, MathHelper.rand.nextInt(1 + ruleData.length() / 4), (ruleData.length() / 4)
//				+ MathHelper.rand.nextInt(1 + ruleData.length() / 4));
//		top = topLimit;
//		bottom = bottomLimit;
//		start = startIndex;
//		end = endIndex;
//		if (top == bottom)
//			bottom++;
//		log.finest(top + " " + bottom + " " + start + " " + end);
////		System.out.println(top + " " + bottom + " " + start + " " + end);
//	}
//
//	/**
//	 * Constructor for a random start and ending, with known top and bottom limits
//	 * 
//	 * @param ruleData
//	 * @param topLimit
//	 * @param bottomLimit
//	 */
//	public CircularRemap(DataNode ruleData, int topLimit, int bottomLimit) {
//		this(ruleData, topLimit, bottomLimit, MathHelper.rand.nextInt(1 + ruleData.length() / 4),
//				(ruleData.length() / 4) + MathHelper.rand.nextInt(1 + ruleData.length() / 4));
//	}
//
//	@Override
//	protected void noteMorph(DataNode input) {
//		StringBuilder sb = new StringBuilder();
//		sb.append(data.getRange(0, start));
////		System.out.println(sb);
//		// for (int i = start; i < Math.min(end, data.length()); ++i) {
//		sb.append(MathHelper.circularRangeMap(0,
//				data.getRange(start, Math.min(end, data.length())), new DataNode(top + ""),
//				new DataNode(bottom + "")));
////		System.out.println(sb);
//		// }
//		sb.append(data.getRange(end, Math.max(end, data.length())));
//		data.setNoteData(sb.toString());
//	}
//
//}

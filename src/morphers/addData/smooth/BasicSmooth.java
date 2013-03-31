package morphers.addData.smooth;

import static structure.currMain.log;
import structure.DataNode;
import abstracts.MorpherRule;

public class BasicSmooth extends MorpherRule {

	public BasicSmooth(DataNode ruleData) {
		super(ruleData);
	}

	@Override
	protected void noteMorph(DataNode DONT_CARE) {
		StringBuilder sb = new StringBuilder();
		// compares 2 at a time, so -1 to not compare against nothing at end
		for (int i = 0; i < data.length() - 1; ++i) {
			
			
			
			DataNode curData = new DataNode(data.get(i));
			DataNode nextData =  new DataNode(data.get(i + 1));
			
			DataNode aveData = DataNode.average(curData, nextData);
			
			sb.append(curData.getNoteData());
			
			if(!aveData.equals(nextData)){
				sb.append(aveData.getNoteData());
			}
			
			

//			if (curData != nextData) {
//				char cData = (char) ((curData + nextData) / 2);
//				if (sb.toString().charAt(sb.length() - 1) != cData) {
//					sb.append(cData);
//				}
//			}
		}
		sb.append(data.get(data.length() - 1));
		log.fine(sb.toString());
		data.setNoteData(sb.toString());
	}
}

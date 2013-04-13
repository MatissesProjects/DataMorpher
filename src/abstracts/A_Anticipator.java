package abstracts;

import static structure.GlobalConstants.log;

public abstract class A_Anticipator {

	int start, end;

	public A_Anticipator(int startIndex, int endIndex) {
		start = startIndex;
		end = endIndex;
		log.severe("Start: " + start + " End: " + end);

	}

	public abstract void doAnticipation();

}

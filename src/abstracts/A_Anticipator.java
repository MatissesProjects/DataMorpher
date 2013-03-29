package abstracts;

public abstract class A_Anticipator {

	int start, end;

	public A_Anticipator(int startIndex, int endIndex) {
		start = startIndex;
		end = endIndex;
	}

	public abstract void doAnticipation();

}

package noteStuff;

/**
 * Current 'Data' point for the note Rule morphers
 * 
 * @author Matisse
 * 
 */
public class NoteData implements Comparable<NoteData> {
	private String data;
	private int dataLength;

	public NoteData() {
		this("");
	}

	/**
	 * create a noteData, which is a holder of the data we want to be read for
	 * our 'notes'
	 * 
	 * @param data
	 */
	public NoteData(String data) {
		this.data = data;
		dataLength = data.length();
	}

	public NoteData(char c) {
		this(c+"");
	}

	/**
	 * set the data of our dataholder
	 */
	public void setNoteData(String data) {
		this.data = data;
		dataLength = data.length();
	}

	public String getNoteData() {
		return data;
	}

	public int length() {
		return dataLength;
	}

	/**
	 * This takes the current data and adds data and
	 * 
	 * @param data
	 * @return this added to data at end
	 */
	public void add(NoteData addData) {
		setNoteData(data + addData.getNoteData());
	}

	/**
	 * currently just returns the data
	 */
	@Override
	public String toString() {
		return data;
	}

	@Override
	public int compareTo(NoteData other) {
		if (get(0) > other.get(0))
			return 1;// after 1
		if (get(0) < other.get(0))
			return -1;// before -1
		return 0;// equal 0
	}

	public void removeAll(NoteData dataToRemove) {
		replaceAll(dataToRemove.getNoteData(), "");
	}
	
	public void replaceAll(String dataToRemove, String replacement) {
		setNoteData(data.replaceAll(dataToRemove, replacement));
	} 

	public void flip(int start, int end) {
		NoteData pass = new NoteData(new StringBuilder(getRange(start, end)).reverse()
				.toString());
		insertData(start, end, pass);
	}

	public void insertData(int start, int end, NoteData aData) {
		setNoteData(getRange(0, start) //
				+ aData.getNoteData() + //
				getRange(end, length()));
	}

	public char get(int i) {
		return data.charAt(i) ;
	}

	/**
	 * Noninclusive [start, end)
	 * @param start
	 * @param end
	 * @return
	 */
	public String getRange(int start, int end) {
		return data.substring(start, Math.min(end, data.length()));
	}
}

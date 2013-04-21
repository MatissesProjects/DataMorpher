package structure;

import interfaces.IDataHolder;

import java.util.ArrayList;
import java.util.List;

import mathResources.MathHelper;
import morphers.addData.grammarRules.GrammarRule;

/**
 * Current 'Data' point for the note Rule morphers
 * 
 * @author Matisse
 * 
 */
public class DataNode implements Comparable<DataNode>, IDataHolder {
	private String data;
	private int dataLength;

	public DataNode() {
		this("");
	}

	/**
	 * create a noteData, which is a holder of the data we want to be read for our 'notes'
	 * 
	 * @param data
	 */
	public DataNode(String data) {
		this.data = data;
		dataLength = data.length();
	}

	public DataNode(List<DataNode> dataList) {
		this("");
		addAll(dataList);
	}

	public DataNode(char c) {
		this(c + "");
	}

	public DataNode(int i) {
		this(i + "");
	}

	public DataNode(double d) {
		this(d + "");
	}

	/**
	 * set the data of our dataholder
	 */
	public void setNoteData(String data) {
		this.data = data;
		dataLength = data.length();
	}

	/**
	 * set the data of our dataholder
	 */
	public void setNoteData(DataNode setData) {
		this.data = setData.data;
		dataLength = setData.length();
	}

	public String getNoteData() {
		return data;
	}

	/**
	 * This takes the current data and adds data and
	 * 
	 * @param data
	 * @return this added to data at end
	 */
	public void add(DataNode addData) {
		setNoteData(data + addData.getNoteData());
	}

	/**
	 * This takes the current data and adds data and
	 * 
	 * @param data
	 * @return this added to data at end
	 */
	public void add(char addData) {
		setNoteData(data + addData);
	}

	public void removeAll(DataNode dataToRemove) {
		replaceAll(dataToRemove.getNoteData(), "");
	}

	public void replaceAll(GrammarRule rule) {
		setNoteData(data.replaceAll(rule.getToReplace(), rule.getReplacementStr()));
	}

	public void replaceAll(String dataToRemove, String replacement) {
		setNoteData(data.replaceAll(dataToRemove, replacement));
	}

	public void flip(int start, int end) {
		DataNode pass = new DataNode(new StringBuilder(getRange(start, end).data).reverse()
				.toString());
		insertData(start, end, pass);
	}

	public void insertData(int start, int end, DataNode aData) {
		setNoteData(getRange(0, start) //
				+ aData.getNoteData() + //
				getRange(end, length()));
	}

	public char charAt(int i) {
		return get(i).getData().charAt(0);
	}

	/**
	 * Noninclusive [start, end)
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	// public String getRange(int start, int end) {
	// return data.substring(start, Math.min(end, data.length()));
	// }

	public DataNode getRange(int start, int end) {
		return new DataNode(data.substring(start, Math.min(end, data.length())));
	}

	public void addAll(List<DataNode> bag) {
		for (DataNode d : bag)
			add(d);
	}

	public List<DataNode> getRangeList(int start, int end) {
		List<DataNode> ret = new ArrayList<DataNode>(end - start);
		for (int i = start; i < end; ++i) {
			ret.add(new DataNode(data.charAt(i)));
		}
		return ret;
	}

	public static DataNode average(DataNode currData, DataNode nextData) {
		// TODO: fix for non-String
		return new DataNode((char) ((currData.get(0).getData().charAt(0) + nextData.get(0)
				.getData().charAt(0)) / 2));
	}

	private String setRandomData(int num, String currData) {
		if (num <= 0)
			return currData;
		return setRandomData(num - 1, data + MathHelper.rand.nextInt(26));
	}

	@Override
	public int length() {
		return dataLength;
	}

	/**
	 * get data at location
	 * 
	 * @param i
	 * @return
	 */
	@Override
	public IDataHolder get(int i) {
		return new DataNode(data.charAt(i));
	}

	/**
	 * This object is a dataNode, it will respond true
	 * 
	 * @return True, because this is a DataNode
	 */
	@Override
	public boolean isDataNode() {
		return true;
	}

	/**
	 * This object is not a dataNodeHolder, so we return false
	 * 
	 * @return False, not a DataNodeHolder
	 */
	@Override
	public boolean isDataNodeHolder() {
		return false;
	}

	/**
	 * This will return the data within this Node
	 */
	@Override
	public String getData() {
		return data;
	}

	@Override
	public void setRandomData() {
		int length = 3 + MathHelper.rand.nextInt(7);
		data = setRandomData(length, data);
	}

	@Override
	public void setData(IDataHolder data) {
		this.data = data.getData();
	}

	/**
	 * currently just returns the data
	 */
	@Override
	public String toString() {
		return data;
	}

	@Override
	public int compareTo(DataNode other) {
		if (charAt(0) > other.charAt(0)) {
			return 1;// after 1
		}
		if (charAt(0) < other.charAt(0)) {
			return -1;// before -1
		}
		return 0;// equal 0
	}

	@Override
	public int value() {
		// if we have a value assigned to us, return that one, otherwise lets calculate a value
		// if (valueSet)
		// return value;
		int ret = 0;
		for (Character ch : data.toCharArray()) {
			if (ch >= '0' || ch <= '9') {
				ret += ch - '0';
				// System.out.println((ch - '0'));
			}
			ret += ch;
		}
		return ret / data.length();
	}
}

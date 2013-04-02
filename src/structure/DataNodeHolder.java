package structure;

import interfaces.IDataHolder;

import java.util.ArrayList;
import java.util.List;

public class DataNodeHolder implements IDataHolder {

	List<IDataHolder> dataNodes = new ArrayList<>();

	/**
	 * This is basically like adding an empty new folder into a directory
	 */
	public DataNodeHolder() {
	}

	/**
	 * Create a holder with something in it
	 * 
	 * @param addData
	 */
	public DataNodeHolder(IDataHolder addData) {
		add(addData);
	}

	/**
	 * Create a holder with multiple things in it
	 * 
	 * @param addDataArray
	 */
	public DataNodeHolder(IDataHolder[] addDataArray) {
		for (IDataHolder addData : addDataArray)
			add(addData);
	}

	/**
	 * add a IDataHolder to this
	 * 
	 * @param addData
	 */
	public void add(IDataHolder addData) {
		dataNodes.add(addData);
	}

	/**
	 * This will return false because it is a DataNodeHolder
	 */
	@Override
	public boolean isDataNode() {
		return false;
	}

	/**
	 * Will return true, because this is a DataNodeHolder
	 */
	@Override
	public boolean isDataNodeHolder() {
		return true;
	}

	/**
	 * This will recursively call all within it to get all the data, then report that data back
	 */
	@Override
	public String getData() {
		return null;
	}

}

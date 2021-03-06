package structure;

import interfaces.IDataHolder;

import java.util.ArrayList;
import java.util.List;

import mathResources.MathHelper;

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
		for (IDataHolder currLookup : dataNodes) {
			if (currLookup.isDataNodeHolder()) {
				return currLookup.getData() + " ";
			}
		}
		return "No Data";
	}

	@Override
	public int length() {
		return dataNodes.size();
	}

	@Override
	public IDataHolder get(int index) {
		// TODO Auto-generated method stub
		return dataNodes.get(index);
	}

	@Override
	public void setRandomData() {
		int length = 3 + MathHelper.rand.nextInt(7);
		for (IDataHolder data : dataNodes) {
			data = setRandomData(length, data.getData());
		}

	}

	private IDataHolder setRandomData(int num, String currData) {
		if (num <= 0)
			return new DataNode(currData);
		return setRandomData(num - 1, (getData() + MathHelper.rand.nextInt(26)));
	}

	@Override
	public void setData(IDataHolder data) {
		// TODO Auto-generated method stub

	}

	@Override
	public int value() {
		int ret = 0;
		for (IDataHolder currLookup : dataNodes) {
			ret += currLookup.value();
		}
		return ret;
	}

}

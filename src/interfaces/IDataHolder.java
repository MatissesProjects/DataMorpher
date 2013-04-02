package interfaces;

/**
 * IDataHolder is an interface for an object that will contain data. A good example of this is the
 * windows explorer. A folder can contain files or it can contain more folders. If we go into each
 * folder recursively we can get all data contained in this tree like structure
 * 
 * @author Matisse
 * 
 */
public interface IDataHolder {

	/**
	 * Is this a dataNode. (leaf, file)
	 * 
	 * @return
	 */
	public boolean isDataNode();

	/**
	 * Is this a Holder of more DataNodes. (folder)
	 * 
	 * @return
	 */
	public boolean isDataNodeHolder();

	/**
	 * get the data contained within this node
	 * 
	 * @return
	 */
	public String getData();

	public int length();

	public IDataHolder get(int index);
}

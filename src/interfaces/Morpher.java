package interfaces;

/**
 * This interface is supposed to make sure we have all morphable objects we are
 * talking to
 * 
 * @author Matisse
 * 
 * @param <T>
 */
public interface Morpher<T> {

	/**
	 * something happens to the data, either inputed here or the data of the
	 * class, either way, there is a modification or morph that occurs and this
	 * is how we call it
	 * 
	 * @param input
	 *            - this is our input of type DATA_TYPE
	 */
	public void morph(T input);
	// TODO Get rid of need for notedata to be in every call, low priority
	// // // potential fix, create 2 morph functions, and call either
}

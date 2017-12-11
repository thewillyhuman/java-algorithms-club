package HashTable;

/**
 * Represents a cell of the hash table with a status and an element.
 * 
 * @author Guillermo Facundo Colunga
 * @param <T> represents the data type the node will store.
 */
public class HashNode<T extends Comparable<T>> {

	// Constants
	public final static int EMPTY = 0;
	public final static int VALID = 1;
	public final static int DELETED = 2;

	// Variables
	private T element;
	private int status;

	/**
	 * Main Constructor
	 */
	public HashNode() {
		status( EMPTY );
	}

	/**
	 * Setter. Sets the element.
	 * 
	 * @param element to be set.
	 */
	public void element( T element ) {
		this.element = element;
	}

	/**
	 * Getter. Gets the element
	 * 
	 * @return the element.
	 */
	public T element() {
		return this.element;
	}

	/**
	 * Setter. Sets the status.
	 * 
	 * @param status of the node.
	 */
	public void status( int status ) {
		this.status = status;
	}

	/**
	 * Getter. Gets the status.
	 * 
	 * @return the status of the node.
	 */
	public int status() {
		return this.status;
	}

	/**
	 * toString default method.
	 * 
	 * @format if[element != null] --> ellement.toString() else --> "null".
	 */
	public String toString() {
		if (element != null)
			return this.element.toString();
		return "null";

	}
}

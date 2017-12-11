package Graph;

/**
 * Creates a container that can store any kind of data.
 * 
 * @author Guillermo Facundo Colunga
 * @version 1.2
 * @param <T> Type of data the container will store.
 */
public class Container<T> {

	private T element;

	/**
	 * Constructor.
	 * 
	 * @param e the value of the String.
	 */
	public Container( T e ) {
		element( e );
	}

	/**
	 * Setter for the element.
	 * 
	 * @param e (String), the new value for the element. Null not accepted
	 */
	public void element( T e ) {
		if (e != null)
			this.element = e;
	}

	/**
	 * Getter, returns as an String the value of the container.
	 * 
	 * @return the value of the container as an String.
	 */
	public T element() {
		return this.element;
	}

	/**
	 * toString method.
	 * 
	 * @return the value of the container as an String.
	 */
	public String toString() {
		return this.element.toString();
	}

}

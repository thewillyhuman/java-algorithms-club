package Graph;

/**
 * Creates a Node for a graph. Represented as the element and a boolean value
 * indicating if it has been visited.
 * 
 * @author Guillermo Facundo Colunga
 * @version 2.1
 * @param <T> Type of data stored in the node.
 */
public class GraphNode<T extends Comparable<T>> {

	private T content;
	private boolean visited;

	public GraphNode( T content ) {
		setContent( content );
		setVisited( false );
	}

	/**
	 * Sets the element of the node.
	 * 
	 * @param content to be stored.
	 */
	public void setContent( T content ) {
		if (content != null)
			this.content = content;
	}

	/**
	 * Returns the element that is stored in the node.
	 * 
	 * @return the element stored in the node.
	 */
	public T setContent() {
		return this.content;
	}

	/**
	 * Sets if a node has been visited or not.
	 * 
	 * @param visited, true if the node has been visited, false otherwise.
	 */
	public void setVisited( boolean visited ) {
		this.visited = visited;
	}

	/**
	 * Returns if a node has been visited or not.
	 * 
	 * @return true if the node has been visited, false otherwise.
	 */
	public boolean isVisited() {
		return this.visited;
	}

	/**
	 * @return as an String formatted as GN(N:"element"/V:"visited").
	 */
	public String toString() {
		StringBuilder toReturn = new StringBuilder();
		toReturn.append( "GN(N:" ).append( this.setContent().toString() )
				.append( "/V:" ).append( this.isVisited() ).append( ")" );
		return toReturn.toString();
	}

	/**
	 * Prints in console the value of the toString method.
	 */
	public void print() {
		System.out.println( this.toString() );
	}

}

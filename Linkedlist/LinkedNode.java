package Linkedlist;

/**
 * A linked node it's a container that has a pointer to a previous and a next
 * element. Those previous and next elements are from the same liked node type.
 * So with them you can build a list of nodes linked together. Or what is the
 * same, a <code>LinkedList</code>.
 *
 * @author Guillermo Facundo Colunga
 * @version 1
 * @since 201712120953
 * @formatter Oviedo Computing Community
 * @param <T> is the type that the linked node will store.
 */
public class LinkedNode<T extends Comparable<T>> implements Comparable<LinkedNode<T>> {

	private T content;
	private LinkedNode<T> prev, next;

	// -------- END FIELDS --------

	/**
	 * Allocates a LinkedNode object and initializes it with the content passed
	 * as value.
	 * 
	 * @param content of the node.
	 */
	public LinkedNode( T content ) {
		this.content = content;
	}

	/**
	 * Allocates a LinkedNode object and initializes it with the content and
	 * next node passed as value.
	 * 
	 * @param content of the node.
	 * @param next node.
	 */
	public LinkedNode( T content, LinkedNode<T> next ) {
		this( content );
		next( next );
	}

	/**
	 * 
	 * Allocates a LinkedNode object and initializes it with the content, next
	 * and previous nodes passed as value.
	 * 
	 * @param content of node.
	 * @param next value.
	 * @param previous value.
	 */
	public LinkedNode( T content, LinkedNode<T> next, LinkedNode<T> previous ) {
		this( content, next );
		previous( previous );
	}

	/**
	 * @return the content of the node.
	 */
	public T content() {
		return this.content;
	}

	/**
	 * @param content of the node.
	 */
	public void content( T content ) {
		this.content = content;
	}

	/**
	 * @return the previous node.
	 */
	public LinkedNode<T> previous() {
		return this.prev;
	}

	/**
	 * @param previousNode is a pointer to the previous node.
	 */
	public void previous( LinkedNode<T> previousNode ) {
		this.prev = previousNode;
	}

	/**
	 * @return the next node.
	 */
	public LinkedNode<T> next() {
		return this.next;
	}

	/**
	 * @param nextNode is a pointer to the next node.
	 */
	public void next( LinkedNode<T> nextNode ) {
		this.next = nextNode;
	}

	/**
	 * Sets the node to null. Helps the garbage collector to find and delete the
	 * node. Even though its not necessary to be called at any time.
	 */
	public void delete() {
		this.content = null;
		this.next = null;
		this.prev = null;
	}

	/**
	 * Compares the value of the content.
	 */
	@Override public int compareTo( LinkedNode<T> node ) {
		return this.content().compareTo( node.content() );
	}
}

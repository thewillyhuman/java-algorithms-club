package AVLTree;

/**
 * Represents an AVL leave a an AVLTree.
 * 
 * @author Guillermo Facundo Colunga
 * @version 2.1
 * @param <T> Type of data that the AVLNode will contain.
 */
public class AVLNode<T extends Comparable<T>> {

	private T element;
	private AVLNode<T> left, right;
	private int height;

	/**
	 * AVLNode Constructor. Only requires an element for the current AVLNode.
	 * The left child and the right child will be set to null.
	 * 
	 * @param element to be set in the current AVLNode.
	 * @throws Exception if element is null.
	 */
	public AVLNode( T element ) {
		element( element );
		left( null );
		right( null );
	}

	/**
	 * AVLNode Constructor. Requires the element for the current node, the
	 * AVLNode of the left and the one for the right.
	 * 
	 * @param element for the current node
	 * @param left AVLNode
	 * @param right AVLNode
	 * @throws Exception Exception if element, left or right is null.
	 */
	public AVLNode( T element, AVLNode<T> left, AVLNode<T> right ) {
		element( element );
		left( left );
		right( right );
	}

	/**
	 * Returns the actual value of the node. Notice that if the current value is
	 * null will return null.
	 * 
	 * @return the value of the node. In other words the element that the node
	 *         contains.
	 */
	public T element() {
		return this.element;
	}

	/**
	 * Sets the value of the node. Because of the implementation this method
	 * will accept null values.
	 * 
	 * @param element to be set.
	 */
	public void element( T element ) {
		this.element = element;
	}

	/**
	 * Return the height of the subtree starting at the node.
	 * 
	 * @return the height as an Integer.
	 */
	public int height() {
		updateHeight();
		return this.height;
	}

	/**
	 * Setter for the height property.
	 * 
	 * @param height to be set as new in the node.
	 */
	public void height( int height ) {
		if (height < 0)
			throw new IllegalArgumentException( "The height cannot be negative" );
		this.height = height;
	}

	/**
	 * Returns the AVLNode that is placed at the left. So its value is less than
	 * the actual node. If there is no left child will return null.
	 * 
	 * @return the AVLNode that is placed at the left. Null if there isn't.
	 */
	public AVLNode<T> left() {
		return this.left;
	}

	/**
	 * Sets the AVLNode that is placed at the left. Because of the
	 * implementation this method will accept null values.
	 * 
	 * @param left the node to be set.
	 */
	public void left( AVLNode<T> left ) {
		this.left = left;
	}

	/**
	 * Returns the AVLNode that is placed at the right. So its value is grater
	 * than the actual node. If there is no left child will return null.
	 * 
	 * @return the AVLNode that is placed at the right. Null if there isn't.
	 */
	public AVLNode<T> right() {
		return this.right;
	}

	/**
	 * Sets the AVLNode that is placed at the left. Because of the
	 * implementation this method will accept null values.
	 * 
	 * @param right the node to be set.
	 */
	public void right( AVLNode<T> right ) {
		this.right = right;
	}

	/**
	 * toString default method. Returns as an String the value of the element.
	 * 
	 * @return the value of the node.
	 */
	@Override public String toString() {
		return this.element().toString() + "(" + balance() + ")";
	}

	/**
	 * Prints the value of the toString method.
	 */
	public void print() {
		System.out.println( this.toString() );
	}

	/**
	 * Updates the height of the tree from a given root or node.
	 */
	protected void updateHeight() {
		// If the node doesn't have children, its height is just 0
		if (left() == null && right() == null)
			height( 0 );

		// If it has a child on one side, its height is its child's height plus
		// one
		else if (left() != null && right() == null)
			height( 1 + left().height() );

		else if (left() == null && right() != null)
			height( 1 + right().height() );

		// If it has one child on each side, its height will be the greatest of
		// its childrens's height plus one
		else if (left().height() > right().height())
			height( 1 + left().height() );
		else
			height( 1 + right().height() );
	}

	/**
	 * Calculates the balance factor of the node.
	 * 
	 * @return the balance factor of the node.
	 */
	public int balance() {
		return calculateBalance();
	}

	/**
	 * By means of the height returns the BF of the node. Three cases, the node
	 * has no subtrees, has one subtree or has two subtrees.
	 * 
	 * @return
	 */
	private int calculateBalance() {

		// If the node doesn't have children, its BF is just 0
		if (left() == null && right() == null)
			return 0;
		// If it has a child on one side
		else if (right() == null)
			return -1 - left().height();
		else if (left() == null && right() != null)
			return 1 + right().height();
		// If it has one child on each side
		else
			return ( right().height() - left().height() );
	}
}

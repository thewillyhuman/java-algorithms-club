package AVLTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * In computer science, an AVL tree (Georgy Adelson-Velsky and Evgenii Landis'
 * tree, named after the inventors) is a self-balancing binary search tree. It
 * was the first such data structure to be invented.[2] In an AVL tree, the
 * heights of the two child subtrees of any node differ by at most one; if at
 * any time they differ by more than one, rebalancing is done to restore this
 * property. Lookup, insertion, and deletion all take O(log n) time in both the
 * average and worst cases, where n is the number of nodes in the tree prior to
 * the operation. Insertions and deletions may require the tree to be rebalanced
 * by one or more tree rotations.
 * 
 * @author Guillermo Facundo Colunga
 * @version 2.3
 * @param <T> Type of data that the structure will contain.
 */
public class AVLTree<T extends Comparable<T>> {

	private AVLNode<T> root;

	/**
	 * Main Constructor. It doesn't need any parameter. will create an AVL Tree
	 * with a null root.
	 */
	public AVLTree() {
		root( null );
	}

	/**
	 * 
	 * Allocates an AVLTree object and initializes it with the root as a root
	 * element of the tree.
	 * 
	 * @param root of the tree
	 */
	public AVLTree( T root ) {
		root( null );
		add( root );
	}

	/**
	 * 
	 * Allocates an AVLTree object and initializes with the elements given.
	 * 
	 * @param elements to create the tree.
	 */
	@SafeVarargs public AVLTree( T... elements ) {
		for (T element : elements) {
			this.add( element );
		}
	}

	/**
	 * Returns the root of the tree, if there is. Otherwise null.
	 * 
	 * @return the AVLNode that represents the root of the tree if there is.
	 *         Otherwise null.
	 */
	public AVLNode<T> root() {
		return this.root;
	}

	/**
	 * Sets the root of the tree. As null is a dangerous value if the root is
	 * set to null will print a warning message.
	 * 
	 * @param root AVLNode to be the root of the tree.
	 */
	public void root( AVLNode<T> root ) {
		this.root = root;
	}

	/**
	 * Adds an element to the tree. By calling the recursive and private method
	 * add(AVLNode<T> root, T element), that will return the top node of the
	 * tree.
	 * 
	 * @param element to be added to the tree.
	 * @throws Exception if the the element is null or if it's already in the
	 *             tree.
	 */
	public void add( T element ) throws IllegalArgumentException {
		root( add( root(), element ) );
	}

	/**
	 * Recursive add method. If the root given is null it will create a new
	 * AVLNode assigning the value of the node we want to add there. If not will
	 * allocate the element in its place and then will return again the root.
	 * 
	 * @param root of the AVL tree.
	 * @param element to be added to the tree.
	 * @return the root of the tree.
	 * @throws Exception if the element already exists or if it's null.
	 */
	private AVLNode<T> add( AVLNode<T> root, T element )
			throws IllegalArgumentException {
		if (element == null) {
			throw new IllegalArgumentException(
					"The element you want to add was null." );
		} else if (root == null) {
			return new AVLNode<T>( element );
		} else if (root.element().equals( element )) {
			throw new IllegalArgumentException(
					"No repeated elements are allowed inside a tree." );
		} else if (element.compareTo( root.element() ) < 0) {
			root.left( add( root.left(), element ) );
		} else {
			root.right( add( root.right(), element ) );
		}
		return ( this.updateBalanceFactor( root ) );
	}

	/**
	 * Deprecated. Iterative method to add nodes. If the root given is null it
	 * will create a new AVLNode assigning the value of the node we want to add
	 * there. If not will allocate the element in its place and then will return
	 * again the root.
	 * 
	 * Please, use the recursive version.
	 * 
	 * @param element to add to the tree.
	 */
	@Deprecated public void addIterative( T element ) {
		if (element == null)
			throw new IllegalArgumentException(
					"The element you want to add was null." );
		AVLNode<T> root = root();
		boolean added = false;
		while (!added) {
			if (root == null) {
				root( new AVLNode<T>( element ) );
				added = true;
			} else if (element.compareTo( root.element() ) < 0) {
				if (root.left() == null) {
					root.left( new AVLNode<T>( element ) );
					added = true;
				}
				root = root.left();
			} else if (element.compareTo( root.element() ) == 0) {
				throw new IllegalArgumentException(
						"No repeated elements are allowed inside a tree." );
			} else {
				if (root.right() == null) {
					root.right( new AVLNode<T>( element ) );
					added = true;
				}
				root = root.right();
			}
		}
	}

	/**
	 * Public toString method. Returns a string representation of the object. In
	 * general, the toString method returns a string that "textually represents"
	 * this object. The result should be a concise but informative
	 * representation that is easy for a person to read. It is recommended that
	 * all subclasses override this method. In this case the default format is:
	 * root+left+right and null pointers as "-" (dash). (Pre-Order)
	 * 
	 * @return toString private and recursive method
	 */
	@Override public String toString() {
		return toString( root );
	}

	/**
	 * toString private recursive method. While the root is different from null
	 * the method will continue traversing the tree and adding the nodes to the
	 * StringBuilder. Instead of String concatenation it uses StringBuilder
	 * because as it is a recursive method we improve the performance.
	 * 
	 * @param root
	 * @return null if root = null. Otherwise: "root+left+right". Pre-Order.
	 */
	private String toString( AVLNode<T> root ) {
		StringBuilder str = new StringBuilder();
		if (root == null) {
			str.append( "-" );
		} else {
			str.append( root.toString() );
			str.append( toString( root.left() ) ).append( toString( root.right() ) );
		}
		return str.toString();
	}

	/**
	 * Search method. Given a T element it returns true if the element is in the
	 * tree. False otherwise.
	 * 
	 * @param T element, the element you want to look for in the tree.
	 * @return true if the element is in the tree, false otherwise.
	 */
	public boolean search( T element ) {
		return search( element, root() );
	}

	/**
	 * Search private and reflexive method. Given a T element and a root it
	 * checks if the T element is in the tree.
	 * 
	 * @param T element, the element you want to look for in the tree.
	 * @param root, where you are looking for the element.
	 * @return true if the element is in the tree, false otherwise.
	 */
	private boolean search( T element, AVLNode<T> root ) {
		if (root == null || element == null) {
			return false;
		} else if (root.element().equals( element )) {
			return true;
		} else if (element.compareTo( root.element() ) < 0) {
			return search( element, root.left() );
		} else if (element.compareTo( root.element() ) > 0) {
			return search( element, root.right() );
		}
		return false;
	}

	/**
	 * Deprecated. Iterative version of search method. Please, use the recursive
	 * method. Given a T element and a root it checks if the T element is in the
	 * tree.
	 * 
	 * @param element to be searched.
	 * @return true if the element exists in the tree. False otherwise.
	 */
	@Deprecated public boolean searchIterative( T element ) {
		if (element == null)
			throw new IllegalArgumentException(
					"The element you want to add was null." );
		AVLNode<T> root = root();
		while (root != null) {
			if (element.equals( root.element() )) {
				return true;
			} else if (element.compareTo( root.element() ) < 0) {
				root = root.left();
			} else {
				root = root.right();
			}
		}
		return false;
	}

	/**
	 * Search and Return method. If the element is in the tree then it search
	 * for the element in the tree and returns it.
	 * 
	 * @param element
	 * @return
	 */
	public T searchAndReturn( T element ) {
		if (search( element ))
			return searchAndReturn( element, root() );
		else
			return null;
	}

	/**
	 * Search and return private and reflexive method. Given a T element and a
	 * root it returns the element.
	 * 
	 * @param T element, the element you want to look for in the tree.
	 * @param root, where you are looking for the element.
	 * @return The element you are looking for.
	 */
	private T searchAndReturn( T element, AVLNode<T> root ) {
		if (root.element().equals( element )) {
			return root.element();
		} else if (element.compareTo( root.element() ) < 0) {
			return searchAndReturn( element, root.left() );
		} else {
			return searchAndReturn( element, root.right() );
		}
	}

	/**
	 * Get the maximum value in the tree. Calls the recursive and private method
	 * T getMax(AVLNode<T> root).
	 * 
	 * @return the maximum value in the tree.
	 */
	public T max() {
		return max( root() );
	}

	/**
	 * Private and reflexive getMax Method, gets the maximum value in the tree
	 * by means of recursion. Notice that the max value of a tree is always
	 * allocated at the bottom right position.
	 * 
	 * @param root of the tree.
	 * @return the maximum value of the tree.
	 */
	public T max( AVLNode<T> root ) {
		if (root == null) {
			return null;
		} else if (root.right() != null) {
			return max( root.right() );
		}
		return root.element();
	}

	/**
	 * Travels the Tree in order, that is: leftSubTtree + root + rightSubTree.
	 * Null leaves will be represented as "-".
	 * 
	 * Procedure: Traverse the left subtree by recursively calling the in-order
	 * function. Display the data part of root element (or current element).
	 * Traverse the right subtree by recursively calling the in-order function
	 * 
	 * @return the result of traveling all the tree in order from the top root.
	 */
	public String inOrderTraversal() {
		return inOrderTraversal( this.root() );
	}

	/**
	 * Recursive method to traverse the tree from a given root. It travels in
	 * order as left + root + right. Null leaves will be represented as "-"
	 * 
	 * @param root of the tree or subtree.
	 * @return an String containing all the traverse path.
	 */
	private String inOrderTraversal( AVLNode<T> root ) {
		StringBuilder aux = new StringBuilder();
		if (root == null)
			return "-";

		aux.append( inOrderTraversal( root.left() ) );
		aux.append( root.element() );
		aux.append( inOrderTraversal( root.right() ) );

		return aux.toString();
	}

	/**
	 * Travels the Tree in post-order, that is: leftSubTtree + rightSubTree +
	 * root. Null leaves will be represented as "-"
	 * 
	 * Procedure: Traverse the left subtree by recursively calling the
	 * post-order function. Traverse the right subtree by recursively calling
	 * the post-order function. Display the data part of root element (or
	 * current element).
	 * 
	 * @return the result of traveling all the tree in post-order from the top
	 *         root.
	 */
	public String postOrderTraversal() {
		return postOrderTraversal( this.root() );
	}

	/**
	 * Recursive method to traverse the tree from a given root. It travels in
	 * post-order as left + right + root. Null leaves will be represented as "-"
	 * 
	 * @param root of the tree or subtree.
	 * @return an String containing all the traverse path.
	 */
	private String postOrderTraversal( AVLNode<T> root ) {
		StringBuilder aux = new StringBuilder();
		if (root == null)
			return "-";

		aux.append( postOrderTraversal( root.left() ) );
		aux.append( postOrderTraversal( root.right() ) );
		aux.append( root.element() );

		return aux.toString();
	}

	/**
	 * Public and not reflexive remove method. Given an element as a paramenter
	 * it removes it from the tree.
	 * 
	 * @param element, the element to be deleted
	 * @throws Exception if you try to delete a null, empty or non existent
	 *             node.
	 */
	public void remove( T element ) {
		root( remove( root, element ) );
	}

	/**
	 * Private and reflexive remove method. Given an element as a parameter and
	 * a root it removes the element from the tree.
	 * 
	 * @param element, the element to be deleted
	 * @param root where you start to look for the node
	 * @return the deleted node.
	 * @throws Exception if you try to delete a null, empty or non existent node
	 */
	public AVLNode<T> remove( AVLNode<T> root, T element ) {
		if (!search( element )) {
			throw new IllegalArgumentException(
					"The provided element is not in the tree." );
		} else if (root == null) {
			throw new IllegalArgumentException( "The provided root is null." );
		} else if (root.element().equals( element )) {
			if (root.left() == null) {
				return root.right();
			} else if (root.right() == null) {
				return root.left();
			} else {
				root.element( max( root.left() ) );
				root.left( remove( root.left(), root.element() ) );
			}
		} else if (element.compareTo( root.element() ) < 0) {
			root.left( remove( root.left(), element ) );
		} else {
			root.right( remove( root.right(), element ) );
		}
		return ( updateBalanceFactor( root ) );
	}

	/**
	 * Given the actual tree and a tree as a parameter will return another tree
	 * that will be the composition of both trees.
	 * 
	 * @param tree. Second tree of the composition.
	 * @return a tree containing all the nodes in the first and the second tree.
	 * @throws CloneNotSupportedException
	 */
	public AVLTree<T> join( AVLTree<T> tree ) {
		AVLTree<T> joinTree = this.clone();
		return join( joinTree, tree );

	}

	/**
	 * Private and recursive method for join two trees. Given the first tree and
	 * the second tree will look first; If the second tree contains a root. If
	 * yes will continue looking if the root of the second tree is contained in
	 * the first one. If not, will add to the first tree the root of the second
	 * one. Then we can start to work with the left and right trees. For left.
	 * we set the root of an auxiliary tree as the root of the very first left
	 * element of our second tree. and then we will call recursively to our join
	 * method with the first tree and the left tree of our second tree. And
	 * finally the same for the right as for the left.
	 * 
	 * @param tree1 first tree to join.
	 * @param tree2 second tree to join.
	 * @return a tree containing all the nodes from tree1 and tree2. Following
	 *         the rules of the AVL trees, that is: No repeated elements,
	 *         ordered as BST...
	 */
	private AVLTree<T> join( AVLTree<T> tree1, AVLTree<T> tree2 ) {
		AVLNode<T> joinRoot = tree2.root();
		if (joinRoot != null) {
			if (!tree1.search( joinRoot.element() ))
				tree1.add( joinRoot.element() );

			AVLTree<T> treeL = new AVLTree<T>();
			treeL.root( joinRoot.left() );
			tree1.join( tree1, treeL );

			AVLTree<T> treeR = new AVLTree<T>();
			treeR.root( joinRoot.right() );
			tree1.join( tree1, treeR );
		}
		return tree1;
	}

	/**
	 * Updates the Balance Factor of the Node.
	 * 
	 * @param root
	 * @return processRotations(node)
	 */
	public AVLNode<T> updateBalanceFactor( AVLNode<T> root ) {
		root.updateHeight();
		return processRotations( root );
	}

	/**
	 * This method decides if we have to perform a single or double and left or
	 * right rotation.
	 * 
	 * @param root
	 * @return single[Left / Right]Rotation(root)
	 */
	private AVLNode<T> processRotations( AVLNode<T> root ) {
		if (root.balance() == -2) {
			if (root.left().balance() <= 0)
				return singleLeftRotation( root );
			else
				return doubleLeftRotation( root );

		} else if (root.balance() == 2) {
			if (root.right().balance() >= 0)
				return singleRightRotation( root );
			else
				return doubleRightRotation( root );
		}
		return root;
	}

	/**
	 * Performs a single left rotation to a given subtree.
	 * 
	 * @param b root of the subtree.
	 * @return Balanced subtree.
	 */
	private AVLNode<T> singleLeftRotation( AVLNode<T> root ) {
		AVLNode<T> aux = root.left();
		root.left( aux.right() );
		aux.right( root );
		root = aux;

		root.updateHeight();
		return root;
	}

	/**
	 * Performs a single right rotation to a given subtree.
	 * 
	 * @param b root of the subtree.
	 * @return Balanced subtree.
	 */
	private AVLNode<T> singleRightRotation( AVLNode<T> root ) {
		AVLNode<T> aux = root.right();
		root.right( aux.left() );
		aux.left( root );
		root = aux;

		root.updateHeight();
		return root;
	}

	/**
	 * Performs a double left rotation.
	 * 
	 * @param root
	 * @return balanced subtree
	 */
	private AVLNode<T> doubleLeftRotation( AVLNode<T> root ) {
		AVLNode<T> aux = root.left().right();

		root.left().right( aux.left() );
		aux.left( root.left() );

		root.left( aux.right() );
		aux.right( root );

		root = aux;

		root.updateHeight();
		return root;
	}

	/**
	 * Performs a double right rotation.
	 * 
	 * @param root
	 * @return balanced subtree
	 */
	private AVLNode<T> doubleRightRotation( AVLNode<T> root ) {
		AVLNode<T> aux = root.right().left();

		root.right().left( aux.right() );
		aux.right( root.right() );

		root.right( aux.left() );
		aux.left( root );

		root = aux;

		root.updateHeight();
		return root;
	}

	/**
	 * Get Height method. Returns the height of the tree without accessing to
	 * the node parameters. To perform that it calls to the private and
	 * reflexive getHeight() method with the root of the tree as a parameter.
	 * 
	 * 
	 * @return the height of the tree as an integer.
	 * @important The method considers the height of a single leaf as 0.
	 */
	public int height() {
		return height( this.root() );
	}

	/**
	 * Get Height [ PRIVATE AND REFLEXIVE ]. It returns the height of the tree
	 * without accessing to the node parameters.
	 * 
	 * @param root where you start to perform the algorithm
	 * @return the height as an integer.
	 * @important The method considers the height of a single leaf as 0.
	 */
	private int height( AVLNode<T> root ) {
		// If the tree is empty...
		if (root == null)
			return 0;

		// That check is to know whether a node is a leaf or not.
		// If one single leaf is counted as 1 remove two following lines.
		else if (root.left() == null && root.right() == null)
			return 0;

		// Depending on the balance factor we can know which subtree has more
		// height, if the balance factor equals or less 0 we will take the left
		// subtree as the one with more height, the right one otherwise.
		if (root.balance() <= 0)
			return 1 + height( root.left() );
		else
			return 1 + height( root.right() );
	}

	/**
	 * If the root of a tree is null means that the tree is empty.
	 * 
	 * @return whether a tree is empty or not.
	 */
	public boolean isEmpty() {
		return ( root == null );
	}

	/**
	 * Returns a pointer to an auxiliary tree containing all the elements as
	 * this tree.
	 * 
	 * @return an auxiliary tree containing all the elements on the working
	 *         tree.
	 */
	public AVLTree<T> clone() {
		AVLTree<T> copy = new AVLTree<T>();
		return clone( copy, this.root() );
	}

	/**
	 * Private and recursive version for make a copy of the actual tree.
	 * 
	 * @param tree that will be the auxiliary one.
	 * @param root to start working to make the copy.
	 * @return the aux tree.
	 */
	private AVLTree<T> clone( AVLTree<T> tree, AVLNode<T> root ) {
		if (root != null) {
			tree.add( root.element() );
			clone( tree, root.left() );
			clone( tree, root.right() );
		}
		return tree;
	}

	/**
	 * The current tree as a List shorted.
	 * 
	 * @return the current tree as a list shorted with the default type
	 *         comparator.
	 */
	public List<T> toList() {
		List<T> toReturn = new ArrayList<T>();
		toReturn = toList( toReturn, this.root() );
		return toReturn;
	}

	/**
	 * Private and recursive method to get the tree as a List.
	 * 
	 * @param list where the elements will be stored.
	 * @param root of the working tree.
	 * @return the list containing all the elements not shorted.
	 */
	private List<T> toList( List<T> list, AVLNode<T> root ) {
		if (root != null) {
			list.add( root.element() );
			toList( list, root.left() );
			toList( list, root.right() );
		}
		return list;
	}

	/**
	 * The current tree as a List shorted.
	 * 
	 * @param comparator used to sort the list.
	 * @return the current tree as a list sorted by the custom comparator.
	 */
	public List<T> toList( Comparator<T> comparator ) {
		List<T> toReturn = new ArrayList<T>();
		toReturn = toList( toReturn, this.root() );
		Collections.sort( toReturn, comparator );
		return toReturn;
	}

	/**
	 * Given a tree this method will give the number of nodes that contains.
	 * 
	 * @return the number of nodes contained by the tree.
	 */
	public int numberOfNodes() {
		return numberOfNodes( this.root() );
	}

	/**
	 * Given a tree and the root of it this method will return the number of
	 * nodes that contains.
	 * 
	 * @param root of the tree.
	 * @return the number of nodes contained by the tree.
	 */
	private int numberOfNodes( AVLNode<T> root ) {
		if (root == null)
			return 0;
		return ( 1 + numberOfNodes( root.left() ) + numberOfNodes( root.right() ) );
	}

	/**
	 * Returns an AVLTree containing the different elements from one tree and
	 * another.
	 * 
	 * @param secondTree is the second AVLTree to get the different elements.
	 * @return An AVLTree that contains all the elements that are not contained
	 *         in the other tree. And works in both ways, elements that are in
	 *         the first but not in the second and elements that are in the
	 *         second but not in the first.
	 */
	public AVLTree<T> difference( AVLTree<T> secondTree ) {
		AVLTree<T> toReturn = new AVLTree<T>();
		for (T element : this.toList()) {
			if (!secondTree.search( element ))
				toReturn.add( element );
		}
		for (T element : secondTree.toList()) {
			if (!this.search( element ))
				toReturn.add( element );
		}
		return toReturn;
	}

	/**
	 * For the actual tree and a given element this method will return the
	 * number of nodes that is greater than the element given.
	 * 
	 * @param element is the element we are going to use to compare with the
	 *            elements contained in the actual tree.
	 * @return the number of elements that are grater that the element given as
	 *         a parameter.
	 * @throws IllegalStateException if the current tree is empty.
	 */
	public int numberOfElementsGreaterThan( T element )
			throws IllegalStateException {
		// If the current tree is empty it will throw an Exception to warn about
		// the illegal state.
		if (this.isEmpty())
			throw new IllegalStateException( "The current tree is empty." );
		if (element.compareTo( this.max() ) >= 0)
			return 0;
		int res = 0; // The variable that will store the final result.
		List<T> aux = this.toList();
		for (T current : aux) { // We get all the nodes as a list of elements.
			if (current.compareTo( element ) == 1) // If the element is
													// greater..
				res++; // we increment the result in one unit.
		}
		return res; // Finally we return the variable that stores the result.
	}

	/**
	 * For the actual tree and a given element this method will return the
	 * number of nodes that is greater than the element given.
	 * 
	 * @param element is the element we are going to use to compare with the
	 *            elements contained in the actual tree.
	 * @return the number of elements that are grater that the element given as
	 *         a parameter.
	 */
	public int greaterElements( T element ) {
		return this.greaterElements( this.root(), element );
	}

	/**
	 * Private and recursive method to get all the elements that are greater
	 * then a given element.
	 * 
	 * @param root is the current element where we iterate.
	 * @param key is the given element to make the condition.
	 * @return the number of elements that are grater that the element given as
	 *         a parameter.
	 */
	private int greaterElements( AVLNode<T> root, T key ) {
		if (root == null) {
			return 0;
		} else if (key.compareTo( root.element() ) == 0) {
			return numberOfNodes( root.right() );
		} else if (key.compareTo( root.element() ) < 0) {
			return greaterElements( root.left(), key )
					+ numberOfNodes( root.right() ) + 1;
		} else {
			return greaterElements( root.right(), key );
		}
	}
}

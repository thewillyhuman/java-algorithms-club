package AVLTree.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AVLTree.AVLTree;

/**
 * 
 * @author Guillermo facundo Colunga
 * @version 2.2
 */
public class AVLTreeTest {

	AVLTree<String> stringTree;
	AVLTree<Integer> integerTree;
	AVLTree<Character> charTree;

	@Before public void setUp() {
		stringTree = new AVLTree<String>();
		integerTree = new AVLTree<Integer>();
		charTree = new AVLTree<Character>();
	}

	@Test public void addTest() {

		// Chars...
		assertEquals( "-", charTree.toString() );
		charTree.add( 'b' );
		assertEquals( "b(0)--", charTree.toString() );
		charTree.add( 'a' );
		assertEquals( "b(-1)a(0)---", charTree.toString() );
		charTree.add( 'd' );
		assertEquals( "b(0)a(0)--d(0)--", charTree.toString() );
		charTree.add( 'c' );
		assertEquals( "b(1)a(0)--d(-1)c(0)---", charTree.toString() );
		charTree.add( 'g' );
		assertEquals( "b(1)a(0)--d(0)c(0)--g(0)--", charTree.toString() );
		charTree.add( 'i' );
		assertEquals( "d(0)b(0)a(0)--c(0)--g(1)-i(0)--", charTree.toString() );
		charTree.add( 'h' );
		assertEquals( "d(0)b(0)a(0)--c(0)--h(0)g(0)--i(0)--", charTree.toString() );

		// Testing Exceptions...
		try {
			stringTree.add( null );
			integerTree.add( null );
			charTree.add( null );
			fail( "An exception should be thrown when adding null objects" );
		} catch (Exception e) {
			System.out.println( e + " | DON'T WORRY IT'S A TEST" );
		}
	}

	@SuppressWarnings("deprecation") @Test public void addIterativeTest() {

		// Chars...
		assertEquals( "-", charTree.toString() );
		charTree.addIterative( 'b' );
		assertEquals( "b(0)--", charTree.toString() );
		charTree.addIterative( 'a' );
		assertEquals( "b(-1)a(0)---", charTree.toString() );
		charTree.addIterative( 'd' );
		assertEquals( "b(0)a(0)--d(0)--", charTree.toString() );
		charTree.addIterative( 'c' );
		assertEquals( "b(1)a(0)--d(-1)c(0)---", charTree.toString() );
		charTree.addIterative( 'g' );
		assertEquals( "b(1)a(0)--d(0)c(0)--g(0)--", charTree.toString() );
		charTree.addIterative( 'i' );
		assertEquals( "b(2)a(0)--d(1)c(0)--g(1)-i(0)--", charTree.toString() );
		charTree.addIterative( 'h' );
		assertEquals( "b(3)a(0)--d(2)c(0)--g(2)-i(-1)h(0)---", charTree.toString() );

		// Testing Exceptions...
		try {
			stringTree.addIterative( null );
			integerTree.addIterative( null );
			charTree.addIterative( null );
			fail( "An exception should be thrown when adding null objects" );
		} catch (Exception e) {
			System.out.println( e + " | DON'T WORRY IT'S A TEST" );
		}
	}

	@Test public void searchTest() {

		// Chars...
		charTree.add( 'b' );
		charTree.add( 'a' );
		charTree.add( 'd' );
		charTree.add( 'c' );
		charTree.add( 'g' );
		charTree.add( 'i' );
		charTree.add( 'h' );

		assertEquals( true, charTree.search( 'i' ) );
		assertEquals( false, charTree.search( 'f' ) );

		// Empty tree.
		assertEquals( false, integerTree.search( 1 ) );

		integerTree.add( 9 );
		integerTree.add( 8 );
		integerTree.add( 7 );
		integerTree.add( 6 );
		integerTree.add( 5 );
		integerTree.add( 4 );
		integerTree.add( 3 );
		integerTree.add( 2 );
		integerTree.add( 1 );
		assertEquals( true, integerTree.search( 1 ) );
		assertEquals( false, integerTree.search( 10 ) );

		stringTree.add( "a" );
		stringTree.add( "b" );
		stringTree.add( "c" );
		stringTree.add( "d" );
		stringTree.add( "e" );
		stringTree.add( "f" );
		stringTree.add( "g" );
		stringTree.add( "h" );
		assertEquals( true, stringTree.search( "h" ) );
		assertEquals( false, stringTree.search( "j" ) );
	}

	@SuppressWarnings("deprecation") @Test public void searchIterativeTest() {

		// Chars...
		charTree.add( 'b' );
		charTree.add( 'a' );
		charTree.add( 'd' );
		charTree.add( 'c' );
		charTree.add( 'g' );
		charTree.add( 'i' );
		charTree.add( 'h' );

		assertEquals( true, charTree.searchIterative( 'i' ) );
		assertEquals( false, charTree.searchIterative( 'f' ) );

		// Integers...
		// Empty tree.
		assertEquals( false, integerTree.searchIterative( 1 ) );

		integerTree.add( 9 );
		integerTree.add( 8 );
		integerTree.add( 7 );
		integerTree.add( 6 );
		integerTree.add( 5 );
		integerTree.add( 4 );
		integerTree.add( 3 );
		integerTree.add( 2 );
		integerTree.add( 1 );
		assertEquals( true, integerTree.searchIterative( 1 ) );
		assertEquals( false, integerTree.searchIterative( 10 ) );

		// Strings...
		stringTree.add( "a" );
		stringTree.add( "b" );
		stringTree.add( "c" );
		stringTree.add( "d" );
		stringTree.add( "e" );
		stringTree.add( "f" );
		stringTree.add( "g" );
		stringTree.add( "h" );
		// Elements in and out the tree.
		assertEquals( true, stringTree.searchIterative( "h" ) );
		assertEquals( false, stringTree.searchIterative( "j" ) );
	}

	@Test public void getMaxTest() {

		// Complete tree
		charTree.add( 'b' );
		charTree.add( 'a' );
		charTree.add( 'd' );
		charTree.add( 'c' );
		charTree.add( 'g' );
		charTree.add( 'i' );
		charTree.add( 'h' );
		assertEquals( 'i', (char) charTree.max() );

		// Empty tree
		assertEquals( null, integerTree.max() );

	}

	@Test public void inOrderTraversalTest() {
		// Complete tree.
		integerTree.add( 5 );
		integerTree.add( 3 );
		integerTree.add( 7 );
		integerTree.add( 6 );
		integerTree.add( 9 );
		assertEquals( "-3-5-6-7-9-", integerTree.inOrderTraversal() );

		// Empty tree
		assertEquals( "-", stringTree.inOrderTraversal() );

		// Only one element
		charTree.add( 'a' );
		assertEquals( "-a-", charTree.inOrderTraversal() );
	}

	@Test public void postOrderTraversalTest() {
		// Complete tree.
		integerTree.add( 5 );
		integerTree.add( 3 );
		integerTree.add( 7 );
		integerTree.add( 6 );
		integerTree.add( 9 );

		assertEquals( "--3--6--975", integerTree.postOrderTraversal() );

		// Empty tree
		assertEquals( "-", stringTree.postOrderTraversal() );

		// Only one element
		charTree.add( 'a' );
		assertEquals( "--a", charTree.postOrderTraversal() );
	}

	/**
	 * Test for the search method. Creates a new AVL tree, adds some nodes and
	 * runs the method for some of them that exists and also for some of them
	 * that does not exists and for some exceptions.
	 * 
	 * @throws Exception
	 */
	@Test public void searchSecondTest() throws Exception {
		System.out.println( "------------- Inicializing the searchTest() method -------------\n" );
		// Creating a tree.
		AVLTree<Character> b = new AVLTree<Character>();

		// Some nodes to the AVL tree b.
		b.add( 'b' );
		b.add( 'a' );
		b.add( 'c' );
		b.add( 'f' );
		System.out.println( "Current working tree: " + b.toString() + "\n" );
		assertEquals( "b(1)a(0)--c(1)-f(0)--", b.toString() );

		// Possitive testing
		System.out.println( "Positive testing starting... " );
		assertEquals( true, b.search( 'c' ) );
		System.out.println( "The result of searching 'c' is.... " + b.search( 'c' )
				+ " | assertEquals : true" );
		assertEquals( true, b.search( 'b' ) );
		System.out.println( "The result of searching 'b' is.... " + b.search( 'b' )
				+ " | assertEquals : true" );
		assertEquals( true, b.search( 'a' ) );
		System.out.println( "The result of searching 'a' is.... " + b.search( 'a' )
				+ " | assertEquals : true" );
		assertEquals( true, b.search( 'f' ) );
		System.out.println( "The result of searching 'f' is.... " + b.search( 'f' )
				+ " | assertEquals : true" + "\n" );

		// Negative testing
		// 1srt - Part with assertNotEquals.
		System.out.println( "Negative testing starting... " );
		System.out.println( "1srt - Part " );
		assertNotSame( false, b.search( 'c' ) );
		System.out.println( "The result of searching 'c' is.... " + b.search( 'c' )
				+ " | assertNotSame : false" );
		assertNotSame( false, b.search( 'b' ) );
		System.out.println( "The result of searching 'b' is.... " + b.search( 'b' )
				+ " | assertNotSame : false" );
		assertNotSame( false, b.search( 'a' ) );
		System.out.println( "The result of searching 'a' is.... " + b.search( 'a' )
				+ " | assertNotSame : false" );
		assertNotSame( false, b.search( 'f' ) );
		System.out.println( "The result of searching 'f' is.... " + b.search( 'f' )
				+ " | assertNotSame : false" + "\n" );

		// 2nd - Part with assertEquals and trying exceptions.
		System.out.println( "2nd - Part " );
		assertEquals( false, b.search( 'g' ) );
		System.out.println( "The result of searching 'g' is....  " + b.search( 'g' )
				+ " | assertEquals : false" );
		assertEquals( false, b.search( null ) );
		System.out.println( "The result of searching 'null' is.... " + b.search( null )
				+ " | assertEquals : false" );
		assertEquals( false, b.search( ' ' ) );
		System.out.println( "The result of searching ' ' is.... " + b.search( ' ' )
				+ " | assertEquals : false" );
		assertEquals( false, b.search( '0' ) );
		System.out.println( "The result of searching '0' is.... " + b.search( '0' )
				+ " | assertEquals : false" );
		assertEquals( false, b.search( '/' ) );
		System.out.println( "The result of searching '/' is.... " + b.search( '/' )
				+ " | assertEquals : false" );
		assertEquals( false, b.search( '@' ) );
		System.out.println( "The result of searching '@' is.... " + b.search( '@' )
				+ " | assertEquals : false" + "\n" );

		System.out.println( "------------- Ending OK the searchTest() method -------------\n" );
	}

	@Test public void searchReturnTest() throws Exception {
		System.out.println(
				"------------- Inicializing the searchReturnTest() method -------------\n" );
		// Creating a tree.
		AVLTree<Character> c = new AVLTree<Character>();

		// Some nodes to the AVL tree c.
		c.add( 'b' );
		c.add( 'a' );
		c.add( 'c' );
		c.add( 'f' );
		System.out.println( "Current working tree: " + c.toString() + "\n" );
		assertEquals( "b(1)a(0)--c(1)-f(0)--", c.toString() );

		// Positive testing
		System.out.print( "Positive testing starting... " );
		assertEquals( c.root().element(), c.searchAndReturn( 'b' ) );
		assertEquals( c.root().left().element(), c.searchAndReturn( 'a' ) );
		assertEquals( c.root().right().element(), c.searchAndReturn( 'c' ) );
		assertEquals( c.root().right().right().element(), c.searchAndReturn( 'f' ) );
		System.out.println( "PASSED" );

		// Negative testing
		System.out.print( "Negative testing starting... " );
		assertNotSame( c.root().element(), c.searchAndReturn( 'c' ) );
		assertNotSame( c.root().element(), c.searchAndReturn( 'a' ) );
		assertNotSame( c.root().right().right().element(), c.searchAndReturn( 'b' ) );
		System.out.println( "PASSED" );

		// All test OK
		System.out.println( "Possitive and negative tests... PASSED\n" );

		System.out
				.println( "------------- Ending OK the searchReturnTest() method -------------\n" );
	}

	@Test public void getMaxSecondTest() {
		System.out.println( "------------- Inicializing the getMaxTest() method -------------\n" );
		// Creating a tree.
		AVLTree<Character> d = new AVLTree<Character>();

		// Some nodes to the AVL tree c.
		d.add( 'b' );
		d.add( 'a' );
		d.add( 'd' );
		d.add( 'c' );
		System.out.println( "Current working tree: " + d.toString() + "\n" );

		// Positive testing
		System.out.print( "Positive testing starting... " );
		assertEquals( 'd', (char) d.max() );
		System.out.println( "PASSED" );

		// Negative Testing
		System.out.print( "Negative testing starting... " );
		assertNotSame( 'a', (char) d.max() );
		assertNotSame( 'b', (char) d.max() );
		assertNotSame( 'c', (char) d.max() );
		System.out.println( "PASSED\n" );

		System.out.println( "------------- Ending OK the getMaxTest() method -------------\n" );
	}

	@Test public void removeTest() {
		// Chars...
		charTree.add( 'b' );
		charTree.add( 'a' );
		charTree.add( 'd' );
		charTree.add( 'c' );
		charTree.add( 'g' );
		charTree.add( 'i' );
		charTree.add( 'h' );
		assertEquals( "d(0)b(0)a(0)--c(0)--h(0)g(0)--i(0)--", charTree.toString() );
		try {
			charTree.remove( 'b' );
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals( "d(0)a(1)-c(0)--h(0)g(0)--i(0)--", charTree.toString() );
		System.out.println( charTree.toString() );
		try {
			charTree.remove( 'g' );
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals( "d(0)a(1)-c(0)--h(1)-i(0)--", charTree.toString() );

		// Testing exceptions and Special cases...
		try {
			integerTree.remove( 5 );
			fail( "An exception should be thrown because integerTree is empty." );
		} catch (Exception e) {
			System.out.println( e );
		}

		try {
			integerTree.add( 1 );
			integerTree.add( 2 );
			integerTree.remove( 5 );
			fail( "An exception should be thrown because 5 is not in the tree" );
		} catch (Exception e) {
			System.out.println( e );
		}

		try {
			integerTree.add( 3 );
			integerTree.add( 4 );
			assertEquals( true, integerTree.search( 4 ) );
			integerTree.remove( 4 );
			assertEquals( false, integerTree.search( 4 ) );
			integerTree.remove( 4 );
			fail( "You cannot remove an element two times. An exception should be thrown before." );
		} catch (Exception e) {
			System.out.println( e );
		}
	}

	@Test public void updateHeightTest() {
		AVLTree<Character> a = new AVLTree<Character>();
		a.add( 'b' );
		a.add( 'a' );
		a.add( 'd' );
		a.add( 'c' );
		a.add( 'g' );
		a.add( 'i' );
		a.add( 'h' );
		assertEquals( "d(0)b(0)a(0)--c(0)--h(0)g(0)--i(0)--", a.toString() );
		System.out.println( a.toString() );

	}

	@Test public void joinTest() {
		// Easy Martin tests...
		AVLTree<Character> a = new AVLTree<Character>();
		a.add( 'b' );
		a.add( 'a' );
		a.add( 'd' );
		AVLTree<Character> b = new AVLTree<Character>();
		b.add( 'c' );
		b.add( 'g' );
		b.add( 'i' );
		b.add( 'd' );
		assertEquals( "d(0)b(0)a(0)--c(0)--g(1)-i(0)--", a.join( b ).toString() );
		System.out.println( a.join( b ).toString() );

		// Testing with an empty tree.
		AVLTree<Character> c = new AVLTree<Character>();
		assertEquals( "-", charTree.join( c ).toString() );
		assertEquals( "-", c.join( charTree ).toString() );

		// Only one empty tree.
		charTree.add( 'a' );
		charTree.add( 'b' );
		charTree.add( 'c' );
		assertEquals( "b(0)a(0)--c(0)--", charTree.join( c ).toString() );
		assertEquals( "b(0)a(0)--c(0)--", c.join( charTree ).toString() );
		System.out.println( c.join( charTree ).toString() );

		AVLTree<Integer> firstTree = new AVLTree<Integer>();
		firstTree.add( 10 );
		firstTree.add( 15 );
		assertEquals( "10(1)-15(0)--", firstTree.toString() );

		AVLTree<Integer> secondTree = new AVLTree<Integer>();
		assertEquals( "-", secondTree.toString() );

		AVLTree<Integer> newTree = firstTree.join( secondTree );
		assertEquals( "10(1)-15(0)--", newTree.toString() );
		newTree.add( 5 );
		assertEquals( "10(0)5(0)--15(0)--", newTree.toString() );
		assertEquals( "10(1)-15(0)--", firstTree.toString() );
	}

	@Test public void getBFTest() {
		// Example
		AVLTree<Character> a = new AVLTree<Character>();
		a.add( 'b' );
		a.add( 'a' );
		a.add( 'd' );
		a.add( 'c' );
		a.add( 'g' );
		a.add( 'i' );
		a.add( 'h' );
		assertEquals( "d(0)b(0)a(0)--c(0)--h(0)g(0)--i(0)--", a.toString() );

		// Own test
		integerTree.add( 5 );
		integerTree.add( 4 );
		integerTree.add( 6 );
		assertEquals( 0, integerTree.root().balance() );
		assertEquals( 0, integerTree.root().right().balance() );
		assertEquals( 0, integerTree.root().left().balance() );
		assertEquals( "5(0)4(0)--6(0)--", integerTree.toString() );
		integerTree.add( 2 );
		integerTree.add( 3 );
		assertEquals( "5(-1)3(0)2(0)--4(0)--6(0)--", integerTree.toString() );
	}

	@Test public void updateBF() {
		// Example
		AVLTree<Character> a = new AVLTree<Character>();
		a.add( 'b' );
		a.add( 'a' );
		a.add( 'd' );
		a.add( 'c' );
		a.add( 'g' );
		a.add( 'i' );
		a.add( 'h' );
		assertEquals( "d(0)b(0)a(0)--c(0)--h(0)g(0)--i(0)--", a.toString() );
	}

	@Test public void rotationsTest() {
		// Example
		AVLTree<Character> a = new AVLTree<Character>();
		a.add( 'a' );
		a.add( 'b' );
		a.add( 'c' );
		System.out.println( a.toString() );
		assertEquals( "b(0)a(0)--c(0)--", a.toString() );
		a.add( 'd' );
		a.add( 'e' );
		System.out.println( a.root().right() );
		assertEquals( "b(1)a(0)--d(0)c(0)--e(0)--", a.toString() );

		a.add( 'f' );
		assertEquals( "d(0)b(0)a(0)--c(0)--e(1)-f(0)--", a.toString() );

		// Own test
		integerTree.add( 10 );
		integerTree.add( 11 );
		integerTree.add( 12 );
		assertEquals( "11(0)10(0)--12(0)--", integerTree.toString() );
	}

	@Test public void getHeightTest() {
		assertEquals( 0, charTree.height() ); // Empty tree has height 0.
		charTree.add( 'a' ); // We add one node to the tree.
		assertEquals( 0, charTree.height() ); // A tree with only one node has
		// also height 0.
		charTree.add( 'b' ); // We add the second element.
		assertEquals( 1, charTree.height() ); // Now the height should be 1.
		charTree.add( 'c' );
		assertEquals( 1, charTree.height() ); // After the third element height
		// should be still one due to
		// rotations.
		charTree.add( 'd' );
		assertEquals( 2, charTree.height() ); // Checking that when more
		// elements are added the height
		// still increases.
	}

	@Test public void makeCopyTest() {
		integerTree.add( 5 );
		integerTree.add( 4 );
		integerTree.add( 6 );
		assertEquals( "5(0)4(0)--6(0)--", integerTree.toString() );
		AVLTree<Integer> copy = integerTree.clone();
		assertEquals( "5(0)4(0)--6(0)--", copy.toString() );
		assertEquals( integerTree.toString(), copy.toString() );
		copy.add( 3 );
		assertEquals( "5(-1)4(-1)3(0)---6(0)--", copy.toString() );
		assertEquals( "5(0)4(0)--6(0)--", integerTree.toString() );
		assertNotEquals( integerTree.toString(), copy.toString() );
	}

	@Test public void toListTest() {
		charTree.add( 'b' );
		charTree.add( 'c' );
		charTree.add( 'a' );
		System.out.println( charTree.toList().toString() );
	}

	@Test public void countTest() {
		integerTree.add( 1 );
		integerTree.add( 2 );
		integerTree.add( 3 );
		integerTree.add( 4 );
		integerTree.add( 5 );
		assertEquals( 5, integerTree.numberOfNodes() );
		assertEquals( 0, charTree.numberOfNodes() );
		stringTree.add( "aa" );
		assertEquals( 1, stringTree.numberOfNodes() );
	}

	@Test public void getDifferenceTest() {
		// This will be the second tree.
		AVLTree<Integer> secondIntegerTree = new AVLTree<Integer>();
		// This will be the tree were the result will be stored.
		AVLTree<Integer> result = new AVLTree<Integer>();

		// First tree --> empty.
		// Second tree --> empty.
		// Result --> empty.
		result = integerTree.difference( secondIntegerTree );
		assertEquals( true, result.isEmpty() );

		// First tree --> 1, 2.
		// Second tree --> empty.
		// Result --> 1, 2.
		integerTree.add( 1 );
		integerTree.add( 2 );
		result = integerTree.difference( secondIntegerTree );
		assertEquals( true, result.search( 1 ) );
		assertEquals( true, result.search( 2 ) );

		// First tree --> 1, 2.
		// Second tree --> 1.
		// Result --> 2.
		secondIntegerTree.add( 1 );
		result = integerTree.difference( secondIntegerTree );
		assertEquals( false, result.search( 1 ) );
		assertEquals( true, result.search( 2 ) );

		// First tree --> 1, 2.
		// Second tree --> 1, 3.
		// Result --> 2, 3.
		secondIntegerTree.add( 3 );
		result = integerTree.difference( secondIntegerTree );
		assertEquals( false, result.search( 1 ) );
		assertEquals( true, result.search( 2 ) );
		assertEquals( true, result.search( 3 ) );

	}

	@Test public void getNumberOfEementsGreaterThanTest() {
		// Integers
		// Testing with no elements so an exception should be thrower.
		try {
			integerTree.numberOfElementsGreaterThan( 1 );
			fail( "An exception should be throwed because the tree is empty." );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Testing with one element
		integerTree.add( 20 );

		// One element and condition bigger than the actual value.
		// Expected no elements.
		assertEquals( 0, integerTree.numberOfElementsGreaterThan( 20 ) );

		// Testing with one elements and condition lower than the current value.
		// Expected one element.
		assertEquals( 1, integerTree.numberOfElementsGreaterThan( 19 ) );

		// Adding a second element lower than the first one and condition equals
		// to the first element.
		// Expected no elements
		integerTree.add( 19 );
		assertEquals( 0, integerTree.numberOfElementsGreaterThan( 20 ) );

		// Strings are different data type so lets tests it also.
		try {
			stringTree.numberOfElementsGreaterThan( "a" );
			fail( "An exception should be throwed because the tree is empty." );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Testing with one element
		stringTree.add( "b" );

		// One element and condition bigger than the actual value.
		// Expected no elements.
		assertEquals( 0, stringTree.numberOfElementsGreaterThan( "b" ) );

		// Testing with one elements and condition lower than the current value.
		// Expected one element.
		assertEquals( 1, stringTree.numberOfElementsGreaterThan( "a" ) );

		// Adding a second element lower than the first one and condition equals
		// to the first element.
		// Expected no elements
		stringTree.add( "a" );
		assertEquals( 0, stringTree.numberOfElementsGreaterThan( "b" ) );

	}

	@Test public void getGreaterElementsTest() {
		// Integers
		// Testing with no elements so an exception should be thrower.
		try {
			integerTree.numberOfElementsGreaterThan( 1 );
			fail( "An exception should be throwed because the tree is empty." );
		} catch (Exception e) {
			System.out.println( e );
		}

		// Testing with one element
		integerTree.add( 20 );

		// One element and condition bigger than the actual value.
		// Expected no elements.
		assertEquals( 0, integerTree.greaterElements( 20 ) );

		// Testing with one elements and condition lower than the current value.
		// Expected one element.
		assertEquals( 1, integerTree.greaterElements( 19 ) );

		// Adding a second element lower than the first one and condition equals
		// to the first element.
		// Expected no elements
		integerTree.add( 17 );
		assertEquals( 0, integerTree.greaterElements( 20 ) );

		integerTree.add( 25 );
		integerTree.add( 16 );
		integerTree.add( 26 );
		integerTree.add( 24 );
		integerTree.add( 18 );
		assertEquals( 5, integerTree.greaterElements( 17 ) );
	}
}

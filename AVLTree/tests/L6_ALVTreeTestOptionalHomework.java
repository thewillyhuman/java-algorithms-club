package AVLTree.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import AVLTree.AVLTree;

/**
 * 
 * @author Carlos Mencía
 * @version 0.1
 *
 */
public class L6_ALVTreeTestOptionalHomework {

	@SuppressWarnings("deprecation") @Test public void testAddIterative() {
		AVLTree<String> t = new AVLTree<String>();
		t.addIterative( "b" );
		assertEquals( "b(0)--", t.toString() );

		t.addIterative( "a" );
		assertEquals( "b(-1)a(0)---", t.toString() );

		t.addIterative( "d" );
		assertEquals( "b(0)a(0)--d(0)--", t.toString() );

		t.addIterative( "c" );
		assertEquals( "b(1)a(0)--d(-1)c(0)---", t.toString() );

		t.addIterative( "g" );
		assertEquals( "b(1)a(0)--d(0)c(0)--g(0)--", t.toString() );

		t.addIterative( "i" );
		assertEquals( "b(2)a(0)--d(1)c(0)--g(1)-i(0)--", t.toString() );

		t.addIterative( "h" );
		assertEquals( "b(3)a(0)--d(2)c(0)--g(2)-i(-1)h(0)---", t.toString() );

		try {
			t.add( "a" );
		} catch (Exception e) {
			System.out.println( e );
		}

	}

	@SuppressWarnings("deprecation") @Test public void testSearchIterative() {
		AVLTree<String> t = new AVLTree<String>();

		// Searching in an empty tree
		// -
		assertEquals( false, t.search( "a" ) );

		t.add( "b" );
		/*
		 * b - -
		 */
		assertEquals( true, t.searchIterative( "b" ) );
		assertEquals( false, t.searchIterative( "a" ) );
		assertEquals( false, t.searchIterative( "c" ) );

		t.add( "a" );
		/*
		 * b a - - -
		 */
		assertEquals( true, t.searchIterative( "a" ) );
		assertEquals( true, t.searchIterative( "b" ) );
		assertEquals( false, t.searchIterative( "c" ) );

		t.add( "d" );
		/*
		 * b a d - - - -
		 */
		assertEquals( true, t.searchIterative( "d" ) );
		assertEquals( true, t.searchIterative( "a" ) );
		assertEquals( true, t.searchIterative( "b" ) );
		assertEquals( false, t.searchIterative( "c" ) );
		assertEquals( false, t.searchIterative( "e" ) );

		t.add( "c" );
		/*
		 * b a d - - c - - -
		 */
		assertEquals( true, t.searchIterative( "d" ) );
		assertEquals( true, t.searchIterative( "a" ) );
		assertEquals( true, t.searchIterative( "b" ) );
		assertEquals( true, t.searchIterative( "c" ) );
		assertEquals( false, t.searchIterative( "e" ) );

		t.add( "g" );
		/*
		 * b a d - - c g - - - -
		 */
		assertEquals( true, t.searchIterative( "d" ) );
		assertEquals( true, t.searchIterative( "a" ) );
		assertEquals( true, t.searchIterative( "b" ) );
		assertEquals( true, t.searchIterative( "c" ) );
		assertEquals( true, t.searchIterative( "g" ) );
		assertEquals( false, t.searchIterative( "e" ) );
		assertEquals( false, t.searchIterative( "h" ) );

		t.add( "i" );
		/*
		 * b a d - - c g - - - i - -
		 */
		assertEquals( true, t.searchIterative( "d" ) );
		assertEquals( true, t.searchIterative( "a" ) );
		assertEquals( true, t.searchIterative( "b" ) );
		assertEquals( true, t.searchIterative( "c" ) );
		assertEquals( true, t.searchIterative( "g" ) );
		assertEquals( true, t.searchIterative( "i" ) );
		assertEquals( false, t.searchIterative( "e" ) );
		assertEquals( false, t.searchIterative( "h" ) );
		assertEquals( false, t.searchIterative( "j" ) );

		t.add( "h" );
		/*
		 * b a d - - c g - - - i h - - -
		 */
		assertEquals( true, t.searchIterative( "d" ) );
		assertEquals( true, t.searchIterative( "a" ) );
		assertEquals( true, t.searchIterative( "b" ) );
		assertEquals( true, t.searchIterative( "c" ) );
		assertEquals( true, t.searchIterative( "g" ) );
		assertEquals( true, t.searchIterative( "i" ) );
		assertEquals( true, t.searchIterative( "h" ) );
		assertEquals( false, t.searchIterative( "e" ) );
		assertEquals( false, t.searchIterative( "j" ) );

	}

	@Test public void testTraversals() {
		AVLTree<String> t = new AVLTree<String>();
		t.add( "b" );
		assertEquals( "b(0)--", t.toString() );

		t.add( "a" );
		assertEquals( "b(-1)a(0)---", t.toString() );

		t.add( "d" );
		assertEquals( "b(0)a(0)--d(0)--", t.toString() );

		t.add( "c" );
		assertEquals( "b(1)a(0)--d(-1)c(0)---", t.toString() );

		t.add( "g" );
		assertEquals( "b(1)a(0)--d(0)c(0)--g(0)--", t.toString() );

		t.add( "i" );
		assertEquals( "d(0)b(0)a(0)--c(0)--g(1)-i(0)--", t.toString() );

		t.add( "h" );
		assertEquals( "d(0)b(0)a(0)--c(0)--h(0)g(0)--i(0)--", t.toString() );

		assertEquals( "-a-b-c-d-g-h-i-", t.inOrderTraversal() );
		assertEquals( "--a--cb--g--ihd", t.postOrderTraversal() );

	}

}

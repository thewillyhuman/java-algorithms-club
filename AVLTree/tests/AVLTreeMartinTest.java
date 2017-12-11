package AVLTree.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import AVLTree.AVLTree;

/**
 * 
 * @author Guillermo Facundo Colunga
 * @version 2.1
 */
public class AVLTreeMartinTest {

	@Test public void addTest() {
		// Example.
		AVLTree<Character> a = new AVLTree<Character>();
		a.add( 'b' );
		assertEquals( "b(0)--", a.toString() );
		a.add( 'a' );
		assertEquals( "b(-1)a(0)---", a.toString() );
		a.add( 'd' );
		assertEquals( "b(0)a(0)--d(0)--", a.toString() );
		a.add( 'c' );
		assertEquals( "b(1)a(0)--d(-1)c(0)---", a.toString() );
		a.add( 'g' );
		assertEquals( "b(1)a(0)--d(0)c(0)--g(0)--", a.toString() );
		a.add( 'i' );
		assertEquals( "d(0)b(0)a(0)--c(0)--g(1)-i(0)--", a.toString() );
		a.add( 'h' );
		assertEquals( "d(0)b(0)a(0)--c(0)--h(0)g(0)--i(0)--", a.toString() );

	}

	@Test public void searchTest() {
		// Example
		AVLTree<Character> a = new AVLTree<Character>();
		a.add( 'b' );
		a.add( 'a' );
		a.add( 'd' );
		a.add( 'c' );
		a.add( 'g' );
		a.add( 'i' );
		a.add( 'h' );
		assertEquals( true, a.search( 'i' ) );
		assertEquals( false, a.search( 'f' ) );

	}
}

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
public class L7_AVLTreeTestBasicOpsWithHeight {

	@Test public void testAddRemove() throws Exception {
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

		t.remove( "b" );
		assertEquals( "d(0)a(1)-c(0)--h(0)g(0)--i(0)--", t.toString() );
		t.remove( "g" );
		assertEquals( "d(0)a(1)-c(0)--h(1)-i(0)--", t.toString() );
		t.remove( "c" );
		assertEquals( "d(1)a(0)--h(1)-i(0)--", t.toString() );
		t.remove( "h" );
		assertEquals( "d(0)a(0)--i(0)--", t.toString() );

		try {
			t.add( "a" );
		} catch (Exception e) {
			System.out.println( e );
		}

	}

}

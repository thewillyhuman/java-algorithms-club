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
public class Carlos_Unit8EvalTest {

	@Test public void testGetHeightCarlos() {

		AVLTree<Integer> ti = new AVLTree<Integer>();

		ti.add( 10 );
		ti.add( 6 );
		ti.add( 15 );
		ti.add( 3 );
		ti.add( 9 );
		ti.add( 14 );
		ti.add( 20 );
		ti.add( 2 );
		ti.add( 4 );
		ti.add( 7 );
		ti.add( 12 );
		ti.add( 1 );

		assertEquals( "10(-1)6(-1)3(-1)2(-1)1(0)---4(0)--9(-1)7(0)---15(-1)14(-1)12(0)---20(0)--",
				ti.toString() );
		assertEquals( 4, ti.height() );

		// 20, 4, 10, 9, 6, 3.

		ti.remove( 20 );

		assertEquals( "6(0)3(-1)2(-1)1(0)---4(0)--10(0)9(-1)7(0)---14(0)12(0)--15(0)--",
				ti.toString() );
		assertEquals( 3, ti.height() );

		ti.remove( 4 );

		assertEquals( "6(1)2(0)1(0)--3(0)--10(0)9(-1)7(0)---14(0)12(0)--15(0)--", ti.toString() );
		assertEquals( 3, ti.height() );

		ti.remove( 10 );

		assertEquals( "6(1)2(0)1(0)--3(0)--9(1)7(0)--14(0)12(0)--15(0)--", ti.toString() );
		assertEquals( 3, ti.height() );

		ti.remove( 9 );

		assertEquals( "6(1)2(0)1(0)--3(0)--14(-1)7(1)-12(0)--15(0)--", ti.toString() );
		assertEquals( 3, ti.height() );

		ti.remove( 6 );

		assertEquals( "3(1)2(-1)1(0)---14(-1)7(1)-12(0)--15(0)--", ti.toString() );
		assertEquals( 3, ti.height() );

		ti.remove( 3 );

		assertEquals( "7(0)2(-1)1(0)---14(0)12(0)--15(0)--", ti.toString() );
		assertEquals( 2, ti.height() );
	}

	@Test public void testSingleRotation() {
		// Single right rotations
		AVLTree<Character> a = new AVLTree<Character>();
		a.add( 'a' );
		a.add( 'b' );
		a.add( 'd' );
		assertEquals( "b(0)a(0)--d(0)--", a.toString() );

		a.add( 'c' );
		a.add( 'e' );
		a.add( 'f' );
		assertEquals( "d(0)b(0)a(0)--c(0)--e(1)-f(0)--", a.toString() );

		// Single left rotations
		AVLTree<Character> b = new AVLTree<Character>();
		b.add( 'f' );
		b.add( 'e' );
		b.add( 'c' );
		assertEquals( "e(0)c(0)--f(0)--", b.toString() );

		b.add( 'd' );
		b.add( 'b' );
		b.add( 'a' );
		assertEquals( "c(0)b(-1)a(0)---e(0)d(0)--f(0)--", b.toString() );
	}

	@Test public void testDoubleRotation() {
		// Double left rotation
		AVLTree<Character> a = new AVLTree<Character>();
		a.add( 'e' );
		a.add( 'g' );
		a.add( 'b' );
		a.add( 'd' );
		a.add( 'c' );
		assertEquals( "e(-1)c(0)b(0)--d(0)--g(0)--", a.toString() );

		// Double right rotation
		AVLTree<Character> b = new AVLTree<Character>();
		b.add( 'd' );
		b.add( 'b' );
		b.add( 'g' );
		b.add( 'e' );
		b.add( 'f' );
		assertEquals( "d(1)b(0)--f(0)e(0)--g(0)--", b.toString() );
	}

	@Test public void testRemoval() {
		// Double left rotation
		AVLTree<Integer> a = new AVLTree<Integer>();
		a.add( 10 );
		a.add( 2 );
		a.add( 35 );
		a.add( 1 );
		a.add( 8 );
		a.add( 20 );
		a.add( 40 );
		a.add( 5 );
		a.add( 15 );
		a.add( 25 );
		a.add( 50 );
		a.add( 30 );
		assertEquals( "10(1)2(1)1(0)--8(-1)5(0)---35(-1)20(1)15(0)--25(1)-30(0)--40(1)-50(0)--",
				a.toString() );

		a.remove( 2 );
		assertEquals( "20(0)10(-1)5(0)1(0)--8(0)--15(0)--35(0)25(1)-30(0)--40(1)-50(0)--",
				a.toString() );

		a.remove( 20 );
		assertEquals( "15(0)5(1)1(0)--10(-1)8(0)---35(0)25(1)-30(0)--40(1)-50(0)--", a.toString() );

		a.remove( 5 );
		assertEquals( "15(1)8(0)1(0)--10(0)--35(0)25(1)-30(0)--40(1)-50(0)--", a.toString() );
	}

}

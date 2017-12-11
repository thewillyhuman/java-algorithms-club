package BinaryHeap.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import BinaryHeap.BinaryHeap;

public class BinaryHeapMartinTest {

	@Test public void addTest() {
		BinaryHeap<Integer> a = new BinaryHeap<Integer>();
		a.add( 10 );
		a.add( 9 );
		a.add( 8 );
		assertTrue( a.toString().equals( "[8, 10, 9]" ) );
		a.add( 7 );
		assertTrue( a.toString().equals( "[7, 8, 9, 10]" ) );
		a.add( 6 );
		assertTrue( a.toString().equals( "[6, 7, 9, 10, 8]" ) );
		a.add( 5 );
		assertTrue( a.toString().equals( "[5, 7, 6, 10, 8, 9]" ) );
		a.add( 4 );
		assertTrue( a.toString().equals( "[4, 7, 5, 10, 8, 9, 6]" ) );
	}

	@Test public void removeTest() {
		BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
		heap.add( 9 );
		heap.add( 8 );
		heap.add( 7 );
		heap.add( 6 );
		heap.add( 5 );
		heap.add( 1 );
		heap.add( 2 );
		heap.add( 3 );
		heap.add( 4 );

		assertEquals( heap.toString(), "[1, 3, 2, 4, 7, 8, 5, 9, 6]" );
		assertEquals( 1, (int) heap.min() );
		assertEquals( heap.toString(), "[2, 3, 5, 4, 7, 8, 6, 9]" );
	}

	@Test public void fullMartinTest() {
		BinaryHeap<Character> b = new BinaryHeap<Character>();

		b.add( 'f' );
		b.add( 'g' );
		b.add( 'a' );
		b.add( 'z' );
		b.add( 'd' );

		System.out.println( b.toString() );
		assertEquals( b.toString(), "[a, d, f, z, g]" );
		assertEquals( 'a', (char) b.min() );
		assertEquals( b.toString(), "[d, g, f, z]" );
	}

	@Test public void secondConstructorTest() {
		BinaryHeap<Integer> a = new BinaryHeap<Integer>(
				new Integer[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 } );

		assertEquals( "[1, 2, 4, 3, 6, 5, 8, 10, 7, 9]", a.toString() );
	}

}

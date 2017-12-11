package BinaryHeap.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import BinaryHeap.BinaryHeap;

public class BinaryHeapTest {

	BinaryHeap<Integer> integerHeap;

	@Before public void setUp() {
		integerHeap = new BinaryHeap<Integer>();
	}

	@Test public void constructorTest() {
		// Testing the first Constructor
		BinaryHeap<Integer> auxHeap = new BinaryHeap<Integer>();
		assertEquals( "[]", auxHeap.toString() );

		// Testing the second Constructor
		BinaryHeap<Integer> secondAuxHeap = new BinaryHeap<Integer>( new Integer[] {} );
		assertEquals( "[]", secondAuxHeap.toString() );
		BinaryHeap<Integer> tirhtAuxHeap = new BinaryHeap<Integer>(
				new Integer[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 } );
		assertEquals( "[1, 2, 4, 3, 6, 5, 8, 10, 7, 9]", tirhtAuxHeap.toString() );
	}

	@Test public void addTest() {
		integerHeap.add( 1 );
		assertEquals( "[1]", integerHeap.toString() );

		integerHeap.add( 10 );
		assertEquals( "[1, 10]", integerHeap.toString() );

		// Testing that repeated elements cannot be added to the heap.
		try {
			integerHeap.add( 10 );
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println( e );
		}

		integerHeap.add( 9 );
		integerHeap.add( 2 );
		integerHeap.add( 8 );
		integerHeap.add( 3 );
		integerHeap.add( 7 );
		integerHeap.add( 4 );
		integerHeap.add( 6 );
		integerHeap.add( 5 );
		assertEquals( "[1, 2, 3, 4, 5, 9, 7, 10, 6, 8]", integerHeap.toString() );
	}

	@Test public void getMeinTest() {
		// If the heap is null we will throw an exception.
		try {
			assertEquals( null, (int) integerHeap.min() );
			fail();
		} catch (IllegalStateException e) {
			System.out.println( e );
		}
		integerHeap.add( 10 );
		integerHeap.add( 9 );
		integerHeap.add( 8 );
		integerHeap.add( 7 );
		integerHeap.add( 6 );
		integerHeap.add( 5 );
		integerHeap.add( 4 );
		integerHeap.add( 3 );
		integerHeap.add( 2 );
		integerHeap.add( 1 );
		assertEquals( "[1, 2, 5, 4, 3, 9, 6, 10, 7, 8]", integerHeap.toString() );
		assertEquals( 1, (int) integerHeap.min() );
		assertEquals( "[2, 3, 5, 4, 8, 9, 6, 10, 7]", integerHeap.toString() );
	}
}

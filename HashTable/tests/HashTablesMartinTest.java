package HashTable.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import HashTable.HashTable;

public class HashTablesMartinTest {

	@Test public void martinTest() {
		HashTable<Integer> a = new HashTable<Integer>( 5, HashTable.LINEAR_PROBING, 1.0 );
		a.add( 4 );
		a.add( 13 );
		a.add( 24 );
		a.add( 3 );
		assertEquals( "[0] (1) = 24 - [1] (1) = 3 - [2] (0) = null - [3] (1) = 13 - [4] (1) = 4 - ",
				a.toString() );
		assertEquals( true, a.search( 3 ) );
		assertEquals( false, a.search( 12 ) );
	}

	@Test public void addAndSearchTest() {
		HashTable<Integer> a = new HashTable<Integer>( 5, HashTable.LINEAR_PROBING, 1.0 );
		a.add( 4 );
		a.add( 13 );
		a.add( 24 );
		a.add( 3 );
		assertEquals( "[0] (1) = 24 - [1] (1) = 3 - [2] (0) = null - [3] (1) = 13 - [4] (1) = 4 - ",
				a.toString() );
		assertEquals( true, a.search( 3 ) );
		assertEquals( false, a.search( 12 ) );
	}

	@Test public void doubleHashingTest() {
		// With integer values.
		HashTable<Integer> c = new HashTable<Integer>( 5, HashTable.DOUBLE_HASHING, 0.5 );
		assertEquals( 2, c.f( 7, 0 ) );
		assertEquals( 4, c.f( 7, 1 ) );
		assertEquals( 1, c.f( 7, 2 ) );
		assertEquals( 3, c.f( 7, 3 ) );
		assertEquals( 0, c.f( 7, 4 ) );
		assertEquals( 0, c.f( 0, 0 ) );
		assertEquals( 1, c.f( 2, 4 ) );
		assertEquals( 2, c.f( 3, 3 ) );
		assertEquals( 3, c.f( 32, 1 ) );
		assertEquals( 4, c.f( 1045, 2 ) );

		// With char elements.
		HashTable<Character> d = new HashTable<Character>( 5, HashTable.DOUBLE_HASHING, 0.5 );
		assertEquals( 0, d.f( 'A', 0 ) );
		assertEquals( 1, d.f( 'A', 1 ) );
		assertEquals( 2, d.f( 'A', 2 ) );
		assertEquals( 3, d.f( 'A', 3 ) );
		assertEquals( 4, d.f( 'A', 4 ) );
		assertEquals( 2, d.f( 'a', 0 ) );
		assertEquals( 4, d.f( 'a', 1 ) );
		assertEquals( 1, d.f( 'a', 2 ) );
		assertEquals( 3, d.f( 'a', 3 ) );
		assertEquals( 0, d.f( 'a', 4 ) );
	}

	@Test public void searchAndRemoveWithDoubleHashingTest() {
		HashTable<Integer> c = new HashTable<Integer>( 5, HashTable.DOUBLE_HASHING, 1.0 );
		c.add( 4 );
		c.add( 13 );
		c.add( 24 );
		c.add( 3 );
		assertEquals( "[0] (0) = null - [1] (1) = 3 - [2] (1) = 24 - [3] (1) = 13 - [4] (1) = 4 - ",
				c.toString() );
		c.remove( 24 );
		assertEquals( "[0] (0) = null - [1] (1) = 3 - [2] (2) = 24 - [3] (1) = 13 - [4] (1) = 4 - ",
				c.toString() );
		assertEquals( true, c.search( 3 ) );
		c.add( 15 );
		assertEquals( true, c.search( 3 ) );
		assertEquals( "[0] (1) = 15 - [1] (1) = 3 - [2] (2) = 24 - [3] (1) = 13 - [4] (1) = 4 - ",
				c.toString() );
	}

	@Test public void dynamicResizingTest() {
		HashTable<Integer> a = new HashTable<Integer>( 5, HashTable.LINEAR_PROBING, 0.5 );
		a.add( 4 );
		assertEquals( 0.2, a.loadFactor(), 0.1 );
		a.add( 13 );
		assertEquals( 0.4, a.loadFactor(), 0.1 );
		assertEquals(
				"[0] (0) = null - [1] (0) = null - [2] (0) = null - [3] (1) = 13 - [4] (1) = 4 - ",
				a.toString() );
		a.add( 24 ); // DYNAMIC RESIZING!
		assertEquals( 0.27, a.loadFactor(), 0.1 );
		assertEquals(
				"[0] (0) = null - [1] (0) = null - [2] (1) = 24 - [3] (1) = 13 - [4] (1) = 4 - [5] (0) = null - [6] (0) = null - [7] (0) = null - [8] (0) = null - [9] (0) = null - [10] (0) = null - ",
				a.toString() );
	}
}

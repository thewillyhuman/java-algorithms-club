package Linkedlist.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Linkedlist.LinkedNode;

public class LinkedNodeTest {

	private LinkedNode<Integer> intNode;
	private LinkedNode<String> strNode;
	private LinkedNode<Double> dblNode;

	@Before public void setUp() {
		intNode = new LinkedNode<Integer>( 1 );
		strNode = new LinkedNode<String>( "a" );
		dblNode = new LinkedNode<Double>( 1.0 );
	}
	
	@After public void tearDown() {
		intNode.delete();
		strNode.delete();
		dblNode.delete();
	}

	@Test public void getValueTest() {
		// Integer.
		assertEquals( 1, intNode.content().intValue() );

		// String.
		assertEquals( "a", strNode.content() );

		// Double.
		assertEquals( 1.0, dblNode.content().doubleValue(), 0.00001 );
	}

	@Test public void setValueTest() {
		// Integer.
		assertEquals( 1, intNode.content().intValue() );
		intNode.content( -2 );
		assertEquals( -2, intNode.content().intValue() );

		// String.
		assertEquals( "a", strNode.content() );
		strNode.content( "b" );
		assertEquals( "b", strNode.content() );

		// Double
		assertEquals( 1.0, dblNode.content().doubleValue(), 0.00001 );
		dblNode.content( -1.1 );
		assertEquals( -1.1, dblNode.content().doubleValue(), 0.00001 );
	}

	@Test public void previousNodeTest() {
		// Integer.
		assertNull( intNode.previous() );
		intNode.previous( new LinkedNode<Integer>( 0 ) );
		assertEquals( 0, intNode.previous().content().intValue() );

		// Same for String and Double.
	}
	
	@Test public void nextNodeTest() {
		// Integer.
		assertNull( intNode.next() );
		intNode.next( new LinkedNode<Integer>( 2 ) );
		assertEquals( 2, intNode.next().content().intValue() );

		// Same for String and Double.
	}

	@Test public void deleteTest() {
		// Integer.
		intNode.delete();
		assertNull( intNode.previous() );
		assertNull( intNode.content() );
		assertNull( intNode.next() );

		// String.
		strNode.delete();
		assertNull( strNode.previous() );
		assertNull( strNode.content() );
		assertNull( strNode.next() );

		// Double
		dblNode.delete();
		assertNull( dblNode.previous() );
		assertNull( dblNode.content() );
		assertNull( dblNode.next() );
	}

	@SuppressWarnings("unused") @Test public void mutabilityTest() {
		// Integer.
		assertEquals( 1, intNode.content().intValue() );
		int i = intNode.content();
		i = -2;
		assertEquals( 1, intNode.content().intValue() );
		LinkedNode<Integer> auxIntNode = intNode;
		assertEquals( 1, auxIntNode.content().intValue() );
		auxIntNode.content( -2 );
		assertEquals( -2, intNode.content().intValue() );

		// String.
		assertEquals( "a", strNode.content() );
		String s = strNode.content();
		s = "b";
		assertEquals( "a", strNode.content() );
		LinkedNode<String> auxStringNode = strNode;
		assertEquals( "a", auxStringNode.content() );
		auxStringNode.content( "b" );
		assertEquals( "b", strNode.content() );

		// The same for doubles...

	}

}

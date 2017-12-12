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
		assertEquals( 1, intNode.value().intValue() );

		// String.
		assertEquals( "a", strNode.value() );

		// Double.
		assertEquals( 1.0, dblNode.value().doubleValue(), 0.00001 );
	}

	@Test public void setValueTest() {
		// Integer.
		assertEquals( 1, intNode.value().intValue() );
		intNode.value( -2 );
		assertEquals( -2, intNode.value().intValue() );

		// String.
		assertEquals( "a", strNode.value() );
		strNode.value( "b" );
		assertEquals( "b", strNode.value() );

		// Double
		assertEquals( 1.0, dblNode.value().doubleValue(), 0.00001 );
		dblNode.value( -1.1 );
		assertEquals( -1.1, dblNode.value().doubleValue(), 0.00001 );
	}

	@Test public void previousNodeTest() {
		// Integer.
		assertNull( intNode.previous() );
		intNode.previous( new LinkedNode<Integer>( 0 ) );
		assertEquals( 0, intNode.previous().value().intValue() );

		// Same for String and Double.
	}
	
	@Test public void nextNodeTest() {
		// Integer.
		assertNull( intNode.next() );
		intNode.next( new LinkedNode<Integer>( 2 ) );
		assertEquals( 2, intNode.next().value().intValue() );

		// Same for String and Double.
	}

	@Test public void deleteTest() {
		// Integer.
		intNode.delete();
		assertNull( intNode.previous() );
		assertNull( intNode.value() );
		assertNull( intNode.next() );

		// String.
		strNode.delete();
		assertNull( strNode.previous() );
		assertNull( strNode.value() );
		assertNull( strNode.next() );

		// Double
		dblNode.delete();
		assertNull( dblNode.previous() );
		assertNull( dblNode.value() );
		assertNull( dblNode.next() );
	}

	@SuppressWarnings("unused") @Test public void mutabilityTest() {
		// Integer.
		assertEquals( 1, intNode.value().intValue() );
		int i = intNode.value();
		i = -2;
		assertEquals( 1, intNode.value().intValue() );
		LinkedNode<Integer> auxIntNode = intNode;
		assertEquals( 1, auxIntNode.value().intValue() );
		auxIntNode.value( -2 );
		assertEquals( -2, intNode.value().intValue() );

		// String.
		assertEquals( "a", strNode.value() );
		String s = strNode.value();
		s = "b";
		assertEquals( "a", strNode.value() );
		LinkedNode<String> auxStringNode = strNode;
		assertEquals( "a", auxStringNode.value() );
		auxStringNode.value( "b" );
		assertEquals( "b", strNode.value() );

		// The same for doubles...

	}

}

package Graph.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Graph.GenericDataStructure;

/**
 * 
 * @author Guillermo Facundo Colunga
 * @version 2.1
 */
public class GenericDataStructureTest {

	private GenericDataStructure<String> StringGds = null;
	private GenericDataStructure<Integer> IntegerGds = null;
	private GenericDataStructure<Character> CharGds = null;

	@Before public void setUp() {
		StringGds = new GenericDataStructure<String>();
		IntegerGds = new GenericDataStructure<Integer>();
		CharGds = new GenericDataStructure<Character>();
	}

	@Test public void addTest() {
		// Strings...
		StringGds.add( "a" );
		assertEquals( "a.", StringGds.toString() );
		StringGds.add( "b" );
		assertEquals( "a.b.", StringGds.toString() );
		StringGds.add( "c" );
		assertEquals( "a.b.c.", StringGds.toString() );
		StringGds.add( "d" );
		assertEquals( "a.b.c.d.", StringGds.toString() );

		// Integers...
		IntegerGds.add( 1 );
		assertEquals( "1.", IntegerGds.toString() );
		IntegerGds.add( 2 );
		assertEquals( "1.2.", IntegerGds.toString() );
		IntegerGds.add( 3 );
		assertEquals( "1.2.3.", IntegerGds.toString() );
		IntegerGds.add( 4 );
		assertEquals( "1.2.3.4.", IntegerGds.toString() );

		// Characters...
		CharGds.add( 'A' );
		assertEquals( "A.", CharGds.toString() );
		CharGds.add( 'B' );
		assertEquals( "A.B.", CharGds.toString() );
		CharGds.add( 'C' );
		assertEquals( "A.B.C.", CharGds.toString() );
		CharGds.add( 'D' );
		assertEquals( "A.B.C.D.", CharGds.toString() );
	}

	@Test public void sortTest() {
		// Strings...
		StringGds.add( "d" );
		StringGds.add( "c" );
		StringGds.add( "b" );
		StringGds.add( "a" );
		assertEquals( "a.b.c.d.", StringGds.toString() );

		// Integers...
		IntegerGds.add( 4 );
		IntegerGds.add( 3 );
		IntegerGds.add( 2 );
		IntegerGds.add( 1 );
		assertEquals( "1.2.3.4.", IntegerGds.toString() );

		// Characters...
		CharGds.add( 'D' );
		CharGds.add( 'C' );
		CharGds.add( 'B' );
		CharGds.add( 'A' );
		assertEquals( "A.B.C.D.", CharGds.toString() );
	}

	@Test public void compareToTest() {
		// Strings...
		StringGds.add( "a" );
		StringGds.add( "b" );
		StringGds.add( "c" );
		StringGds.add( "d" );
		assertEquals( -1, StringGds.compareTwoElements( 1, 2 ) );
		assertEquals( 1, StringGds.compareTwoElements( 2, 1 ) );
		assertEquals( 0, StringGds.compareTwoElements( 0, 0 ) );

		// Integers...
		IntegerGds.add( 1 );
		IntegerGds.add( 2 );
		IntegerGds.add( 3 );
		IntegerGds.add( 4 );
		assertEquals( -1, IntegerGds.compareTwoElements( 1, 2 ) );
		assertEquals( 1, IntegerGds.compareTwoElements( 2, 1 ) );
		assertEquals( 0, IntegerGds.compareTwoElements( 0, 0 ) );

		// Characters...
		CharGds.add( 'A' );
		CharGds.add( 'B' );
		CharGds.add( 'C' );
		CharGds.add( 'D' );
		assertEquals( -1, CharGds.compareTwoElements( 1, 2 ) );
		assertEquals( 1, CharGds.compareTwoElements( 2, 1 ) );
		assertEquals( 0, CharGds.compareTwoElements( 0, 0 ) );
	}

	@Test public void toStringTest() {
		// Strings...
		StringGds.add( "a" );
		StringGds.add( "b" );
		StringGds.add( "c" );
		StringGds.add( "d" );
		assertEquals( "a.b.c.d.", StringGds.toString() );

		// Integers...
		IntegerGds.add( 1 );
		IntegerGds.add( 2 );
		IntegerGds.add( 3 );
		IntegerGds.add( 4 );
		assertEquals( "1.2.3.4.", IntegerGds.toString() );

		// Characters...
		CharGds.add( 'A' );
		CharGds.add( 'B' );
		CharGds.add( 'C' );
		CharGds.add( 'D' );
		assertEquals( "A.B.C.D.", CharGds.toString() );
	}

}

package Graph.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Graph.Container;

/**
 * 
 * @author Guillermo Facundo Colunga
 * @version 2.1
 */
public class ContainerTest {

	Container<String> StringContainer = null;
	Container<Integer> IntegerContainer = null;
	Container<Character> CharContainer = null;

	@Before public void setUp() {
		StringContainer = new Container<String>( "" );
		IntegerContainer = new Container<Integer>( 2 );
		CharContainer = new Container<Character>( 'A' );
	}

	@Test public void setStringElementTest() {
		StringContainer.element( "Hola caracola" );
		assertEquals( "Hola caracola", StringContainer.element() );
		StringContainer.element( null );
		assertEquals( "Hola caracola", StringContainer.element() );
		StringContainer.element( "" );
		assertEquals( "", StringContainer.element() );
	}

	@Test public void setIntegerElementTest() {
		IntegerContainer.element( 5 );
		assertEquals( 5, (int) IntegerContainer.element() );
		IntegerContainer.element( null );
		assertEquals( 5, (int) IntegerContainer.element() );
		IntegerContainer.element( 4 );
		assertEquals( 4, (int) IntegerContainer.element() );
	}

	@Test public void setCharElementTest() {
		CharContainer.element( 'B' );
		assertEquals( 'B', (char) CharContainer.element() );
		CharContainer.element( null );
		assertEquals( 'B', (char) CharContainer.element() );
		CharContainer.element( 'C' );
		assertEquals( 'C', (int) CharContainer.element() );
	}

	@Test public void getStringElementTest() {
		StringContainer.element( "Hola caracola" );
		assertEquals( "Hola caracola", StringContainer.element() );
	}

	@Test public void getIntegerElementTest() {
		IntegerContainer.element( 5 );
		assertEquals( 5, (int) IntegerContainer.element() );
	}

	@Test public void getCharElementTest() {
		CharContainer.element( 'D' );
		assertEquals( 'D', (char) CharContainer.element() );
	}

	@Test public void toStringTest() {
		StringContainer.element( "Hola caracola" );
		IntegerContainer.element( 5 );
		CharContainer.element( 'G' );
		assertEquals( "Hola caracola", StringContainer.toString() );
		assertEquals( "5", IntegerContainer.toString() );
		assertEquals( "G", CharContainer.toString() );
	}
}

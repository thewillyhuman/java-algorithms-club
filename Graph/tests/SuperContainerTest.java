package Graph.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Graph.Container;
import Graph.SuperContainer;

/**
 * 
 * @author Guillermo Facundo Colunga
 * @version 2.1
 */
public class SuperContainerTest<T, U> {

	private SuperContainer<Container<String>, String> StringStringSuperContainer;
	private SuperContainer<Container<String>, Integer> StringIntegerSuperContainer;
	private SuperContainer<Container<String>, Character> StringCharSuperContainer;

	private SuperContainer<Container<Integer>, String> IntegerStringSuperContainer;
	private SuperContainer<Container<Integer>, Integer> IntegerIntegerSuperContainer;
	private SuperContainer<Container<Integer>, Character> IntegerCharSuperContainer;

	private SuperContainer<Container<Character>, String> CharStringSuperContainer;
	private SuperContainer<Container<Character>, Integer> CharIntegerSuperContainer;
	private SuperContainer<Container<Character>, Character> CharCharSuperContainer;

	// private SuperContainer<GenericDataStructure<U>, String> whatEver;

	@SuppressWarnings({ "unchecked", "rawtypes" }) @Before public void setUp() {
		// Container<String>
		Container StringContainer = new Container( "A" );
		StringStringSuperContainer = new SuperContainer<Container<String>, String>( StringContainer,
				"B", 1 );
		StringIntegerSuperContainer = new SuperContainer<Container<String>, Integer>(
				StringContainer, 1, 1 );
		StringCharSuperContainer = new SuperContainer<Container<String>, Character>(
				StringContainer, 'B', 1 );

		// Container<Integer>
		Container IntegerContainer = new Container( 1 );
		IntegerStringSuperContainer = new SuperContainer<Container<Integer>, String>(
				IntegerContainer, "B", 1 );
		IntegerIntegerSuperContainer = new SuperContainer<Container<Integer>, Integer>(
				IntegerContainer, 1, 1 );
		IntegerCharSuperContainer = new SuperContainer<Container<Integer>, Character>(
				IntegerContainer, 'B', 1 );

		// Container<Character>
		Container CharContainer = new Container( 'A' );
		CharStringSuperContainer = new SuperContainer<Container<Character>, String>( CharContainer,
				"B", 1 );
		CharIntegerSuperContainer = new SuperContainer<Container<Character>, Integer>(
				CharContainer, 1, 1 );
		CharCharSuperContainer = new SuperContainer<Container<Character>, Character>( CharContainer,
				'B', 1 );

		// Development...
		// Container<T> TContainer = new Container("pepe");
		// whatEver = new SuperContainer<GenericDataStructure<U>,
		// String>(TContainer, "B", 1);
	}

	@Test public void getContainerTest() {
		// Container<String>
		assertEquals( "A", StringStringSuperContainer.container().element() );
		assertEquals( "A", StringIntegerSuperContainer.container().element() );
		assertEquals( "A", StringCharSuperContainer.container().element() );

		// Container<Integer>
		assertEquals( 1, IntegerStringSuperContainer.container().element() );
		assertEquals( 1, IntegerIntegerSuperContainer.container().element() );
		assertEquals( 1, IntegerCharSuperContainer.container().element() );

		// Container<Integer>
		assertEquals( 'A', CharStringSuperContainer.container().element() );
		assertEquals( 'A', CharIntegerSuperContainer.container().element() );
		assertEquals( 'A', CharCharSuperContainer.container().element() );
	}

	@SuppressWarnings({ "rawtypes", "unchecked" }) @Test public void setContainerTest() {
		// Container<String>
		// -String
		assertEquals( "A", StringStringSuperContainer.container().element() );
		StringStringSuperContainer.container( new Container( "B" ) );
		assertEquals( "B", StringStringSuperContainer.container().element() );

		// -Integer
		assertEquals( "A", StringIntegerSuperContainer.container().element() );
		StringIntegerSuperContainer.container( new Container( "B" ) );
		assertEquals( "B", StringIntegerSuperContainer.container().element() );

		// -Character
		assertEquals( "A", StringCharSuperContainer.container().element() );
		StringCharSuperContainer.container( new Container( "B" ) );
		assertEquals( "B", StringCharSuperContainer.container().element() );

		// Container<Integer>
		// -String
		assertEquals( 1, IntegerStringSuperContainer.container().element() );
		IntegerStringSuperContainer.container( new Container( 2 ) );
		assertEquals( 2, IntegerStringSuperContainer.container().element() );

		// -Integer
		assertEquals( 1, IntegerIntegerSuperContainer.container().element() );
		IntegerIntegerSuperContainer.container( new Container( 2 ) );
		assertEquals( 2, IntegerIntegerSuperContainer.container().element() );

		// -Character
		assertEquals( 1, IntegerCharSuperContainer.container().element() );
		IntegerCharSuperContainer.container( new Container( 2 ) );
		assertEquals( 2, IntegerCharSuperContainer.container().element() );

		// Container<Integer>
		// -String
		assertEquals( 'A', CharStringSuperContainer.container().element() );
		CharStringSuperContainer.container( new Container( 'B' ) );
		assertEquals( 'B', CharStringSuperContainer.container().element() );

		// -Integer
		assertEquals( 'A', CharIntegerSuperContainer.container().element() );
		CharIntegerSuperContainer.container( new Container( 'B' ) );
		assertEquals( 'B', CharIntegerSuperContainer.container().element() );

		// -Character
		assertEquals( 'A', CharCharSuperContainer.container().element() );
		CharCharSuperContainer.container( new Container( 'B' ) );
		assertEquals( 'B', CharCharSuperContainer.container().element() );
	}

	@Test public void getInfoTest() {
		// Container<String>
		assertEquals( "B", StringStringSuperContainer.info() );
		assertEquals( 1, (int) StringIntegerSuperContainer.info() );
		assertEquals( 'B', (char) StringCharSuperContainer.info() );

		// Container<Integer>
		assertEquals( "B", IntegerStringSuperContainer.info() );
		assertEquals( 1, (int) IntegerIntegerSuperContainer.info() );
		assertEquals( 'B', (char) IntegerCharSuperContainer.info() );

		// Container<Integer>
		assertEquals( "B", CharStringSuperContainer.info() );
		assertEquals( 1, (int) CharIntegerSuperContainer.info() );
		assertEquals( 'B', (char) CharCharSuperContainer.info() );
	}

	@Test public void setInfoTest() {
		// Container<String>
		// -String
		assertEquals( "B", StringStringSuperContainer.info() );
		StringStringSuperContainer.info( "C" );
		assertEquals( "C", StringStringSuperContainer.info() );

		// -Integer
		assertEquals( 1, (int) StringIntegerSuperContainer.info() );
		StringIntegerSuperContainer.info( 2 );
		assertEquals( 2, (int) StringIntegerSuperContainer.info() );

		// -Character
		assertEquals( 'B', (char) StringCharSuperContainer.info() );
		StringCharSuperContainer.info( 'C' );
		assertEquals( 'C', (char) StringCharSuperContainer.info() );

		// Container<Integer>
		// -String
		assertEquals( "B", IntegerStringSuperContainer.info() );
		IntegerStringSuperContainer.info( "C" );
		assertEquals( "C", IntegerStringSuperContainer.info() );

		// -Integer
		assertEquals( 1, (int) IntegerIntegerSuperContainer.info() );
		IntegerIntegerSuperContainer.info( 2 );
		assertEquals( 2, (int) IntegerIntegerSuperContainer.info() );

		// -Character
		assertEquals( 'B', (char) IntegerCharSuperContainer.info() );
		IntegerCharSuperContainer.info( 'C' );
		assertEquals( 'C', (char) IntegerCharSuperContainer.info() );

		// Container<Integer>
		// -String
		assertEquals( "B", CharStringSuperContainer.info() );
		CharStringSuperContainer.info( "C" );
		assertEquals( "C", CharStringSuperContainer.info() );

		// -Integer
		assertEquals( 1, (int) CharIntegerSuperContainer.info() );
		CharIntegerSuperContainer.info( 2 );
		assertEquals( 2, (int) CharIntegerSuperContainer.info() );

		// -Character
		assertEquals( 'B', (char) CharCharSuperContainer.info() );
		CharCharSuperContainer.info( 'C' );
		assertEquals( 'C', (char) CharCharSuperContainer.info() );

	}

	@Test public void getKeyTest() {
		// Container<String>
		assertEquals( 1, StringStringSuperContainer.key() );
		assertEquals( 1, (int) StringIntegerSuperContainer.key() );
		assertEquals( 1, (char) StringCharSuperContainer.key() );

		// Container<Integer>
		assertEquals( 1, IntegerStringSuperContainer.key() );
		assertEquals( 1, (int) IntegerIntegerSuperContainer.key() );
		assertEquals( 1, (char) IntegerCharSuperContainer.key() );

		// Container<Integer>
		assertEquals( 1, CharStringSuperContainer.key() );
		assertEquals( 1, (int) CharIntegerSuperContainer.key() );
		assertEquals( 1, (char) CharCharSuperContainer.key() );
	}

	@Test public void setKeyTest() {
		// Container<String>
		// -String
		assertEquals( 1, StringStringSuperContainer.key() );
		StringStringSuperContainer.key( 2 );
		assertEquals( 2, StringStringSuperContainer.key() );

		// -Integer
		assertEquals( 1, StringIntegerSuperContainer.key() );
		StringIntegerSuperContainer.key( 2 );
		assertEquals( 2, (int) StringIntegerSuperContainer.key() );

		// -Character
		assertEquals( 1, StringCharSuperContainer.key() );
		StringCharSuperContainer.key( 2 );
		assertEquals( 2, StringCharSuperContainer.key() );

		// Container<Integer>
		// -String
		assertEquals( 1, IntegerStringSuperContainer.key() );
		IntegerStringSuperContainer.key( 2 );
		assertEquals( 2, IntegerStringSuperContainer.key() );

		// -Integer
		assertEquals( 1, IntegerIntegerSuperContainer.key() );
		IntegerIntegerSuperContainer.key( 2 );
		assertEquals( 2, (int) IntegerIntegerSuperContainer.key() );

		// -Character
		assertEquals( 1, IntegerCharSuperContainer.key() );
		IntegerCharSuperContainer.key( 2 );
		assertEquals( 2, (char) IntegerCharSuperContainer.key() );

		// Container<Integer>
		// -String
		assertEquals( 1, CharStringSuperContainer.key() );
		CharStringSuperContainer.key( 2 );
		assertEquals( 2, CharStringSuperContainer.key() );

		// -Integer
		assertEquals( 1, CharIntegerSuperContainer.key() );
		CharIntegerSuperContainer.key( 2 );
		assertEquals( 2, CharIntegerSuperContainer.key() );

		// -Character
		assertEquals( 1, CharCharSuperContainer.key() );
		CharCharSuperContainer.key( 2 );
		assertEquals( 2, CharCharSuperContainer.key() );
	}

	@Test public void toStringTest() {
		// Container<String>
		assertEquals( "A, B, 1", StringStringSuperContainer.toString() );
		assertEquals( "A, 1, 1", StringIntegerSuperContainer.toString() );
		assertEquals( "A, B, 1", StringCharSuperContainer.toString() );

		// Container<Integer>
		assertEquals( "1, B, 1", IntegerStringSuperContainer.toString() );
		assertEquals( "1, 1, 1", IntegerIntegerSuperContainer.toString() );
		assertEquals( "1, B, 1", IntegerCharSuperContainer.toString() );

		// Container<Integer>
		assertEquals( "A, B, 1", CharStringSuperContainer.toString() );
		assertEquals( "A, 1, 1", CharIntegerSuperContainer.toString() );
		assertEquals( "A, B, 1", CharCharSuperContainer.toString() );
	}

}

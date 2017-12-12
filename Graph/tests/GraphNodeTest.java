package Graph.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Graph.GraphNode;

/**
 * 
 * @author Guillermo Facundo Colunga
 * @version 2.1
 */
public class GraphNodeTest {

	private GraphNode<String> StringGraphNode;
	private GraphNode<Integer> IntegerGraphNode;
	private GraphNode<Character> CharGraphNode;

	@Before public void setUp() {
		StringGraphNode = new GraphNode<String>( "A" );
		IntegerGraphNode = new GraphNode<Integer>( 1 );
		CharGraphNode = new GraphNode<Character>( 'A' );
	}

	@Test public void setElementTest() {
		// Strings...
		StringGraphNode.setContent( "B" );
		assertEquals( "B", StringGraphNode.setContent() );
		StringGraphNode.setContent( null );
		assertEquals( "B", StringGraphNode.setContent() );
		StringGraphNode.setContent( "C" );
		assertEquals( "C", StringGraphNode.setContent() );

		// Integers...
		IntegerGraphNode.setContent( 2 );
		assertEquals( 2, (int) IntegerGraphNode.setContent() );
		IntegerGraphNode.setContent( null );
		assertEquals( 2, (int) IntegerGraphNode.setContent() );
		IntegerGraphNode.setContent( 3 );
		assertEquals( 3, (int) IntegerGraphNode.setContent() );

		// Characters...
		CharGraphNode.setContent( 'B' );
		assertEquals( 'B', (char) CharGraphNode.setContent() );
		CharGraphNode.setContent( null );
		assertEquals( 'B', (char) CharGraphNode.setContent() );
		CharGraphNode.setContent( 'C' );
		assertEquals( 'C', (char) CharGraphNode.setContent() );
	}

	@Test public void getElementTest() {
		// Strings...
		assertEquals( "A", StringGraphNode.setContent() );

		// Integers...
		assertEquals( 1, (int) IntegerGraphNode.setContent() );

		// Characters...
		assertEquals( 'A', (char) CharGraphNode.setContent() );
	}

	@Test public void setVisitedTest() {
		// Strings...
		StringGraphNode.setVisited( false );
		assertEquals( false, StringGraphNode.isVisited() );
		StringGraphNode.setVisited( true );
		assertEquals( true, StringGraphNode.isVisited() );

		// Integers...
		IntegerGraphNode.setVisited( false );
		assertEquals( false, IntegerGraphNode.isVisited() );
		IntegerGraphNode.setVisited( true );
		assertEquals( true, IntegerGraphNode.isVisited() );

		// Characters...
		CharGraphNode.setVisited( false );
		assertEquals( false, CharGraphNode.isVisited() );
		CharGraphNode.setVisited( true );
		assertEquals( true, CharGraphNode.isVisited() );
	}

	@Test public void getVisitedTest() {
		// Strings..
		assertEquals( false, StringGraphNode.isVisited() );
		StringGraphNode.setVisited( true );
		assertEquals( true, StringGraphNode.isVisited() );

		// Integers...
		assertEquals( false, IntegerGraphNode.isVisited() );
		IntegerGraphNode.setVisited( true );
		assertEquals( true, IntegerGraphNode.isVisited() );

		// Characters...
		assertEquals( false, CharGraphNode.isVisited() );
		CharGraphNode.setVisited( true );
		assertEquals( true, CharGraphNode.isVisited() );
	}

	@Test public void toStringTest() {
		// Strings...
		StringGraphNode.setContent( "B" );
		assertEquals( "GN(N:B/V:false)", StringGraphNode.toString() );
		StringGraphNode.setVisited( true );
		assertEquals( "GN(N:B/V:true)", StringGraphNode.toString() );
		StringGraphNode.setContent( "C" );
		StringGraphNode.setVisited( false );
		assertEquals( "GN(N:C/V:false)", StringGraphNode.toString() );

		// Integers...
		IntegerGraphNode.setContent( 2 );
		assertEquals( "GN(N:2/V:false)", IntegerGraphNode.toString() );
		IntegerGraphNode.setVisited( true );
		assertEquals( "GN(N:2/V:true)", IntegerGraphNode.toString() );
		IntegerGraphNode.setVisited( false );
		IntegerGraphNode.setContent( 3 );
		assertEquals( "GN(N:3/V:false)", IntegerGraphNode.toString() );

		// Characters...
		CharGraphNode.setContent( 'B' );
		assertEquals( "GN(N:B/V:false)", CharGraphNode.toString() );
		CharGraphNode.setVisited( true );
		assertEquals( "GN(N:B/V:true)", CharGraphNode.toString() );
		CharGraphNode.setVisited( false );
		CharGraphNode.setContent( 'C' );
		assertEquals( "GN(N:C/V:false)", CharGraphNode.toString() );
	}

}

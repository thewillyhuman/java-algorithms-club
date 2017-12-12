package Graph.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Graph.Graph;
import Graph.GraphNode;

/**
 * 
 * @author Guillermo Facundo Colunga
 * @version 2.1
 */
public class GraphMartinTest {

	@Test public void GraphNodeTest() {
		GraphNode<Integer> numbers = new GraphNode<Integer>( 4 );
		assertEquals( 4, (int) numbers.setContent() );
		assertEquals( false, numbers.isVisited() );
		numbers.setVisited( true );
		assertEquals( true, numbers.isVisited() );
		assertEquals( "GN(N:4/V:true)", numbers.toString() );

		GraphNode<String> myString = new GraphNode<String>( "hello" );
		assertEquals( "hello", myString.setContent() );
		assertEquals( false, myString.isVisited() );
		assertEquals( "GN(N:hello/V:false)", myString.toString() );

		GraphNode<Character> myChar = new GraphNode<Character>( 'a' );
		assertEquals( 'a', (char) myChar.setContent() );
		assertEquals( "GN(N:a/V:false)", myChar.toString() );
		myChar.setContent( 'b' );
		assertEquals( "GN(N:b/V:false)", myChar.toString() );
		myChar.setVisited( true );
		assertEquals( "GN(N:b/V:true)", myChar.toString() );
	}

	@Test public void GraphEdittingTest() {
		Graph<Character> g1 = new Graph<Character>( 3 );
		assertEquals( 0, g1.size() );
		try {
			g1.addNode( 'a' );
		} catch (Exception e) {
			System.out.println( "No repeated nodes are allowed " + e );
		}
		assertEquals( 1, g1.size() );
		assertEquals( 0, g1.node( 'a' ) );
		assertArrayEquals(
				new boolean[][] { { false, false, false }, { false, false, false },
						{ false, false, false } },
				g1.edges() );
		assertArrayEquals(
				new double[][] { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } },
				g1.weight() );
		// Test nodes for nodes not found
		assertEquals( Graph.INDEX_NOT_FOUND, g1.node( 'b' ) );
		// No repeated nodes is allowed
		try {
			g1.addNode( 'a' );
		} catch (Exception e) {
			System.out.println( "No repeated nodes are allowed " + e );
		}
		try {
			g1.addNode( 'b' );
			g1.addNode( 'c' );
		} catch (Exception e) {
			System.out.println( "No repeated nodes are allowed " + e );
		}
		assertEquals( 3, g1.size() );
		assertEquals( 0, g1.node( 'a' ) );
		assertEquals( 1, g1.node( 'b' ) );
		assertEquals( 2, g1.node( 'c' ) );
		assertArrayEquals(
				new boolean[][] { { false, false, false }, { false, false, false },
						{ false, false, false } },
				g1.edges() );
		assertArrayEquals(
				new double[][] { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } },
				g1.weight() );
		// Testing edges
		try {
			g1.existsEdge( 'b', 'd' );
		} catch (Exception e) {
			System.out.println( "Starting|arrival node does not exists " + e );
		}
		try {
			assertEquals( false, g1.existsEdge( 'b', 'c' ) );
		} catch (Exception e) {
			System.out.println( "Starting or arrival node does not exists " + e );
		}
		assertArrayEquals(
				new boolean[][] { { false, false, false }, { false, false, false },
						{ false, false, false } },
				g1.edges() );
		assertArrayEquals(
				new double[][] { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } },
				g1.weight() );
		try {
			g1.addEdge( 'b', 'c', 5.0 );
			assertEquals( true, g1.existsEdge( 'b', 'c' ) );
		} catch (Exception e) {
			System.out.println( "Starting or arrival node does not exists " + e );
		}
		assertArrayEquals(
				new boolean[][] { { false, false, false }, { false, false, true },
						{ false, false, false } },
				g1.edges() );
		assertArrayEquals(
				new double[][] { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 5.0 }, { 0.0, 0.0, 0.0 } },
				g1.weight() );
	}

	@Test

	public void TestFloyd() throws Exception {
		Graph<String> g = new Graph<String>( 6 );
		assertEquals( 0, g.size() );

		try {
			g.addNode( "V1" );
			g.addNode( "V2" );
			g.addNode( "V3" );
			g.addNode( "V4" );
			g.addNode( "V5" );
			g.addNode( "V6" );
		} catch (Exception e) {
			System.out.println( "No repeated nodes are allowed " + e );
		}

		assertEquals( 6, g.size() );
		assertEquals( 0, g.node( "V1" ) );
		assertEquals( 1, g.node( "V2" ) );
		assertEquals( 2, g.node( "V3" ) );
		assertEquals( 3, g.node( "V4" ) );
		assertEquals( 4, g.node( "V5" ) );
		assertEquals( 5, g.node( "V6" ) );
		assertArrayEquals( new boolean[][] { { false, false, false, false, false, false },
				{ false, false, false, false, false, false },
				{ false, false, false, false, false, false },
				{ false, false, false, false, false, false },
				{ false, false, false, false, false, false },
				{ false, false, false, false, false, false } }, g.edges() );
		assertArrayEquals(
				new double[][] { { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 } },
				g.weight() );

		try {
			g.addEdge( "V1", "V2", 3.0 );
			g.addEdge( "V1", "V3", 4.0 );
			g.addEdge( "V1", "V5", 8.0 );

			g.addEdge( "V2", "V5", 5.0 );

			g.addEdge( "V3", "V5", 3.0 );

			g.addEdge( "V5", "V6", 3.0 );
			g.addEdge( "V5", "V4", 7.0 );

			g.addEdge( "V6", "V4", 2.0 );
		} catch (Exception e) {
			System.out.println( "Starting or arrival node does not exists " + e );
		}

		assertArrayEquals( new boolean[][] { { false, true, true, false, true, false },
				{ false, false, false, false, true, false },
				{ false, false, false, false, true, false },
				{ false, false, false, false, false, false },
				{ false, false, false, true, false, true },
				{ false, false, false, true, false, false } }, g.edges() );
		assertArrayEquals(
				new double[][] { { 0.0, 3.0, 4.0, 0.0, 8.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 5.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 3.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 7.0, 0.0, 3.0 },
						{ 0.0, 0.0, 0.0, 2.0, 0.0, 0.0 } },
				g.weight() );
		assertEquals( "V1-V2-V5-V4-V6-V3-", g.traverseGraph( "V1" ) );

		g.floyd( g.size() );
		assertArrayEquals( new int[][] { { -1, -1, -1, 5, 2, 4 }, { -1, -1, -1, 5, -1, 4 },
				{ -1, -1, -1, 5, -1, 4 },
				{ -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, 5, -1, -1 }, { -1, -1, -1, -1, -1, -1 } },
				g.getP() );
		assertArrayEquals( new double[][] { { 00.0, 03.0, 04.0, 12.0, 07.0, 10.0 },
				{ Graph.MAX_NUMBER, 00.0, Graph.MAX_NUMBER, 10.0, 05.0, 08.0 },
				{ Graph.MAX_NUMBER, Graph.MAX_NUMBER, 00.0, 08.0, 03.0, 06.0 },
				{ Graph.MAX_NUMBER, Graph.MAX_NUMBER, Graph.MAX_NUMBER, 00.0, Graph.MAX_NUMBER,
						Graph.MAX_NUMBER },
				{ Graph.MAX_NUMBER, Graph.MAX_NUMBER, Graph.MAX_NUMBER, 05.0, 00.0, 03.0 },
				{ Graph.MAX_NUMBER, Graph.MAX_NUMBER, Graph.MAX_NUMBER, 02.0, Graph.MAX_NUMBER,
						00.0 } },
				g.getA() );

		try {
			assertEquals( "V1V3V5V6", g.printFloydPath( "V1", "V6" ) );
		} catch (Exception e) {
			System.out.println( "Starting or arrival node does not exists " + e );
		}
	}

	@Test public void TestDijkstra() throws Exception {
		Graph<String> g = new Graph<String>( 6 );
		assertEquals( 0, g.size() );

		try {
			g.addNode( "V1" );
			g.addNode( "V2" );
			g.addNode( "V3" );
			g.addNode( "V4" );
			g.addNode( "V5" );
			g.addNode( "V6" );
		} catch (Exception e) {
			System.out.println( "No repeated nodes are allowed" + e );
		}

		assertEquals( 6, g.size() );
		assertEquals( 0, g.node( "V1" ) );
		assertEquals( 1, g.node( "V2" ) );
		assertEquals( 2, g.node( "V3" ) );
		assertEquals( 3, g.node( "V4" ) );
		assertEquals( 4, g.node( "V5" ) );
		assertEquals( 5, g.node( "V6" ) );
		assertArrayEquals( new boolean[][] { { false, false, false, false, false, false },
				{ false, false, false, false, false, false },
				{ false, false, false, false, false, false },
				{ false, false, false, false, false, false },
				{ false, false, false, false, false, false },
				{ false, false, false, false, false, false } }, g.edges() );
		assertArrayEquals(
				new double[][] { { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 } },
				g.weight() );

		try {
			g.addEdge( "V1", "V2", 3.0 );
			g.addEdge( "V1", "V3", 4.0 );
			g.addEdge( "V1", "V5", 8.0 );

			g.addEdge( "V2", "V5", 5.0 );

			g.addEdge( "V3", "V5", 3.0 );

			g.addEdge( "V5", "V6", 3.0 );
			g.addEdge( "V5", "V4", 7.0 );

			g.addEdge( "V6", "V4", 2.0 );
		} catch (Exception e) {
			System.out.println( "Starting or arrival node does not exists " + e );
		}

		assertArrayEquals( new boolean[][] { { false, true, true, false, true, false },
				{ false, false, false, false, true, false },
				{ false, false, false, false, true, false },
				{ false, false, false, false, false, false },
				{ false, false, false, true, false, true },
				{ false, false, false, true, false, false } }, g.edges() );
		assertArrayEquals(
				new double[][] { { 0.0, 3.0, 4.0, 0.0, 8.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 5.0, 0.0 },
						{ 0.0, 0.0, 0.0, 0.0, 3.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
						{ 0.0, 0.0, 0.0, 7.0, 0.0, 3.0 },
						{ 0.0, 0.0, 0.0, 2.0, 0.0, 0.0 } },
				g.weight() );

		g.Dijkstra( "V1" );
		assertArrayEquals( new double[][] { { 0.0, 3.0, 4.0, 12.0, 7.0, 10.0 } }, g.getD() );
		assertArrayEquals( new int[] { -1, 0, 0, 5, 2, 4 }, g.getPD() );

		g.Dijkstra( "V2" );
		assertArrayEquals(
				new double[][] { { Graph.MAX_NUMBER, 0.0, Graph.MAX_NUMBER, 10.0, 5.0, 8.0 } },
				g.getD() );
		assertArrayEquals( new int[] { -1, -1, -1, 5, 1, 4 }, g.getPD() );
	}

}

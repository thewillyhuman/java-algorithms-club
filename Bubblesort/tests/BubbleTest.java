package Bubblesort.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Bubblesort.Bubble;

public class BubbleTest {

	private Integer[] intArr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 },
			sortIntArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	private String[] strArr = { "d", "c", "b", "a" },
			sortStrArr = { "a", "b", "c", "d" };

	private Double[] dblArr = { 1.9, 2.6, Double.MAX_VALUE, 0.00004, Double.MIN_VALUE },
			sortDblArr = { Double.MIN_VALUE, 0.00004, 1.9, 2.6, Double.MAX_VALUE };

	@Test public void integerSortTest() {
		Bubble.sort( intArr );
		assertArrayEquals( sortIntArr, intArr );
	}

	@Test public void stringSortTest() {
		Bubble.sort( strArr );
		assertArrayEquals( sortStrArr, strArr );
	}
	
	@Test public void doubleSortTest() {
		Bubble.sort( dblArr );
		assertArrayEquals( sortDblArr, dblArr );
	}
}

package Bubblesort;

/**
 * Bubble sort is a sorting algorithm that is implemented by starting in the
 * beginning of the array and swapping the first two elements only if the first
 * element is greater than the second element. This comparison is then moved
 * onto the next pair and so on and so forth. This is done until the array is
 * completely sorted. The smaller items slowly “bubble” up to the beginning of
 * the array.
 *
 * @author Guillermo Facundo Colunga.
 * @version 1
 * @since 201712120028.
 * @formatter Oviedo Computing Community Extended.
 */
public class Bubble {

	/**
	 * Average: O(N^2) Worst: O(N^2) Memory: O(1)
	 * 
	 * Sorts the given array of elements by executing bubble sort. That is by
	 * starting in the beginning of the array and swapping the first two
	 * elements only if the first element is greater than the second element.
	 * This comparison is then moved onto the next pair and so on and so forth.
	 * This is done until the array is completely sorted. The smaller items
	 * slowly “bubble” up to the beginning of the array.
	 * 
	 * @param elements array to be sorted. It is sorted in the same array.
	 */
	public static <T extends Comparable<T>> void sort( T[] elements ) {
		for (int i = 1; i < elements.length; i++) { // O(n)
			for (int j = elements.length - 1; j >= i; j--) { // O(n)
				if (elements[j - 1].compareTo( elements[j] ) > 0) {
					T temp = elements[j];
					elements[j] = elements[j - 1];
					elements[j - 1] = temp;
				}
			}
		}
	}

}

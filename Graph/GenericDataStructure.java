package Graph;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Creates a data structure of a given T type of data.
 * 
 * @author Guillermo Facundo Colunga
 * @version 1.2
 * @param <T> Type of data the data structure will contain.
 */
public class GenericDataStructure<T extends Comparable<T>> {

	private LinkedList<T> collection;

	/**
	 * Adds the element given as a parameter to the collection.
	 * 
	 * @param element element to add.
	 */
	public void add( T element ) {
		if (collection == null)
			collection = new LinkedList<T>();
		collection.add( element );
	}

	/**
	 * default toString method. In order to print all the elements in the
	 * collection.
	 */
	@Override public String toString() {
		sort();
		StringBuilder aux = new StringBuilder();
		for (T s : collection)
			aux.append( s.toString() + "." );
		return aux.toString();
	}

	/**
	 * CompareTwoElements method that compares two elements given their array
	 * positions.
	 * 
	 * @param firstPos the position of the first element.
	 * @param secondPos the position of your second element.
	 * @return -1 if first less, 0 if equals and 1 if second less.
	 */
	public int compareTwoElements( int firstPos, int secondPos ) {
		return ( collection.get( firstPos ).compareTo( collection.get( secondPos ) ) );
	}

	/**
	 * Sorts the collection by using mergeShort from collections.
	 */
	private void sort() {
		Collections.sort( collection );
	}

}

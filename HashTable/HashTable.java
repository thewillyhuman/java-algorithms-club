package HashTable;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Represents a completely functional hashTable
 * 
 * @author Guillermo Facundo Colunga
 * @param <T> is the data type the hash table will store.
 */
public class HashTable<T extends Comparable<T>> {

	// Constants.
	public final static int LINEAR_PROBING = 0;
	public final static int QUADRATIC_PROBING = 1;
	public final static int DOUBLE_HASHING = 2;
	public final static int ATTEMPS = 10;

	// Variables.
	private int B = 7;
	private int redispersionType = LINEAR_PROBING;
	private double minLF = 0.5;
	private ArrayList<HashNode<T>> associativeArray;
	private int n = 0;
	private int R = 5;

	/**
	 * Main constructor.
	 * 
	 * @param B the size of the HashTable
	 * @param redispersionType type of re dispersion that is going to be used.
	 * @param minLF the minimum load factor accepted.
	 */
	public HashTable( int B, int redispersionType, double minLF ) {
		setB( B );
		redispersion( redispersionType );
		minLoadFactor( minLF );
		associativeArray = new ArrayList<HashNode<T>>( B );
		for (int i = 0; i < B; i++) {
			associativeArray.add( new HashNode<T>() );
		}
		this.R = prevPrime( B );
	}

	/**
	 * Return the value size of the hash table.
	 * 
	 * @return B, the size of the hash table.
	 */
	public int getB() {
		return B;
	}

	/**
	 * Sets the parameter B that represents the size of the hash table.
	 * 
	 * @param b, the size of the hash table.
	 */
	private void setB( int b ) {
		if (b < 0) {
			throw new IllegalArgumentException( "B can not be negative." );
		} else {
			B = b;
		}
	}

	/**
	 * Return the re-dispersion type.
	 * 
	 * @return redispersionType that represents which one of the re-dispersion
	 *         is used.
	 */
	public int redispersion() {
		return redispersionType;
	}

	/**
	 * Sets the re-dispersion of the hash table.
	 * 
	 * @param redispersionType the redispersionType to set
	 */
	private void redispersion( int redispersionType ) {
		this.redispersionType = redispersionType;
	}

	/**
	 * Return the minimum load factor accepted by the hash table.
	 * 
	 * @return the minLF that represents the minimum load factor accepted.
	 */
	public double minLoadFactor() {
		return minLF;
	}

	/**
	 * Return the R, that represents something that I already don't know.
	 * 
	 * @return R
	 */
	public int getR() {
		return this.R;
	}

	/**
	 * Sets the minimum accepted load factor for the hash table.
	 * 
	 * @param minLF, the minimum accepted load factor for the hash table.
	 */
	private void minLoadFactor( double minLF ) {
		if (minLF < 0) {
			throw new IllegalArgumentException( "B can not be negative." );
		} else {
			this.minLF = minLF;
		}
	}

	/**
	 * Return the associative array.
	 * 
	 * @return the ArrayList associativeArray.
	 */
	public ArrayList<HashNode<T>> associativeArray() {
		return this.associativeArray;
	}

	/**
	 * Hashing function
	 * 
	 * @param element to be stored.
	 * @param i Attempt number.
	 * @return slot in the array where the element should be placed
	 */
	public int f( T element, int i ) {
		switch (redispersionType) {
			case LINEAR_PROBING:
				return ( ( Math.abs( element.hashCode() ) + i ) % B );
			case DOUBLE_HASHING:
				return ( ( Math.abs( element.hashCode() )
						+ i * ( R - Math.abs( element.hashCode() % R ) ) ) % B );
		}
		// That will be the case of quadratic probing.
		return ( ( Math.abs( element.hashCode() ) + ( i * i ) ) % B );
	}

	/**
	 * Gets the Load Factor.
	 * 
	 * @return the LF
	 */
	public double loadFactor() {
		return (double) n / (double) B;
	}

	/**
	 * Adds an element to the hash table. For that will calculate the hash
	 * function until there's a free slot.
	 * 
	 * @param element to add to the hash table.
	 * @return the number of collisions that produce the hashing function.
	 */
	public int add( T element ) {
		boolean success = false;
		int i = 0;
		do {
			if (associativeArray.get( f( element, i ) )
					.status() != HashNode.VALID) {
				associativeArray.get( f( element, i ) ).element( element );
				associativeArray.get( f( element, i ) ).status( HashNode.VALID );
				success = true;
			}
			i++;
		} while (!success && i < ATTEMPS);
		n++;
		if (loadFactor() > minLF) {
			dynamicResize();
		}
		return i - 1;
	}

	/**
	 * Search. Given an element it checks if it is in the position it should be.
	 * 
	 * @param element
	 * @return true if the element is in the hashTable; false otherwise.
	 */
	public boolean search( T element ) {
		if (this.associativeArray().isEmpty())
			throw new IllegalStateException( "The hashTable is empty." );

		int i = 0;
		do {
			HashNode<T> hashNode = associativeArray.get( f( element, i ) );
			if (hashNode.status() == HashNode.EMPTY) {
				return false;
			} else if (( hashNode.status() == HashNode.VALID )
					&& ( hashNode.element().equals( element ) )) {
				return true;
			}
			i++;
		} while (i < ATTEMPS);
		return false;
	}

	/**
	 * Calls the private dynamic resizing method with the actual hash table
	 * size.
	 */
	public void dynamicResize() {
		dynamicResize( nextPrime( 2 * this.B ) );
	}

	/**
	 * Resizes the table dynamically.
	 * 
	 * @explanation First creates a new HashTable with double hashing and this
	 *              size provided. Then, for every valid element in the actual
	 *              hash table will copy it to the new one that the same type of
	 *              re-dispersion. And then will change the pointer of the
	 *              associative array to this auxiliary hashTable, update the
	 *              parameters and done.
	 * 
	 * @param size (2*B)
	 */
	public void dynamicResize( int size ) {
		HashTable<T> auxTable = new HashTable<T>( size, this.redispersion(),
				this.minLoadFactor() );
		for (HashNode<T> element : associativeArray) {
			if (element.status() == HashNode.VALID) {
				auxTable.add( element.element() );
			}
		}
		this.associativeArray = auxTable.associativeArray();
		setB( size );
		this.R = prevPrime( B );
	}

	/**
	 * Second option to resize the hash table.
	 * 
	 * @param size, new size.
	 */
	public void dynamicResize2( int size ) {
		ArrayList<HashNode<T>> prev = associativeArray;
		associativeArray = new ArrayList<HashNode<T>>();
		for (int i = 0; i < size; i++) {
			associativeArray.set( i, new HashNode<T>() );
		}
		this.n = 0;
		setB( size );
		this.R = HashTable.prevPrime( B );

		for (int i = 0; i < prev.size(); i++) {
			if (prev.get( i ).status() == HashNode.VALID) {
				this.add( prev.get( i ).element() );
			}
		}
	}

	public ArrayList<HashNode<T>> clone() {
		ArrayList<HashNode<T>> copy = new ArrayList<HashNode<T>>();
		for (HashNode<T> hn : associativeArray) {
			if (hn.status() == HashNode.VALID)
				copy.add( hn );
		}
		return copy;

	}

	/**
	 * Given a element will remove it from the hash table. If it doesn't exists
	 * will throw an exception.
	 * 
	 * @param element to be removed.
	 * @throws IllegalStateException if the hash table is empty.
	 */
	public void remove( T element ) {
		if (this.associativeArray().isEmpty())
			throw new IllegalStateException( "The hashTable is empty." );

		boolean success = false;
		int i = 0;
		do {
			HashNode<T> hashNode = associativeArray.get( f( element, i ) );
			if (hashNode.status() == HashNode.VALID
					&& hashNode.element().equals( element )) {
				hashNode.status( HashNode.DELETED );
			}
			i++;
		} while (!success && i < ATTEMPS);
		n--;
	}

	// --- BEGIN OF HOMEWORK FOR 4.12.2015 ---

	/**
	 * Given an integer number as a parameter it returns true only in the case
	 * that this number is a prime number. False otherwise. A prime number (or a
	 * prime) is a natural number greater than 1 that has no positive divisors
	 * other than 1 and itself.
	 * 
	 * @param number to check if it's prime or not
	 * @return true if the parameter is a prime number and false otherwise.
	 * @complexity log(n);
	 */
	public static boolean isPrime( int prime ) {
		if (prime < 2)
			return false;
		int sqrt = (int) Math.sqrt( prime ) + 1;
		for (int i = 2; i < sqrt; i++) {
			if (prime % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * Returns the next prime number given an integer number as a parameter.
	 * 
	 * @param number where you start to check for the next prime number
	 * @return an integer number that will be the next prime with respect to the
	 *         parameter.
	 */
	public static int nextPrime( int prime ) {
		if (prime < 2)
			return 2;
		int prim = prime + 1;
		while (!isPrime( prim )) {
			prim++;
		}
		return prim;
	}

	/**
	 * This is a second option and probable algorithm that by means of the
	 * BigInteger class and the AKS algorithm will evaluate and find the next
	 * immediate probable algorithm. Notice that this method nor is perfect nor
	 * has been designed for low workloads.
	 * 
	 * @param i number to start looking for prime numbers.
	 * @return the next immediate prime number.
	 */
	@Deprecated public static int getNextPrimeAKS( int i ) {
		if (i < 0) {
			return nextPrime( i );
		}
		// create 2 BigInteger objects
		BigInteger bi1, bi2;
		// assign the first to the actual number.
		bi1 = new BigInteger( Integer.toString( i ) );
		// assign nextProbablePrime value of bi1 to bi2
		bi2 = bi1.nextProbablePrime();
		return bi2.intValue();
	}

	/**
	 * Returns the previous prime number given an integer number as a parameter.
	 * 
	 * @param number where you start to check for the previous prime number
	 * @return an integer number that will be the previous prime with respect to
	 *         the parameter.
	 */
	public static int prevPrime( int prime ) throws IllegalArgumentException {
		if (prime <= 2)
			throw new IllegalArgumentException(
					"There are not any previus prime number." );
		int prim = ( prime - 1 );
		while (!isPrime( prim )) {
			prim--;
		}
		return prim;
	}

	// --- END OF HOMEWORK FOR 4.12.2015 --- bla bla bla

	/**
	 * To String default method.
	 * 
	 * @format [Slot] (Node’s status) = element.toString() -
	 */
	public String toString() {
		StringBuilder aux = new StringBuilder();
		int i = 0;
		if (associativeArray != null) {
			for (HashNode<T> element : associativeArray) {
				aux.append( "[" ).append( i ).append( "]" )
						.append( " (" + element.status() + ")" ).append( " = " )
						.append( element.element() ).append( " - " );
				i++;
			}
		}
		return aux.toString();
	}
}
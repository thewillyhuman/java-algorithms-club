package HashTable.tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import HashTable.HashTable;

public class HashTablesUltimateCompleteTest {

	HashTable<Integer> ht;

	@Before public void setUp() {
		ht = new HashTable<Integer>( 7, HashTable.LINEAR_PROBING, 0.5 );
	}

	@Test public void isPrimeTest() {
		// Some base cases.
		assertEquals( false, HashTable.isPrime( -2 ) );
		assertEquals( false, HashTable.isPrime( -1 ) );
		assertEquals( false, HashTable.isPrime( 0 ) );
		assertEquals( false, HashTable.isPrime( 1 ) );
		assertEquals( true, HashTable.isPrime( 2 ) );

		// Some random prime testing.
		Integer[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
				71, 73, 79, 83, 89,
				97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
				181, 191, 193, 197,
				199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
				307, 311, 313, 317,
				331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431,
				433, 439, 443, 449,
				457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569,
				571, 577, 587, 593,
				599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
				701, 709, 719, 727,
				733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839,
				853, 857, 859, 863,
				877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991,
				997 };

		for (int i = 0; i < prime.length; i++) {
			assertEquals( true, HashTable.isPrime( prime[i] ) );
		}

		// Some random non prime testing.
		Integer[] nonPrime = { 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28,
				30, 32, 33, 34, 35,
				36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63,
				64, 65, 66, 68, 69,
				70, 72, 74, 75, 76, 77, 78, 80, 81, 82, 84, 85, 86, 87, 88, 90, 91, 92, 93, 94, 95,
				96, 98, 99, 100,
				102, 104, 105, 106, 108, 110, 111, 112, 114, 115, 116, 117, 118, 119, 120, 121, 122,
				123, 124, 125, 126,
				128, 129, 130, 132, 133, 134, 135, 136, 138, 140, 141, 142, 143, 144, 145, 146, 147,
				148, 150 };

		for (int i = 0; i < nonPrime.length; i++) {
			assertEquals( false, HashTable.isPrime( nonPrime[i] ) );
		}
	}

	@Test public void getNextPrimeTest() {
		// Some base cases.
		assertEquals( 2, HashTable.nextPrime( -2 ) );
		assertEquals( 2, HashTable.nextPrime( -1 ) );
		assertEquals( 2, HashTable.nextPrime( 0 ) );
		assertEquals( 2, HashTable.nextPrime( 1 ) );
		// Status changed.
		assertEquals( 3, HashTable.nextPrime( 2 ) );

		// Some random prime testing.
		Integer[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
				71, 73, 79, 83, 89,
				97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
				181, 191, 193, 197,
				199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
				307, 311, 313, 317,
				331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431,
				433, 439, 443, 449,
				457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569,
				571, 577, 587, 593,
				599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
				701, 709, 719, 727,
				733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839,
				853, 857, 859, 863,
				877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991,
				997 };

		// For every number in the array the next one is the next prime so we
		// check that.
		for (int i = 0; i < prime.length - 1; i++) {
			int aux = prime[i + 1];
			assertEquals( aux, HashTable.nextPrime( prime[i] ) );
		}
	}

	@SuppressWarnings("deprecation") @Test @Ignore public void getNextPrimeAKSTest() {
		// Some base cases.
		assertEquals( 2, HashTable.getNextPrimeAKS( -2 ) );
		assertEquals( 2, HashTable.getNextPrimeAKS( -1 ) );
		assertEquals( 2, HashTable.getNextPrimeAKS( 0 ) );
		assertEquals( 2, HashTable.getNextPrimeAKS( 1 ) );
		// Status changed.
		assertEquals( 3, HashTable.getNextPrimeAKS( 2 ) );

		// Some random prime testing.
		Integer[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
				71, 73, 79, 83, 89,
				97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
				181, 191, 193, 197,
				199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
				307, 311, 313, 317,
				331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431,
				433, 439, 443, 449,
				457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569,
				571, 577, 587, 593,
				599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
				701, 709, 719, 727,
				733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839,
				853, 857, 859, 863,
				877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991,
				997 };

		// For every number in the array the next one is the next prime so we
		// check that.
		for (int i = 0; i < prime.length - 1; i++) {
			int aux = prime[i + 1];
			assertEquals( aux, HashTable.getNextPrimeAKS( prime[i] ) );
		}
	}

	@Test public void getPrevPrimeTest() {
		// Some base cases.
		try {
			assertEquals( 2, HashTable.prevPrime( -2 ) );
			fail( "There's no prime previus to -2" );
		} catch (IllegalArgumentException e) {
			System.out.println( "FROM TESTING: " + e );
		}
		try {
			assertEquals( 2, HashTable.prevPrime( -1 ) );
			fail( "There's no prime previus to -1" );
		} catch (IllegalArgumentException e) {

		}
		try {
			assertEquals( 2, HashTable.prevPrime( 0 ) );
			fail( "There's no prime previus to 0" );
		} catch (IllegalArgumentException e) {
			System.out.println( "FROM TESTING: " + e );
		}
		try {
			assertEquals( 2, HashTable.prevPrime( 1 ) );
			fail( "There's no prime previus to 1" );
		} catch (IllegalArgumentException e) {
			System.out.println( "FROM TESTING: " + e );
		}
		try {
			assertEquals( 2, HashTable.prevPrime( 2 ) );
			fail( "There's no prime previus to 2" );
		} catch (IllegalArgumentException e) {
			System.out.println( "FROM TESTING: " + e );
		}

		// Some random prime testing.
		Integer[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
				71, 73, 79, 83, 89,
				97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
				181, 191, 193, 197,
				199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
				307, 311, 313, 317,
				331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431,
				433, 439, 443, 449,
				457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569,
				571, 577, 587, 593,
				599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
				701, 709, 719, 727,
				733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839,
				853, 857, 859, 863,
				877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991,
				997 };

		// For every number in the array the next one is the next prime so we
		// check that.
		for (int i = 1; i < prime.length; i++) {
			int aux = prime[i - 1];
			assertEquals( aux, HashTable.prevPrime( prime[i] ) );
		}
	}

	@Test @Ignore public void differentsLoadFactorsTest() {
		HashTable<Integer> linearHash = new HashTable<Integer>( 5, HashTable.LINEAR_PROBING, 0.5 );
		HashTable<Integer> quadraticHash = new HashTable<Integer>( 5, HashTable.QUADRATIC_PROBING,
				0.5 );
		HashTable<Integer> doubleHash = new HashTable<Integer>( 5, HashTable.DOUBLE_HASHING, 0.5 );

		double linearTest = 0.0;
		double quadraticTest = 0.0;
		double doubleTest = 0.0;
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int c = 0; c < 100; c++) {
			double aux = System.currentTimeMillis();
			for (int i = 0; i < 100000; i++)
				linearHash.add( i );
			linearTest = System.currentTimeMillis() - aux;

			aux = System.currentTimeMillis();
			for (int i = 0; i < 100000; i++)
				quadraticHash.add( i );
			quadraticTest = System.currentTimeMillis() - aux;

			aux = System.currentTimeMillis();
			for (int i = 0; i < 100000; i++)
				doubleHash.add( i );
			doubleTest = System.currentTimeMillis() - aux;

			System.out.println( "Linear " + linearTest + "ms" );
			System.out.println( "Quadratic " + quadraticTest + "ms" );
			System.out.println( "Double " + doubleTest + "ms" );

			if (( linearTest > doubleTest ) && ( linearTest > quadraticTest ))
				results.add( 1 );
			else if (( doubleTest > linearTest ) && ( doubleTest > quadraticTest ))
				results.add( 2 );
			else
				results.add( 3 );
		}
		System.out.print( "Better algorithm ->" + populated( results ) );
	}

	private int populated( ArrayList<Integer> aux ) {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;

		for (Integer i : aux) {
			if (i.equals( 1 ))
				count1++;
			else if (i.equals( 2 ))
				count2++;
			else if (i.equals( 3 ))
				count3++;
		}

		if (( count1 < count2 ) && ( count1 < count3 ))
			return 1;
		else if (( count2 < count1 ) && ( count2 < count3 ))
			return 2;
		else
			return 3;
	}

	@Test public void testHashingFunctionIntegers() {
		// Example
		HashTable<Integer> a = new HashTable<Integer>( 5, HashTable.LINEAR_PROBING, 0.5 );
		assertEquals( 2, a.f( 7, 0 ) );
		assertEquals( 3, a.f( 7, 1 ) );
		assertEquals( 4, a.f( 7, 2 ) );
		assertEquals( 0, a.f( 7, 3 ) );

		// System.out.println(a.f(4, 0));

		// Example
		HashTable<Integer> b = new HashTable<Integer>( 5, HashTable.QUADRATIC_PROBING, 0.5 );
		assertEquals( 2, b.f( 7, 0 ) );
		assertEquals( 3, b.f( 7, 1 ) );
		assertEquals( 1, b.f( 7, 2 ) );
		assertEquals( 1, b.f( 7, 3 ) );
	}

	@Test public void testHashingFunctionCharacters() {
		// Example
		HashTable<Character> a = new HashTable<Character>( 5, HashTable.LINEAR_PROBING, 0.5 );
		assertEquals( 0, a.f( 'A', 0 ) );
		assertEquals( 1, a.f( 'A', 1 ) );
		assertEquals( 2, a.f( 'A', 2 ) );
		assertEquals( 3, a.f( 'A', 3 ) );

		// Example
		HashTable<Character> b = new HashTable<Character>( 5, HashTable.QUADRATIC_PROBING, 0.5 );
		assertEquals( 0, b.f( 'A', 0 ) );
		assertEquals( 1, b.f( 'A', 1 ) );
		assertEquals( 4, b.f( 'A', 2 ) );
		assertEquals( 4, b.f( 'A', 3 ) );

	}

	@Test public void testHashTableAddSearchLP() {
		// Example
		HashTable<Integer> a = new HashTable<Integer>( 5, HashTable.LINEAR_PROBING, 1.0 );
		a.add( 4 );
		a.add( 13 );
		a.add( 24 );
		a.add( 3 );

		assertEquals( "[0] (1) = 24 - [1] (1) = 3 - [2] (0) = null - [3] (1) = 13 - [4] (1) = 4 - ",
				a.toString() );
		assertEquals( true, a.search( 3 ) );
		assertEquals( false, a.search( 12 ) );
	}

	@Test public void testHashTableAddSearchQP() {
		// Example
		HashTable<Integer> b = new HashTable<Integer>( 5, HashTable.QUADRATIC_PROBING, 1.0 );
		b.add( 4 );
		b.add( 13 );
		b.add( 24 );
		b.add( 3 );

		assertEquals( "[0] (1) = 24 - [1] (0) = null - [2] (1) = 3 - [3] (1) = 13 - [4] (1) = 4 - ",
				b.toString() );
		assertEquals( true, b.search( 3 ) );
		assertEquals( false, b.search( 12 ) );

	}

	@Test public void testHashTableRemoveLP() {
		// Example
		HashTable<Integer> a = new HashTable<Integer>( 5, HashTable.LINEAR_PROBING, 1.0 );
		a.add( 4 );
		a.add( 13 );
		a.add( 24 );
		a.add( 3 );
		a.remove( 24 );
		assertEquals( true, a.search( 3 ) );
		assertEquals( false, a.search( 24 ) );
		assertEquals( "[0] (2) = 24 - [1] (1) = 3 - [2] (0) = null - [3] (1) = 13 - [4] (1) = 4 - ",
				a.toString() );

		a.add( 15 );
		assertEquals( true, a.search( 3 ) );
		assertEquals( "[0] (1) = 15 - [1] (1) = 3 - [2] (0) = null - [3] (1) = 13 - [4] (1) = 4 - ",
				a.toString() );

	}

	@Test public void testHashTableRemoveQP() {
		// Example
		HashTable<Integer> b = new HashTable<Integer>( 5, HashTable.QUADRATIC_PROBING, 1.0 );
		b.add( 4 );
		b.add( 13 );
		b.add( 24 );
		b.add( 3 );

		b.remove( 24 );
		assertEquals( true, b.search( 3 ) );
		assertEquals( "[0] (2) = 24 - [1] (0) = null - [2] (1) = 3 - [3] (1) = 13 - [4] (1) = 4 - ",
				b.toString() );

		b.add( 15 );
		assertEquals( true, b.search( 3 ) );
		assertEquals( "[0] (1) = 15 - [1] (0) = null - [2] (1) = 3 - [3] (1) = 13 - [4] (1) = 4 - ",
				b.toString() );
	}

	@SuppressWarnings("static-access") @Test public void testPrime() {
		HashTable<Integer> a = new HashTable<Integer>( 5, HashTable.LINEAR_PROBING, 1.0 );
		assertEquals( false, a.isPrime( 1 ) ); // One is not a prime number so
												// prime
		// numbers are those grater than one
		// that...
		assertEquals( true, a.isPrime( 5 ) );
		assertEquals( true, a.isPrime( 17 ) );
		assertEquals( true, a.isPrime( 11 ) );
		assertEquals( true, a.isPrime( 113 ) );
		assertEquals( false, a.isPrime( 90 ) );
		assertEquals( false, a.isPrime( 12345 ) );

		assertEquals( 2, a.prevPrime( 3 ) );
		assertEquals( 3, a.prevPrime( 4 ) );
		assertEquals( 3, a.prevPrime( 5 ) );
		assertEquals( 5, a.prevPrime( 7 ) );
		assertEquals( 7, a.prevPrime( 10 ) );
		assertEquals( 11, a.prevPrime( 12 ) );
		assertEquals( 11, a.prevPrime( 13 ) );
		assertEquals( 53, a.prevPrime( 59 ) );
		assertEquals( 3499, a.prevPrime( 3500 ) );

		assertEquals( 7, a.nextPrime( 5 ) );
		assertEquals( 11, a.nextPrime( 7 ) );
		assertEquals( 11, a.nextPrime( 7 ) );
		assertEquals( 11, a.nextPrime( 7 ) );
		assertEquals( 13, a.nextPrime( 12 ) );
		assertEquals( 13, a.nextPrime( 11 ) );
		assertEquals( 17, a.nextPrime( 14 ) );
		assertEquals( 3001, a.nextPrime( 3000 ) );

	}

	@Test public void martinTest() {
		HashTable<Integer> a = new HashTable<Integer>( 5, HashTable.LINEAR_PROBING, 1.0 );
		a.add( 4 );
		a.add( 13 );
		a.add( 24 );
		a.add( 3 );
		assertEquals( "[0] (1) = 24 - [1] (1) = 3 - [2] (0) = null - [3] (1) = 13 - [4] (1) = 4 - ",
				a.toString() );
		assertEquals( true, a.search( 3 ) );
		assertEquals( false, a.search( 12 ) );
	}

	@Test public void addAndSearchTest() {
		HashTable<Integer> a = new HashTable<Integer>( 5, HashTable.LINEAR_PROBING, 1.0 );
		a.add( 4 );
		a.add( 13 );
		a.add( 24 );
		a.add( 3 );
		assertEquals( "[0] (1) = 24 - [1] (1) = 3 - [2] (0) = null - [3] (1) = 13 - [4] (1) = 4 - ",
				a.toString() );
		assertEquals( true, a.search( 3 ) );
		assertEquals( false, a.search( 12 ) );
	}

	@Test public void doubleHashingTest() {
		// With integer values.
		HashTable<Integer> c = new HashTable<Integer>( 5, HashTable.DOUBLE_HASHING, 0.5 );
		assertEquals( 2, c.f( 7, 0 ) );
		assertEquals( 4, c.f( 7, 1 ) );
		assertEquals( 1, c.f( 7, 2 ) );
		assertEquals( 3, c.f( 7, 3 ) );
		assertEquals( 0, c.f( 7, 4 ) );
		assertEquals( 0, c.f( 0, 0 ) );
		assertEquals( 1, c.f( 2, 4 ) );
		assertEquals( 2, c.f( 3, 3 ) );
		assertEquals( 3, c.f( 32, 1 ) );
		assertEquals( 4, c.f( 1045, 2 ) );

		// With char elements.
		HashTable<Character> d = new HashTable<Character>( 5, HashTable.DOUBLE_HASHING, 0.5 );
		assertEquals( 0, d.f( 'A', 0 ) );
		assertEquals( 1, d.f( 'A', 1 ) );
		assertEquals( 2, d.f( 'A', 2 ) );
		assertEquals( 3, d.f( 'A', 3 ) );
		assertEquals( 4, d.f( 'A', 4 ) );
		assertEquals( 2, d.f( 'a', 0 ) );
		assertEquals( 4, d.f( 'a', 1 ) );
		assertEquals( 1, d.f( 'a', 2 ) );
		assertEquals( 3, d.f( 'a', 3 ) );
		assertEquals( 0, d.f( 'a', 4 ) );
	}

	@Test public void searchAndRemoveWithDoubleHashingTest() {
		HashTable<Integer> c = new HashTable<Integer>( 5, HashTable.DOUBLE_HASHING, 1.0 );
		c.add( 4 );
		c.add( 13 );
		c.add( 24 );
		c.add( 3 );
		assertEquals( "[0] (0) = null - [1] (1) = 3 - [2] (1) = 24 - [3] (1) = 13 - [4] (1) = 4 - ",
				c.toString() );
		c.remove( 24 );
		assertEquals( "[0] (0) = null - [1] (1) = 3 - [2] (2) = 24 - [3] (1) = 13 - [4] (1) = 4 - ",
				c.toString() );
		assertEquals( true, c.search( 3 ) );
		c.add( 15 );
		assertEquals( true, c.search( 3 ) );
		assertEquals( "[0] (1) = 15 - [1] (1) = 3 - [2] (2) = 24 - [3] (1) = 13 - [4] (1) = 4 - ",
				c.toString() );
	}

	@Test public void dynamicResizingTest() {
		HashTable<Integer> a = new HashTable<Integer>( 5, HashTable.LINEAR_PROBING, 0.5 );
		a.add( 4 );
		assertEquals( 0.2, a.loadFactor(), 0.1 );
		a.add( 13 );
		assertEquals( 0.4, a.loadFactor(), 0.1 );
		assertEquals(
				"[0] (0) = null - [1] (0) = null - [2] (0) = null - [3] (1) = 13 - [4] (1) = 4 - ",
				a.toString() );
		a.add( 24 ); // DYNAMIC RESIZING!
		assertEquals( 0.27, a.loadFactor(), 0.1 );
		assertEquals(
				"[0] (0) = null - [1] (0) = null - [2] (1) = 24 - [3] (1) = 13 - [4] (1) = 4 - [5] (0) = null - [6] (0) = null - [7] (0) = null - [8] (0) = null - [9] (0) = null - [10] (0) = null - ",
				a.toString() );
	}

}

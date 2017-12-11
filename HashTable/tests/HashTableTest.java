package HashTable.tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Random;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import HashTable.HashTable;

public class HashTableTest {

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

	@SuppressWarnings("deprecation") @Test public void getNextPrimeAKSTest() {
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

	private static String randomWord( int length ) {
		Random random = new Random();
		StringBuilder word = new StringBuilder( length );
		for (int i = 0; i < length; i++) {
			word.append( (char) ( 'a' + random.nextInt( 26 ) ) );
		}

		return word.toString();
	}

	@Test @Ignore public void differentsLoadFactorsTest() {
		HashTable<String> linearHash = new HashTable<String>( 5, HashTable.LINEAR_PROBING, 0.5 );
		HashTable<String> quadraticHash = new HashTable<String>( 5, HashTable.QUADRATIC_PROBING,
				0.5 );
		HashTable<String> doubleHash = new HashTable<String>( 5, HashTable.DOUBLE_HASHING, 0.5 );

		double linearTest = 0.0;
		int linearCol = 0;
		double quadraticTest = 0.0;
		int quadraticCol = 0;
		double doubleTest = 0.0;
		int doubleCol = 0;
		ArrayList<Integer> results = new ArrayList<Integer>();

		double aux = System.currentTimeMillis();
		for (int i = 0; i < 216553; i++)
			linearCol += linearHash.add( randomWord( 3 ) );
		linearTest = System.currentTimeMillis() - aux;

		aux = System.currentTimeMillis();
		for (int i = 0; i < 216553; i++)
			quadraticCol += quadraticHash.add( randomWord( 3 ) );
		quadraticTest = System.currentTimeMillis() - aux;

		aux = System.currentTimeMillis();
		for (int i = 0; i < 216553; i++)
			doubleCol += doubleHash.add( randomWord( 3 ) );
		doubleTest = System.currentTimeMillis() - aux;

		System.out.println( linearTest + ", " + quadraticTest + ", " + doubleTest + "." );

		if (( linearTest < doubleTest ) && ( linearTest < quadraticTest ))
			results.add( 1 );
		else if (( doubleTest < linearTest ) && ( doubleTest < quadraticTest ))
			results.add( 2 );
		else
			results.add( 3 );

		System.out.println( "Better algorithm ->" + populated( results ) );

		System.out
				.println( "LINEAR PROBING\t\t COLISIONS\t --> \t" + linearCol + ", \tTIME -->\t "
						+ linearTest + "ms." );
		System.out.println(
				"QUADRATIC PROBING\t COLISIONS\t --> \t" + quadraticCol + ", \tTIME -->\t "
						+ quadraticTest + "ms." );
		System.out
				.println( "DOUBLE HASHING\t\t COLISIONS\t --> \t" + doubleCol + ", \tTIME -->\t "
						+ doubleTest + "ms." );
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

		if (( count1 > count2 ) && ( count1 > count3 ))
			return 1;
		else if (( count2 > count1 ) && ( count2 > count3 ))
			return 2;
		else
			return 3;
	}

}

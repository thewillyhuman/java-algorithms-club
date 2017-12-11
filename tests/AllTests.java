package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import AVLTree.tests.AllAVLTests;
import BinaryHeap.tests.AllBinaryHeapTests;
import Bubblesort.tests.BubbleTest;
import Graph.tests.AllGraphsTests;
import HashTable.tests.HashTableAllTests;

@RunWith(Suite.class) @SuiteClasses({ AllAVLTests.class,
		AllBinaryHeapTests.class, AllGraphsTests.class,
		HashTableAllTests.class, BubbleTest.class }) public class AllTests {

}

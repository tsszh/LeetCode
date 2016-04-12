package utilities;

import java.util.Random;

public class RandomListNodeFactory {
	/**
	 * 
	 * Create a random linked list based on the provided label and index array.
	 * The length of two array are guaranteed to be identical.
	 * 
	 * @param labels The array that records the labels of each node, following the sequence of linked list.
	 * @param indexs The array that records the label of node which each random pointer points at, -1 indicates null
	 * @return The head of the random linked array
	 * 
	 */
	private static RandomListNode createRandomListHelper( int[] labels, int[] indexs ) {
		int n = labels.length;
		RandomListNode[] nodePools = new RandomListNode[n];
		RandomListNode head = null, prev = null, curr = null;
		for ( int i = 0; i < n; i++ ) {
			nodePools[i] = curr = new RandomListNode( labels[i] );
			if ( prev != null ) prev.next = curr;
			else head = curr;
			prev = curr;
		}
		for ( int i = 0; i < n; i++ ) {
			if ( indexs[i] != -1 )
				nodePools[i].random = nodePools[ indexs[i] ];
		}
		return head;
	}
	
	/**
	 * 
	 * Create a random linked list based on the provided label and index array. 
	 * 
	 * @param labels The array that records the labels of each node, following the sequence of linked list.
	 * @param indexs The array that records the label of node that each random pointer points at, -1 indicates null
	 * @return The head of the random linked array
	 * 
	 */
	public static RandomListNode createRandomList( int[] labels, int[] indexs ) {
		if ( labels.length != indexs.length ) {
			System.err.println("The lenght of the arrays are not equal");
			return null;
		} 
		return createRandomListHelper(labels, indexs);
	}
	
	/**
	 * 
	 * Create a random linked list based on the provided label array. The random pointer will be set based on a random index array. 
	 * 
	 * @param labels The array that records the labels of each node, following the sequence of linked list.
	 * @return The head of the random linked array
	 * 
	 */
	public static RandomListNode createRandomListByLabelArray( int[] labels ) {
		int n = labels.length;
		if ( n == 0 ) return null;
		Random rand = new Random();
		int[] indexs = new int[n];
		for (  int i = 0; i < n; i++ ) {
			indexs[i] = rand.nextInt(n+1)-1;
		}
		return createRandomListHelper(labels,indexs);
	}
	
	/**
	 * 
	 * Create a random linked list based on the provided random index array.
	 * The labels would be set from 0 to n-1, where n is the length of the index array. 
	 * 
	 * @param indexs The array that records the labels of node which each random pointer points at, -1 indicates null.
	 * @return The head of the random linked array
	 * 
	 */
	public static RandomListNode createRandomListByIndexArray( int[] indexs ) {
		int n = indexs.length;
		if ( n == 0 ) return null;
		int[] labels = new int[n];
		for (  int i = 0; i < n; i++ ) {
			labels[i] = i;
		}
		return createRandomListHelper(labels,indexs);
	}
}

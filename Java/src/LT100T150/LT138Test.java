package LT100T150;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import utilities.RandomListNode;
import utilities.RandomListNodeFactory;

@RunWith(Parameterized.class)
public class LT138Test {
	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][] {
			{ new int[]{0,1,2,3}, new int[]{2,-1,1,2} },
			{ new int[]{2,-1,5,4,-3}, new int[]{-1,0,0,0,4} },
			{ new int[]{3}, new int[]{0} },
			{ new int[]{-4}, new int[]{-1} },
			{ new int[]{}, new int[]{} }
		});
	}
	@Parameter
	public int[] labels;
	@Parameter(value=1)
	public int[] indexs;
	
	private RandomListNode oldList;
	private List<RandomListNode> oldListCopy; 
	
	@Before
	public void intialize() {
		// Create the original linked list
		oldList = RandomListNodeFactory.createRandomList(labels, indexs);
		
		// Record the original linked list
		oldListCopy = new ArrayList<>();
		for ( RandomListNode temp = oldList; temp != null; temp = temp.next ) {
			oldListCopy.add(temp);
		}
	}
	
	@Test
	public void test1() {
		// Copy the original Linked list
		RandomListNode newList = new LT138().copyRandomList1(oldList);
		
		checkOriginalListNotChanged( oldList, oldListCopy );
		checkTwoListIsEqual( oldList, newList );
	}
	
	@Test
	public void test2() {
		// Copy the original Linked list
		RandomListNode newList = new LT138().copyRandomList2(oldList);
		
		checkOriginalListNotChanged( oldList, oldListCopy );
		checkTwoListIsEqual( oldList, newList );
	}

	private void checkOriginalListNotChanged( RandomListNode oldList, List<RandomListNode> oldListCopy ) {
		// Check whether the original linked list has been changed
		Iterator<RandomListNode> it = oldListCopy.iterator();
		for ( RandomListNode temp = oldList; temp != null; temp = temp.next ) {
			assertTrue( it.hasNext() && temp == it.next() );
		}
	}
	
	private void checkTwoListIsEqual( RandomListNode oldList, RandomListNode newList ) {
		// Check whether two linked list are equal
		while ( oldList != null ) {
			assertTrue( oldList != newList );
			assertEquals( oldList.label, newList.label );
			if ( oldList.random == null ) {
				assertTrue( newList.random == null );
			} else {
				assertTrue( oldList.random != newList.random );
				assertEquals( oldList.random.label, newList.random.label );
			}
			oldList = oldList.next;
			newList = newList.next;
		}
	}
}

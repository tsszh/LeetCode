package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RandomListNodeFactoryTest {

	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][]{
			{ new int[] {3,-3,4,2}, new int[] {3,-1,1,0} },
			{ new int[] {3}, new int[] {0} },
			{ new int[] {}, new int[] {} },
		});
	}
	
	@Parameter
	public int[] labels;
	
	@Parameter(value=1)
	public int[] indexs;
	
	@Test
	public void createRandomListTest() {
		RandomListNode list = RandomListNodeFactory.createRandomList(labels, indexs);
		justifyLinkedList(list,labels,indexs);
	}
	
	@Test
	public void createRandomListByLabelArrayTest() {
		RandomListNode list = RandomListNodeFactory.createRandomListByLabelArray(labels);
		justifyLinkedList(list,labels,null);
	}
	
	@Test
	public void createRandomListByIndexArrayTest() {
		RandomListNode list = RandomListNodeFactory.createRandomListByIndexArray(indexs);
		justifyLinkedList(list,null,indexs);
	}
	
	private void justifyLinkedList( RandomListNode list, int[] labels, int[] indexs ) {
		if ( indexs == null ) {
			for ( int i = 0; i < labels.length && list!=null; i++, list = list.next ) {
				assertEquals(list.label,labels[i]);
				assertTrue( list.random==null || intArrayContains(labels,list.random.label) );
			}
		} else {
			for ( int i = 0; i < indexs.length && list!=null; i++, list = list.next ) {
				assertEquals(list.label,labels==null?i:labels[i]);
				if ( indexs[i] == -1 ) {
					assertTrue( list.random==null );
				} else {
					assertEquals( list.random.label, labels==null?indexs[i]:labels[ indexs[i] ]);
				}
			}
		}
	}
	
	private boolean intArrayContains( int[] array, int key ) {
		for ( int x : array ) {
			if ( x == key ) return true;
		}
		return false;
	}
}

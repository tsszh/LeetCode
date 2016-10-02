package LT200T250;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import utilities.ListNode;
import utilities.ListNodeFactory;

@RunWith(Parameterized.class)
public class LT206Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{5},
			{2},
			{1},
			{0}
		});
	}
	@Parameter
	public int len;
	
	private LT206 dummy = new LT206();
	
	@Test
	public void test() {
		ListNode head = ListNodeFactory.createListNode(len);
		int[] expRes = new int[len];
		for (int i = 0; i < len; i++) {
			expRes[i] = len-1-i;
		}
		assertArrayEquals(expRes, ListNodeFactory.toArray(dummy.reverseList(head)));
	}
	@Test
	public void test2() {
		ListNode head = ListNodeFactory.createListNode(len);
		int[] expRes = new int[len];
		for (int i = 0; i < len; i++) {
			expRes[i] = len-1-i;
		}
		assertArrayEquals(expRes, ListNodeFactory.toArray(dummy.reverseList2(head)));
	}

}

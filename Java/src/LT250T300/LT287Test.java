package LT250T300;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT287Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{5,2},
			{1,1},
			{10,3},
			{10000,40}
		});
	}
	@Parameter
	public int n;
	@Parameter(value=1)
	public int res;
	
	private LT287 dummy = new LT287();
	private int[] nums;
	@Before
	public void intitialize() {
		nums = new int[n+1];
		for ( int i = 0; i < n; i++ ) nums[i]=i+1;
		nums[n] = res;
		shuffleArray(nums);
	}
	
	@Test
	public void test() {
		assertEquals( res, dummy.findDuplicate(nums) );
	}
	private void shuffleArray( int[] nums ) {
		Random rand = new Random();
		int n = nums.length;
		for ( int i = 0; i < n; i++ ) {
			swap( nums, i, i+rand.nextInt(n-i) );
		}
	}
	private void swap( int[] nums, int a, int b ) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}

package LT150T200;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT164Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{0, 2}, 2},
			{new int[]{-1, 2, 4}, 3},
			{new int[]{-7, -1, 0, 2, 4}, 6},
			{new int[]{-2, 1}, 3},
			{new int[]{1}, 0}
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value=1)
	public int expRes;
	
	private LT164 dummy = new LT164();
	
	@Test
	public void test() {
		shuffle(nums);
//		System.out.println(Arrays.toString(nums));
		int res = dummy.maximumGap(nums);
		assertEquals( expRes, res );
	}
	
	private void shuffle( int[] nums ) {
		Random rand = new Random();
		int n = nums.length;
		for ( int i = 0; i < n; i++ ) {
			int j = rand.nextInt(n-i)+i;
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
		}
	}
}

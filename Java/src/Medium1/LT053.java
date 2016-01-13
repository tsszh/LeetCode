package Medium1;

import java.util.*;

public class LT053 {
	public static void main ( String[] args ) {
		LT053 dummy = new LT053();
		Scanner in = new Scanner(System.in);
		Random gen = new Random();
		for ( int i = 0; i < 20; i++ ) {
			int[] nums = new int[gen.nextInt(200000)];
			for ( int j = 0; j < nums.length; j++ ) {
				nums[j] = gen.nextInt(100);
			}
			long st1, et1, st2, et2;
			int res1, res2;
			st1 = System.nanoTime();
			res1 = dummy.maxSubArray1(nums);
			et1 = System.nanoTime();
			st2 = System.nanoTime();
			res2 = dummy.maxSubArray2(nums);
			et2 = System.nanoTime();
			System.out.printf("Dynamic Programming: %3d %10d ns\n", res1,et1-st1);
			System.out.printf("Divide & Conquer   : %3d %10d ns\n\n", res2,et2-st2);
		}
		
		in.close();
	}
	/**
	 * Dynamic Programming : sum[i] = sum[i-1]+nums[i] if sum[i-1] > 0
	 *                              = nums[i]          Otherwise
	 * sum[i] records the longest subArray ended at i
	 * Time O(n) Space O(1)
	 * @param nums
	 * @return
	 */
	public int maxSubArray1(int[] nums) {
		if ( nums == null || nums.length == 0 ) return 0;
        int max = Integer.MIN_VALUE;
        int prevSum = -1;
        for ( int i = 0; i < nums.length; i++ ) {
        	if ( prevSum >= 0 )
        		prevSum += nums[i];
        	else
        		prevSum = nums[i];
        	if ( prevSum > max )
        		max = prevSum;
        }
        return max;
    }
	/**
	 * Divide and Conquer : max = Math.max( left.max, right.max, left.RightLongest+right.LeftLongest )
	 * @param nums
	 * @return
	 */
	public int maxSubArray2(int[] nums) {
		if ( nums == null || nums.length == 0 ) return 0;
		return maxSubArray2Helper(nums,0,nums.length-1).max;
	}
	private Result maxSubArray2Helper( int[] nums, int s, int e ) {
		if ( s == e )
			return new Result(nums[s],nums[s],nums[s],nums[s]);
		int m = (s+e)>>1;
		Result left  = maxSubArray2Helper(nums,s,m);
		Result right = maxSubArray2Helper(nums,m+1,e);
		
		int max = Math.max(left.max, right.max);
		max = Math.max(max, left.rmax+right.lmax);
		int lmax = Math.max(left.lmax, left.sum+right.lmax);
		int rmax = Math.max(right.rmax, right.sum+left.rmax);
		int sum = left.sum + right.sum;
		//System.out.printf("[%2d %2d] %3d (%3d,%3d) sum = %d\n",s,e,max,lmax,rmax,sum);
		return new Result(max,lmax,rmax,sum);
	}
	public int maxSubArray2R(int[] nums) {
		if ( nums == null || nums.length == 0 ) return 0;
		return maxSubArray2HelperR(nums,0,nums.length-1).max;
	}
	private Result maxSubArray2HelperR( int[] nums, int s, int e ) {
		if ( s == e )
			return new Result(nums[s],nums[s],nums[s],nums[s]);
		int m = (s+e)>>1;
		return maxSubArray2Helper(nums,s,m).combineWith(maxSubArray2Helper(nums,m+1,e));
	}
	private class Result {
		int max;
		int lmax;
		int rmax;
		int sum;
		Result(int max, int lmax, int rmax, int sum ) {
			this.max = max;
			this.lmax = lmax;
			this.rmax = rmax;
			this.sum = sum;
		}
		public Result combineWith(Result right) {
			max = Math.max(max, right.max);
			max = Math.max(max, rmax+right.lmax);
			lmax = Math.max(lmax, sum+right.lmax);
			rmax = Math.max(right.rmax, right.sum+rmax);
			sum = sum + right.sum;
			return this;
		}
	}
}

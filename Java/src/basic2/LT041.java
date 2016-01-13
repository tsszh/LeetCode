package basic2;

import java.util.*;

public class LT041 {
	public static void main ( String[] args ) {
		LT041 dummy = new LT041();
		int[] nums = new int[20];
		for ( int i = 0; i<nums.length; i++ ) {
			nums[i] = i+1;
		}
		nums[9] = 20;
		nums[0] = -1;
		Random rand = new Random();
		for ( int i = 0; i < nums.length; i++ ) {
			int j = rand.nextInt(nums.length);
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
		}
		System.out.println(Arrays.toString(nums));
		System.out.println(dummy.firstMissingPositive(nums));
		System.out.println(Arrays.toString(nums));
	}
	public int firstMissingPositive(int[] nums) {
		if ( nums == null || nums.length == 0 ) return 1;
		for ( int i = 0; i<nums.length; i++ ) {
			if ( nums[i] != i+1 ) {
				int j = nums[i]-1;
				while ( j>=0 && j<nums.length && nums[j]!=j+1 ) {
					int temp = nums[j]-1;
					nums[j] = j+1;
					j = temp;
				}
			}
		}
		for ( int i = 0; i < nums.length; i++  ) {
			if ( nums[i] != i+1 ) return i+1;
		}
		return nums.length+1;
    }
}

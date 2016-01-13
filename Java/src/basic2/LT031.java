package basic2;

import java.util.*;

public class LT031 {
	public static void main ( String[] args ) {
		LT031 dummy = new LT031();
		Scanner in = new Scanner(System.in);
		while ( in.hasNextInt() ) {
			int tempInt = in.nextInt();
			if ( tempInt > 0 ) {
				int bits = (int)Math.log10(tempInt)+1;
				int[] nums = new int[bits];
				for ( int i = nums.length-1; i>=0; i-- ) {
					nums[i] = tempInt%10;
					tempInt /= 10;
				}
				System.out.println(Arrays.toString(nums));
				dummy.nextPermutation(nums);
				System.out.println(Arrays.toString(nums));
			}
		}
		in.close();
	}
	public void nextPermutation(int[] nums) {
        if ( nums != null && nums.length > 1 ) {
        	int i = nums.length-2;
        	while ( i>=0 && nums[i] >= nums[i+1] ) i--;
        	if ( i == -1 ) reverseArray(nums,0);
        	else {
        		int temp = nums[i];
        		int j = i+1;
        		while ( j<nums.length-1 && nums[j+1]>temp ) j++;
        		nums[i] = nums[j];
        		nums[j] = temp;
        		reverseArray(nums,i+1);
        	}
        }
    }
	private void reverseArray( int[] nums, int start ) {
		for ( int end = nums.length-1, temp; start < end; start++, end-- ) {
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
		}
	}
}

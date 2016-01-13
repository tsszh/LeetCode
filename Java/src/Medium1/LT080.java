package Medium1;

import java.util.Arrays;

public class LT080 {
	public static void main ( String[] args ) {
		int[] nums = new int[] {
			1,2,2,2,2,2,3,4
		};
		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
	public static int removeDuplicates(int[] nums) {
		int i = 0;
        for ( int j=0; j < nums.length; ) {
            nums[i++] = nums[j++];
            if ( j < nums.length && nums[j] == nums[i-1] ) nums[i++] = nums[j++];
            while ( j < nums.length && nums[j] == nums[i-1] ) j++;
        }
        return i;
    }
}

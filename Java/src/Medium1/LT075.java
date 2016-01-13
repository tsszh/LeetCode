package Medium1;

import java.util.*;

public class LT075 {
	public static void main ( String[] args ) {
		int[] nums = new int[] {
			0,0,2
		};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
	public static void sortColors(int[] nums) {
        for ( int m0=0, m1=0, m2=0; m2 < nums.length; m2++ ) {
        	if ( nums[m2] == 0 ) {
        		nums[m0++] = 0;
        		if ( m0 <= m1 ) nums[m1] = 1;
        		m1++;
        		if ( m1<=m2 ) nums[m2] = 2;
        	} else if ( nums[m2] == 1 ) {
        		nums[m1++] = 1;
        		if ( m1<=m2 ) nums[m2] = 2;
        	}
        }
    }
}

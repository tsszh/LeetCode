package basic2;

import java.util.*;

public class LT033 {
	public static void main ( String[] args ) {
		int[] nums = new int[30];
		for ( int i = 0; i<nums.length; i++ ) {
			nums[i] = 1;
		}
		nums[nums.length-1]=5;
		Scanner in = new Scanner(System.in);
		while ( in.hasNextInt() ) {
			rotateArray(nums, in.nextInt());
			System.out.println(Arrays.toString(nums));
			System.out.println(search(nums,in.nextInt()));
		}
		in.close();
	}
	public static void rotateArray( int[] nums, int n ) {
		int count = nums.length, bound=0;
		while ( count > 0 ) {
			int i = bound;
			int temp = nums[bound];
			while ( count > 0 ) {
				int j = (i+n)%nums.length;
				count--;
				if ( j == bound ) {
					nums[i] = temp;
					break;
				} else {
					nums[i] = nums[j];
					i = j;
				}
			}
			bound++;
		}
	}
	public static int search(int[] nums, int target) {
		if ( nums == null || nums.length == 0 ) return -1;
		int zero = nums[0];
		if ( zero == target ) return 0;
        boolean isLeft = target>nums[0];
        int s = 0, e = nums.length-1;
        while ( s < nums.length && nums[s] == zero ) s++;
        while ( e >= 0 && nums[e] == zero ) e--;
        while ( s <= e ) {
        	int mid = (s+e)/2;
        	int midV = nums[mid];
        	if ( midV == target ) return mid;
        	if ( isLeft ) {
        		if ( midV > zero && midV < target )
        			s = mid+1;
        		else
        			e = mid-1;
        	} else { // isRight
        		if ( midV < zero && midV > target )
        			e = mid-1;
        		else
        			s = mid+1;
        	}
        }
        return -1;
    }
}

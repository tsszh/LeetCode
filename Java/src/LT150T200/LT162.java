package LT150T200;

public class LT162 {
	public int findPeakElement(int[] nums) {
		if ( nums == null || nums.length == 0 ) return 0;
		int l = 0, r = nums.length-1;
		while ( l < r ) {
			int m = (l+r)/2;
			switch ( judge(nums,m) ) {
			case  0: return m;
			case -1: r = m; break;
			case  1: l = m+1;
			}
		}
		return l;
	}
	// Up 1; Peak 0; Down -1;
	private int judge ( int[] nums, int i ) {
		if ( nums.length == 1 ) return 0;
		if ( i == 0 ) {
			if ( nums[i] > nums[i+1] ) return 0;
			return 1;
		}
		if ( i == nums.length-1 ) {
			if ( nums[i-1] < nums[i] ) return 0;
			return -1;
		}
		if ( nums[i-1] > nums[i] ) return -1;
		if ( nums[i] < nums[i+1] ) return 1;
		return 0;
	}
}

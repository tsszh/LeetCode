package Medium1;

public class LT055 {
	public boolean canJump(int[] nums) {
		if ( nums == null || nums.length == 0 ) return false;
		for ( int i = 0, max = 1; i < nums.length-1; i++ ) {
			max--;
			if ( nums[i] > max ) max = nums[i];
			if ( max <= 0 ) return false;
		}
		return true;
    }
}

package basic2;

public class LT045 {
	public static void main ( String[] args ) {
		LT045 dummy = new LT045();
		int[] nums = new int[] {
				1,1,1,1
		};
		System.out.println(dummy.jump(nums));
	}
	public int jump(int[] nums) {
		int count=0, pos = 0, lastChecked = 0;
		while ( pos+nums[pos] < nums.length-1 ) {
			count++;
			int nextPos = pos+nums[pos];
			int max = nextPos;
			for ( int i = nextPos; i>lastChecked; i-- ) {
				if ( i+nums[i] > max ) {
					max = i+nums[i];
					nextPos = i;
				}
			}
			lastChecked = pos+nums[pos];
			pos = nextPos;
		}
		return count+1;
    }
}

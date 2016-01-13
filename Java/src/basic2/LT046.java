package basic2;

import java.util.*;

public class LT046 {
	public static void main ( String[] args ) {
		LT046 dummy = new LT046();
		int[] nums = new int[] {
				1,2
		};
		List<List<Integer>> ret = dummy.permuteUnique(nums);
		HashSet<List<Integer>> retSet = new HashSet<List<Integer>>(dummy.permute(nums));
		System.out.println(""+retSet.size()+" "+ret.size());
		System.out.println(ret);
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if ( nums == null || nums.length == 0 ) return ret;
		Arrays.sort(nums);
		permuteUniqueHelper(nums,0,ret);
		return ret;
    }
	private void permuteUniqueHelper( int[] nums, int start, List<List<Integer>> ret ) {
		if ( start >= nums.length ) {
			ret.add(intArrayToList(nums));
			return;
		}
		
		// 1 1 2 2 3 3 
		permuteUniqueHelper(nums,start+1,ret);
		for ( int i = start+1; i < nums.length; i++ ) {
			if ( nums[i] == nums[start] ) continue;
			int temp = nums[start];
			nums[start] = nums[i];
			nums[i] = temp;
			permuteUniqueHelper(nums,start+1,ret);
		}
		// 3 1 1 2 2 3
		for ( int i = start; i < nums.length-1; i++ ) {
			if ( nums[i] > nums[i+1] ) {
				int temp = nums[i];
				nums[i] = nums[i+1];
				nums[i+1] = temp;
			}
		}
		// 1 1 2 2 3 3
	}
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if ( nums == null || nums.length == 0 ) return ret;
		permuteHelper(nums,0,ret);
		return ret;
    }
	private void permuteHelper(int[] nums, int start, List<List<Integer>> ret ) {
		if ( start >= nums.length ) {
			ret.add(intArrayToList(nums));
			return;
		}
		int temp = nums[start];
		for ( int i = start; i < nums.length; i++ ) {
			nums[start] = nums[i];
			nums[i] = temp;
			permuteHelper(nums,start+1,ret);
			nums[i] = nums[start];
		}
		nums[start] = temp;
	}
	private List<Integer> intArrayToList ( int[] nums ) {
		if ( nums == null || nums.length == 0 ) return new ArrayList<Integer>();
		List<Integer> ret = new ArrayList<Integer>(nums.length);
		for ( int i = 0; i < nums.length; i++ )
			ret.add(nums[i]);
		return ret;
	}
}

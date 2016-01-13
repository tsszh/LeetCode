package Medium1;

import java.util.*;

public class LT090 {
	public static void main ( String[] args ) {
		int[] nums = new int[] {
				2,1,2,3,3
		};
		List<List<Integer>> res = subsetsWithDup(nums);
		for ( List<Integer> list : res )
			System.out.println(list);
	}
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		Arrays.sort(nums);
		for ( int i = 0; i < nums.length; ) {
			int count = 0, num = nums[i];
			while ( i<nums.length && nums[i]==num ) {count++;i++;}
			List<List<Integer>> temp = new LinkedList<List<Integer>>();
			while ( count > 0 ) {
				for ( List<Integer> item : res ) {
					List<Integer> newItem = new ArrayList<Integer>(item);
					for ( int c = 0; c < count; c++ )
						newItem.add(num);
					temp.add(newItem);
				}
				count--;
			}
			res.addAll(temp);
		}
		return res;
    }
}

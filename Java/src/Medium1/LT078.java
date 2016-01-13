package Medium1;

import java.util.*;

public class LT078 {
	public static void main ( String[] args ) {
		int[] nums = new int[] {
			1,2	
		};
		List<List<Integer>> res = subsets(nums);
		System.out.println(res.size());
		for ( List<Integer> item : res )
			System.out.println(item);
	}
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        for ( int i = 0; i < nums.length; i++ ) {
        	List<List<Integer>> temp = new LinkedList<List<Integer>>();
        	for ( List<Integer> item : res ) {
        		List<Integer> newItem = new ArrayList<Integer>(item.size()+1);
        		newItem.addAll(item);
        		newItem.add(nums[i]);
        		temp.add(newItem);
        	}
        	res.addAll(temp);
        }
        return res;
    }
}

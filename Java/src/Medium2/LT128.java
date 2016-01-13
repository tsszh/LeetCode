package Medium2;

import java.util.*;

public class LT128 {
	public static void main ( String[] args ) {
		int[] nums = new int[] {
				-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7
		};
		System.out.println(longestConsecutive(nums));
	}
	public static int longestConsecutive(int[] nums) {
		if ( nums == null || nums.length == 0 ) return 0;
		if ( nums.length == 1 ) return 1;
		class Pair {
			int min;
			int max;
			Pair( int min, int max ) {
				this.min = min;
				this.max = max;
			}
			public String toString() {
				return String.format("[%d,%d]", min,max);
			}
		}
		HashSet<Integer> intSet = new HashSet<Integer>(nums.length);
        HashMap<Integer,Pair> minMap = new HashMap<Integer,Pair>(nums.length>>1);
        HashMap<Integer,Pair> maxMap = new HashMap<Integer,Pair>(nums.length>>1);
        int maxLen = 1;
        for ( int val : nums ) {
        	if ( intSet.contains(val) ) continue;
        	else intSet.add(val);
        	Pair low  = maxMap.get(val-1);
        	Pair high = minMap.get(val+1);
        	if ( low == null ) {
        		if ( high == null ) {
        			Pair temp = new Pair(val,val);
        			minMap.put(val, temp);
        			maxMap.put(val, temp);
        		} else {
        			minMap.remove(high.min);
        			high.min = val;
        			minMap.put(high.min, high);
        			maxLen = Math.max(maxLen,high.max - high.min + 1);
        		}
        	} else {
        		if ( high == null ) {
        			maxMap.remove(low.max);
        			low.max = val;
        			maxMap.put(low.max, low);
        			maxLen = Math.max(maxLen,low.max - low.min + 1);
        		} else {
        			minMap.remove(high.min);
        			maxMap.remove(high.max);
        			
        			maxMap.remove(low.max);
        			low.max = high.max;
        			maxMap.put(low.max,low);
        			maxLen = Math.max(maxLen,low.max - low.min + 1);
        		}
        	}
        }
        return maxLen;
    }
}

package basic2;

import java.util.*;

public class LT034 {
	public static void main ( String[] args ) {
		LT034 dummy = new LT034();
		int[] nums = new int[10];
		Random gen = new Random();
		for ( int i = 0; i<nums.length; i++ )
			nums[i] = gen.nextInt(20);
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		Scanner in = new Scanner(System.in);
		while ( in.hasNextInt() ) {
			System.out.println(Arrays.toString(nums));
			long st, et;
			int[] ret;
			int target = in.nextInt();
			
			System.out.println("Insert Position : "+dummy.searchInsert(nums,target));
			
			st = System.nanoTime();
			ret = dummy.searchRange(nums,target);
			et = System.nanoTime();
			System.out.println("Double Binary Search : "+Arrays.toString(ret)+(et-st)+"ns");
			
			st = System.nanoTime();
			ret = dummy.searchRange2(nums,target);
			et = System.nanoTime();
			System.out.println("Divide and Conquer   : "+Arrays.toString(ret)+(et-st)+"ns");
		}
		in.close();
	}
	public int[] searchRange2(int[] nums, int target ) {
		if ( nums == null || nums.length == 0 ) return new int[]{-1,-1};
		return searchRangeHealper(nums,0,nums.length-1,target);
	}
	private int[] searchRangeHealper(int[] nums, int s, int e, int target ) {
		if ( s > e ) return new int[] {-1,-1};
		int mid = (s+e)/2;
		int midV = nums[mid];
		if ( target < midV )
			return searchRangeHealper(nums,s,mid-1,target);
		else if ( target > midV )
			return searchRangeHealper(nums,mid+1,e,target);
		else {
			int lo = searchRangeHealper(nums,s,mid-1,target)[0];
			if ( lo < 0 ) lo = mid;
			int hi = searchRangeHealper(nums,mid+1,e,target)[1];
			if ( hi < 0 ) hi = mid;
			return new int[] {lo,hi};
		}
	}
	
	public int[] searchRange(int[] nums, int target) {
		if ( nums == null || nums.length == 0 ) return new int[]{-1,-1};
		int lo = binarySearch(nums,target,true);
		if ( lo < nums.length && nums[lo] == target ) {
			int high = binarySearch(nums,target,false);
			return new int[] {lo,high};
		} else {
			return new int[] {-1,-1};
		}
		
    }
	private int binarySearch( int[] nums, int target, boolean isLowBound ) {
		int s = 0, e = nums.length-1;
		while ( s <= e ) {
			int mid = (s+e)/2;
			int midV = nums[mid];
			if ( midV>target||(midV == target&&isLowBound) ) {
				e = mid-1;
			} else {
				s = mid+1;
			}
		}
		if ( isLowBound ) return s;
		else return e;
	}
	
	public int searchInsert( int[] nums, int target ) {
		if ( nums == null ) return 0;
		int s = 0, e = nums.length-1;
		while ( s<=e ) {
			int mid = (s+e)/2;
			int midV = nums[mid];
			if ( midV == target ) return mid;
			else if ( midV < target )
				s = mid+1;
			else
				e = mid-1;
		}
		return s;
	}
}

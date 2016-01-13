package basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LT015 {
	public static void main  ( String[] args ) 
			throws FileNotFoundException{
		Scanner in = new Scanner(new File("c:/Users/ZSong/Desktop/test.txt"));
		ArrayList<Integer> input = new ArrayList<Integer>();
		while ( in.hasNextInt() )
			input.add(in.nextInt());
		int[] nums = new int[input.size()];
		for ( int i = 0; i<nums.length; i++ ) {
			nums[i] = input.get(i);
		}
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		Scanner in2 = new Scanner(System.in);
		while ( in2.hasNextInt() ) {
			int ret = threeSumClosest(nums,in2.nextInt());
			System.out.println(ret);
		}
		in.close();
		in2.close();
	}
	public static int threeSumClosest(int[] nums, int target) {
		if ( nums==null || nums.length < 3 ) return 0;
		Arrays.sort(nums);
		
		int ret = nums[0]+nums[1]+nums[2];
		int mingap = Math.abs(ret-target);
		
		int i;
		for ( i = 0; i<nums.length-2 ; i++ ) {
			int a = nums[i];
			for ( int j = i+1, k=nums.length-1; j<k; ) {
				int b = nums[j];
				int c = nums[k];
				int sum = a+b+c;
				if ( Math.abs(sum-target) < mingap  ) {
					ret = sum;
					mingap = Math.abs(sum-target);
					if ( mingap == 0 ) return target;
				} 
				if ( sum < target ) {
					while( j<k && nums[j]==b ) j++;
				} else {
					while ( j<k && nums[k]==c ) k--;
				}
			}
			while ( i<nums.length-1 && nums[i+1]==a ) i++;
		}
		return ret;
    }
}

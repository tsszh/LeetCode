package basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class LT017 {
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
		input.sort( new Comparator<Integer> () {
						public int compare(Integer a, Integer b) {
							return a-b;
						}
					});
		System.out.println(input);
		Scanner target = new Scanner(System.in);
		while ( target.hasNext() ) {
			System.out.println(fourSum(nums,target.nextInt()));
		}
		target.close();
		in.close();
	}
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		if ( nums == null || nums.length <3 ) return new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();

		int i;
		for ( i = 0; i<nums.length-3 ; i++ ) {
			int a = nums[i];
			for ( int j=i+1; j<nums.length-2; j++ ) {
				int b = nums[j]; 
				for ( int k = j+1, l=nums.length-1; k<l; ) {
					int c = nums[k];
					int d = nums[l];
					int sum = a+b+c+d;
					if ( sum == target ) {
						ret.add(Arrays.asList(new Integer[]{a,b,c,d}));
						while( k<l && nums[k]==c ) k++;
						while ( k<l && nums[l]==d ) l--;
					} else if ( sum < target ) {
						while( k<l && nums[k]==c ) k++;
					} else {
						while ( k<l && nums[l]==d ) l--;
					}
				}
				while ( j<nums.length-1 && nums[j+1]==b) j++;
			}
			while ( i<nums.length-1 && nums[i+1]==a ) i++;
		}
		return ret;
	}
}

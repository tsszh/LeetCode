package basic;

import java.util.*;
import java.io.*;

public class LT014 {
	public static void main  ( String[] args ) 
			throws FileNotFoundException{
		Scanner in = new Scanner(new File("c:/Users/ZSong/Desktop/test.txt"));
		ArrayList<Integer> input = new ArrayList<Integer>();
		while ( in.hasNextInt() )
			input.add(in.nextInt());
		int[] nums = new int[input.size()];
		int[] nums2= new int[input.size()];
		for ( int i = 0; i<nums.length; i++ ) {
			nums[i] = input.get(i);
			nums2[i] = input.get(i);
		}
		long st, et;
		st = System.nanoTime();
		List<List<Integer>> ret = threeSum(nums);
		et = System.nanoTime();
		System.out.println("threeSum  = "+(et-st));
		System.out.println(ret);
		
		st = System.nanoTime();
		List<List<Integer>> ret2 = threeSum2(nums2);
		et = System.nanoTime();
		System.out.println("threeSum2 = "+(et-st));
		System.out.println(ret2);
		in.close();
	}
	public static List<List<Integer>> threeSum2(int[] nums) {
		if ( nums == null || nums.length <3 ) return new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		
		ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
		
		int i;
		for ( i = 0; i<nums.length-2 && nums[i]<0; i++ ) {
			int a = nums[i];
			for ( int j = i+1, k=nums.length-1; j<k; ) {
				int b = nums[j];
				int c = nums[k];
				if ( a+b+c == 0 ) {
					ret.add(Arrays.asList(new Integer[]{a,b,c}));
					while( j<k && nums[j]==b ) j++;
					while ( j<k && nums[k]==c ) k--;
				} else if ( a+b+c < 0 ) {
					while( j<k && nums[j]==b ) j++;
				} else {
					while ( j<k && nums[k]==c ) k--;
				}
			}
			while ( i<nums.length-1 && nums[i+1]==a ) i++;
		}
		if ( i<nums.length-2&&nums[i]==0&&nums[i+1]==0&&nums[i+2]==0 )
			ret.add(Arrays.asList(new Integer[]{0,0,0}));
		return ret;
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		if ( nums == null || nums.length <3 ) return new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		
        HashSet<Integer> nmap = new HashSet<Integer>(nums.length);
        for ( int n : nums )
        	nmap.add(n);
        
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        // a<=b<=c
        for ( int i = 0; i<nums.length-2 && nums[i]<=0; i++ ) {
        	int a = nums[i];
        	for ( int j = i+1; j<nums.length-1; j++ ) {
        		int b= nums[j];
        		int c = -a-b;
        		if ( c<b ) {
        			j = nums.length;
        			continue;
        		}
        		if ( c>0 && nmap.contains(c) ) {
        			if ( c != b || nums[j+1]==b )
        				ret.add(Arrays.asList(new Integer[]{a,b,c}));
        		} else if ( a==0 && b==0 && nums[j+1] ==0 ) {
        			ret.add(Arrays.asList(new Integer[]{0,0,0}));
        		}
        		while ( j<nums.length-1 && nums[j+1]==b ) j++;
        	}
        	while ( i<nums.length-1 && nums[i+1]==a ) i++;
        }
        return ret;
    }
}

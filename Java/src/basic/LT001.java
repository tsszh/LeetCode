package basic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @author ZSong
 * @version 1.0  07/01/2015
 * 
 */
public class LT001 {
	public static void main ( String[] args ) {
		try {
			Scanner in = new Scanner(new File("C:\\Users\\ZSong\\Desktop\\test.txt"));
			in.useDelimiter(Pattern.compile("[=\\{,\\s\\}]+"));
			ArrayList<Integer> nums = new ArrayList<Integer> ();
			int target = 0;
			while ( in.hasNext() ) {
				if ( in.next().equals("numbers") ){
					while(in.hasNextInt())
						nums.add(in.nextInt());
				} else { // in.next().equals("target=");
					target = in.nextInt(); 
				}
			}
			int[] numscopy = new int[nums.size()];
			for ( int i = 0; i < numscopy.length; i++ )
				numscopy[i] = nums.get(i);
			System.out.println(Arrays.toString(twoSum(numscopy,target)));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> nmap = new HashMap<Integer,Integer>(nums.length);
        for ( int i = 0; i<nums.length; i++  ) {
        	if ( nmap.containsKey(target-nums[i]) ) {
        		return new int[] {nmap.get(target-nums[i]),i+1};
        	} else {
        		nmap.put(nums[i], i+1 );
        	}
        }
        return null;
    }
}

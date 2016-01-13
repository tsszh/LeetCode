package basic;

import java.util.*;

public class LT003 {
	public static void main ( String[] args ) {
		String teststr = "adjglknev ruenioivaut oiut, opuxz, iu erpieuoapwuezsuidvmruzlv";
		long st = System.nanoTime();
		int ans = lengthOfLongestSubstring2(teststr);
		long et = System.nanoTime();
		System.out.println( "2 = "+ ans+":" + (et-st)+"ns");
		st = System.nanoTime();
		ans = lengthOfLongestSubstring(teststr);
		et = System.nanoTime();
		System.out.println( "1 = "+ ans+":" +(et-st)+"ns");
	}
	public static int lengthOfLongestSubstring2(String s) {
		int[] lmap = new int[300];
		int max = 0, temp = 0;
        for ( int i = 1; i <= s.length(); i++ ) {
        	char key = s.charAt(i-1);
        	temp++;
        	if ( i-lmap[key]<temp )
        		temp = i-lmap[key];
        	max = max>temp?max:temp;
        	lmap[key]=i;
        }
        return max;
	}
	public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> lmap = new HashMap<Character,Integer>(30);
        int max = 0, temp = 0;
        for ( int i = 0; i < s.length(); i++ ) {
        	char key = s.charAt(i);
        	temp++;
        	if ( lmap.containsKey(key) && i-lmap.get(key)<temp )
        		temp = i-lmap.get(key);
        	max = max>temp?max:temp;
        	lmap.put(key,i);
        }
        return max;
    }
}

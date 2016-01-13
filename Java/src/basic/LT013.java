package basic;

import java.io.*;
import java.util.*;

public class LT013 {
	public static void main  ( String[] args ) 
			throws FileNotFoundException{
		Scanner in = new Scanner(new File("c:/Users/ZSong/Desktop/test.txt"));
		ArrayList<String> strs = new ArrayList<String>();
		while ( in.hasNextLine() )
			strs.add(in.nextLine());
		String ret = longestCommonPrefix(strs.toArray(new String[0]));
		System.out.println(ret);
		in.close();
	}
	public static String longestCommonPrefix(String[] strs) {
		if ( strs.length == 0 ) return "";
        int len = strs[0].length();
        for ( int r = 1; r<strs.length; r++ ) {
        	len = Math.min(len, strs[r].length());
        	for ( int i = 0; i<len; i++ ) {
        		if ( strs[0].charAt(i) != strs[r].charAt(i) ) {
        			len = i;
        		}
        	}
        }
        return strs[0].substring(0,len);
    }
}

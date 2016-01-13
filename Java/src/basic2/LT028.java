package basic2;

import java.util.Arrays;
import java.util.Scanner;

public class LT028 {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		while ( true ) {
			String str = in.nextLine();
			if ( str.equals("exit") ) break;
			String pattern = in.nextLine();
			System.out.println(strStr(str,pattern));
		}
		in.close();
	}
	public static int strStr(String haystack, String needle) {
        if ( haystack == null || needle == null || haystack.equals("") || needle.equals("") ) return -1;
        int[] lps = stringPrefixCal(needle);
        for ( int i = 0, q=0; i<haystack.length(); i++ ) {
        	while ( q>0 && haystack.charAt(i) != needle.charAt(q) )
        		q = lps[q-1];
        	if ( haystack.charAt(i) == needle.charAt(q) ) {
        		q++;
        		if ( q == needle.length() )
        			return i-needle.length()+1;
        	}
        }
        return -1;
    }
	private static int[] stringPrefixCal ( String str ) {
		int[] lps = new int[str.length()];
		for ( int q = 1, k = 0; q<lps.length; q++ ) {
			while ( k>0 && str.charAt(k) != str.charAt(q) )
				k = lps[k-1];
			if ( str.charAt(k) == str.charAt(q) )
				k++;
			lps[q] = k;
		}
		System.out.println(Arrays.toString(lps));
		return lps;
	}
}

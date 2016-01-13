package basic;

import java.util.*;

public class LT005 {
	public static void main ( String[] args ) {
		String input = "abcabacada";
		Scanner in = new Scanner(System.in);
		while ( in.hasNext() ) {
			input = in.next();
			if ( input.equals("Q") )
				break;
			System.out.println(longestPalindrome(input));
		}
		in.close();
	}
	/**
	 * A simple O(N) solution.
	 * Manacher Algorithm
	 * First : String Processing - Insert interval symbols into the original string
	 * 			   				   Add Heading and Tailing symbols to avoid boundary test
	 * Second: Calculate the longest palindrome length centered at each character (including interval symbols)
	 * 		   Maintain two varible : id & mx ( mx = id+ret[id] )
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		// string processing ( add intervals and head/tail symbol )
        int[] str = new int[s.length()*2+3];
        str[0] = -10; str[1] = -1 ; str[str.length-1]=-20;
        for ( int i = 2, j = 0; j < s.length(); j++ ) {
        	str[i++] = s.charAt(j);
        	str[i++] = -1;
        }
        // calculate the ret[] where 2*ret[i]-1 is the longest palindromic substring centered at i 
        int[] ret = new int[str.length];
        int id = 0, mx = 0;
        int max = 0, maxid = 0;
        for ( int i = 1; i < str.length-1; i++ ) {
        	int j = 2*id-i;
        	if ( i < mx && ret[j] < mx -i )
        		ret[i] = ret[j];
        	else {
        		int c = i<mx?mx-i:1;
        		while ( str[i-c] == str[i+c] )
        			c++;
        		ret[i] = c;
        		id = i;
        		mx = id+c;
        		if ( c >= max ) {
        			max = c;
        			maxid = i;
        		}
        	}
        }
        //translate the results
        return s.substring((maxid-max)/2,(maxid+max)/2-1);
    }
}

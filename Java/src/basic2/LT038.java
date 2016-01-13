package basic2;

import java.util.*;

public class LT038 {
	public static void main ( String[] args ) {
		LT038 dummy = new LT038();
		Scanner in = new Scanner(System.in);
		while ( in.hasNextInt() ) {
			System.out.println(dummy.countAndSay(in.nextInt()));
		}
		in.close();
	}
	public String countAndSay(int n) {
		if ( n == 0 ) return "0";
		if ( n == 1 ) return "1";
        String prev = countAndSay(n-1);
        StringBuilder str = new StringBuilder();
        int ch = 0, count = 0;
        for ( int i = 0 ; i < prev.length(); i++ ) {
        	if ( ch == 0 ) {
        		ch = prev.charAt(i);
        	} else if ( ch != prev.charAt(i) ) {
        		str.append(count+""+(char)ch);
        		count = 0;
        		ch = prev.charAt(i);
        	}
        	count++;
        }
        str.append(count+""+(char)ch);
        return str.toString();
    }
}

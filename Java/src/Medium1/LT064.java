package Medium1;

import java.util.*;

public class LT064 {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		while ( in.hasNextLine() ) {
			String str = in.nextLine();
			if ( str.equals("exit") ) break;
			System.out.println(isNumber(str));
		}
		in.close();
	}
	public static boolean isNumber(String s) {
		if ( s==null || (s=s.trim()).length()==0 ) return false;
        boolean sign = false;
        int dot = -1;
        int e = -1;
        boolean number = false;
        for ( int i = 0; i < s.length(); i++ ) {
        	int ch = s.charAt(i);
        	if ( ch<'0' || ch>'9' ) {
	        	if ( ch == '+' || ch == '-' ) {
	        		if ( i != e+1 || sign ) return false;
	        		sign = true;
	        	} else if ( ch == '.' ) {
	        		if ( dot!=-1||e!=-1) return false;
	        		dot = i;
	        	} else if ( ch == 'e' ) {
	        		if (!number||e!=-1||i==0||(sign&&i==1)) return false;
	        		e = i;
	        		number = false;
	        		sign = false;
	        	} else
	        		return false;
        	} else {
        	    number = true;
        	}
        }
        return number;
    }
}

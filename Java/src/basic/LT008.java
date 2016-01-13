package basic;

import java.util.Scanner;

public class LT008 {
	public static void main (String[] args ) {
		Scanner in = new Scanner(System.in);
		String input;
		while ( in.hasNextLine() ) {
			input = in.nextLine();
			System.out.println(myAtoi(input));
		}
		in.close();
	}
	public static int myAtoi(String str) {
		if ( str == null  )	return 0;
		str = str.trim();
		if ( str.equals("") ) return 0;
		int sign = 1;
		int ret = 0;
		for ( int i = 0; i < str.length(); i++ ) {
			int ch = str.charAt(i);
			if ( ch < '0' || ch > '9' ) {
				if ( i == 0 ) {
					if (ch=='-') sign = -1;
					else if ( ch == '+' ) sign = 1;
					else return 0;
				} else
					return sign*ret;
			} else {
				int x = ch-'0';
				if ( ret > (Integer.MAX_VALUE-x)/10 ) {
					return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
				}
				ret = ret*10+x;
			}
		}
		return sign*ret;
    }
}

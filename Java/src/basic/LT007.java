package basic;

import java.util.*;

public class LT007 {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		int input;
		while ( in.hasNextInt() ) {
			input = in.nextInt();
			System.out.println(""+input+" = "+reverse(input));
		}
		in.close();
	}
	
	public static final int bound = 1000000000;
	public static int reverse(int x) {
		if ( x == Integer.MIN_VALUE ) return 0;
    	if ( x < 0 )
    		return -reverse(-x);
    	int ret = 0;
    	while ( x >= 10 ) {
    		ret = ret*10+x%10;
    		x /= 10;
    	}
    	if ( ret <= (Integer.MAX_VALUE-x)/10 )
    		return ret*10+x;
    	else
    		return 0;
	}
}

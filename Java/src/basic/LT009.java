package basic;

import java.util.Scanner;

public class LT009 {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		int input;
		while ( in.hasNextInt() ) {
			input = in.nextInt();
			System.out.println(""+input+" = "+isPalindrome(input));
		}
		in.close();
	}
	public static final int bound = 1000000000;
	public static boolean isPalindrome(int x) {
        if ( x < 0  ) return false;
        if ( x > bound ) {
        	int hi = bound, lo = 1;
        	while ( hi > lo ) {
        		if ( (x/hi)%10 != (x/lo)%10 )
        			return false;
        		hi/=10;
        		lo*=10;
        	}
        	return true;
        } else {
        	int reverse = 0;
        	int origin = x;
        	while ( x>0 ) {
        		reverse = reverse*10+x%10;
        		x/=10;
        	}
        	return reverse == origin;
        }
    }
	
}

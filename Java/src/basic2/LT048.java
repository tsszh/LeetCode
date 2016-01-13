package basic2;

import java.util.*;

public class LT048 {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		while ( in.hasNextDouble() ) {
			System.out.println(myPow(in.nextDouble(),in.nextInt()));
		}
		in.close();
	}
	public static double myPow(double x, int n) {
		if ( n == 0 ) return 1;
		if ( n == 1 ) return x;
		if ( n < 0 ) {
			return 1/(myPow(x,-(n/2))*myPow(x,-(n-n/2)));
		}
		double res = myPow(x,n/2);
        return (n%2==0)?res*res:res*res*x;
    }
}

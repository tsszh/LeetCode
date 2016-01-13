package basic2;

import java.util.*;

public class LT029 {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		while ( in.hasNextInt() ) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(""+" "+divide(a,b));
		}
		in.close();
	}
	public static int divide(int dividend, int divisor) {
        if ( divisor == 0 || (dividend==Integer.MIN_VALUE && divisor==-1) ) return Integer.MAX_VALUE;
        if ( dividend == divisor ) return 1;
        if ( dividend == 0 || divisor == Integer.MIN_VALUE ) return 0;
        if ( divisor == 1 ) return dividend;
        if ( divisor == -1 ) return -dividend;
        
        int dvd, div;
        div = Math.abs(divisor);
        boolean isNegative;
        if ( dividend < 0 ) {
        	dvd = dividend;
        	isNegative = divisor>0;
        } else {
        	dvd = -dividend;
        	isNegative = divisor<0;
        }
        
        int ans = divideHelper(dvd,div);
        
        if ( isNegative ) return -ans;
        else return ans;
    }
	private static int divideHelper(int dvd, int div) {
		int ans = 0;
        while ( dvd+div < 0 ) {
        	int temp = div, i = 1; 
        	while ( temp < 1073741824 && dvd+(temp<<1) <=0 ) {
        		temp<<=1;
        		i<<=1;
        	}
        	ans += i;
        	dvd += temp;
        }
        if ( dvd+div == 0 ) return ans+1;
        else return ans;
	}
}

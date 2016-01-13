package Medium1;

import java.util.*;

public class LT069 {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		while ( in.hasNextInt() ) {
			int x = in.nextInt();
			long st, et;
			st = System.nanoTime();
			Math.sqrt(x);
			et = System.nanoTime();
			System.out.printf("Math.sqrt    : result = %4d; Time = %10d ns\n",(int)Math.sqrt(x),et-st);
			st = System.nanoTime();
			mySqrt(x);
			et = System.nanoTime();
			System.out.printf("Binary Search: result = %4d; Time = %10d ns\n",mySqrt(x),et-st);
			st = System.nanoTime();
			mySqrt2(x);
			et = System.nanoTime();
			System.out.printf("Newton Method: result = %4d; Time = %10d ns\n",mySqrt(x),et-st);
		}
		in.close();
	}
	// Binary Search
	public static int mySqrt(int x) {
		if ( x <= 0 ) return 0;
		if ( x == 1 ) return 1;
		int start = 1, end=x>>1;
		while ( start <= end ) {
			int mid = (start+end)>>1;
			if ( mid > 46340 || mid*mid > x )
				end = mid-1;
			else
				start = mid+1;
		}
		return end;
    }
	// Newton Method
	public static int mySqrt2(int x) {
		if ( x <= 0 ) return 0;
		double prev=x, res=1;
		while ( prev-res>0.001 || prev-res<-0.001 ) {
			prev = res;
			res = (res+x/res)/2;
		}
		return (int)res;
	}
}

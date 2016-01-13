package Medium1;

import java.util.*;

public class LT089 {
	public static void main ( String[] args ) {
		long st, et, total1=0, total2=0;
		for ( int i = 0; i < 10; i++ ) {
			st = System.nanoTime();
			grayCode(i);
			et = System.nanoTime();
			System.out.printf("grayCode (%2d) %20d ns\n",i,et-st);
			total1+=et-st;
			
			st = System.nanoTime();
			grayCode2(i);
			et = System.nanoTime();
			System.out.printf("grayCode2(%2d) %20d ns\n",i,et-st);
			total2+=et-st;
		}
		System.out.println("Total1 = "+total1);
		System.out.println("Total2 = "+total2);
	}
	public static List<Integer> grayCode(int n) {
		//if ( n == 0 ) return new ArrayList<Integer>();
		int[] res = new int[1<<n];
		for ( int i = 1, mask = 1; i < res.length; mask<<=1 ) {
			for ( int j = i-1; j>=0; j--,i++ ) {
				res[i] = res[j]+mask;
			}
		}
		List<Integer> finalRes = new ArrayList<Integer>(res.length);
		for ( int num : res ) {
			finalRes.add(num);
		}
		return finalRes;
    }
	public static List<Integer> grayCode2(int n) {
		if ( n == 0 ) return new ArrayList<Integer>();
		List<Integer> res = new ArrayList<Integer>(1<<n);
		res.add(0);
		for ( int mask = 1, bound = 1<<n; mask < bound; mask<<=1 ){
			for ( int i = res.size()-1; i>=0; i-- )
				res.add( res.get(i)+mask );
		}
		return res;
	}
}

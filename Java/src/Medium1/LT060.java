package Medium1;

import java.util.Arrays;

public class LT060 {
	public static void main ( String[] args ) {
		int n = 0;
		for ( int k = 0; k < NFACTORIAL[n]; k++ )
			System.out.println(getPermutation(n,k+1));
	}
	
	private static final int[] NFACTORIAL = new int[] {1,1,2,6,24,120,720,5040,40320,362880};
	public static String getPermutation(int n, int k) {
		int[] res = new int[n];
		for ( int i = 0; i < n; i++ )
			res[i] = n-i;
		for ( int i = 0 ; i < n && k!=0 ; i++ ) {
			int result    = k/NFACTORIAL[n-i-1];
			int remainder = k%NFACTORIAL[n-i-1];
			if ( remainder != 0 ) result++;
			int temp = res[n-result];
			for ( int j = n-result; j > i; j-- )
				res[j] = res[j-1];
			res[i] = temp;
			k = remainder;
		}
		return Arrays.toString(res).replace(", ","").substring(1, 1+n);
    }
}

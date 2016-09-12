package Contest;

import java.util.Arrays;

public class P2 {
	public static void main(String[] args) {
		P2 dummy = new P2();
		System.out.println(dummy.integerReplacement2(100000000));
		System.out.println(dummy.integerReplacement2(14));
	}
	public int integerReplacement(int n) {
		int r = 0;
		while (n%2 == 0) {
			r++;
			n /=2;
		}
		if (n == 1) return r;
		int[] res = new int[n+1];
		res[1] = 0;
		for (int i = 2; i < n + 1; i++) {
			if (i%2 == 0) {
				res[i] = res[i/2] + 1;
			} else {
				res[i] = Math.min(res[i-1], res[(i+1)/2] + 1) + 1;
			}
		}
		return r + res[n];
    }
	public int integerReplacement2(int n) {
		return integerReplacementHelper(n);
    }
	private int integerReplacementHelper(int n) {
		int r = 0;
		while (n%2 == 0) {
			r++;
			n /= 2;
		}
		if (n == 1) return r;
		return r + 1 + Math.min(integerReplacementHelper(n - 1), integerReplacementHelper(n + 1));
 	}
}

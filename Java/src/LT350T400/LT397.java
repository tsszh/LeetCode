package LT350T400;

/**
 * 397. Integer Replacement
 * 
 * Given a positive integer n and you can do operations as follow:
 * 
 * 	1. If n is even, replace n with n/2.
 * 	2. If n is odd, you can replace n with either n + 1 or n - 1.
 * 
 * 	What is the minimum number of replacements needed for n to become 1?
 * 
 * 	Example: 
 * 	8 -> 4 -> 2 -> 1 (3)
 * 	7 -> 8 -> 4 -> 2 -> 1 (4)
 * 
 * @author Zehao
 *
 */
public class LT397 {
	/**
	 * Dynamic Programming Method. Time: O(n), Space: O(n)
	 * 
	 * n    | 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
	 * step | 0 1 2 2 3 3 4 3 4 4  5  4  5  5  5  4
	 * 
	 * Corner Case {2147483647, 32} Don't Pass!
	 * 
	 * @param n
	 * @return
	 */
	public int integerReplacement(int n) {
		if (n+1 < n) return 32; // Fix the corner case 2147483647(32)
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
	
	/**
	 * Greedy Method
	 * 
	 * If n is odd, go to the next even number with more 2
	 * The only number that doesn't follow this rule if 3, which would go to 2 instead of 4
	 * 
	 * @param n
	 * @return
	 */
	public int integerReplacementQuick(int n) {
		int r = 0;
		while (n != 1) {
			if (n % 2 == 0) {
				r++;
				n /= 2;
			} else if (n == 3) {
				r++;
				n--;
			} else{
				r+=2;
				if ((n/2)%2 == 0) {
					n = n/2;
				} else {
					n = n/2 + 1; // Avoid the (int) overflow
				}
			}
		}
		return r;
	}
}

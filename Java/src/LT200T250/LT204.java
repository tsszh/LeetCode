package LT200T250;

import java.util.BitSet;

/**
 * 204. Count Primes
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Tag: Hash Table
 * Similar Problems: 263. Ugly Number
 * 					 264. Ugly Number II
 * 					 279. Perfect Squares
 * 
 * @author Zehao
 *
 */
public class LT204 {
	/**
	 * Sieve Method
	 * Time: O(n*lglgn) Space: O(n)
	 * 
	 * @param n
	 * @return
	 */
	public int countPrimes(int n) {
		if (n <= 1) return 0;
		BitSet prime = new BitSet(n);
		prime.flip(2, n);
		for (int i = 2; i*i < n; i++) {
			if (!prime.get(i)) continue;
			for (int j = i*i; j < n; j+=i) {
				prime.set(j, false);
			}
		}
		return prime.cardinality();
	}
}

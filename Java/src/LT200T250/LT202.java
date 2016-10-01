package LT200T250;

import java.util.*;

/**
 * 202. Happy Number
 * 
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 12 + 92 = 82 
 * 82 + 22 = 68 
 * 62 + 82 = 100 
 * 12 + 02 + 02 = 1
 * 
 * Tags: Hash
 * 
 * Similar Problems: 258. Add Digits
 * 					 263. Ugly Number
 * 
 * @author Zehao
 *
 */
public class LT202 {
	/**
	 * HashSet Solution Space: O(n)
	 * 
	 * @param n
	 * @return
	 */
	public boolean isHappy(int n) {
		if (n <= 0)
			return false;
		Set<Integer> set = new HashSet<>();
		while (n != 1 && !set.contains(n)) {
			set.add(n);
			int tmp = 0;
			while (n != 0) {
				tmp += (n % 10) * (n % 10);
				n /= 10;
			}
			n = tmp;
		}
		return n == 1;
	}

	/**
	 * Floyd Cycle Space: O(1)
	 * 
	 * @param n
	 * @return
	 */
	public boolean isHappy2(int n) {
		if (n <= 0)
			return false;
		int slow = squareSum(n);
		int fast = squareSum(slow);
		while (slow != fast) {
			slow = squareSum(slow);
			fast = squareSum(squareSum(fast));
		}
		if (slow == 1)
			return true;
		return false;
	}

	private int squareSum(int n) {
		int tmp = 0;
		while (n != 0) {
			tmp += (n % 10) * (n % 10);
			n /= 10;
		}
		return tmp;
	}
}

package LT150T200;

/**
 * 191. Number of 1 Bits
 * 
 * Write a function that takes an unsigned integer and returns the number of ��1'
 * bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ��11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 * 
 * Similar Problems: 190. Reverse Bits
 * 					 231. Power of Two
 * 					 338. Counting Bits
 * 					 401. Binary Watch
 * 
 * @author Zehao
 *
 */
public class LT191 {
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			n &= n - 1;
			count++;
		}
		return count;
	}
}
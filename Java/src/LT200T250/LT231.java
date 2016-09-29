package LT200T250;

/**
 * 231. Power of Two
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Similar Problems: 191. Number of 1 Bits
 * 					 326. Power of Three
 * 					 342. Power of Four
 * 
 * @author Zehao
 *
 */
public class LT231 {
	public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n&(n-1)) == 0;
    }
}

package LT000T050;

/**
 * 7. Reverse Integer
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Return 0 if the result overflow.
 * 
 * Similar Problems: 8. String to Integer (atoi)
 *                   190. Reverse Bits
 * 
 * @author Zehao
 *
 */
public class LT7 {
	public int reverse(int x) {
		long res = reverse((long)x);
		if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
		return (int)res;
    }
	private long reverse(long x) {
		if (x < 0) return -reverse(-x);
		long res = 0;
		while (x > 0) {
			res = res*10 + x%10;
			x /= 10;
		}
		return res;
	}
}

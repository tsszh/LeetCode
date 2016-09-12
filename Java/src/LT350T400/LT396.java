package LT350T400;

/**
 * 396. Rotate Function
 * 
 * Given an array of integers A and let n to be its length.
 * 
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 * 
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * 
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * 
 * Examples:
 * 
 * A = [4, 3, 2, 6]
 * 
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * 
 * 
 * @author Zehao
 *
 */

public class LT396 {
	/**
	 * 
	 * Sum(A) = 4 + 3 + 2 + 6 = 15
	 * F(0) = 25
	 * F(1) = F(0) + Sum(A) - 4 * 6
	 * F(2) = F(1) + Sum(A) - 4 * 2
	 * F(3) = F(2) + Sum(A) - 4 * 3
	 * 
	 * @param A
	 * @return
	 */
	public int maxRotateFunction(int[] A) {
		// Calculate the sum of an array
		int sum = 0;
		int fk = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			fk += i * A[i];
		}
		// Calculate the maximum value of F(k)
		int res = fk;
		for (int k = 1; k < A.length; k++) {
			fk = fk + sum - A.length * A[A.length - k];
			if (fk > res) res = fk;
		}
		return res;
    }
}

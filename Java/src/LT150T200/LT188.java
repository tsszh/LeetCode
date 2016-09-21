package LT150T200;

/**
 * 188. Best Time to Buy and Sell Stock IV
 * 
 * QuestionEditorial Solution My
 * Submissions Total Accepted: 33092 Total Submissions: 142075 Difficulty: Hard
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * Similar Problems: 121. Best Time to Buy and Sell Stock 
 * 					 122. Best Time to Buy and Sell Stock II
 * 					 123. Best Time to Buy and Sell Stock II
 * 
 * @author Zehao
 *
 */
public class LT188 {
	/**
	 * Dynamic Programing
	 * Time: O(kN) Space: O(kN)
	 * 
	 * res[r][c] Max profit with at most r transactions at day c
	 * 
	 * res[r][c] = max{ res[r][c-1], max{ res[r-1][i-1] + prices[c] - prices[i]  } }
	 * 
	 * @param k
	 * @param prices
	 * @return
	 */
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length < 1 || k < 1)
			return 0;
		int n = prices.length;

		// Quick Solve O(n)
		int unlimitedMax = 0, unlimitedUpNum = 0;
		for (int i = 1, lastMin = prices[0]; i < n; i++) {
			if (prices[i] < prices[i - 1]) {
				if (prices[i - 1] > lastMin) {
					unlimitedUpNum++;
					unlimitedMax += prices[i - 1] - lastMin;
				}
				lastMin = prices[i];
			} else if (i == n - 1 && prices[i] > lastMin) {
				unlimitedUpNum++;
				unlimitedMax += prices[i] - lastMin;
			}
		}
		if (unlimitedUpNum <= k)
			return unlimitedMax;

		// DP O(kN)
		int[][] res = new int[k][n];
		// Initialize the first row
		res[0][0] = 0;
		for (int i = 1, lastMin = prices[0]; i < n; i++) {
			res[0][i] = Math.max(res[0][i - 1], prices[i] - lastMin);
			lastMin = Math.min(lastMin, prices[i]);
		}
		// Iterate over the remaining rows
		for (int r = 1; r < k; r++) {
			res[r][0] = 0;
			int tmp = -prices[0];
			for (int c = 1; c < n; c++) {
				res[r][c] = Math.max(res[r][c - 1], prices[c] + tmp);
				tmp = Math.max(tmp, res[r - 1][c - 1] - prices[c]);
			}
		}
		return res[k - 1][n - 1];
	}
}

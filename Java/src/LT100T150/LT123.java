package LT100T150;

/**
 * 123. Best Time to Buy and Sell Stock III
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * Similar Problems: 121. Best Time to Buy and Sell Stock
 * 					 122. Best Time to Buy and Sell Stock II
 * 					 188. Best Time to Buy and Sell Stock IV
 * 					 309. Best Time to Buy and Sell Stock with Cooldown
 * 
 * @author Zehao
 *
 */
public class LT123 {
	/**
	 * Dynamic Programming
	 * Time: O(n) Space: O(n)
	 * 
	 * prices   | 7 1 5 3 6 4
	 * leftMax  | 0 0 4 4 5 5
	 * rightMax | 5 5 3 3 0 0
	 * Sum      | 5 5 7 7 5 5
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) return 0;
		int[] leftMax = new int[prices.length];
		leftMax[0] = 0;
		int lastMin = prices[0];
		for (int i = 1; i < prices.length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], prices[i] - lastMin);
			lastMin = Math.min(lastMin, prices[i]);
		}

		int[] rightMax = new int[prices.length];
		rightMax[prices.length - 1] = 0;
		int lastMax = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i], lastMax - prices[i]);
			lastMax = Math.max(lastMax, prices[i]);
		}

		int res = 0;
		for (int i = 0; i < prices.length; i++) {
			res = Math.max(res, leftMax[i] + rightMax[i]);
		}
		return res;
	}
}

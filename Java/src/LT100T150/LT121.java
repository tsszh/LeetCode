package LT100T150;

/**
 * 121. Best Time to Buy and Sell Stock
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Example:
 * [7, 1, 5, 3, 6, 4] => 6 - 1 = 5
 * [7, 6, 4, 3, 1] => 0
 * 
 * Similar Problems: 53. Maximum Subarray
 * 					 122. Best Time to Buy and Sell Stock II
 * 					 123. Best Time to Buy and Sell Stock III
 * 					 188. Best Time to Buy and Sell Stock IV
 * 					 309. Best Time to Buy and Sell Stock with Cooldown
 * @author Zehao
 *
 */
public class LT121 {
	public int maxProfit(int[] prices) {
		int res = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			res = Math.max(res, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return res;
	}
}

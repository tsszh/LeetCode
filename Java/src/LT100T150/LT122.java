package LT100T150;

/**
 * 122. Best Time to Buy and Sell Stock II
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 * Similar Problems: 121. Best Time to Buy and Sell Stock
 * 					 123. Best Time to Buy and Sell Stock III
 * 					 188. Best Time to Buy and Sell Stock IV
 * 					 309. Best Time to Buy and Sell Stock with Cooldown
 * 
 * @author Zehao
 *
 */
public class LT122 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int res = 0;
		int lastMin = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[i - 1]) {
				res += Math.max(prices[i - 1] - lastMin, 0);
				lastMin = prices[i];
			}
			if (i == prices.length - 1) {
				res += Math.max(prices[i] - lastMin, 0);
			}
		}
		return res;
	}
}

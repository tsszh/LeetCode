package LT300T350;

public class LT309 {
	/**
	 * DP Solution
	 * 
	 * 		  Best   Worst        
	 * Time : O(N)   O(N^2) 
	 * Space: O(1)   O(N)
	 * 
	 * res[r][c] Max profit with at most r transactions at day c
	 * 
	 * res[r][c] = max{ res[r][c-1], max{ res[r-1][i-2]||0 + prices[c] - prices[i]  } }
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 1)
			return 0;
		int n = prices.length;

		// Quick Solve O(n)
		int unlimitedMax = 0, unlimitedUpNum = 0;
		boolean coldDown = false;
		for (int i = 1, lastMin = prices[0], lastMaxIndex = -2, lastMinIndex = 0; i < n; i++) {
			if (prices[i] < prices[i - 1]) {
				if (prices[i - 1] > lastMin) {
					unlimitedUpNum++;
					unlimitedMax += prices[i - 1] - lastMin;
					if (lastMinIndex - lastMaxIndex == 1) coldDown = true;
					lastMaxIndex = i - 1;
				} 
				lastMin = prices[i];
				lastMinIndex = i;
			} else if (i == n - 1 && prices[i] > lastMin) {
				unlimitedUpNum++;
				unlimitedMax += prices[i] - lastMin;
				if (lastMinIndex - lastMaxIndex == 1) coldDown = true;
			}
		}
		int k = unlimitedUpNum;
		if (k < 2 || !coldDown) return unlimitedMax;
		
		// DP O(kN)
		int[] res = new int[n];
		int[] lastRes = new int[n];
		// Initialize the first row
		res[0] = 0;
		for (int i = 1, lastMin = prices[0]; i < n; i++) {
			res[i] = Math.max(res[i - 1], prices[i] - lastMin);
			lastMin = Math.min(lastMin, prices[i]);
		}
		// Iterate over the remaining rows
		for (int r = 1; r < k; r++) {
			int[] tmpArray = lastRes;
			lastRes = res;
			res = tmpArray;
			res[0] = 0;
			int tmp = -prices[0];
			for (int c = 1; c < n; c++) {
				res[c] = Math.max(res[c - 1], prices[c] + tmp);
				if (c >= 2) {
					tmp = Math.max(tmp, lastRes[c - 2] - prices[c]);
				} else {
					tmp = Math.max(tmp, - prices[c]);
				}
				
			}
		}
		return res[n - 1];
	}
}

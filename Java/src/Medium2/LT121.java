package Medium2;

public class LT121 {
	public static void main ( String[] args ) {
		int[] prices = new int[] {
			1,4,2,6,3,9,4,10
		};
		System.out.println(maxProfit2(prices));
	}
	public static int maxProfit2(int[] prices) {
        int[] record = new int[prices.length];  // record[i]=maxProfit(0~i)+maxProfit(i~end)
        int buyIn = Integer.MAX_VALUE;
        int leftMax = 0;
        for ( int i = 0; i < prices.length; i++ ) {
        	int price = prices[i];
        	if ( price < buyIn ) buyIn = price;
        	leftMax = record[i] = Math.max(leftMax,price-buyIn);
        }
        int sellOut = Integer.MIN_VALUE;
        int rightMax = 0;
        int res = 0;
        for ( int i = prices.length-1; i >= 0; i-- ) {
        	int price = prices[i];
        	if ( price > sellOut ) sellOut = price;
        	rightMax = Math.max(rightMax, sellOut-price);
        	res = Math.max(res, record[i]+rightMax);
        }
        return res;
    }
	public static int maxProfit(int[] prices) {
        int sum = 0;
        for ( int i = 1; i < prices.length; i++ ) {
        	int temp = prices[i]-prices[i-1];
        	if (  temp > 0 )
        		sum+=temp;
        }
        return sum;
    }
}

package basic2;

import java.util.*;

public class LT032 {
	public static void main ( String[] args ) {
		LT032 dummy = new LT032();
		Scanner in = new Scanner(System.in);
		while ( in.hasNextLine() ) {
			String s = in.nextLine();
			if ( s.equals("exit") ) break;
			int len; long st, et;
			st = System.nanoTime();
			len = dummy.longestValidParentheses(s);
			et = System.nanoTime();
			System.out.println("1 = "+len+" takes "+(et-st)+"ns");
			st = System.nanoTime();
			len = dummy.longestValidParentheses2(s);
			et = System.nanoTime();
			System.out.println("2 = "+len+" takes "+(et-st)+"ns");
		}
		in.close();
	}
	/**
	 * Dynamic Programming :
	 * dp[i] record the length of longest valid parentheses ended in i;
	 * dp[i] = dp[i-dp[i-1]-2]+dp[i-1]+2   <= s[i]==')' && s[i-dp[i-1]-1]=='('
	 *       = 0                           <= 
	 * @param s
	 * @return
	 */
	public int longestValidParentheses2(String s) {
		if ( s == null || s.length() < 2 ) return 0;
		int[] dp = new int[s.length()];
		int max = 0;
		for ( int i=1; i<s.length(); i++ ) {
			if ( s.charAt(i) == ')' ) {
				int j = i-dp[i-1]-1;
				if ( j>=0 && s.charAt(j) == '(' ) {
					if ( j>=1 )
						dp[i] = dp[j-1]+dp[i-1]+2;
					else
						dp[i] = dp[i-1]+2;
				}
				
				if ( dp[i] > max )
					max = dp[i];
			}
		}
		return max;
	}
	/**
	 * '(' = 1 '(' = -1 sum[i] equals the sum of s[0] to s[i]
	 * table[i] records the index of last '(' with sum == i;   
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		if ( s == null || s.length() < 2 ) return 0;
		int[] table = new int[s.length()+1];
		Arrays.fill(table, -2);
		table[0]=-1;
 		int max = 0;
		for ( int sum=0, i=0; i<s.length(); i++  ) {
			if ( s.charAt(i) == '(' ) {
				sum++;
				table[sum] = i;
			}
			else {
				sum--;
				if ( sum < 0 ) {
					while ( i<s.length()-1 && s.charAt(i+1) != '(' ) i++;
					sum = 0;
					Arrays.fill(table, -2);
					table[0] = i;
				} else {
					if ( table[sum] > -2 )
						max = Math.max(max,i-table[sum]);
				}
			}
		}
		return max;
    }
}

package basic2;

import java.util.*;

public class LT022 {
	public static void main ( String[] agrs ) {
		Scanner in = new Scanner(System.in);
		while ( in.hasNextInt() ) {
			System.out.println(generateParenthesis(in.nextInt()));
		}
		in.close();
	}
	public static List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<String>();
		if ( n == 0 ) return ret;
		char[] ans = new char[2*n];
		ans[ans.length-1]=')';
		generateParenthesisHelper(n,0,0,ans,ret);
		return ret;
	}
	private static void generateParenthesisHelper( int n, int count, int d, char[] ans, List<String> ret ) {
		if ( d == ans.length-1 ) {
			ret.add(new String(ans));
			return;
		}
		if ( n > 0 ) {
			ans[d] = '(';
			generateParenthesisHelper(n-1,count+1,d+1,ans,ret);
		}
		if ( count>0 ) {
			ans[d] = ')';
			generateParenthesisHelper(n,count-1,d+1,ans,ret);
		}
	}
}

package Medium2;

import java.util.*;

public class LT118 {
	public static void main ( String[] args ) {
		System.out.println(generate(10));
		System.out.println(getRow(3));
	}
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>(numRows);
		int[] ans = new int[numRows];
		for ( int i = 0; i < numRows; i++ ) {
			ans[i] = 1;
			for ( int j = i-1; j > 0; j-- ) {
				ans[j] += ans[j-1];
			}
			List<Integer> resItem = new ArrayList<Integer>(i+1);
			for ( int j = 0; j <= i; j++ )
				resItem.add(ans[j]);
			res.add(resItem);
		}
		return res;
    }
	public static List<Integer> getRow(int rowIndex) {
		int[] ans = new int[++rowIndex];
		for ( int i = 0; i < rowIndex; i++ ) {
			ans[i] = 1;
			for ( int j = i-1; j > 0; j-- ) {
				ans[j] += ans[j-1];
			}
		}
		List<Integer> resItem = new ArrayList<Integer>(rowIndex);
		for ( int j = 0; j < rowIndex; j++ )
			resItem.add(ans[j]);
		return resItem;
    }
}

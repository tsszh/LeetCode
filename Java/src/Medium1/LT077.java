package Medium1;

import java.util.*;

public class LT077 {
	public static void main ( String[] args ) {
		LT077 dummy = new LT077();
		List<List<Integer>> res = dummy.combine(4, 3);
		for ( List<Integer> item : res )
			System.out.println(item);
	}
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if ( k  < 1 || n < k ) return res;
		int[] ans = new int[k];
		combineHelper(n,k,1,ans,res);
		return res;
    }
	private void combineHelper(int n, int count, int s, int[] ans, List<List<Integer>> res ) {
		if ( count == 0 ) {
			List<Integer> item = new ArrayList<Integer>(ans.length);
			for ( int i = ans.length -1; i >= 0; i-- )
				item.add(ans[i]);
			res.add(item);
			return;
		}
		int end = n-count+1;
		while ( s <= end ) {
			ans[count-1] = s++;
			combineHelper(n,count-1,s,ans,res);
		}
	}
}

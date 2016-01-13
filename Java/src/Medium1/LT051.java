package Medium1;

import java.util.*;

public class LT051 {
	public static void main ( String[] args ) {
		LT051 dummy = new LT051();
		int n = 5;
		List<List<String>> res = dummy.solveNQueens(n);
		for ( List<String> ans : res ) {
			for ( String line : ans )
				System.out.println(line);
			System.out.println();
		}
		Set<List<String>> resSet = new HashSet<List<String>>(res);
		System.out.println(""+resSet.size()+" "+res.size());
		System.out.println(""+dummy.totalNQueens(n));
	}
	public int totalNQueens(int n) {
		if ( n == 0 ) return 0;
		BitSet check = new BitSet(5*n);
        // 0  ~ n-1    : column   check  = c
        // n  ~ 3n-2   : digonal1 check  = r+c +n
        // 3n+1 ~ 5n-1 : digonal2 check  = r-c+n +3n
        return totalNQueensHelper(n,0,check); // O(n!) Time
    }
	private int totalNQueensHelper( int n, int line, BitSet check ) {
		if ( line == n ) return 1;
		int count = 0;
		for ( int c=0; c < n; c++ ) {
			if ( check.get(c) || check.get(line+c+n) || check.get(line-c+(n<<2)) ) continue;
			check.set(c);
			check.set(line+c+n);
			check.set(line-c+(n<<2));
			count += totalNQueensHelper(n,line+1,check);
			check.set(c,false);
			check.set(line+c+n,false);
			check.set(line-c+(n<<2),false);
		}
		return count;
	}
	
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<List<String>>();
        if ( n == 0 ) return res;
        StringBuilder strBuffer = new StringBuilder();
        for ( int i = 1; i < n; i++ ) strBuffer.append('.');
        strBuffer.append('Q');
        for ( int i = 1; i < n; i++ ) strBuffer.append('.');
        String[] strSet = new String[n];
        for ( int i = 0; i < n; i++ ) {
        	strSet[i] = strBuffer.substring(n-1-i, n+n-1-i);
        }
        int[] ansCol = new int[n];
        BitSet check = new BitSet(5*n);
        // 0  ~ n-1    : column   check  = c
        // n  ~ 3n-2   : digonal1 check  = r+c +n
        // 3n+1 ~ 5n-1 : digonal2 check  = r-c+n +3n
        solveNQueensHelper(n,0,check,ansCol,strSet,res);
        return res;
    }
	
	private void solveNQueensHelper
		( int n, int line, BitSet check, int[] ansCol, String[] strSet, List<List<String>> res ) {
		if ( line == n ) {
			List<String> resItem = new ArrayList<String>(n);
			for ( int i = 0; i < n; i++ ) {
				resItem.add(strSet[ansCol[i]]);
			}
			res.add(resItem);
			return;
		}	
		for ( int c=0; c < n; c++ ) {
			if ( check.get(c) || check.get(line+c+n) || check.get(line-c+(n<<2)) ) continue;
			check.set(c);
			check.set(line+c+n);
			check.set(line-c+(n<<2));
			ansCol[line] = c;
			solveNQueensHelper(n,line+1,check,ansCol,strSet,res);
			check.set(c,false);
			check.set(line+c+n,false);
			check.set(line-c+(n<<2),false);
		}
	}
}

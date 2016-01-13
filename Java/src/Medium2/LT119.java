package Medium2;

import java.util.*;

public class LT119 {
	public static void main ( String[] args ) {
		String[] prevTriangle = new String[] {
			
		};
		List<List<Integer>> triangle = new LinkedList<List<Integer>>();
		for ( String preLine : prevTriangle ) {
			List<Integer> line = new LinkedList<Integer>();
			for ( int i = 0; i < preLine.length(); i++ ) {
				line.add(preLine.charAt(i)-'0');
			}
			triangle.add(line);
		}
		System.out.println(triangle);
		System.out.println(minimumTotal(triangle));
	}
	public static int minimumTotal(List<List<Integer>> triangle) {
		if ( triangle == null || triangle.size() == 0 ) return 0;
		int len = triangle.get(triangle.size()-1).size();
		int[] dpSum = new int[len+1];
		Arrays.fill(dpSum, Integer.MAX_VALUE);
		dpSum[1] = 0;
		for ( List<Integer> line : triangle ) {
			int i = line.size();
			ListIterator<Integer> it = line.listIterator(line.size());
			while ( it.hasPrevious() ) {
				dpSum[i] = Math.min(dpSum[i-1], dpSum[i])+it.previous();
				i--;
			}
		}
		int min = Integer.MAX_VALUE;
		for ( int val : dpSum ) {
			if ( val < min )
				min = val;
		}
		return min;
    }
}

package Medium1;

import java.util.*;

public class LT085 {
	public static void main ( String[] args ) {
		String[] preMatrix = new String[] {
			"1001",
			"0000",
			"1011"
		};
		char[][] matrix = new char[preMatrix.length][preMatrix[0].length()];
		for ( int i = 0; i < matrix.length; i++ )
			for ( int j = 0 ; j < matrix[0].length; j++ )
				matrix[i][j] = preMatrix[i].charAt(j);
		System.out.println(maximalRectangle(matrix));
	}
	public static int maximalRectangle(char[][] matrix) {
		if ( matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return 0;
		int[] histogram = new int[matrix[0].length];
		Deque<Integer> stack = new ArrayDeque<Integer>(histogram.length);
		int max = 0;
		for ( int i = 0 ; i < matrix.length; i++ ) {
			for ( int j = 0; j < histogram.length; j++ ) {
				if ( matrix[i][j] == '0' ) histogram[j] = 0;
				else histogram[j]++;
				while ( !stack.isEmpty() && histogram[j] < histogram[stack.peek()] ) {
					int h = histogram[stack.pop()];
					int w = j - (stack.isEmpty()?-1:stack.peek()) -1;
					max = Math.max(max,h*w);
				}
				stack.push(j);
			}
			while ( !stack.isEmpty() ) {
				int h = histogram[stack.pop()];
				int w = histogram.length - (stack.isEmpty()?-1:stack.peek()) -1;
				max = Math.max(max,h*w);
			}
			System.out.println(Arrays.toString(histogram)+max);
		}
		return max;
    }
}

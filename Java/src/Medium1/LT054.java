package Medium1;

import java.util.*;

public class LT054 {
	public static void main ( String[] args ) {
		String[] strMatrix = new String[] {
			"123",
			"234",
			"345",
			"456"
		};
		int[][] matrix = new int[strMatrix.length][strMatrix[0].length()];
		for ( int i = 0; i < matrix.length; i++ ) {
			for ( int j = 0; j < matrix[i].length; j++ )
			matrix[i][j] = (strMatrix[i].charAt(j))-'0'; 
		}
		System.out.println(spiralOrder(matrix));
	}
	public static List<Integer> spiralOrder(int[][] matrix) {
		if ( matrix == null || matrix.length == 0 || matrix[0].length==0 ) return new ArrayList<Integer>();
		int row = matrix.length, col = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>(row*col);
        int i = 0, j = -1;
        while ( row > 0 && col > 0 ) {
        	for ( int c = 0; c < col; c++ )
        		res.add(matrix[i][++j]);
        	row--;
        	for ( int c = 0; c < row; c++ )
        		res.add(matrix[++i][j]);
        	col--;
        	
        	if ( row > 0 && col > 0 ) {
        		for ( int c = 0; c < col; c++ )
            		res.add(matrix[i][--j]);
            	row--;
            	for ( int c = 0; c < row; c++ )
            		res.add(matrix[--i][j]);
            	col--;
        	}
        }
        return res;
    }
}

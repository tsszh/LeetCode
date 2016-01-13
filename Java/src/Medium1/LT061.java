package Medium1;

import java.util.Arrays;

public class LT061 {
	public static void main ( String[] args ) {
		String[] matrix = new String[] {
			"1234",
			"4321"
		};
		int[][] obstacleGrid = new int[matrix.length][matrix[0].length()];
		for ( int i = 0; i < obstacleGrid.length; i++ )
			for ( int j = 0; j < obstacleGrid[0].length; j++ )
				obstacleGrid[i][j] = matrix[i].charAt(j)-'0';
		//System.out.println(uniquePathsWithObstacles(obstacleGrid));
		System.out.println(minPathSum(obstacleGrid));
	}
	public static long uniquePaths(int m, int n) {
        if ( m < 2 || n < 2 ) return 1;
        if ( m == 2 ) return n;
        if ( n == 2 ) return m;
        long[] res = new long[n];
        Arrays.fill(res,1);
        for ( int i = 1; i < m; i++ )
            for ( int j = 1; j < n; j++ )
                res[j] = res[j]+res[j-1];
        return res[n-1];
    }
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if ( obstacleGrid == null || obstacleGrid.length==0 || obstacleGrid[0].length==0 ) return 0;
        int[] res = new int[obstacleGrid[0].length+1];
        res[0]=1;
        for( int i = 1; i < res.length; i++ ) {
            if ( obstacleGrid[0][i-1]==1 || res[i-1]==0)
                res[i] = 0;
            else
                res[i] = 1;
        }
        System.out.println(Arrays.toString(res));
        res[0]=0;
        for ( int i = 1; i < obstacleGrid.length; i++ ) {
            for ( int j = 1; j < res.length; j++ ) {
                if ( obstacleGrid[i][j-1]==1 )
                    res[j]=0;
                else
                    res[j]+=res[j-1];
            }
            System.out.println(Arrays.toString(res));
        }
        return res[res.length-1];
    }
	public static int minPathSum(int[][] grid) {
		if ( grid == null || grid.length == 0 || grid[0].length==0 ) return 0;
		int[] res = new int[grid[0].length+1];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0]=0;
		for ( int r = 0; r < grid.length; r++ ) {
			for ( int c = 0; c < grid[r].length; c++ ) {
				res[c+1] = (res[c+1]>res[c])?res[c]+grid[r][c]:res[c+1]+grid[r][c];
			}
			res[0]=Integer.MAX_VALUE;
			System.out.println(Arrays.toString(res));
		}
		return res[res.length-1];
    }
}

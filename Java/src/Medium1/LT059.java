package Medium1;

public class LT059 {
	public static void main ( String[] args ) {
		int[][] res = generateMatrix(5);
		for ( int r = 0; r < res.length; r++ ) {
			for ( int c = 0; c < res.length; c++ )
				System.out.printf("%3d",res[r][c]);
			System.out.println();
		}
	}
	public static int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int  num = 1;
		for ( int count = n-1, i = 0, j = 0; count >= 0 ; count-=2, i++, j++ ) {
			for ( int c = 0; c < count; c++ )
				res[i][j++]=num++;
			for ( int c = 0; c < count; c++ )
				res[i++][j]=num++;
			for ( int c = 0; c < count; c++ )
				res[i][j--]=num++;
			for ( int c = 0; c < count; c++ )
				res[i--][j]=num++;
			if ( count == 0 )
				res[i][j] = num;
		}
		return res;
    }
}

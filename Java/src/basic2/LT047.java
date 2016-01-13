package basic2;

public class LT047 {
	public static void main ( String[] args ) {
		LT047 dummy = new LT047();
		String[] preMatrix = new String[] {
				"123",
				"-|-",
				"abc"
		};
		int[][] matrix = new int[preMatrix.length][preMatrix[0].length()];
		for ( int r = 0; r < matrix.length; r++ )
			for ( int c = 0; c < matrix[0].length; c++ )
				matrix[r][c] = preMatrix[r].charAt(c);
		matrixShow(matrix);
		dummy.rotate(matrix);
		matrixShow(matrix);
	}
	public void rotate(int[][] matrix) {
        if ( matrix == null || matrix.length == 1 ) return;
        int n = matrix.length;
        for ( int circle = 0, circleLimit = (n-1)/2+1; circle < circleLimit ; circle++ ) {
        	int count = n-2*circle-1;
        	int i = circle, j = circle+count;
        	while (  count > 0 ) {
        		i=circle; j=circle+count-1;
        		int temp = matrix[i][j];
        		for ( int k = 0; k < 3; k++ ) {
        			matrix[i][j] = matrix[n-j-1][i];
        			int jj = j;
        			j = i;
        			i = n-jj-1;
        		}
        		matrix[i][j] = temp;
        		count--;
        	}
        }
        
    }
	private static void matrixShow ( int[][] matrix ) {
		for ( int r = 0; r < matrix.length; r++ ) {
			for ( int c = 0; c < matrix[0].length; c++ ) {
				System.out.print((char)matrix[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

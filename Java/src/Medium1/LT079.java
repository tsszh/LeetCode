package Medium1;

public class LT079 {
	public static void main ( String[] args ) {
		LT079 dummy = new LT079();
		String[] preBoard = new String[] {
				"xyzy",
				"sfcs",
				"adee"
		};
		char[][] board = new char[preBoard.length][];
		for ( int i = 0; i < board.length; i++ )
			board[i] = preBoard[i].toCharArray();
		System.out.println(dummy.exist(board, "ab"));
	}
	public boolean exist(char[][] board, String word) {
		if ( board == null || word == null ) return false;
		if ( word.length()==0 ) return true;
		if ( board.length == 0 || board[0].length == 0 ) return false;
		
		boolean[][] isOccupied = new boolean[board.length][board[0].length];
		for ( int i = 0; i < board.length; i++ ) {
			for ( int j = 0; j < board[i].length; j++ ) {
				if ( existHelper(board,word,0,i,j,isOccupied) )
					return true;
			}
		}
		return false;
    }
	private boolean existHelper(char[][] board, String word, int pos, int i, int j, boolean[][] isOccupied ) {
        //showMatrix(isOccupied);
        if ( isOccupied[i][j] ) return false;
        if ( board[i][j] != word.charAt(pos) ) return false;
        isOccupied[i][j] = true; 
        if ( pos == word.length()-1 ) return true;
        if ( j < board[i].length-1 && existHelper(board,word,pos+1,i,j+1,isOccupied) ) return true;
        if ( i < board.length-1    && existHelper(board,word,pos+1,i+1,j,isOccupied) ) return true;
        if ( j > 0 && existHelper(board,word,pos+1,i,j-1,isOccupied) ) return true;
        if ( i > 0 && existHelper(board,word,pos+1,i-1,j,isOccupied) ) return true;
        isOccupied[i][j] = false;
        return false;
    }
	@SuppressWarnings("unused")
	private void showMatrix ( boolean[][] isOccupied ) {
		for ( int i = 0; i < isOccupied.length; i++ ) {
			for ( int j = 0; j < isOccupied[0].length; j++ ) {
				System.out.print((isOccupied[i][j]?1:0));
			}
			System.out.println();
		}
		System.out.println();
	}
}

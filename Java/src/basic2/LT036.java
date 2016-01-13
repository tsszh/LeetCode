package basic2;

import java.util.*;

public class LT036 {
	public static void main ( String[] args ) {
		LT036 dummy = new LT036();
		char[][] board = new char[limit][];
		board[0] = "5...7...9".toCharArray();
		board[1] = "......1..".toCharArray();
		board[2] = "..9.4..35".toCharArray();
		board[3] = ".84.3...2".toCharArray();
		board[4] = "....62..4".toCharArray();
		board[5] = ".6.49....".toCharArray();
		board[6] = "37..1.6..".toCharArray();
		board[7] = ".2..8..7.".toCharArray();
		board[8] = "..8......".toCharArray();
		boolean ret;
		long st, et;
		st = System.nanoTime();
		ret = dummy.isValidSudoku(board);
		et = System.nanoTime();
		System.out.println(ret+" "+(et-st)+" ns");
		printSudoku(board);
		st = System.currentTimeMillis();
		dummy.solveSudoku(board);
		et = System.currentTimeMillis();
		System.out.println(" "+(et-st)+" ms");
		printSudoku(board);
	}
	/**
	 * Private Pair class is used to record the position of empty cells. 
	 * @author ZSong
	 *
	 */
	private class Pair {
		int r;
		int c;
		Pair( int r, int c ) {
			this.r = r;
			this.c = c;
		}
	}
	public static final int limit = 9; // 9*9 Sudoku Problem
	/**
	 * 
	 * @param board
	 */
	public void solveSudoku(char[][] board) {
		if ( board == null ) return;
		int[] rowCheck = new int[limit];
		int[] colCheck = new int[limit];
		int[] blockCheck = new int[limit];
		List<Pair> emptyCell = new LinkedList<Pair>();
		for ( int r = 0; r < limit; r++ ) {
			for ( int c = 0; c < limit; c++ ) {
				int digit = board[r][c];
				if ( digit >= '1' && digit <= '9' ) {
					digit -= '0';
					if ( !setBit(rowCheck,r,digit) ) return;
					if ( !setBit(colCheck,c,digit) ) return;
					if ( !setBit(blockCheck,r/3*3+c/3,digit) ) return;
				} else {
					emptyCell.add(new Pair(r,c));
				}
			}
		}
		if ( !emptyCell.isEmpty() ) {
			fillSudokuDFS(board,rowCheck,colCheck,blockCheck,emptyCell);	
		}
    }
	@SuppressWarnings("unused")
	private boolean fillSudokuDFS2
	(char[][] board, int[] rowCheck, int[] colCheck, int[] blockCheck, List<Pair> emptyCell) {
		if ( emptyCell.isEmpty() ) return true; // Sudoku coard has been solved;
		Pair cell = emptyCell.get(0);
		emptyCell.remove(0);
		int block = cell.r/3*3+cell.c/3;
		for ( int d = 1; d <= limit; d++ ) {
			if ( !isSet(rowCheck,cell.r,d) && !isSet(colCheck,cell.c,d) 
					&& !isSet(blockCheck,block,d) ) {
				board[cell.r][cell.c] = (char)('0'+d);
				setBit(rowCheck,cell.r,d);
				setBit(colCheck,cell.c,d);
				setBit(blockCheck,block,d);
				if ( !fillSudokuDFS(board,rowCheck,colCheck,blockCheck,emptyCell) ) {
					board[cell.r][cell.c] = '.';
					resetBit(rowCheck,cell.r,d);
					resetBit(colCheck,cell.c,d);
					resetBit(blockCheck,block,d);
				} else
					return true;
			}
		}
		// The Sudoku board can not be solved, reset the board
		emptyCell.add(cell);
		return false;
	}
	/**
	 * Solve the Sudoku board with DFS process.
	 * First, fill all cells that can be directly determined via fillSudokuWithoutGuess method.
	 * Second, choose one empty cell and guess the number from valid number set. 
	 * If the remaining Sudoku board can be successfully solved by recursively calling fillSudokuDFS method, 
	 * the guess is true and return true. Otherwise, choose another number from the valid number set.
	 * If there is no valid number at given position, the given Sudoku cannot be solved.
	 * If the Sudoku board cannot be solved, the board need to be reseted. 
	 *     
	 * @param board
	 * @param rowCheck
	 * @param colCheck
	 * @param blockCheck
	 * @param emptyCell
	 * @return true if the Sudoku board can be solved. False otherwise.
	 */
	private boolean fillSudokuDFS
		(char[][] board, int[] rowCheck, int[] colCheck, int[] blockCheck, List<Pair> emptyCell) {
		List<Pair> tempFilled = fillSudokuWithoutGuess(board,rowCheck,colCheck,blockCheck,emptyCell);
		if ( !emptyCell.isEmpty() ) {
			Pair cell = emptyCell.get(0);
			emptyCell.remove(0);
			int block = cell.r/3*3+cell.c/3;
			for ( int d = 1; d <= limit; d++ ) {
				if ( !isSet(rowCheck,cell.r,d) && !isSet(colCheck,cell.c,d) 
						&& !isSet(blockCheck,block,d) ) {
					board[cell.r][cell.c] = (char)('0'+d);
					setBit(rowCheck,cell.r,d);
					setBit(colCheck,cell.c,d);
					setBit(blockCheck,block,d);
					if ( !fillSudokuDFS(board,rowCheck,colCheck,blockCheck,emptyCell) ) {
						board[cell.r][cell.c] = '.';
						resetBit(rowCheck,cell.r,d);
						resetBit(colCheck,cell.c,d);
						resetBit(blockCheck,block,d);
					} else
						return true;
				}
			}
			// The Sudoku board can not be solved, reset the board
			if ( !tempFilled.isEmpty() ) { // Add all cells removed during fillSudokuWithoutGuess
				Iterator<Pair> it = tempFilled.iterator();
				while ( it.hasNext() ) {
					Pair itcell = it.next();
					int itd = board[itcell.r][itcell.c]-'0';
					board[itcell.r][itcell.c] = '.';
					resetBit(rowCheck,itcell.r,itd);
					resetBit(colCheck,itcell.c,itd);
					resetBit(blockCheck,itcell.r/3*3+itcell.c/3,itd);
					emptyCell.add(itcell);
					it.remove();
				}
			}
			emptyCell.add(cell); // Add the chosen cell for guess
			return false;
		}
		return true;
	}
	/**
	 * FillSudokuWithoutGuess is used to fill all the cells that can be directly determined from the given board.
	 * If only one number is possible at given cell, then there is no need for DFS process.
	 * The filling process is based on the guess of some cells. Thus, the cells filled in this process should be recorded and return to caller method.
	 *  
	 * @param board
	 * @param rowCheck
	 * @param colCheck
	 * @param blockCheck
	 * @param emptyCell
	 * @return
	 */
	private List<Pair> fillSudokuWithoutGuess
	(char[][] board, int[] rowCheck, int[] colCheck, int[] blockCheck, List<Pair> emptyCell) {
		List<Pair> removedCells = new LinkedList<Pair>();
		boolean isDone = false;
		while ( !isDone ) {
			isDone = true;
			Iterator<Pair> it = emptyCell.iterator();
			while ( it.hasNext() ) {
				Pair cell = it.next();
				int digit = -1;
				int block = cell.r/3*3+cell.c/3;
				for ( int d = 1; d <= limit; d++ ) {
					if ( !isSet(rowCheck,cell.r,d) && !isSet(colCheck,cell.c,d) 
							&& !isSet(blockCheck,block,d) ) {
						if ( digit == -1 ) // The first valid number
							digit = d;
						else {             // More than one numbers are valid
							digit = -2;
							break;
						}
					}
				}
				// Only one number is possible, fill the cell and add the cell to return list
				if ( digit > 0 ) {    
					board[cell.r][cell.c] = (char)('0'+digit);
					setBit(rowCheck,cell.r,digit);
					setBit(colCheck,cell.c,digit);
					setBit(blockCheck,block,digit);
					removedCells.add(cell);
					it.remove();
					isDone = false;
				}
			}
		}
		return removedCells;
	}
	
	/**
	 * Utility methods used to determine whether the given number is valid at specific position
	 */
	private static final int[] mask = new int[] {0,1,2,4,8,16,32,64,128,256};
	/**
	 * Set the digit number at given position if possible.
	 * @param check  :  One of rowCheck, colCheck and blockCheck
	 * @param n      :  Row, column or block number
	 * @param digit  :  The number to be set
	 * @return       :  True if the number is set
	 */
	private boolean setBit( int[] check, int n, int digit ) {
		if ( (check[n] & mask[digit]) > 0  ) return false;
		check[n] |= mask[digit];
		return true;
	}
	private void resetBit( int[] check, int n, int digit ) {
		check[n] ^= mask[digit];
	}
	private boolean isSet( int[] check, int n, int digit ) {
		return (check[n] & mask[digit]) > 0 ;
	}
	/**
	 * The method used to determine whether the given Sudoku board is valid.
	 * The valid Sudoku is not guaranteed to be solvable.
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		if ( board == null ) return false;
		int[] rowCheck = new int[limit];
		int[] colCheck = new int[limit];
		int[] blockCheck = new int[limit];
		for ( int r = 0; r < limit; r++ ) {
			for ( int c = 0; c < limit; c++ ) {
				int digit = board[r][c];
				if ( digit >= '1' && digit <= '9' ) {
					digit -= '0';
					if ( !setBit(rowCheck,r,digit) ) return false;
					if ( !setBit(colCheck,c,digit) ) return false;
					if ( !setBit(blockCheck,r/3*3+c/3,digit) ) return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Utility function to print out the Sudoku Matrix.
	 * @param board
	 */
	private static void printSudoku ( char[][] board ) {
		for ( int r = 0; r < limit; r++ ) {
			for ( int c = 0; c < limit; c++ ) {
				System.out.print(board[r][c]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

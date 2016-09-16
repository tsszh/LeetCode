package LT150T200;

/**
 * 174. Dungeon Game
 * 
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * 
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 3 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * 
 *  1 -3  3
 *  0 -2  0
 * -3 -3 -3
 * 
 * Similar Problems: 62. Unique Paths
 * 					 64. Minimum Path Sum
 * 
 * @author Zehao
 *
 */
public class LT174 {
	/**
	 * DP from Bottom-Right
	 * 
	 * res[][] records the minimum HP required at current position.
	 * 
	 * @param dungeon
	 * @return
	 */
	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length==0) return 1;
		int nR = dungeon.length, nC = dungeon[0].length;
		int[][] res = new int[nR][nC];
		// Initialize
		res[nR-1][nC-1] = getMinHP(1, dungeon[nR-1][nC-1]);
		for (int r = nR - 2; r >= 0; r--) {
			res[r][nC-1] = getMinHP(res[r+1][nC-1], dungeon[r][nC-1]);
		}
		for (int c = nC - 2; c >= 0; c--) {
			res[nR-1][c] = getMinHP(res[nR-1][c+1], dungeon[nR-1][c]);
		}
		// Main Loop
		for (int r = nR-2; r >= 0; r--) {
			for (int c = nC-2; c >= 0; c--) {
				int minBottom = getMinHP(res[r+1][c], dungeon[r][c]);
				int minRight = getMinHP(res[r][c+1], dungeon[r][c]);
				res[r][c] = Math.min(minBottom, minRight);
			}
		}
		return res[0][0];
	}
	private int getMinHP(int previous, int current) {
		int res = previous - current;
		if (res <= 0) return 1;
		return res;
	}
	/**
	 * DP From Top-Left Corner
	 * 
	 * Not correct Yet....
	 * 
	 * @param dungeon
	 * @return
	 */
	public int calculateMinimumHP2(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length==0) return 1;
		int nR = dungeon.length, nC = dungeon[0].length;
		int[][] currRes = new int[nR][nC];
		int[][] minRes = new int[nR][nC];
		// Initialize the left-top corner
		minRes[0][0] = dungeon[0][0];
		currRes[0][0] = dungeon[0][0];
		// Initialize the first row
		for (int c = 1; c < nC; c++) {
			currRes[0][c] = currRes[0][c-1] + dungeon[0][c];
			minRes[0][c] = Math.min(currRes[0][c], minRes[0][c-1]);
		}
		// Initialize the first column
		for (int r = 1; r < nR; r++) {
			currRes[r][0] = currRes[r-1][0] + dungeon[r][0];
			minRes[r][0] = Math.min(minRes[r-1][0], currRes[r][0]);
		}
		// Main Loop
		for (int r = 1; r < nR; r++ ) {
			for (int c = 1; c < nC; c++) {
				int topCurr = currRes[r-1][c] + dungeon[r][c],
					topMin = Math.min(topCurr, minRes[r-1][c]),
					leftCurr = currRes[r][c-1] + dungeon[r][c],
					leftMin = Math.min(leftCurr, minRes[r][c-1]);
				if (leftMin > topMin || (leftMin == topMin && leftCurr >= topCurr)) {
					currRes[r][c] = leftCurr;
					minRes[r][c] = leftMin;
				} else {
					currRes[r][c] = topCurr;
					minRes[r][c] = topMin;
				}
			}
		}
		return Math.max(1, 1 - minRes[nR-1][nC-1]);
	}
}

package LT200T250;

import java.util.*;

/**
 * 200. Number of Islands
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * xample 1:
 * 
 * 11110
 * 11010
 * 11000
 * 00000 Answer: 1
 * 
 * Example 2:
 * 
 * 11000
 * 11000
 * 00100
 * 00011 Answer: 3
 * 
 * Tags: BFS, DFS, Union Find
 * 
 * Similar Problems: 130. Surrounded Regions
 * 					 286. Walls and Gates
 * 					 305. Number of Islands II
 * 					 323. Number of Connected Components in an Undirected Graph 
 * 
 * @author Zehao
 *
 */
public class LT200 {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			return 0;
		// Initialization
		int rows = grid.length, cols = grid[0].length;
		Map<Integer, Set<Integer>> map = new HashMap<>(rows);
		for (int r = 0; r < rows; r++) {
			Set<Integer> set = new HashSet<>();
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == '1') {
					set.add(c);
				}
			}
			if (set.size() != 0)
				map.put(r, set);
		}
		int count = 0;
		while (map.size() != 0) {
			for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
				int r = entry.getKey();
				for (int c : entry.getValue()) {
					cosumeIslands(r, c, map);
					count++;
					break;
				}
				break;
			}
		}
		return count;
	}

	private boolean inSet(int r, int c, Map<Integer, Set<Integer>> map) {
		return map.containsKey(r) && map.get(r).contains(c);
	}

	private void cosumeIslands(int r, int c, Map<Integer, Set<Integer>> map) {
		map.get(r).remove(c);
		if (map.get(r).size() == 0)
			map.remove(r);
		if (inSet(r + 1, c, map))
			cosumeIslands(r + 1, c, map);
		if (inSet(r - 1, c, map))
			cosumeIslands(r - 1, c, map);
		if (inSet(r, c + 1, map))
			cosumeIslands(r, c + 1, map);
		if (inSet(r, c - 1, map))
			cosumeIslands(r, c - 1, map);
	}

}

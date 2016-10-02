package LT200T250;

import java.util.*;

/**
 * 207. Course Schedule
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]]
 * 
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]]
 * 
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0, and to take course 0 you should also have finished course
 * 1. So it is impossible.
 * 
 * Tags: DFS, BFS, TpSort, Graph
 * 
 * Similar Problems: 210. Course Schedule II
 * 					 261. Graph Valid Tree
 * 					 310. Minimum Height Trees
 * 
 * @author Zehao
 *
 */
public class LT207 {
	/**
	 * DFS Cyclic Detection
	 * 
	 * Time: O(V+E)
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses < 2)
			return true;
		// Initialize the graph
		int[] mark = new int[numCourses]; // 0 unvisited; 1 tmp; 2 visited;
		List<List<Integer>> edges = new ArrayList<List<Integer>>(numCourses);
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
			;
		}
		for (int[] pair : prerequisites) {
			edges.get(pair[0]).add(pair[1]);
		}
		// DFS
		for (int i = 0; i < numCourses; i++) {
			if (mark[i] != 0)
				continue;
			if (!dfs(i, mark, edges))
				return false;
		}
		return true;
	}

	private boolean dfs(int n, int[] mark, List<List<Integer>> edges) {
		mark[n] = 1; // mark as tmp
		for (int child : edges.get(n)) {
			if (mark[child] == 2)
				continue; // Skip visited node
			if (mark[child] == 1)
				return false; // Cyclic Detection
			if (!dfs(child, mark, edges))
				return false;
		}
		mark[n] = 2; // mark as visited;
		return true;
	}
}

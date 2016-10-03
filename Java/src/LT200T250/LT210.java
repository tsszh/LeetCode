package LT200T250;

import java.util.*;

/**
 * 210. Course Schedule II
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To take
 * course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * 
 * Tags: Topological Sort, BFS
 * 
 * Similar Problems: 207. Course Schedule
 * 					 269. Alien Dictionary
 * 					 310. Minimum Height Trees
 * 					 
 * 
 * @author Zehao
 *
 */
public class LT210 {
	/**
	 * Topological Sort:
	 * Time: O(V+E)
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses < 1)
			return new int[0];
		// Initialize the graph
		int[] incomingEdgeCount = new int[numCourses];
		Queue<Integer> freeNode = new ArrayDeque<>(numCourses);
		List<List<Integer>> edges = new ArrayList<List<Integer>>(numCourses);
		List<Integer> res = new ArrayList<>(numCourses);
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}
		for (int[] pair : prerequisites) {
			edges.get(pair[1]).add(pair[0]);
			incomingEdgeCount[pair[0]]++;
		}
		for (int i = 0; i < numCourses; i++) {
			if (incomingEdgeCount[i] == 0)
				freeNode.add(i);
		}
		// BFS
		while (!freeNode.isEmpty()) {
			int node = freeNode.remove();
			res.add(node);
			for (int childNode : edges.get(node)) {
				incomingEdgeCount[childNode]--;
				if (incomingEdgeCount[childNode] == 0) {
					freeNode.add(childNode);
				}
			}
		}
		if (res.size() != numCourses)
			return new int[0];
		int[] ret = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			ret[i] = res.get(i);
		}
		return ret;
	}
}

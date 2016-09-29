package LT150T200;

import java.util.ArrayList;
import java.util.List;

import utilities.TreeNode;

/**
 * 199. Binary Tree Right Side View
 * 
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:
 * Given the following binary tree,
 * 
 *    1       <--
 *  /   \
 * 2     3    <--
 *  \     \
 *   5     4  <--
 *   
 * You should return [1, 3, 4].
 *  
 * Tags: Tree
 * 
 * Similar Problems: 116. Populating Next Right Pointers in Each Node
 * 
 * @author Zehao
 *
 */
/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class LT199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		rightSideViewHelper(root, 0, res);
		return res;
	}

	private void rightSideViewHelper(TreeNode root, int level, List<Integer> res) {
		if (root == null)
			return;
		if (res.size() <= level) {
			res.add(root.val);
		} else {
			res.set(level, root.val);
		}
		rightSideViewHelper(root.left, level + 1, res);
		rightSideViewHelper(root.right, level + 1, res);
	}
}

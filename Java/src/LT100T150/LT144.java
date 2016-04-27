package LT100T150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utilities.TreeNode;

/**
 * 144. Binary Tree Preorder Traversal
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values. 
 * 
 * For example: 
 * Given binary tree {1,#,2,3},
 *   1
 *    \
 *     2
 *    /
 *   3
 * return [1,2,3]
 * 
 * Similar Problems:  94. Binary Tree Inorder Traversal
 * 		              145. Binary Tree Postorder Traversal 
 * 
 * @author Zehao
 *
 */
public class LT144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		preorderTraversalHelper(root, res);
		return res;
	}

	private void preorderTraversalHelper(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		res.add(root.val);
		preorderTraversalHelper(root.left, res);
		preorderTraversalHelper(root.right, res);
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				res.add(root.val);
				root = root.left;
			} else {
				root = stack.pop().right;
			}
		}
		return res;
	}
}

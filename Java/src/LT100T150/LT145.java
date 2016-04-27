package LT100T150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utilities.TreeNode;

/**
 * 145. Binary Tree Postorder Traversal 
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example:
 * 
 * Given binary tree {1,#,2,3}, return [3,2,1].
 * 
 * Similar Problems: 94. Binary Tree Inorder Traversal
 * 					 144. Binary Tree Preorder Traversal
 * 
 * @author Zehao
 *
 */
public class LT145 {
	/**
	 * Recursive Algorithm
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		postorderTraversalHelper( root, res );
		return res;
	}
	private void postorderTraversalHelper( TreeNode root, List<Integer> res ) {
		if ( root == null ) return;
		postorderTraversalHelper( root.left, res );
		postorderTraversalHelper( root.right, res );
		res.add( root.val );
	}
	
	public List<Integer> postorderTraversal2( TreeNode root ) {
		List<Integer> res = new ArrayList<>();
		if ( root == null ) return res;
		Deque<TreeNode> stack = new ArrayDeque<>();
		
		TreeNode prev = null;
		while ( !stack.isEmpty() || root != null ) {
			if ( root == null ) {
				root = stack.peek();
				prev = null;
			} else if ( root != stack.peek() ) {
				stack.push(root);
				prev = root;
				root = root.left;
			} else {
				if ( root.right != prev ) {
					prev = root;
					root = root.right;
				} else {
					res.add(root.val);
					prev = root;
					stack.pop();
					root = stack.peek();
				}
			}
		}
		
		return res;
	}
}

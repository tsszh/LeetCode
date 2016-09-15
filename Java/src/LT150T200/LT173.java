package LT150T200;

import java.util.ArrayDeque;
import java.util.Deque;

import utilities.TreeNode;

/**
 * 173. Binary Search Tree Iterator
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 
 * @author Zehao
 *
 */
public class LT173 {
	TreeNode curr;
	Deque<TreeNode> stack = new ArrayDeque<>();
	public LT173(TreeNode root) {
        curr = root;
        while (curr != null && curr.left != null) {
        	stack.push(curr);
        	curr = curr.left;
        }
    }

	private TreeNode getNext() {
		if (curr == null) return null;
		if (curr.right != null) {
			stack.push(curr);
			TreeNode tmp = curr.right;
			while (tmp.left != null) {
				stack.push(tmp);
				tmp = tmp.left;
			}
			return tmp;
		} else {
			TreeNode parent = stack.peek();
			if (parent != null) stack.pop();
			TreeNode tmp = curr;
			while (parent != null && tmp == parent.right) {
				tmp = parent;
				parent = stack.peek();
				if (parent != null) stack.pop();
			}
			if (parent == null) return null;
			return parent;
		}
	}
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr != null;
    }

    /** @return the next smallest number */
    public int next() {
    	if (curr == null) return -1;
    	int res = curr.val;
    	curr = getNext();
        return res;
    }
}

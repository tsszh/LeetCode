package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Serialization
 * 
 * The serialization of a binary tree follows a level order traversal, where '#'
 * signifies a path terminator where no node exists below.
 * 
 * Example:
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * 
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 * 
 * @author Zehao
 *
 */
public class TreeFactory {
	public static TreeNode deserialize(String str) {
		List<String> inputs = new ArrayList<>(Arrays.asList(str.substring(1, str.length() - 1).split("[\\{\\},]")));
		if (inputs.isEmpty() || inputs.get(0).equals(""))
			return null;
		TreeNode root = null;
		Iterator<String> it = inputs.iterator();
		root = new TreeNode(Integer.parseInt(it.next()));

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (it.hasNext() && !queue.isEmpty()) {
			TreeNode tnode = queue.remove();
			String val = it.next();
			if (!val.equals("#")) {
				tnode.left = new TreeNode(Integer.parseInt(val));
				queue.add(tnode.left);
			}
			if (!it.hasNext())
				break;
			val = it.next();
			if (!val.equals("#")) {
				tnode.right = new TreeNode(Integer.parseInt(val));
				queue.add(tnode.right);
			}

		}
		return root;
	}

	public static String serialize(TreeNode root) {
		if (root == null)
			return "{}";
		StringBuilder res = new StringBuilder();
		res.append("{");

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		res.append(root.val + ",");
		while (!queue.isEmpty()) {
			root = queue.remove();
			if (root.left != null) {
				res.append(root.left.val + ",");
				queue.add(root.left);
			} else {
				res.append("#,");
			}
			if (root.right != null) {
				res.append(root.right.val + ",");
				queue.add(root.right);
			} else {
				res.append("#,");
			}
		}
		return res.toString().replaceAll(",(#,)*$", "}");
	}

	public static void verticalTreePrint(TreeNode root) {
		if (root == null)
			return;
		verticalTreePrintHelper(root, 1);
	}

	private static void verticalTreePrintHelper(TreeNode root, int indent) {
		if (root == null)
			return;
		verticalTreePrintHelper(root.right, indent + 1);
		String format = "%" + (4 * indent) + "s%d\n";
		System.out.printf(format, "", root.val);
		verticalTreePrintHelper(root.left, indent + 1);
	}
}

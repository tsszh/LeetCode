package utilities;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		return ""+val;
	}
}

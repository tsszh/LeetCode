package Medium1;

import java.util.Arrays;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	public String toString() {
		return ""+val;
	}
	public static TreeNode createFromSortedArray(int[] vals) {
		if ( vals == null || vals.length == 0 ) return null;
		return createFromSortedArrayAssured(vals,0,vals.length-1);
	}
	public static  TreeNode createFromSortedArray(int[] vals, int start, int end) {
		if ( start >= end || start < 0 || vals == null || end > vals.length ) return null;
		return createFromSortedArrayAssured(vals,start,end-1);
	}
	private static TreeNode createFromSortedArrayAssured ( int[] vals, int start, int end ) {
		if ( start > end ) return null;
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(vals[mid]);
		root.left = createFromSortedArrayAssured(vals,start,mid-1);
		root.right = createFromSortedArrayAssured(vals,mid+1,end);
		return root;
	}
	public static String vertPrint (TreeNode root) {
		StringBuilder res = new StringBuilder();
		vertPrintHelper(root,0,res);
		return res.toString();
	}
	private static void vertPrintHelper( TreeNode root, int level, StringBuilder res ) {
		if ( root == null ) return;
		vertPrintHelper(root.right,level+1,res);
		char[] blank = new char[level*3];
		Arrays.fill(blank, ' ');
		res.append(blank);
		res.append(root.val);
		res.append(System.getProperty("line.separator"));
		vertPrintHelper(root.left ,level+1,res);
	}
}

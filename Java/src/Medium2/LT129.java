package Medium2;

public class LT129 {
	public static void main ( String[] args ) {
		LT129 dummy = new LT129();
		int[] preorder = new int[] {
				0
		};
		int[] inorder = new int[] {
				0
		};
		TreeNode root = BSTree.buildTreeFromPreAndIn(preorder, inorder);
		System.out.println(BSTree.vertPrint(root));
		System.out.println(dummy.sumNumbers(root));
	}
	public int sumNumbers(TreeNode root) {
		return sumNumbersHelper(root,0);
    }
	private int sumNumbersHelper(TreeNode root, int sum) {
		if ( root == null ) return 0;
		sum = sum*10+root.val;
		if ( root.left == null && root.right == null ) return sum;
		return sumNumbersHelper(root.left,sum)+sumNumbersHelper(root.right,sum);
	}
}

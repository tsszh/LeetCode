package Medium1;

import java.util.*;

public class LT095 {
	public static void main ( String[] args ) {
		LT095 dummy = new LT095();
		int n = 0;
		for ( int i = 1; i < 20; i++ )
			System.out.println(dummy.numTrees(i));
		List<TreeNode> res = dummy.generateTrees(n);		
		System.out.println("size = "+res.size());
		for ( TreeNode root : res ) {
			System.out.println(TreeNode.vertPrint(root));
			System.out.println("-------------------------------------");
		}
	}
	public int numTrees(int n) { // O(n^2)
		int[] dp = new int[n+1];
		dp[0] = 1;
		for ( int i = 1; i <= n; i++ ) {
			int count = 0;
			for ( int j = 1; j <= i; j++ ) {
				count += dp[j-1]*dp[i-j];
			}
			dp[i] = count;
		}
		return dp[n];
    }
	public List<TreeNode> generateTrees(int n) { // O(2^n)
        if ( n < 0 ) return new LinkedList<TreeNode>();
        List< List<TreeNode> > dp = new ArrayList<List<TreeNode>>(n+1);
        dp.add(new ArrayList<TreeNode>());
        dp.get(0).add(null);
        dp.add(new ArrayList<TreeNode>());
        dp.get(1).add(new TreeNode(1));
        for ( int i = 2; i <= n; i++ ) { // [1~i]
        	List<TreeNode> tempRes = new LinkedList<TreeNode>();
        	for ( int j = 1; j <=i; j++ ) { // [1~j-1]j[j+1,i]
        		List<TreeNode> leftList = dp.get(j-1);
        		List<TreeNode> rightList = copyAndIncrease(dp.get(i-j),j);
        		for ( TreeNode left : leftList )
        			for ( TreeNode right : rightList ) {
        				TreeNode tempRoot = new TreeNode(j);
        				tempRoot.left = left;
        				tempRoot.right = right;
        				tempRes.add(tempRoot);
        			}
        	}
        	dp.add(tempRes);
        }
        return dp.get(n);
    }
	private List<TreeNode> copyAndIncrease( List<TreeNode> origin, int increment ) {
		List<TreeNode> res = new ArrayList<TreeNode>(origin.size());
		for ( TreeNode root : origin ) {
			res.add(copyAndIncrease(root,increment));
		}
		return res;
	}
	private TreeNode copyAndIncrease( TreeNode root, int increment ) {
		if ( root == null ) return null;
		TreeNode newRoot = new TreeNode(root.val+increment);
		newRoot.left = copyAndIncrease(root.left,increment);
		newRoot.right = copyAndIncrease(root.right,increment);
		return newRoot;
	}
}

package Medium2;

import java.util.*;

public class BSTree {
	TreeNode root;
	int size;
	BSTree(){
		root = null;
		size = 0;
	}
	BSTree(int val) {
		root = new TreeNode(val);
		size = 1;
	}
	BSTree(int[] vals, boolean isSorted) {
		if ( !isSorted ) Arrays.sort(vals);
		root = createFromSortedArray(vals);
		size = vals==null?0:vals.length;
	}
	public static void main ( String[] arge ) {
		int[] postorder = new int[] {
				-1,-3,-4,-2,7,6,-9,8,-5
		};
		int[] inorder = new int[] {
				-1,-2,-3,-4,-5,6,7,8,-9
		};
		
		TreeNode root = buildTreeFromInAndPost(inorder,postorder);
		System.out.println(vertPrint(root));
		System.out.println(maxPathSum(root));
	}
	
	public static int maxPathSum(TreeNode root) {
		if ( root == null ) return 0;
		maxPathSumHelper2(root);
		return maxPath;
    }
	private static int maxPath = Integer.MIN_VALUE;
	private static int maxPathSumHelper2( TreeNode root ) { // return maximum branch
		if ( root == null ) return 0;
		int left = maxPathSumHelper2(root.left);
		if ( left < 0 ) left = 0;
		int right = maxPathSumHelper2(root.right);
		if ( right < 0 ) right = 0;
		maxPath = Math.max(maxPath, left+root.val+right);
		System.out.printf("Node %3d : maxPath = %3d maxBranch = %3d\n",root.val,maxPath,root.val + (left>right?left:right));
		return root.val + (left>right?left:right);
	}
	
	public static void flatten(TreeNode root) {
        flattenHelper(root);
        if ( root != null ) root.left = null; 
    }
	private static TreeNode flattenHelper(TreeNode root) {
		if ( root == null ) return null;
		TreeNode left  = flattenHelper(root.left );
		TreeNode right = flattenHelper(root.right);
		root.right = left!=null?left:right;
		root.left = root;
		if ( left != null ) {
			left.left.right = right;
			root.left = left.left;
			left.left = null;
		}
		if ( right != null ) {
			root.left = right.left;
			right.left = null;
		}
		return root;
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if ( root == null ) return res;
        Deque<TreeNode> ans = new LinkedList<TreeNode>();
        TreeNode curr = root;
        while ( !ans.isEmpty() || curr!=null ) {
        	while ( curr != null ) {
        		ans.addLast(curr);
        		sum -= curr.val;
        		curr = curr.left;
        	}
        	curr = ans.getLast();
        	if ( curr.right == null ) {
        		if ( sum == 0 ) {
        			List<Integer> resItem = new ArrayList<Integer>(ans.size());
        			for ( TreeNode node : ans )
        				resItem.add(node.val);
        			res.add(resItem);
        		}
        		while ( !ans.isEmpty() && (ans.getLast().right==null||ans.getLast().right==curr) ) {
        			curr = ans.removeLast();
        			sum += curr.val;
        		}
        		if ( !ans.isEmpty() ) curr = ans.getLast().right;
        		else curr = null;
        	} else {
        		curr = curr.right;
        	}
        }
        return res;
    }
	public static boolean hasPathSum(TreeNode root, int sum) {
		if ( root == null ) return false;
		if ( root.left == null && root.right == null ) return root.val == sum;
		return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
	
	public static TreeNode buildTreeFromInAndPost(int[] inorder, int[] postorder) {
        if ( postorder == null || inorder == null || postorder.length!=inorder.length || postorder.length == 0 ) return null;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>(postorder.length);
        int len = postorder.length;
        TreeNode root = new TreeNode(postorder[len-1]);
        stack.push(root);
        for ( int i = len-2, j = len-1; i >= 0; i-- ) {
        	TreeNode temp = new TreeNode(postorder[i]);
        	TreeNode parent = stack.peek();
        	boolean isLeft = false;
        	while ( !stack.isEmpty() && stack.peek().val == inorder[j] ) {
        		parent = stack.pop();
        		j--;
        		isLeft = true;
        	}
        	if ( isLeft )
        		parent.left  = temp;
        	else
        		parent.right = temp;
        	stack.push(temp);
        }
        return root;
    }
	public static TreeNode buildTreeFromPreAndIn(int[] preorder, int[] inorder) {
        if ( preorder == null || inorder == null || preorder.length!=inorder.length || preorder.length == 0 ) return null;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>(preorder.length);
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for ( int i = 1, j = 0; i < preorder.length; i++ ) {
        	TreeNode temp = new TreeNode(preorder[i]);
        	TreeNode parent = stack.peek();
        	boolean isLeft = true;
        	while ( !stack.isEmpty() && stack.peek().val == inorder[j] ) {
        		parent = stack.pop();
        		j++;
        		isLeft = false;
        	}
        	if ( isLeft )
        		parent.left  = temp;
        	else
        		parent.right = temp;
        	stack.push(temp);
        }
        return root;
    }
	
	public static int minDepth(TreeNode root) {
		if ( root == null ) return 0;
        return minDepthHelper(root,1);
    }
    public static int minDepthHelper(TreeNode root, int depth ) {
        if ( root == null ) return Integer.MAX_VALUE;
        int leftD = minDepthHelper(root.left,depth+1);
        int rightD = minDepthHelper(root.right,depth+1);
        if ( leftD == Integer.MAX_VALUE && rightD == Integer.MAX_VALUE )
            return depth;
        return Math.min(leftD,rightD);
    }
	public static int maxDepth(TreeNode root) {
		if ( root == null ) return 0;
		return 1+Math.max(maxDepth(root.left), maxDepth(root.right) );
    }
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		if ( root == null ) return res;
		Deque<TreeNode> curr = new ArrayDeque<TreeNode>(); // Queue
		TreeNode dummy = new TreeNode(0);
		curr.add(root);
		curr.add(dummy);
		while ( curr.size() > 1 ) {
			List<Integer> resItem = new ArrayList<Integer>(curr.size());
			while ( !curr.isEmpty() ) {
				TreeNode tempNode = curr.remove();
				if ( tempNode == dummy ) break;
				resItem.add(tempNode.val);
				if ( tempNode.left  != null ) curr.add(tempNode.left);
				if ( tempNode.right != null ) curr.add(tempNode.right);
			}
			curr.add(dummy);
			res.addFirst(resItem);
		}
		return res;
    }
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if ( root == null ) return res;
		Deque<TreeNode> curr = new ArrayDeque<TreeNode>();  // Stack
		Deque<TreeNode> next = new ArrayDeque<TreeNode>();
		curr.push(root);
		boolean leftToRight = true;
		while ( !curr.isEmpty() ) {
			List<Integer> resItem = new ArrayList<Integer>(curr.size());
			while ( !curr.isEmpty() ) {
				TreeNode tempNode = curr.pop();
				resItem.add(tempNode.val);
				if ( leftToRight ) {
					if ( tempNode.left  != null ) next.push(tempNode.left);
					if ( tempNode.right != null ) next.push(tempNode.right);
				} else {
					if ( tempNode.right != null ) next.push(tempNode.right);
					if ( tempNode.left  != null ) next.push(tempNode.left);
				}
			}
			res.add(resItem);
			Deque<TreeNode> tempDeque = curr;
			curr = next;
			next = tempDeque;
			leftToRight = !leftToRight;
		}
		return res;
    }
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if ( root == null ) return res;
		Deque<TreeNode> curr = new ArrayDeque<TreeNode>(); // Queue
		curr.add(root);
		Deque<TreeNode> next = new ArrayDeque<TreeNode>();
		while ( !curr.isEmpty() ) {
			List<Integer> resItem = new ArrayList<Integer>(curr.size());
			while ( !curr.isEmpty() ) {
				TreeNode tempNode = curr.remove();
				resItem.add(tempNode.val);
				if ( tempNode.left  != null ) next.add(tempNode.left);
				if ( tempNode.right != null ) next.add(tempNode.right);
			}
			res.add(resItem);
			Deque<TreeNode> tempDeque = curr;
			curr = next;
			next = tempDeque;
		}
		return res;
    }
	
	public static boolean isSymmetric(TreeNode root) {
		return root==null||isSymmetricHelper(root.left,root.right);
    }
	private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if ( left == null ) return right == null;
        if ( right == null ) return false;
        if ( !isSymmetricHelper(left.left,right.right) ) return false;
        if ( left.val != right.val ) return false;
        return isSymmetricHelper(left.right,right.left);
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null ) return q == null;
        if ( q == null ) return false;
        if ( !isSameTree(p.left,q.left) ) return false;
        if ( p.val != q.val ) return false;
        return isSameTree(p.right,q.right);
    }
	
	public static void recoverTree(TreeNode root) {
        TreeNode[] pair = new TreeNode[]{null,null};
        recoverTree(root,pair);
        int temp = pair[0].val;
        pair[0].val = pair[1].val;
        pair[1].val = temp;
    }
	private static void recoverTree(TreeNode root, TreeNode[] pair ) {
		if ( root == null ) return;
		recoverTree(root.left,pair);
		if ( pair[1] == null ) {
			if ( pair[0]!=null && root.val < pair[0].val ) {
				pair[1] = root;
			} else {
				pair[0] = root;
			}
		} else if ( root.val < pair[1].val ) {
			pair[1] = root;
		}
		recoverTree(root.right,pair);
	}
	
	public static boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root)>=0;
    }
	public static int isBalancedHelper( TreeNode root ) {
		if ( root == null ) return 0;
		int leftH = isBalancedHelper(root.left);
		int rightH = isBalancedHelper(root.right);
		if ( leftH < 0 || rightH < 0 || Math.abs(leftH-rightH)>1 ) return -1;
		return 1+Math.max(leftH,rightH);
	}
	public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, new TreeNode[]{null});
    }
	private static boolean isValidBSTHelper(TreeNode root, TreeNode[] prev) {
		if ( root == null ) return true;
		if ( !isValidBSTHelper(root.left,prev) ) return false;
		if ( prev[0]!=null && root.val <= prev[0].val ) return false;
		prev[0] = root;
		return isValidBSTHelper(root.right,prev);
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

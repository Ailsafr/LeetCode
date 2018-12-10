package solution.tree;

/**
 * @author By RuiCUI
 * 2018-12-10
 * Easy
 * Question 669:Trim a Binary Search Tree.
 * Given a binary search tree and the lowest and highest boundaries as L and R, 
 * trim the tree so that all its elements lies in [L, R] (R >= L). 
 * You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 * Example 1:
 * Input: 
	    1
	   / \
	  0   2
 * L = 1
 * R = 2
 * Output: 
	    1
	      \
	       2
 * Example 2:
 * Input: 
	    3
	   / \
	  0   4
	   \
	    2
	   /
	  1
 * L = 1
 * R = 3
 * Output: 
	      3
	     / 
	   2   
	  /
	 1
 */
public class TrimABinarySearchTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) n is the total number of nodes in the given tree.
	 * 空间复杂度：O(n) n is the total number of nodes in the given tree.
	 * @param root
	 * @param L
	 * @param R
	 * @return
	 */
	public static TreeNode trimBST(TreeNode root, int L, int R) {
		if(root==null){
			return null;
		}
		if(root.val<L){
			return trimBST(root.right,L,R);
		}else if(root.val>R){
			return trimBST(root.left,L,R);
		}else{
			root.left = trimBST(root.left,L,R);
			root.right = trimBST(root.right,L,R);
		}
		return root;
    }
	
	/**
	 * 答案--Recursion[Accepted],跟我的答案一样
	 * 时间复杂度：O(n) n is the total number of nodes in the given tree.
	 * 空间复杂度：O(n) n is the total number of nodes in the given tree.
	 * @param root
	 * @param L
	 * @param R
	 * @return
	 */
	public TreeNode trimBST1(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(0);
		TreeNode t3 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		int L = 1;
		int R = 2;
		System.out.println(trimBST(t1,L,R));
	}

}

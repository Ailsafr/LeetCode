package solution.tree;

/**
 * @author By RuiCUI
 * 2018-07-03
 * Easy
 * Question 235:Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
	        _______6______
	       /              \
	    ___2__          ___8__
	   /      \        /      \
	   0      _4       7       9
	         /  \
	         3   5
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class LowestCommonAncestorOfABinarySearchTree {

	/**
	 * 我自己写的方法--刚开始理解错了，没有注意是二叉搜索树
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if((root.val-p.val)*(root.val-q.val)<=0){
			return root;
		}
		if(root.val-q.val>0){
			root = root.left;
		}else{
			root = root.right;
		}
		return lowestCommonAncestor(root, p, q);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的思路一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
	    while ((root.val - p.val) * (root.val - q.val) > 0)
	        root = p.val < root.val ? root.left : root.right;
	    return root;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(6);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(0);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(5);
		TreeNode t7 = new TreeNode(8);
		TreeNode t8 = new TreeNode(7);
		TreeNode t9 = new TreeNode(9);
		t4.left = t5;
		t4.right = t6;
		t2.left = t3;
		t2.right = t4;
		t7.left = t8;
		t7.right = t9;
		t1.left = t2;
		t1.right = t7;
		
		TreeNode tree = lowestCommonAncestor(t1,t2,t7);
		System.out.println(tree);
	}

}

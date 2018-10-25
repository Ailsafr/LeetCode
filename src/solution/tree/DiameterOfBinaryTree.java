package solution.tree;

/**
 * @author By RuiCUI
 * 2018-10-25
 * Easy
 * Question 543:Diameter of Binary Tree.
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.
 * Example:
 * Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	static int ans;
	public static int diameterOfBinaryTree(TreeNode root) {
		ans = 1;
        depth(root);
        return ans - 1;
    }
	
	public static int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
	
	/**
	 * 答案1--Depth-First Search [Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	int ans1;
    public int diameterOfBinaryTree1(TreeNode root) {
        ans1 = 1;
        depth1(root);
        return ans1 - 1;
    }
    public int depth1(TreeNode node) {
        if (node == null) return 0;
        int L = depth1(node.left);
        int R = depth1(node.right);
        ans1 = Math.max(ans1, L+R+1);
        return Math.max(L, R) + 1;
    }
    
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t2.left = t4;
		t2.right = t5;
		t1.left = t2;
		t1.right = t3;
		System.out.println(diameterOfBinaryTree(t1));
	}

}

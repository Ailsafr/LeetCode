package solution.tree;

/**
 * @author By RuiCUI
 * 2018-12-18
 * Easy
 * Question 687:Longest Univalue Path.
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. 
 * This path may or may not pass through the root.
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * Example 1:
 * Input:
              5
             / \
            4   5
           / \   \
          1   1   5
 * Output:
 * 2
 * Example 2:
 * Input:
              1
             / \
            4   5
           / \   \
          4   4   5
 * Output:
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class LongestUnivaluePath {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) where n is the number of nodes in the tree.
	 * 空间复杂度：O(h) where h is the height of the tree.
	 * @param root
	 * @return
	 */
	static int result;
	public static int longestUnivaluePath(TreeNode root) {
		result = 0;
        helper(root);
        return result;
    }
	private static int helper(TreeNode node){
		if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        result = Math.max(result, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
	}
	
	/**
	 * 答案--Recursion[Accepted]
	 * 时间复杂度：O(n) where n is the number of nodes in the tree.
	 * 空间复杂度：O(h) where h is the height of the tree.
	 * @param root
	 * @return
	 */
	int ans;
    public int longestUnivaluePath1(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
    
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(5);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(5);
		t2.left = t4;
		t2.right = t4;
		t3.right = t5;
		t1.left = t2;
		t1.right = t3;
		System.out.println(longestUnivaluePath(t1));
	}

}

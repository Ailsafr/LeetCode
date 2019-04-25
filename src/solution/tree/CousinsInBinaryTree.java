package solution.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2019-04-25
 * Easy
 * Question 993:Cousins in Binary Tree.
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * Example 1:
 * 			1
 * 		   / \
 * 		  2   3
 * 		 /
 * 		4
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 * 			1
 * 		   / \
 * 		  2   3
 * 		   \   \
 * 			4   5
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 * 			1
 * 		   / \
 * 		  2   3
 * 		   \   
 * 			4   
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * Note:
 * 1.The number of nodes in the tree will be between 2 and 100.
 * 2.Each node has a unique integer value from 1 to 100.
 */
public class CousinsInBinaryTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
	static Map<Integer, Integer> depth;
    static Map<Integer, TreeNode> parent;
    public static boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap();
        parent = new HashMap();
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }
    public static void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
	
	/**
	 * 答案--Annotate Parent and Depth
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
	Map<Integer, Integer> depth1;
    Map<Integer, TreeNode> parent1;
    public boolean isCousins1(TreeNode root, int x, int y) {
        depth1 = new HashMap();
        parent1 = new HashMap();
        dfs1(root, null);
        return (depth1.get(x) == depth1.get(y) && parent1.get(x) != parent1.get(y));
    }
    public void dfs1(TreeNode node, TreeNode par) {
        if (node != null) {
            depth1.put(node.val, par != null ? 1 + depth1.get(par.val) : 0);
            parent1.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t2.left = t4;
		t3.left = t5;
		t1.left = t2;
		t1.right = t3;
		int x = 4;
		int y = 5;
		System.out.println(isCousins(t1,x,y));
	}

}

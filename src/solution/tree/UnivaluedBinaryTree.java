package solution.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-04-16
 * Easy
 * Question 965:Univalued Binary Tree.
 * A binary tree is univalued if every node in the tree has the same value.
 * Return true if and only if the given tree is univalued.
 * Example 1:
 * 				1
 * 			   / \
 * 			  1   1
 * 			 / \   \
 *          1   1   1
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 * 				2
 * 			   / \
 * 			  2   2
 * 			 / \
 * 			5   2
 * Input: [2,2,2,5,2]
 * Output: false
 * Note:
 * 1.The number of nodes in the given tree will be in the range [1, 100].
 * 2.Each node's value will be an integer in the range [0, 99].
 */
public class UnivaluedBinaryTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param root
	 * @return
	 */
	public static boolean isUnivalTree(TreeNode root) {
		int val = root.val;
		return helper(val,root);
    }
	private static boolean helper(int val, TreeNode root){
		if(root==null){
			return true;
		}
		if(root.val==val){
			return helper(val,root.left)&&helper(val,root.right);
		}else{
			return false;
		}
	}
	
	/**
	 * 答案1--Depth-First Search
	 * 时间复杂度：O(n) where n is the number of nodes in the given tree.
	 * 空间复杂度：O(n) where n is the number of nodes in the given tree.
	 * @param root
	 * @return
	 */
	List<Integer> vals;
    public boolean isUnivalTree1(TreeNode root) {
        vals = new ArrayList();
        dfs(root);
        for (int v: vals)
            if (v != vals.get(0))
                return false;
        return true;
    }
    public void dfs(TreeNode node) {
        if (node != null) {
            vals.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }
	
	/**
	 * 答案2--Recursion
	 * 时间复杂度：O(n) where n is the number of nodes in the given tree.
	 * 空间复杂度：O(h) where h is the height of the given tree. 
	 * @param root
	 * @return
	 */
    public boolean isUnivalTree2(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(1);
		TreeNode t6 = new TreeNode(1);
		t3.right = t6;
		t2.left = t4;
		t2.right = t5;
		t1.left = t2;
		t1.right = t3;
		System.out.println(isUnivalTree(t1));
	}

}

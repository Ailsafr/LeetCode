package solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-08-19
 * Medium
 * Question 94:Binary Tree Inorder Traversal.
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Example:
 * Input: [1,null,2,3]
	   1
	    \
	     2
	    /
	   3
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null){
			return result;
		}
		helper(result,root);
		return result;
    }
	private static void helper(List<Integer> result, TreeNode root){
		if(root!=null){
			if(root.left!=null){
				helper(result,root.left);
			}
			result.add(root.val);
			if(root.right!=null){
				helper(result,root.right);
			}
		}
	}
	
	/**
	 * 答案1--Recursive Approach
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public List <Integer> inorderTraversal1(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
	
	/**
	 * 答案2--Iterating method using Stack
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    public List <Integer> inorderTraversal2(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        Stack <TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
	
	/**
	 * 答案3--Morris Traversal
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    public List <Integer> inorderTraversal3(TreeNode root) {
        List <Integer> res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t2.left = t3;
		t1.right = t2;
		System.out.println(inorderTraversal(t1));
	}

}

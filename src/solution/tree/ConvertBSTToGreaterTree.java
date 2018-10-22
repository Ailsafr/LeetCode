package solution.tree;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-10-22
 * Easy
 * Question 538:Convert BST to Greater Tree.
 * Given a Binary Search Tree (BST), 
 * convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * Example:
 * Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13
 * Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 */
public class ConvertBSTToGreaterTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	private static int sum = 0;
	public static TreeNode convertBST(TreeNode root) {
		if(root!=null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
	
	/**
	 * 答案1--Recursion [Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	private int sum1 = 0;
	public TreeNode convertBST1(TreeNode root) {
		if(root!=null){
            convertBST(root.right);
            sum1 += root.val;
            root.val = sum1;
            convertBST(root.left);
        }
        return root;
    }
	
	/**
	 * 答案2--Iteration with a Stack [Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }

        return root;
    }
	
	/**
	 * 答案3--Reverse Morris In-order Traversal [Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param root
	 * @return
	 */
	private TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }

    public TreeNode convertBST3(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            /* 
             * If there is no right subtree, then we can visit this node and
             * continue traversing left.
             */
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            }
            /* 
             * If there is a right subtree, then there is at least one node that
             * has a greater value than the current one. therefore, we must
             * traverse that subtree first.
             */
            else {
                TreeNode succ = getSuccessor(node);
                /* 
                 * If the left subtree is null, then we have never been here before.
                 */
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                }
                /* 
                 * If there is a left subtree, it is a link that we created on a
                 * previous pass, so we should unlink it and visit this node.
                 */
                else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }
        
        return root;
    }
    
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(13);
		t1.left = t2;
		t1.right = t3;
		System.out.println(convertBST(t1));
	}

}

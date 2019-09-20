package solution.tree;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-09-20
 * Medium
 * Question 129:Sum Root to Leaf Numbers.
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 * Example:
 * Input: [1,2,3]
	    1
	   / \
	  2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 * Input: [4,9,0,5,1]
	    4
	   / \
	  9   0
	 / \
	5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class SumRootToLeafNumbers {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	private static int sum = 0;
	public static int sumNumbers(TreeNode root) {
		if (root==null) {
			return 0;
		}
		helper(0, root.val+"", root);
		return sum;
    }
	private static void helper(int num, String str, TreeNode root) {
		if (root.left==null && root.right==null) {
			sum += Integer.parseInt(str);
		}
		if (root.left!=null) {
			helper(num, str+root.left.val, root.left);
		}
		if (root.right!=null) {
			helper(num, str+root.right.val, root.right);
		}
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public int sumNumbers1(TreeNode root) {
		return sum(root, 0);
	}
	public int sum(TreeNode n, int s){
		if (n == null) return 0;
		if (n.right == null && n.left == null) return s*10 + n.val;
		return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	int total;
    public int sumNumbers2(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }
    void helper(TreeNode root, int sum) {
        if (root == null) return;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }
        helper(root.left, sum);
        helper(root.right, sum);
    }
    
    /**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    public int sumNumbers3(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum = 0;
        TreeNode curr;
        Stack<TreeNode> ws = new Stack<TreeNode>();
        ws.push(root);
        
        while(!ws.empty()){
            curr = ws.pop();
            if(curr.right!=null){
                curr.right.val = curr.val*10+curr.right.val;
                ws.push(curr.right);
            }
            if(curr.left!=null){
                curr.left.val = curr.val*10+curr.left.val;
                ws.push(curr.left);
            }
            if(curr.left==null && curr.right==null){ // leaf node
                sum+=curr.val;
            }
        }
        return sum;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(0);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(1);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		System.out.println(sumNumbers(t1));
	}

}

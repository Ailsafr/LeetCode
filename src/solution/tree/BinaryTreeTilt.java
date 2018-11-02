package solution.tree;

/**
 * @author By RuiCUI
 * 2018-11-02
 * Easy
 * Question 563:Binary Tree Tilt.
 * Given a binary tree, return the tilt of the whole tree.
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. 
 * Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * Example:
 * Input: 
	         1
	       /   \
	      2     3
 * Output: 1
 * Explanation: 
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 * 1.The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * 2.All the tilt values won't exceed the range of 32-bit integer.
 * Hint:
 * 1.Don't think too much, this is an easy problem. Take some small tree as an example.
 * 2.Can a parent node use the values of its child nodes? How will you implement it?
 * 3.May be recursion and tree traversal can help you in implementing.
 * 4.What about postorder traversal, using values of left and right childs?
 */
public class BinaryTreeTilt {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param root
	 * @return
	 */
	public static int findTilt(TreeNode root) {
		if(root==null){
			return 0;
		}
		return Math.abs(getSum(root.left)-getSum(root.right))+findTilt(root.left)+findTilt(root.right);
    }
	
	private static int getSum(TreeNode root){
		if(root==null){
			return 0;
		}
		return root.val + getSum(root.left) + getSum(root.right);
	}
	
	/**
	 * 答案--Using Recursion [Accepted],跟我的思路一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	int tilt=0;
    public int findTilt1(TreeNode root) {
        traverse(root);
        return tilt;
    }
    public int traverse(TreeNode root)
    {
        if(root==null )
            return 0;
        int left=traverse(root.left);
        int right=traverse(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		System.out.println(findTilt(t1));
	}

}

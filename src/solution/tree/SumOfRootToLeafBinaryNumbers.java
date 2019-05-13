package solution.tree;

/**
 * @author By RuiCUI
 * 2019-05-13
 * Easy
 * Question 1022:Sum of Root To Leaf Binary Numbers.
 * Given a binary tree, each node has value 0 or 1.  
 * Each root-to-leaf path represents a binary number starting with the most significant bit.  
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * Return the sum of these numbers.
 * Example 1:
 * 				 1
 * 		   	   /   \
 * 		  	  0   	1
 * 		 	 / \   / \
 * 			0   1 0   1
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * Note:
 * 1. The number of nodes in the tree is between 1 and 1000.
 * 2. node.val is 0 or 1.
 * 3. The answer will not exceed 2^31 - 1.
 * Hint:
 * Find each path, then transform that path to an integer in base 10.
 */
public class SumOfRootToLeafBinaryNumbers {

	/**
	 * 我自己写的方法
	 * @param root
	 * @return
	 */
	public static int sumRootToLeaf(TreeNode root) {
		return helper(root, 0);
    }
	private static int helper(TreeNode root,int soFar){
		if (root == null) return soFar;
        int ret = root.val + 2 * soFar;
        int sum = 0 ;
        if (root.left != null)
            sum += helper(root.left, ret);
        if (root.right != null )
            sum += helper(root.right, ret);
        
        return sum == 0? ret : sum;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param root
	 * @return
	 */
	int ans= 0;
    public int sumRootToLeaf1(TreeNode root) {
    	runTree(root,"");
        return ans;   
    }
    public void runTree(TreeNode root,String s){
        if(root!=null)
            s+=root.val;
        else 
            return;
        if(root.left==null && root.right==null){
            ans+=Integer.parseInt(s, 2);
        }
        runTree(root.left,s);
        runTree(root.right,s);
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(0);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(0);
		TreeNode t5 = new TreeNode(1);
		t2.left = t4;
		t2.right = t5;
		t3.left = t4;
		t3.right = t5;
		t1.left = t2;
		t1.right = t3;
		System.out.println(sumRootToLeaf(t1));
	}
}

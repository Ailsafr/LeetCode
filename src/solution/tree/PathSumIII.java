package solution.tree;

import java.util.HashMap;

/**
 * @author By RuiCUI
 * 2018-08-21
 * Easy
 * Question 437:Path Sum III.
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
		      10
		     /  \
		    5   -3
		   / \    \
		  3   2   11
		 / \   \
		3  -2   1
 * Return 3. The paths that sum to 8 are:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {

	/**
	 * 我自己写的方法，参考的别人的答案
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param sum
	 * @return
	 */
	public static int pathSum(TreeNode root, int sum) {
		if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
	
	private static int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) 
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param sum
	 * @return
	 */
	public int pathSum1(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param sum
	 * @return
	 */
    public int pathSum2(TreeNode root, int sum) {
        return helper(root, sum, false);
    }
    // Either the path has not started, or it has to go all the way to the end.
    private int helper(TreeNode root, int sum, boolean hasStarted) {
        if (root == null) return 0;
        // if the path has not started, we start now or not.
        if (!hasStarted) {
            return helper(root, sum, true) + helper(root.left, sum, false) + helper(root.right, sum, false);
        }
        // if the path has started
        sum -= root.val;
        return helper(root.left, sum, true) + helper(root.right, sum, true) + (sum == 0? 1 : 0);            
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(11);
		TreeNode t5 = new TreeNode(13);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(2);
		TreeNode t9 = new TreeNode(1);
		t4.left = t7;
		t4.right = t8;
		t6.right = t9;
		t2.left = t4;
		t3.left = t5;
		t3.right = t6;
		t1.left = t2;
		t1.right = t3;
		System.out.println(pathSum(t1,22));
	}

}

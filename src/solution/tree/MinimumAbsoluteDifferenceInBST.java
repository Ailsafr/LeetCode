package solution.tree;

import java.util.TreeSet;

/**
 * @author By RuiCUI
 * 2018-10-18
 * Easy
 * Question 530:Minimum Absolute Difference in BST.
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * Example:
 * Input:
	   1
	    \
	     3
	    /
	   2
 * Output:
 * 1
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 */
public class MinimumAbsoluteDifferenceInBST {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param root
	 * @return
	 */
	static int min = Integer.MAX_VALUE;
    static Integer prev = null;
	public static int getMinimumDifference(TreeNode root) {
		if (root == null) return min;
        
        getMinimumDifference(root.left);
        
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param root
	 * @return
	 */
	int min1 = Integer.MAX_VALUE;
    Integer prev1 = null;
    
    public int getMinimumDifference1(TreeNode root) {
        if (root == null) return min1;
        
        getMinimumDifference1(root.left);
        
        if (prev1 != null) {
            min1 = Math.min(min1, root.val - prev1);
        }
        prev1 = root.val;
        
        getMinimumDifference1(root.right);
        
        return min1;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(nlgn)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    TreeSet<Integer> set = new TreeSet<>();
    int min2 = Integer.MAX_VALUE;
    
    public int getMinimumDifference2(TreeNode root) {
        if (root == null) return min2;
        
        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min2 = Math.min(min2, root.val - set.floor(root.val));
            }
            if (set.ceiling(root.val) != null) {
                min2 = Math.min(min2, set.ceiling(root.val) - root.val);
            }
        }
        
        set.add(root.val);
        
        getMinimumDifference2(root.left);
        getMinimumDifference2(root.right);
        
        return min2;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(2);
		t2.left = t3;
		t1.right = t2;
		System.out.println(getMinimumDifference(t1));
	}

}

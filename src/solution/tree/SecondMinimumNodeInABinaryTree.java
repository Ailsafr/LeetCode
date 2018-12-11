package solution.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2018-12-11
 * Easy
 * Question 671:Second Minimum Node In a Binary Tree.
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, 
 * where each node in this tree has exactly two or zero sub-node. 
 * If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 * If no such second minimum value exists, output -1 instead.
 * Example 1:
 * Input: 
	    2
	   / \
	  2   5
	     / \
	    5   7
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * Example 2:
 * Input: 
	    2
	   / \
	  2   2
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class SecondMinimumNodeInABinaryTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) n is the total number of nodes in the given tree. 
	 * 空间复杂度：O(n) n is the total number of nodes in the given tree. 
	 * @param root
	 * @return
	 */
	static int min = Integer.MAX_VALUE;
	static int min2 = Integer.MAX_VALUE;
	public static int findSecondMinimumValue(TreeNode root) {
		if(root==null||root.left==null){
			return -1;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode t = queue.poll();
			if(t!=null){
				if(t.val<min){
					min2 = min;
					min = t.val;
				}else if(t.val<min2&&t.val!=min){
					min2 = t.val;
				}
			}
			if(t.left!=null){
				queue.add(t.left);
				queue.add(t.right);
			}
		}
		if(min2==Integer.MAX_VALUE){
			return -1;
		}
		return min2;
    }
	
	/**
	 * 答案1--Brute Force[Accepted]
	 * 时间复杂度：O(n) n is the total number of nodes in the given tree. 
	 * 空间复杂度：O(n) n is the total number of nodes in the given tree. 
	 * @param root
	 * @return
	 */
	public void dfs(TreeNode root, Set<Integer> uniques) {
        if (root != null) {
            uniques.add(root.val);
            dfs(root.left, uniques);
            dfs(root.right, uniques);
        }
    }
    public int findSecondMinimumValue1(TreeNode root) {
        Set<Integer> uniques = new HashSet<Integer>();
        dfs(root, uniques);

        int min1 = root.val;
        long ans = Long.MAX_VALUE;
        for (int v : uniques) {
            if (min1 < v && v < ans) ans = v;
        }
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
	
	/**
	 * 答案2--Ad-Hoc[Accepted]
	 * 时间复杂度：O(n) n is the total number of nodes in the given tree. 
	 * 空间复杂度：O(n) n is the total number of nodes in the given tree. 
	 * @param root
	 * @return
	 */
    int min1;
    long ans = Long.MAX_VALUE;
    public void dfs(TreeNode root) {
        if (root != null) {
            if (min1 < root.val && root.val < ans) {
                ans = root.val;
            } else if (min1 == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValue2(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		System.out.println(findSecondMinimumValue(t1));
	}

}

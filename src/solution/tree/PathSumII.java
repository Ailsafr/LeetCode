package solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-09-02
 * Medium
 * Question 113:Path Sum II.
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 * Example:
 * Given the below binary tree and sum = 22,
	      5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \    / \
	7    2  5   1
 * Return:
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
 */
public class PathSumII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param sum
	 * @return
	 */
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, new ArrayList<Integer>(), root, sum);
	    return result;
    }
	private static void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum) {
		if (root == null) {
			return;
		}
	    list.add(root.val);
	    sum -= root.val;
	    if (root.left == null && root.right == null) {
	        if (sum == 0) result.add(list);
	        return;
	    }
	    helper(result, new ArrayList<Integer>(list), root.left, sum);
	    helper(result, new ArrayList<Integer>(list), root.right, sum);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum1(TreeNode root, int sum){
		List<List<Integer>> result  = new LinkedList<List<Integer>>();
		List<Integer> currentResult  = new LinkedList<Integer>();
		pathSum(root,sum,currentResult,result);
		return result;
	}
	public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
			List<List<Integer>> result) {

		if (root == null)
			return;
		currentResult.add(new Integer(root.val));
		if (root.left == null && root.right == null && sum == root.val) {
			result.add(new LinkedList(currentResult));
			currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
			return;
		} else {
			pathSum(root.left, sum - root.val, currentResult, result);
			pathSum(root.right, sum - root.val, currentResult, result);
		}
		currentResult.remove(currentResult.size() - 1);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int SUM = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                path.add(cur.val);
                SUM+=cur.val;
                cur=cur.left;
            }
            cur = stack.peek();
            if(cur.right!=null && cur.right!=pre){
                cur = cur.right;
                continue;
            } 
            if(cur.left==null && cur.right==null && SUM==sum) 
                res.add(new ArrayList<Integer>(path));
  
            pre = cur;
            stack.pop();
            path.remove(path.size()-1);
            SUM-=cur.val;
            cur = null;
        
        }
        return res;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param sum
	 * @return
	 */
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> pathSum3(TreeNode root, int sum) {
	    helper1(new ArrayList<Integer>(), root, sum);
	    return result;
	}
	private void helper1(List<Integer> list, TreeNode root, int sum) {
	    if (root == null) return;
	    list.add(root.val);
	    sum -= root.val;
	    if (root.left == null && root.right == null) {
	        if (sum == 0) result.add(list);
	        return;
	    }
	    helper1(new ArrayList<Integer>(list), root.left, sum);
	    helper1(new ArrayList<Integer>(list), root.right, sum);
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
		TreeNode t9 = new TreeNode(5);
		TreeNode t10 = new TreeNode(1);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t4.left = t7;
		t4.right = t8;
		t3.left = t5;
		t3.right = t6;
		t6.left = t9;
		t6.right = t10;
		
		int sum = 22;
		
		System.out.println(pathSum(t1, sum));
	}

}

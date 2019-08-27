package solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-08-27
 * Medium
 * Question 103:Binary Tree Zigzag Level Order Traversal.
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean zigzag = true;
		helper(root, result, 0, zigzag);
		return result;
    }
	private static void helper(TreeNode root, List<List<Integer>> result, int level, boolean zigzag){
		if (root==null) {
			return;
		}
		if (result.size()<=level) {
			result.add(new ArrayList<Integer>());
		}
		if (zigzag) {
			result.get(level).add(root.val);
		} else {
			result.get(level).add(0, root.val);
		}
		helper(root.left, result, level+1, !zigzag);
		helper(root.right, result, level+1, !zigzag);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder1(TreeNode root) 
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }
    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;
        
        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }
        
        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);
        
        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    public List<List> zigzagLevelOrder2(TreeNode root) {
    	List<List> res = new ArrayList<>();
    	if(root == null) return res;
	    Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    boolean order = true;
	    int size = 1;

	    while(!q.isEmpty()) {
	        List<Integer> tmp = new ArrayList<>();
	        for(int i = 0; i < size; ++i) {
	            TreeNode n = q.poll();
	            if(order) {
	                tmp.add(n.val);
	            } else {
	                tmp.add(0, n.val);
	            }
	            if(n.left != null) q.add(n.left);
	            if(n.right != null) q.add(n.right);
	        }
	        res.add(tmp);
	        size = q.size();
	        order = order ? false : true;
	    }
	    return res;
	}
    
    /**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
	   TreeNode c=root;
	   List<List<Integer>> ans =new ArrayList<List<Integer>>();
	   if(c==null) return ans;
	   Stack<TreeNode> s1=new Stack<TreeNode>();
	   Stack<TreeNode> s2=new Stack<TreeNode>();
	   s1.push(root);
	   while(!s1.isEmpty()||!s2.isEmpty())
	   {
	       List<Integer> tmp=new ArrayList<Integer>();
	        while(!s1.isEmpty())
	        {
	            c=s1.pop();
	            tmp.add(c.val);
	            if(c.left!=null) s2.push(c.left);
	            if(c.right!=null) s2.push(c.right);
	        }
	        ans.add(tmp);
	        tmp=new ArrayList<Integer>();
	        while(!s2.isEmpty())
	        {
	            c=s2.pop();
	            tmp.add(c.val);
	            if(c.right!=null)s1.push(c.right);
	            if(c.left!=null)s1.push(c.left);
	        }
	        if(!tmp.isEmpty()) ans.add(tmp);
	   }
	   return ans;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		t3.left = t4;
		t3.right = t5;
		t1.left = t2;
		t1.right = t3;
		System.out.println(zigzagLevelOrder(t1));
	}

}

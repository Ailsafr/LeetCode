package solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-07-06
 * Easy
 * Question 257:Binary Tree Paths.
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 * Example:
 * Input:
	   1
	 /   \
	2     3
	 \
	  5
 * Output: ["1->2->5", "1->3"]
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {

	/**
	 * 我自己写的方法--看了别人的答案，没有想到多传参数的情况
	 * @param root
	 * @return
	 */
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> answer = new ArrayList<String>();
	    if (root != null) helper(root, "", answer);
	    return answer;
    }
	
	private static void helper(TreeNode root, String path, List<String> answer) {
	    if (root.left == null && root.right == null) answer.add(path + root.val);
	    if (root.left != null) helper(root.left, path + root.val + "->", answer);
	    if (root.right != null) helper(root.right, path + root.val + "->", answer);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths1(TreeNode root) {
	    List<String> answer = new ArrayList<String>();
	    if (root != null) searchBT(root, "", answer);
	    return answer;
	}
	private void searchBT(TreeNode root, String path, List<String> answer) {
	    if (root.left == null && root.right == null) answer.add(path + root.val);
	    if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
	    if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if(root == null) return paths;
        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }
        for (String path : binaryTreePaths2(root.left)) {
        	paths.add(root.val + "->" + path);
        }
        for (String path : binaryTreePaths2(root.right)) {
        	paths.add(root.val + "->" + path);
        }
        return paths;
    }

	/**
	 * 官网没有solution,这是其他人的答案,BFS递归
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths3(TreeNode root) {
	    List<String> list=new ArrayList<String>();
	    Queue<TreeNode> qNode=new LinkedList<TreeNode>();
	    Queue<String> qStr=new LinkedList<String>();
	    
	    if (root==null) return list;
	    qNode.add(root);
	    qStr.add("");
	    while(!qNode.isEmpty()) {
	        TreeNode curNode=qNode.remove();
	        String curStr=qStr.remove();
	        
	        if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
	        if (curNode.left!=null) {
	            qNode.add(curNode.left);
	            qStr.add(curStr+curNode.val+"->");
	        }
	        if (curNode.right!=null) {
	            qNode.add(curNode.right);
	            qStr.add(curStr+curNode.val+"->");
	        }
	    }
	    return list;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,DFS递归
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths4(TreeNode root) {
	    List<String> list=new ArrayList<String>();
	    Stack<TreeNode> sNode=new Stack<TreeNode>();
	    Stack<String> sStr=new Stack<String>();
	    
	    if(root==null) return list;
	    sNode.push(root);
	    sStr.push("");
	    while(!sNode.isEmpty()) {
	        TreeNode curNode=sNode.pop();
	        String curStr=sStr.pop();
	        
	        if(curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
	        if(curNode.left!=null) {
	            sNode.push(curNode.left);
	            sStr.push(curStr+curNode.val+"->");
	        }
	        if(curNode.right!=null) {
	            sNode.push(curNode.right);
	            sStr.push(curStr+curNode.val+"->");
	        }
	    }
	    return list;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		t2.right = t5;
		t1.left = t2;
		t1.right = t3;
		System.out.println(binaryTreePaths(t1));
	}
}

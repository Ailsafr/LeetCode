package solution.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2018-03-19
 * Easy
 * Question 111:Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(NlogN)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static int minDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		if(root.left==null){
			return 1+minDepth(root.right);
		}else if(root.right==null){
			return 1+minDepth(root.left);
		}
		return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,DFS递归
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
       
    }
    
    /**
	 * 官网没有solution,这是其他人的答案,BFS迭代
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    public int minDepth2(TreeNode root) {
    	if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size(); // determine the loop size
            for (int i = 0; i< size; i++){
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    return depth;
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            depth ++;
        }
        return depth;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t5;
		t3.right = t4;
		System.out.println(minDepth(t1));
	}

}

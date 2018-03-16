package solution.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2018-03-16
 * Easy
 * Question 110:Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * Return true.
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
	       1
	      / \
	     2   2
	    / \
	   3   3
	  / \
	 4   4
 * Return false.
 */
public class BalancedBinaryTree {

	/**
	 * 我自己写的方法--递归--DFS
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static boolean isBalanced(TreeNode root) {
		if(root==null){
			return true;
		}
		int left = getLevel(root.left);
		int right = getLevel(root.right);
		if(-2<left-right&&left-right<2){
			return isBalanced(root.left)&&isBalanced(root.right);
		}
		return false;
    }
	
	private static int getLevel(TreeNode tree){
		if(tree==null){
			return 0;
		}
		if(tree.left==null&&tree.right==null){
			return 1;
		}
		return 1+Math.max(getLevel(tree.left), getLevel(tree.right));
	}
	
	/**
	 * 我自己写的方法--迭代--BFS
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static boolean isBalanced1(TreeNode root) {
		if(root==null){
			return true;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(root);
		int num = 0;
		while(q.size()>0){
			TreeNode tree1 = q.poll();
			TreeNode tree2 = q.poll();
			
			if(tree1.left!=null&&tree2.right!=null){
				q.offer(tree1.left);
				q.offer(tree2.right);
			}else if(tree1.left!=null&&tree2.right==null){
				q.offer(tree1.left);
				num++;
			}else if(tree1.left==null&&tree2.right!=null){
				q.offer(tree2.right);
				num++;
			}
		}
		if(num>1){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(7);
		t3.left = t4;
		t3.right = t5;
		//t2.left = t6;
		t1.left = t2;
		t1.right = t3;
		//System.out.println(isBalanced(t1));
		TreeNode tt1 = new TreeNode(1);
		TreeNode tt2 = new TreeNode(2);
		TreeNode tt3 = new TreeNode(2);
		TreeNode tt4 = new TreeNode(3);
		TreeNode tt5 = new TreeNode(3);
		TreeNode tt6 = new TreeNode(4);
		TreeNode tt7 = new TreeNode(4);
		tt4.left = tt6;
		tt5.right = tt7;
		tt3.left = tt4;
		tt2.right = tt5;
		tt1.left = tt3;
		tt1.right = tt2;
		//System.out.println(isBalanced(tt1));
		TreeNode ttt1 = new TreeNode(1);
		TreeNode ttt2 = new TreeNode(2);
		TreeNode ttt3 = new TreeNode(2);
		TreeNode ttt4 = new TreeNode(3);
		TreeNode ttt5 = new TreeNode(3);
		TreeNode ttt6 = new TreeNode(4);
		TreeNode ttt7 = new TreeNode(4);
		ttt5.left = ttt6;
		ttt5.right = ttt7;
		ttt2.left = ttt5;
		ttt2.right = ttt4;
		ttt1.left = ttt2;
		ttt1.right = ttt3;
		System.out.println(isBalanced(ttt1));
	}

}

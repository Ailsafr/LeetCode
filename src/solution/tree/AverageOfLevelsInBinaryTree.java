package solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2018-11-29
 * Easy
 * Question 637:Average of Levels in Binary Tree.
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * 1.The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageOfLevelsInBinaryTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) n refers to the total number of nodes in the given binary tree.
	 * 空间复杂度：O(h) h refers to the height(maximum number of levels) of the given binary tree.
	 * @param root
	 * @return
	 */
	public static List<Double> averageOfLevels(TreeNode root) {
		List < Integer > count = new ArrayList < > ();
        List < Double > res = new ArrayList < > ();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }
    public static void average(TreeNode t, int i, List < Double > sum, List < Integer > count) {
        if (t == null)
            return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }
	
	/**
	 * 答案1--Using Depth First Search[Accepted]
	 * 时间复杂度：O(n) n refers to the total number of nodes in the given binary tree.
	 * 空间复杂度：O(h) h refers to the height(maximum number of levels) of the given binary tree.
	 * @param root
	 * @return
	 */
	public List < Double > averageOfLevels1(TreeNode root) {
        List < Integer > count = new ArrayList < > ();
        List < Double > res = new ArrayList < > ();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }
    public void average1(TreeNode t, int i, List < Double > sum, List < Integer > count) {
        if (t == null)
            return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }
    
    /**
	 * 答案2--Breadth First Search[Accepted]
	 * 时间复杂度：O(n) n refers to the total number of nodes in the given binary tree.
	 * 空间复杂度：O(m) m refers to the maximum mumber of nodes at any level in the input tree.
	 * @param root
	 * @return
	 */
    public List < Double > averageOfLevels2(TreeNode root) {
        List < Double > res = new ArrayList < > ();
        Queue < TreeNode > queue = new LinkedList < > ();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            Queue < TreeNode > temp = new LinkedList < > ();
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                sum += n.val;
                count++;
                if (n.left != null)
                    temp.add(n.left);
                if (n.right != null)
                    temp.add(n.right);
            }
            queue = temp;
            res.add(sum * 1.0 / count);
        }
        return res;
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
		System.out.println(averageOfLevels(t1));
	}

}

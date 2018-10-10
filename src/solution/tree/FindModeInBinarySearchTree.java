package solution.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-10-09
 * Easy
 * Question 501:Find Mode in Binary Search Tree.
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
	   1
	    \
	     2
	    /
	   2
 * return [2].
 * Note: If a tree has more than one mode, you can return them in any order.
 * Follow up: Could you do that without using any extra space? 
 * (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeInBinarySearchTree {

	/**
	 * 我自己写的方法,参考的别人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static int[] findMode(TreeNode root) {
		inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private static int currVal;
    private static int currCount = 0;
    private static int maxCount = 0;
    private static int modeCount = 0;
    
    private static int[] modes;

    private static void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }
    
    private static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode1(TreeNode root) {
        if (root == null) return new int[0];
        
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    Map<Integer, Integer> map; 
    int max3 = 0;
    public int[] findMode3(TreeNode root) {
        if(root==null) return new int[0]; 
        this.map = new HashMap<>(); 
        
        inorder3(root); 
        
        List<Integer> list = new LinkedList<>();
        for(int key: map.keySet()){
            if(map.get(key) == max3) list.add(key);
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i<res.length; i++) res[i] = list.get(i);
        return res; 
    }
    
    private void inorder3(TreeNode node){
        if(node.left!=null) inorder(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0)+1);
        max3 = Math.max(max3, map.get(node.val));
        if(node.right!=null) inorder(node.right); 
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		t2.left = t3;
		t1.right = t2;
		int[] tree = findMode(t1);
		System.out.println(tree);
	}

}

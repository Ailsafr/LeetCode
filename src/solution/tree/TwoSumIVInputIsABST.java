package solution.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2018-12-04
 * Easy
 * Question 653:Two Sum IV - Input is a BST.
 * Given a Binary Search Tree and a target number, 
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 * Example 1:
 * Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7
 * Target = 9
 * Output: True
 * Example 2:
 * Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7
 * Target = 28
 * Output: False
 */
public class TwoSumIVInputIsABST {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) n refers to the number of nodes in the given tree.
	 * 空间复杂度：O(n) n refers to the number of nodes in the given tree.
	 * @param root
	 * @param k
	 * @return
	 */
	static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	public static boolean findTarget(TreeNode root, int k) {
		getMap(root);
		for(Integer key:map.keySet()){
			if(map.containsKey(k-key)&&k-key!=key){
				return true;
			}
		}
		return false;
    }
	
	private static void getMap(TreeNode root){
		if(root==null){
			return;
		}
		map.put(root.val, root.val);
		getMap(root.left);
		getMap(root.right);
	}
	
	/**
	 * 答案1--Using HashSet[Accepted]
	 * 时间复杂度：O(n) n refers to the number of nodes in the given tree.
	 * 空间复杂度：O(n) n refers to the number of nodes in the given tree.
	 * @param root
	 * @param k
	 * @return
	 */
	public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
    
    /**
	 * 答案2--Using BFS and HashSet[Accepted]
	 * 时间复杂度：O(n) n refers to the number of nodes in the given tree.
	 * 空间复杂度：O(n) n refers to the number of nodes in the given tree.
	 * @param root
	 * @param k
	 * @return
	 */
    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }
	
	/**
	 * 答案3--Using BST[Accepted]
	 * 时间复杂度：O(n) n refers to the number of nodes in the given tree.
	 * 空间复杂度：O(n) n refers to the number of nodes in the given tree.
	 * @param root
	 * @param k
	 * @return
	 */
    public boolean findTarget3(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(7);
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		t1.left = t2;
		t1.right = t3;
		int k = 9;
		System.out.println(findTarget(t1,k));
	}

}

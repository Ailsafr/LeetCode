package solution.tree;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-09-03
 * Medium
 * Question 114:Flatten Binary Tree to Linked List.
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, given the following tree:
	    1
	   / \
	  2   5
	 / \   \
	3   4   6
 * The flattened tree should look like:
	1
	 \
	  2
	   \
	    3
	     \
	      4
	       \
	        5
	         \
	          6
 * Hint:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 */
public class FlattenBinaryTreeToLinkedList {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param root
	 * @return
	 */
	private static TreeNode pre = null;
	public static void flatten(TreeNode root) {
		if (root == null)
	        return;
	    flatten(root.right);
	    flatten(root.left);
	    root.right = pre;
	    root.left = null;
	    pre = root;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param root
	 * @return
	 */
	private TreeNode prev = null;
	public void flatten1(TreeNode root) {
	    if (root == null)
	        return;
	    flatten1(root.right);
	    flatten1(root.left);
	    root.right = prev;
	    root.left = null;
	    prev = root;
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param root
	 * @return
	 */
	public void flatten2(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        flatten2(left);
        flatten2(right);
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param root
	 * @return
	 */
	public void flatten3(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()){
            TreeNode curr = stk.pop();
            if (curr.right!=null)  
                 stk.push(curr.right);
            if (curr.left!=null)  
                 stk.push(curr.left);
            if (!stk.isEmpty()) 
                 curr.right = stk.peek();
            curr.left = null;  // dont forget this!! 
        }
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(5);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(6);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		flatten(t1);
	}

}

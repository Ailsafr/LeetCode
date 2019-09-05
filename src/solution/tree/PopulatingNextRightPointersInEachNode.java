package solution.tree;

/**
 * @author By RuiCUI
 * 2019-09-04
 * Medium
 * Question 116:Populating Next Right Pointers in Each Node.
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
 * The binary tree has the following definition:
 * 	struct Node {
	  int val;
	  Node *left;
	  Node *right;
	  Node *next;
	}
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Example:
 * Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 * Note:
 * 1. You may only use constant extra space.
 * 2. Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 */
class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode() {}

    public TreeLinkNode(int _val, TreeLinkNode _left, TreeLinkNode _right, TreeLinkNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersInEachNode {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static TreeLinkNode connect(TreeLinkNode root) {
		if(root == null) {
	        return root;
		}
	    if(root.left != null){
	        root.left.next = root.right;
	        if(root.next != null)
	            root.right.next = root.next.left;
	    }
	    connect(root.left);
	    connect(root.right);
	    return root;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public void connect1(TreeLinkNode root) {
	    if(root == null)
	        return;
	    if(root.left != null){
	        root.left.next = root.right;
	        if(root.next != null)
	            root.right.next = root.next.left;
	    }
	    connect(root.left);
	    connect(root.right);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public void connect2(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode cur = root;
        TreeLinkNode nextLeftmost = null;

        while(cur.left!=null){
            nextLeftmost = cur.left; // save the start of next level
            while(cur!=null){
                cur.left.next=cur.right;
                cur.right.next = cur.next==null? null : cur.next.left;
                cur=cur.next;
            }
            cur=nextLeftmost;  // point to next level 
        }
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public void connect3(TreeLinkNode root) {
		TreeLinkNode n = root;
	    while(n != null && n.left != null) {
	    	TreeLinkNode pre = null;
	        for(TreeLinkNode p = n; p != null; p = p.next) {
	            if(pre != null) pre.next = p.left;
	            p.left.next = p.right;
	            pre = p.right;
	        }
	        n = n.left;
	    }
	}
	
	public static void main(String[] args) {
		TreeLinkNode t7 = new TreeLinkNode(7, null, null, null);
		TreeLinkNode t6 = new TreeLinkNode(6, null, null, null);
		TreeLinkNode t5 = new TreeLinkNode(5, null, null, null);
		TreeLinkNode t4 = new TreeLinkNode(4, null, null, null);
		TreeLinkNode t3 = new TreeLinkNode(3, t6, t7, null);
		TreeLinkNode t2 = new TreeLinkNode(2, t4, t5, null);
		TreeLinkNode t1 = new TreeLinkNode(1, t2, t3, null);
		
		System.out.println(connect(t1));
	}

}

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
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
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
	public static Node1 connect(Node1 root) {
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
	public void connect1(Node1 root) {
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
	public void connect2(Node1 root) {
        if(root==null) return;
        Node1 cur = root;
        Node1 nextLeftmost = null;

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
	public void connect3(Node1 root) {
		Node1 n = root;
	    while(n != null && n.left != null) {
	    	Node1 pre = null;
	        for(Node1 p = n; p != null; p = p.next) {
	            if(pre != null) pre.next = p.left;
	            p.left.next = p.right;
	            pre = p.right;
	        }
	        n = n.left;
	    }
	}
	
	public static void main(String[] args) {
		Node1 t7 = new Node1(7, null, null, null);
		Node1 t6 = new Node1(6, null, null, null);
		Node1 t5 = new Node1(5, null, null, null);
		Node1 t4 = new Node1(4, null, null, null);
		Node1 t3 = new Node1(3, t6, t7, null);
		Node1 t2 = new Node1(2, t4, t5, null);
		Node1 t1 = new Node1(1, t2, t3, null);
		
		System.out.println(connect(t1));
	}

}

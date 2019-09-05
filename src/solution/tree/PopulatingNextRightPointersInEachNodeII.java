package solution.tree;

/**
 * @author By RuiCUI
 * 2019-09-05
 * Medium
 * Question 117:Populating Next Right Pointers in Each Node II.
 * Given a binary tree
 * 	struct Node {
	  int val;
	  Node *left;
	  Node *right;
	  Node *next;
	}
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Example:
 * Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 * Note:
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 */
public class PopulatingNextRightPointersInEachNodeII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static TreeLinkNode connect(TreeLinkNode root) {
		if(root == null) return null;
        TreeLinkNode cur = root;
        while(cur != null){
            if(cur.left != null){
                cur.left.next = (cur.right != null) ? cur.right : helper(cur);
            }
            if(cur.right != null){
                cur.right.next = helper(cur);
            }
            cur = cur.next;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
    private static TreeLinkNode helper(TreeLinkNode root){
        TreeLinkNode temp = root.next;
        while(temp != null){
            if(temp.left != null) return temp.left;
            if(temp.right != null) return temp.right;
            temp = temp.next;
        }
        return null;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public void connect1(TreeLinkNode root) {
        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level
        while (cur != null) {
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public void connect2(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0, null, null, null);
            TreeLinkNode currentChild = tempChild;
            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }
            root = tempChild.next;
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
        if(root == null) return;
        TreeLinkNode cur = root;
        while(cur != null){
            if(cur.left != null){
                cur.left.next = (cur.right != null) ? cur.right : getNext(cur);
            }
            if(cur.right != null){
                cur.right.next = getNext(cur);
            }
            cur = cur.next;
        }
        connect(root.left);
        connect(root.right);
    }
    private TreeLinkNode getNext(TreeLinkNode root){
        TreeLinkNode temp = root.next;
        while(temp != null){
            if(temp.left != null) return temp.left;
            if(temp.right != null) return temp.right;
            temp = temp.next;
        }
        return null;
    }
	
	public static void main(String[] args) {
//		TreeLinkNode t6 = new TreeLinkNode(7, null, null, null);
//		TreeLinkNode t5 = new TreeLinkNode(5, null, null, null);
//		TreeLinkNode t4 = new TreeLinkNode(4, null, null, null);
//		TreeLinkNode t3 = new TreeLinkNode(3, null, t6, null);
//		TreeLinkNode t2 = new TreeLinkNode(2, t4, t5, null);
//		TreeLinkNode t1 = new TreeLinkNode(1, t2, t3, null);
		
		TreeLinkNode t5 = new TreeLinkNode(5, null, null, null);
		TreeLinkNode t4 = new TreeLinkNode(4, null, null, null);
		TreeLinkNode t3 = new TreeLinkNode(3, null, t5, null);
		TreeLinkNode t2 = new TreeLinkNode(2, t4, null, null);
		TreeLinkNode t1 = new TreeLinkNode(1, t2, t3, null);
		
		System.out.println(connect(t1));
	}

}

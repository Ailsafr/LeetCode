package solution.tree;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-11-14
 * Medium
 * Question 173:Binary Search Tree Iterator.
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Example:
 * 					7
 * 				  /   \
 * 				 3    15
 * 					 /  \
 * 					9   20
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 * Note:
 * 1. next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 2. You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 */
public class BinarySearchTreeIterator {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(h)
	 * @param root
	 * @return
	 */
	/**
	 * Your BSTIterator object will be instantiated and called as such:
	 * BSTIterator obj = new BSTIterator(root);
	 * int param_1 = obj.next();
	 * boolean param_2 = obj.hasNext();
	 */
	Stack<TreeNode> stack;
	public BinarySearchTreeIterator(TreeNode root) {
		// Stack for the recursion simulation
        this.stack = new Stack<TreeNode>();
        
        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        this._leftmostInorder(root);
    }
    
	private void _leftmostInorder(TreeNode root) {
        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }
	
    /** @return the next smallest number */
    public int next() {
    	// Node at the top of the stack is the next smallest element
        TreeNode topmostNode = this.stack.pop();

        // Need to maintain the invariant. If the node has a right child, call the 
        // helper function for the right child
        if (topmostNode.right != null) {
            this._leftmostInorder(topmostNode.right);
        }

        return topmostNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return this.stack.size() > 0;
    }
	
	/**
	 * 答案1--Flattening the BST
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
//    ArrayList<Integer> nodesSorted;
//    int index;
//
//    public BSTIterator(TreeNode root) {
//
//        // Array containing all the nodes in the sorted order
//        this.nodesSorted = new ArrayList<Integer>();
//        
//        // Pointer to the next smallest element in the BST
//        this.index = -1;
//        
//        // Call to flatten the input binary search tree
//        this._inorder(root);
//    }
//
//    private void _inorder(TreeNode root) {
//
//        if (root == null) {
//            return;
//        }
//
//        this._inorder(root.left);
//        this.nodesSorted.add(root.val);
//        this._inorder(root.right);
//    }
//
//    /**
//     * @return the next smallest number
//     */
//    public int next() {
//        return this.nodesSorted.get(++this.index);
//    }
//
//    /**
//     * @return whether we have a next smallest number
//     */
//    public boolean hasNext() {
//        return this.index + 1 < this.nodesSorted.size();
//    }

    /**
	 * 答案2--Controlled Recursion
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(h)
	 * @param root
	 * @return
	 */
//  Stack<TreeNode> stack;
//	public BinarySearchTreeIterator(TreeNode root) {
//		// Stack for the recursion simulation
//      this.stack = new Stack<TreeNode>();
//      
//      // Remember that the algorithm starts with a call to the helper function
//      // with the root node as the input
//      this._leftmostInorder(root);
//  }
//  
//	private void _leftmostInorder(TreeNode root) {
//      // For a given node, add all the elements in the leftmost branch of the tree
//      // under it to the stack.
//      while (root != null) {
//          this.stack.push(root);
//          root = root.left;
//      }
//  }
//	
//  /** @return the next smallest number */
//  public int next() {
//  	// Node at the top of the stack is the next smallest element
//      TreeNode topmostNode = this.stack.pop();
//
//      // Need to maintain the invariant. If the node has a right child, call the 
//      // helper function for the right child
//      if (topmostNode.right != null) {
//          this._leftmostInorder(topmostNode.right);
//      }
//
//      return topmostNode.val;
//  }
//  
//  /** @return whether we have a next smallest number */
//  public boolean hasNext() {
//  	return this.stack.size() > 0;
//  }
    
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(7);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(15);
		TreeNode t4 = new TreeNode(9);
		TreeNode t5 = new TreeNode(12);
		t3.left = t4;
		t3.right = t5;
		t1.left = t2;
		t1.right = t3;
		
		BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(t1);
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
	}

}

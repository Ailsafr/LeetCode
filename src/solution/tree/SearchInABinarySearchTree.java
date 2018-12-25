package solution.tree;

/**
 * @author By RuiCUI
 * 2018-12-25
 * Easy
 * Question 700:Search in a Binary Search Tree.
 * Given the root node of a binary search tree (BST) and a value. 
 * You need to find the node in the BST that the node's value equals the given value. 
 * Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 * For example, 
 * Given the tree:
	        4
	       / \
	      2   7
	     / \
	    1   3
 * And the value to search: 2
 * You should return this subtree:
	      2     
	     / \   
	    1   3
 * In the example above, if we want to search the value 5, 
 * since there is no node with value 5, we should return NULL.
 * Note that an empty tree is represented by NULL, 
 * therefore you would see the expected output (serialized tree format) as [], not null.
 */
public class SearchInABinarySearchTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(logN)
	 * 空间复杂度：O(1)
	 * @param root
	 * @param val
	 * @return
	 */
	public static TreeNode searchBST(TreeNode root, int val) {
		if(root==null){
			return null;
		}
		if(root.val==val){
			return root;
		}else if(root.val>val){
			return searchBST(root.left, val);
		}else{
			return searchBST(root.right, val);
		}
    }
	
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(logN)
	 * 空间复杂度：O(1)
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode searchBST1(TreeNode root, int val) {
        if(root == null) return root;
        if(root.val == val){
            return root;
        }else{
            return val<root.val? searchBST(root.left,val):searchBST(root.right,val);
        }
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(logN)
	 * 空间复杂度：O(1)
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val<root.val? root.left:root.right;
        }
        return root;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(7);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		t2.left = t4;
		t2.right = t5;
		t1.left = t2;
		t1.right = t3;
		System.out.println(searchBST(t1,2));
	}

}

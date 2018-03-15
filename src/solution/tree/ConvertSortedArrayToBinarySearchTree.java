package solution.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author By RuiCUI
 * 2018-03-15
 * Easy
 * Question 108:Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
	      0
	     / \
	   -3   9
	   /   /
	 -10  5
 */
public class ConvertSortedArrayToBinarySearchTree {

	/**
	 * 我自己写的方法--递归--DFS
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0){
			return null;
		}
		return getChild(0,nums.length,nums);
    }
	
	private static TreeNode getChild(int left,int right,int[] nums){
		if(right-left<=0){
			return null;
		}else if(right-left==1){
			return new TreeNode(nums[left]);
		}
		int mid = left+(right-left)/2;
		TreeNode tree = new TreeNode(nums[mid]);
		tree.left = getChild(left,mid,nums);
		tree.right = getChild(mid+1,right,nums);
		return tree;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的思路一样--DFS solution
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST1(int[] nums) {
	    if (nums.length == 0) {
	        return null;
	    }
	    TreeNode head = helper(nums, 0, nums.length - 1);
	    return head;
	}

	public TreeNode helper(int[] num, int low, int high) {
	    if (low > high) { // Done
	        return null;
	    }
	    int mid = (low + high) / 2;
	    TreeNode node = new TreeNode(num[mid]);
	    node.left = helper(num, low, mid - 1);
	    node.right = helper(num, mid + 1, high);
	    return node;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案--BFS solution
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST2(int[] nums) {
        
        int len = nums.length;
        if ( len == 0 ) { return null; }
        
        // 0 as a placeholder
        TreeNode head = new TreeNode(0); 
        
        Deque<TreeNode> nodeStack       = new LinkedList<TreeNode>() {{ push(head);  }};
        Deque<Integer>  leftIndexStack  = new LinkedList<Integer>()  {{ push(0);     }};
        Deque<Integer>  rightIndexStack = new LinkedList<Integer>()  {{ push(len-1); }};
        
        while ( !nodeStack.isEmpty() ) {
            TreeNode currNode = nodeStack.pop();
            int left  = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid   = left + (right-left)/2; // avoid overflow
            currNode.val = nums[mid];
            if ( left <= mid-1 ) {
                currNode.left = new TreeNode(0);  
                nodeStack.push(currNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid-1);
            }
            if ( mid+1 <= right ) {
                currNode.right = new TreeNode(0);
                nodeStack.push(currNode.right);
                leftIndexStack.push(mid+1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }
	
	public static void main(String[] args) {
		//int[] nums = {-10,-3,0,5,9};
		int[] nums = {};
		TreeNode tree = sortedArrayToBST(nums);
		System.out.println(sortedArrayToBST(nums));
	}

}

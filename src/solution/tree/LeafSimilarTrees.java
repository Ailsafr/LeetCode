package solution.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-03-11
 * Easy
 * Question 872:Leaf-Similar Trees.
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * 				3
 * 			  /   \
 *           5     1
 *          / \   / \
 *         6   2 9   8
 *            / \
 *           7   4
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * Note:
 * Both of the given trees will have between 1 and 100 nodes.
 */
public class LeafSimilarTrees {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(T1+T2) where T1, T2 are the lengths of the given trees.
	 * 空间复杂度：O(T1+T2) where T1, T2 are the lengths of the given trees.
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		helper(root1,list1);
		helper(root2,list2);
		
		int len1 = list1.size();
		int len2 = list2.size();
		if(len1!=len2){
			return false;
		}
		for(int i=0;i<len1;i++){
			if(list1.get(i)!=list2.get(i)){
				return false;
			}
		}
		
        return true;
    }
	
	private static void helper(TreeNode root,List<Integer> result){
		if(root==null){
			return;
		}
		if(root.left==null&&root.right==null){
			result.add(root.val);
		}
		if(root.left!=null){
			helper(root.left,result);
		}
		if(root.right!=null){
			helper(root.right,result);
		}
	}
	
	/**
	 * 答案--Depth First Search
	 * 时间复杂度：O(T1+T2) where T1, T2 are the lengths of the given trees.
	 * 空间复杂度：O(T1+T2) where T1, T2 are the lengths of the given trees.
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null)
                leafValues.add(node.val);
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(6);
		TreeNode t5 = new TreeNode(2);
		TreeNode t6 = new TreeNode(9);
		TreeNode t7 = new TreeNode(8);
		TreeNode t8 = new TreeNode(7);
		TreeNode t9 = new TreeNode(4);
		t5.left = t8;
		t5.right = t9;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t1.left = t2;
		t1.right = t3;
		System.out.println(leafSimilar(t1,t1));
	}

}

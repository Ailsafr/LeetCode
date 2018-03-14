package solution.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2018-03-14
 * Easy
 * Question 107:Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * return its bottom-up level order traversal as:
	[
	  [15,7],
	  [9,20],
	  [3]
	]
 */
public class BinaryTreeLevelOrderTraversalII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root==null){
			return new ArrayList<List<Integer>>();
		}
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		map = getMapList(root,0,map);
		for(List<Integer> list:map.values()){
			resultList.add(list);
		}
		Collections.reverse(resultList);
		return resultList;
    }
	
	private static Map<Integer,List<Integer>> getMapList(TreeNode root,int level,Map<Integer,List<Integer>> map){
		List<Integer> list = map.get(level);
		if(list==null){
			list = new ArrayList<Integer>();
		}
		list.add(root.val);
		map.put(level, list);
		if(root.left!=null){
			map = getMapList(root.left,1+level,map);
		}
		if(root.right!=null){
			map = getMapList(root.right,1+level,map);
		}
		return map;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案--BFS solution
	 * 原来，只需要list.add(0,object)所得list就是倒序，无需用Collections.reverse(list)
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的思维差不多--DFS solution
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(7);
		t3.left = t4;
		t3.right = t5;
		t2.left = t6;
		t1.left = t2;
		t1.right = t3;
		System.out.println(levelOrderBottom(t1));
	}

}

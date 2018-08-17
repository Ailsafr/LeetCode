package solution.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2018-08-17
 * Easy
 * Question 429:N-ary Tree Level Order Traversal.
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example, given a 3-ary tree:
		    1
		 /  |  \
		3   2   4
	   / \
	  5	  6
 * We should return its level order traversal:
	[
	     [1],
	     [3,2,4],
	     [5,6]
	]
 * Note:
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class NaryTreeLevelOrderTraversal {
	
	public static class Node {
	    public int val;
	    public List<Node> children;
	    public Node() {}
	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(NlogN)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null){
			return result;
		}
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		map = helper(0,root,map);
		for(List<Integer> list:map.values()){
			result.add(list);
		}
		return result;
    }
	
	private static Map<Integer,List<Integer>> helper(int level,Node root,Map<Integer,List<Integer>> map){
		List<Integer> list = null;
		if(map.containsKey(level)){
			list = map.get(level);
		}else{
			list = new ArrayList<Integer>();
		}
		list.add(root.val);
		map.put(level, list);
		if(root.children!=null){
			level = level + 1;
			for(Node n:root.children){
				helper(level,n,map);
			}
		}
		return map;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,用的队列
	 * 时间复杂度：O(NlogN)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        
        if (root == null) return ret;
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }
        
        return ret;
    }

	public static void main(String[] args) {
		Node n5 = new Node(5,null);
		Node n6 = new Node(6,null);
		List<Node> list2 = new ArrayList<Node>(){{add(n5);add(n6);}};
		Node n2 = new Node(3,list2);
		Node n3 = new Node(2,null);
		Node n4 = new Node(4,null);
		List<Node> list1 = new ArrayList<Node>(){{add(n2);add(n3);add(n4);}};
		Node n1 = new Node(1,list1);
		System.out.println(levelOrder(n1));
	}

}

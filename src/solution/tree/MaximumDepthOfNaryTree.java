package solution.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//import java.util.Queue;
//import javafx.util.Pair;

/**
 * @author By RuiCUI
 * 2018-10-31
 * Easy
 * Question 559:Maximum Depth of N-ary Tree.
 * Given a n-ary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * For example, given a 3-ary tree:
			 1
		 /	 |	 \
	    3    2    4
	   / \
	  5   6
 * We should return its max depth, which is 3.
 * Note:
 * 1.The depth of the tree is at most 1000.
 * 2.The total number of nodes is at most 5000.
 */
class Nodec {
    public int val;
    public List<Nodec> children;

    public Nodec() {}

    public Nodec(int _val,List<Nodec> _children) {
        val = _val;
        children = _children;
    }
};

public class MaximumDepthOfNaryTree {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(log(n))
	 * @param root
	 * @return
	 */
	public static int maxDepth(Nodec root) {
		int result = 0;
		if(root==null){
			return result;
		}
		if(root.children==null){
			return 1;
		}else{
			List<Nodec> list = root.children;
			int max = 0;
			for(int i=0;i<list.size();i++){
				int res = maxDepth(list.get(i));
				if(res>max){
					max = res;
				}
			}
			return 1+max;
		}
    }
	
	/**
	 * 答案1--Recursion (DFS(Depth First Search)) 跟我的思路一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(log(n))
	 * @param root
	 * @return
	 */
	public int maxDepth1(Nodec root) {
	    if (root == null) {
	    	return 0;
	    } else if (root.children.isEmpty()) {
	    	return 1;  
	    } else {
	    	List<Integer> heights = new LinkedList<>();
	    	for (Nodec item : root.children) {
	    		heights.add(maxDepth(item)); 
	    	}
	    	return Collections.max(heights) + 1;
	    }
	}

	/**
	 * 答案2--Iteration
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	/*public int maxDepth2(Nodec root) {
	    Queue<Pair<Nodec, Integer>> stack = new LinkedList<>();
	    if (root != null) {
	    	stack.add(new Pair(root, 1));
	    }

	    int depth = 0;
	    while (!stack.isEmpty()) {
	      	Pair<Nodec, Integer> current = stack.poll();
	      	root = current.getKey();
	      	int current_depth = current.getValue();
	      	if (root != null) {
	        	depth = Math.max(depth, current_depth);
	        	for (Nodec c : root.children) {
	          	stack.add(new Pair(c, current_depth + 1));    
	        	}
	      	}
	    }
	    return depth;
	}*/
	
	public static void main(String[] args) {
		Nodec n5 = new Nodec(5,null);
		Nodec n6 = new Nodec(5,null);
		Nodec n2 = new Nodec(2,null);
		Nodec n4 = new Nodec(4,null);
		List<Nodec> l2 = new ArrayList<Nodec>();
		l2.add(n5);
		l2.add(n6);
		Nodec n3 = new Nodec(5,l2);
		List<Nodec> l1 = new ArrayList<Nodec>();
		l1.add(n3);
		l1.add(n2);
		l2.add(n4);
		Nodec n1 = new Nodec(1,l1);
		System.out.println(maxDepth(n1));
	}

}

package solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import solution.tree.NaryTreeLevelOrderTraversal.Node;

/**
 * @author By RuiCUI
 * 2018-11-12
 * Easy
 * Question 590:N-ary Tree Postorder Traversal.
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * For example, given a 3-ary tree:
		    1
		 /  |  \
		3   2   4
	   / \
	  5	  6
 * Return its postorder traversal as: [5,6,3,2,4,1].
 * Note:
 * Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePostorderTraversal {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	static List<Integer> list = new ArrayList<>();
	public static List<Integer> postorder(Node root) {
		if (root == null)
            return list;
        for(Node node: root.children)
            postorder(node);
        list.add(root.val);
        return list;
    }
	
	/**
	 * 答案1--Iterations
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static List<Integer> postorder1(Node root) {
		LinkedList<Node> stack = new LinkedList<>();
	    LinkedList<Integer> output = new LinkedList<>();
	    if (root == null) {
	    	return output;
	    }

	    stack.add(root);
	    while (!stack.isEmpty()) {
	    	Node node = stack.pollLast();
	    	output.addFirst(node.val);
	    	for (Node item : node.children) {
	    		if (item != null) {
	    			stack.add(item);    
	    		} 
	    	}
	    }
	    return output;
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
		System.out.println(postorder(n1));
	}

}

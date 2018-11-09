package solution.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import solution.tree.NaryTreeLevelOrderTraversal.Node;

/**
 * @author By RuiCUI
 * 2018-11-09
 * Easy
 * Question 589:N-ary Tree Preorder Traversal.
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * For example, given a 3-ary tree:
		    1
		 /  |  \
		3   2   4
	   / \
	  5	  6
 * Return its preorder traversal as: [1,3,5,6,2,4].
 * Note:
 * Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePreorderTraversal {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null){
			return result;
		}
		result.add(root.val);
		if(root.children!=null){
			for(int i=0;i<root.children.size();i++){
				result.addAll(preorder(root.children.get(i)));
			}
		}
		return result;
    }
	
	/**
	 * 答案1--Iterations
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public List<Integer> preorder1(Node root) {
	    LinkedList<Node> stack = new LinkedList<>();
	    LinkedList<Integer> output = new LinkedList<>();
	    if (root == null) {
	      return output;
	    }
	    stack.add(root);
	    while (!stack.isEmpty()) {
		    Node node = stack.pollLast();
		    output.add(node.val);
		    Collections.reverse(node.children);
		    for (Node item : node.children) {
		        stack.add(item);
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
		System.out.println(preorder(n1));
	}

}

package solution.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-11-21
 * Easy
 * Question 606:Construct String from Binary Tree.
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()". 
 * And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
	       1
	     /   \
	    2     3
	   /    
	  4     
 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())", 
 * but you need to omit all the unnecessary empty parenthesis pairs. 
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
	       1
	     /   \
	    2     3
	     \  
	      4 
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example, 
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class ConstructStringFromBinaryTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param t
	 * @return
	 */
	public static String tree2str(TreeNode t) {
		if(t==null){
			return "";
		}
		if(t.left==null&&t.right==null){
			return t.val+"";
		}
		if(t.left==null){
			return t.val+"()("+tree2str(t.right)+")";
		}
		if(t.right==null){
			return t.val+"("+tree2str(t.left)+")";
		}
		return  t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
	
	/**
	 * 答案1--Using Recursion[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param t
	 * @return
	 */
	public String tree2str1(TreeNode t){
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";   
    }
	
	/**
	 * 答案2--Iterative Method Using stack[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param t
	 * @return
	 */
	public String tree2str2(TreeNode t) {
        if (t == null)
            return "";
        Stack < TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set < TreeNode > visited = new HashSet < > ();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(4);
		t1.left = t3;
		t.left = t1;
		t.right = t2;
		System.out.println(tree2str(t));
	}

}

package solution.tree;

import java.util.HashSet;

/**
 * @author By RuiCUI
 * 2018-11-06
 * Easy
 * Question 572:Subtree of Another Tree.
 * Given two non-empty binary trees s and t, 
 * check whether tree t has exactly the same structure and node values with a subtree of s. 
 * A subtree of s is a tree consists of a node in s and all of this node's descendants. 
 * The tree s could also be considered as a subtree of itself.
 * Example 1:
 * Given tree s:
	     3
	    / \
	   4   5
	  / \
	 1   2
 * Given tree t:
	   4 
	  / \
	 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
	     3
	    / \
	   4   5
	  / \
	 1   2
	    /
	   0
 * Given tree t:
	   4
	  / \
	 1   2
 * Return false.
 * Hint:
 * 1.Which approach is better here-recursive or iterative?
 * 2.If recursive approach is better, can you write recursive function with its parameters?
 * 3.Two trees s and t are said to be identical if their root values are same and their left and right subtrees are identical.Can you write this in form of recursive formulae?
 * 4.Recursive formulae can be: isIdentical(s,t)= s.val==t.val AND isIdentical(s.left,t.left) AND isIdentical(s.right,t.right).
 */
public class SubtreeOfAnotherTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isSubtree(TreeNode s, TreeNode t) {
		if(s==null&&t!=null){
			return false;
		}
		if(isIdentical(s, t)){
			return true;
		}
		return isSubtree(s.left,t)||isSubtree(s.right,t);
    }
	
	private static boolean isIdentical(TreeNode s,TreeNode t){
		if(s==null&&t==null){
			return true;
		}else if(s==null){
			return false;
		}else if(t==null){
			return false;
		}
		return s.val==t.val&&isIdentical(s.left,t.left)&&isIdentical(s.right,t.right);
	}
	
	/**
	 * 答案1--Using Preorder Traversal[Accepted]
	 * 时间复杂度：O(m^2+n^2+m*n)
	 * 空间复杂度：O(max(m,n))
	 * @param s
	 * @param t
	 * @return
	 */
	HashSet < String > trees = new HashSet < > ();
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }
    public String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
    }
	
	/**
	 * 答案2--By Comparison of Nodes[Accepted],跟我的思路一样
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @param t
	 * @return
	 */
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    public boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
	
	public static void main(String[] args) {
		TreeNode s = new TreeNode(3);
		TreeNode s1 = new TreeNode(4);
		TreeNode s2 = new TreeNode(5);
		TreeNode s3 = new TreeNode(1);
		TreeNode s4 = new TreeNode(2);
		s1.left = s3;
		s1.right = s4;
		s.left = s1;
		s.right = s2;
		TreeNode t = new TreeNode(4);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t.left = t1;
		t.right = t2;
		System.out.println(isSubtree(s,t));
	}

}

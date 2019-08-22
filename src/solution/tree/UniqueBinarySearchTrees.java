package solution.tree;

/**
 * @author By RuiCUI
 * 2019-08-22
 * Medium
 * Question 96:Unique Binary Search Trees.
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
 */
public class UniqueBinarySearchTrees {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param n
	 * @return
	 */
	public static int numTrees(int n) {
		int [] G = new int[n+1];
	    G[0] = G[1] = 1;
	    
	    for(int i=2; i<=n; ++i) {
	    	for(int j=1; j<=i; ++j) {
	    		G[i] += G[j-1] * G[i-j];
	    	}
	    }
	    return G[n];
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param n
	 * @return
	 */
	public int numTrees1(int n) {
	    int [] G = new int[n+1];
	    G[0] = G[1] = 1;
	    
	    for(int i=2; i<=n; ++i) {
	    	for(int j=1; j<=i; ++j) {
	    		G[i] += G[j-1] * G[i-j];
	    	}
	    }
	    return G[n];
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public int numTrees2(int n) {
	    long ans = 1;
	    for(int i=n+1;i<=2*n;i++){
	        ans = ans*i/(i-n);
	    }
	    return (int) (ans/(n+1));
	}
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(numTrees(n));
	}

}

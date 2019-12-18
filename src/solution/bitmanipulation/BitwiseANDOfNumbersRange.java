package solution.bitmanipulation;

/**
 * @author By RuiCUI
 * 2019-12-18
 * Medium
 * Question 201:Bitwise AND of Numbers Range.
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * Example 1:
 * Input: [5,7]
 * Output: 4
 * Example 2:
 * Input: [0,1]
 * Output: 0.
 */
public class BitwiseANDOfNumbersRange {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param m
	 * @param n
	 * @return
	 */
	public static int rangeBitwiseAnd(int m, int n) {
		while(m<n) 
			n = n & (n-1);
        return n;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param m
	 * @param n
	 * @return
	 */
	public int rangeBitwiseAnd1(int m, int n) {
	    int i = 0;
	    for (; m != n; ++i) {
	        m >>= 1;
	        n >>= 1;
	    }
	    return n << i;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param m
	 * @param n
	 * @return
	 */
	public int rangeBitwiseAnd2(int m, int n) {
	    int r=Integer.MAX_VALUE;
	    while((m&r)!=(n&r))  r=r<<1;
	    return n&r;
	}
	
	public static void main(String[] args) {
		int m = 5;
		int n = 7;
		System.out.println(rangeBitwiseAnd(m, n));
	}

}

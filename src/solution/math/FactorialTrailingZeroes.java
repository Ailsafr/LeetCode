package solution.math;

/**
 * @author By RuiCUI
 * 2018-04-20
 * Easy
 * Question 172:Factorial Trailing Zeroes.
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {

	/**
	 * 我自己写的方法--看的别人的答案，因为我没做出来，一脸懵逼啊，这什么题，然后没想到如此简单。。。
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
    public static int trailingZeroes(int n) {
    	return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
    
    /**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
    public static int trailingZeroes1(int n) {
        int cnt = 0;
        while(n>0){
            cnt += n/5;
            n/=5;
        }
        return cnt;
    }
	
	public static void main(String[] args) {
		int n= 29;
		System.out.println(trailingZeroes(n));
	}

}

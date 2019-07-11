package solution.math;

/**
 * @author By RuiCUI
 * 2019-07-11
 * Medium
 * Question 50:Pow(x, n).
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/(2^2) = 1/4 = 0.25
 * Note:
 * 1. -100.0 < x < 100.0
 * 2. n is a 32-bit signed integer, within the range [−2^31, 2^31−1].
 */
public class Powxn {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param x
	 * @param n
	 * @return
	 */
	public static double myPow(double x, int n) {
		if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow1(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow1(x*x, n/2) : x*myPow1(x*x, n/2);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow2(double x, int n) {
	    long m = n > 0 ? n : -(long)n;
	    double ans = 1.0;
	    while (m != 0) {
	        if ((m & 1) == 1)
	            ans *= x;
	        x *= x;
	        m >>= 1;
	    }
	    return n >= 0 ? ans : 1 / ans;
	}
	
	public static void main(String[] args) {
		double x = 2.00000;
		int n = -2;
		System.out.println(myPow(x,n));
	}

}

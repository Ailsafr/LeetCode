package solution.math;

/**
 * @author By RuiCUI
 * 2018-06-26
 * Easy
 * Question 231:Power of Two.
 * Given an integer, write a function to determine if it is a power of two.
 * Example 1:
 * Input: 1
 * Output: true 
 * Explanation: 20 = 1
 * Example 2:
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 * Input: 218
 * Output: false
 */
public class PowerOfTwo {

	/**
	 * 我自己写的方法
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwo(int n) {
		if(n>=Integer.MAX_VALUE||n<=Integer.MIN_VALUE){
			return false;
		}
		String str = Integer.toBinaryString(n);
		if(str.startsWith("1")&&!str.substring(1).contains("1")){
			return true;
		}
		return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,巧妙的用了与运算
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo1(int n) {//if n is power  of  2 ,n just has one bit is 1
	    return n>0 && (n&(n-1))==0;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,用了bitCount函数
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo2(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo3(int n) {
		if(n==0) return false;
		while(n%2==0) n/=2;
		return (n==1);
	}
	
	public static void main(String[] args) {
		int n = -2147483648;
		System.out.println(isPowerOfTwo(n));
	}

}

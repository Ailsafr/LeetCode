package solution.math;

/**
 * @author By RuiCUI
 * 2018-07-20
 * Easy
 * Question 342:Power of Four.
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 * Credits:
 * Special thanks to @yukuairoy for adding this problem and creating all test cases.
 */
public class PowerOfFour {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(log4n) 4为底数
	 * 空间复杂度：O(1)
	 * @param num
	 * @return
	 */
	public static boolean isPowerOfFour(int num) {
		if (num < 1) {
            return false;
        }
        while (num % 4 == 0) {
        	num /= 4;
        }
        return num == 1;
    }
	
	/**
	 * 官网没有solution,这是仿照了Power Of Three的答案
	 * 时间复杂度：O(log4n) 4为底数
	 * 空间复杂度：O(log4n) 4为底数
	 * @param num
	 * @return
	 */
	public static boolean isPowerOfFour1(int num) {
		return Integer.toString(num, 4).matches("^10*$");
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param num
	 * @return
	 */
	public boolean isPowerOfFour2(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position 
    }
	
	public static void main(String[] args) {
		int n = 16;
		System.out.println(isPowerOfFour(n));
	}

}

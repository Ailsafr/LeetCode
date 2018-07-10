package solution.math;

/**
 * @author By RuiCUI
 * 2018-07-10
 * Easy
 * Question 263:Ugly Number.
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * Example 1:
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * Example 3:
 * Input: 14
 * Output: false 
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * Note:
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range:[−2^31,2^31−1].
 */
public class UglyNumber {

	/**
	 * 我自己写的方法
	 * @param num
	 * @return
	 */
	public static boolean isUgly(int num) {
		if(num<1){
			return false;
		}
		while(num>1){
			if(num%2==0){
				num = num/2;
			}else if(num%3==0){
				num = num/3;
			}else if(num%5==0){
				num = num/5;
			}else{
				return false;
			}
		}
		return true;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param num
	 * @return
	 */
	public static boolean isUgly1(int num) {
		for (int i=2; i<6 && num>0; i++)
		    while (num % i == 0)
		        num /= i;
		return num == 1;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param num
	 * @return
	 */
	public boolean isUgly2(int num) {
	    if(num==1) return true;
	    if(num==0) return false;
		while(num%2==0) num=num>>1;
		while(num%3==0) num=num/3;
		while(num%5==0) num=num/5;
	    return num==1;
	}
	
	public static void main(String[] args) {
		int num = 8;
		System.out.println(isUgly(num));
	}

}

package solution.math;

/**
 * @author By RuiCUI
 * 2018-10-10
 * Easy
 * Question 504:Base 7.
 * Given an integer, return its base 7 string representation.
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 */
public class Base7 {

	/**
	 * 我自己写的方法
	 * @param num
	 * @return
	 */
	public static String convertToBase7(int num) {
		return Integer.toString(num, 7);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param num
	 * @return
	 */
	public String convertToBase71(int num) {
	    if (num < 0)
	        return '-' + convertToBase71(-num);
	    if (num < 7)
	        return num + "";
	    return convertToBase71(num / 7) + num % 7;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,跟上面的方法思路差不多
	 * @param num
	 * @return
	 */
	public String convertToBase72(int num) {
        if (num == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        
        if (num < 0) {
            negative = true;
        }
        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num = num / 7;
        }
        
        if (negative) {
            sb.append("-");
        }
        
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		int n = 100;
		System.out.println(convertToBase7(n));
	}

}

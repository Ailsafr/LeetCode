package solution.math;

/**
 * @author By RuiCUI
 * 2018-08-06
 * Easy
 * Question 400:Nth Digit.
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
 * Example 1:
 * Input:
 * 3
 * Output:
 * 3
 * Example 2:
 * Input:
 * 11
 * Output:
 * 0
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */
public class NthDigit {

	/**
	 * 我自己写的方法,没有思路,参考的别人的答案
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public static int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public static int findNthDigit1(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public int findNthDigit2(int n) {
	    n -= 1;
	    int digits = 1, first = 1;
	    while (n / 9 / first / digits >= 1) {
	        n -= 9 * first * digits;
	        digits++;
	        first *= 10;
	    }
	    return (first + n/digits + "").charAt(n%digits) - '0';
	}
	
	public static void main(String[] args) {
		int n = 11;
		System.out.println(findNthDigit(n));
	}

}

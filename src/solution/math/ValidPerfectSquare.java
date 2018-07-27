package solution.math;

/**
 * @author By RuiCUI
 * 2018-07-27
 * Easy
 * Question 367:Valid Perfect Square.
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 * Example 1:
 * Input: 16
 * Returns: True
 * Example 2:
 * Input: 14
 * Returns: False
 */
public class ValidPerfectSquare {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param num
	 * @return
	 */
	public static boolean isPerfectSquare(int num) {
		if(num<2){
			return true;
		}
		int left = 0;
		int right = num;
		while(left+1<right){
			int middle = left + (right-left)/2;
			if(middle>46340){
				right = middle;
				continue;
			}
			if(middle*middle==num){
				return true;
			}else if(middle*middle<num){
				left = middle;
			}else{
				right = middle;
			}
		}
		return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,很巧妙,但是不懂原理
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare1(int num) {
	     int i = 1;
	     while (num > 0) {
	         num -= i;
	         i += 2;
	     }
	     return num == 0;
	 }
	
	/**
	 * 官网没有solution,这是其他人的答案,用了long类型来避免超过最大int
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare2(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare3(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param num
	 * @return
	 */
	public boolean solution(int num) {
	    int root = 0, bit = 1 << 15;
	    while (bit > 0) {
	        root |= bit;
	        if (root > num / root) {    // if root * root > num
	            root ^= bit;    // set the bit back to 0
	        }
	        bit >>= 1;
	    }
	    return root * root == num;
	}
	
	public static void main(String[] args) {
		int n = 808201;
		System.out.println(isPerfectSquare(n));
	}

}

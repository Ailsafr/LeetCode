package solution.bitmanipulation;

/**
 * @author By RuiCUI
 * 2018-12-20
 * Easy
 * Question 693:Binary Number with Alternating Bits.
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 * Example 2:
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 * Example 3:
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 * Example 4:
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 */
public class BinaryNumberWithAlternatingBits {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public static boolean hasAlternatingBits(int n) {
		String str = Integer.toBinaryString(n);
		int len = str.length();
		if(len<2){
			return true;
		}
		for(int i=0;i<len-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				return false;
			}
		}
		return true;
    }
    
    /**
	 * 答案1--Convert to String[Accepted]
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public boolean hasAlternatingBits1(int n) {
        String bits = Integer.toBinaryString(n);
        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
    
    /**
	 * 答案2--Divide By Two[Accepted]
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public boolean hasAlternatingBits2(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) return false;
            cur = n % 2;
            n /= 2;
        }
        return true;
    }
    
	public static void main(String[] args) {
		int n = 5;
		System.out.println(hasAlternatingBits(n));
	}

}

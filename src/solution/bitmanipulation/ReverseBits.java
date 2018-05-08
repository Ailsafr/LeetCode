package solution.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-05-07
 * Easy
 * Question 190:Reverse Bits.
 * Reverse bits of a given 32 bits unsigned integer.
 * Example:
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
 * return 964176192 represented in binary as 00111001011110000010100101000000.
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
	
	/**
	 * 我自己写的方法,不太对，没有考虑到特殊情况
	 * @param n
	 * @return
	 */
	public static int reverseBits(int n) {
		if(n>Integer.MAX_VALUE||n<Integer.MIN_VALUE){
			return n;
		}
		String s = Integer.toBinaryString(n);
		int len = s.length();
		for(int i=len;i<32;i++){
			s = "0" + s;
		}
		s = new StringBuilder(s).reverse().toString();  
		if(s.charAt(0)=='1'){
			int result = 0;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)!='0'){
					result += Math.pow(2, 31-i);
				}
			}
			return result;
		}
		return Integer.parseInt(s, 2);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案，利用位运算
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public static int reverseBits1(int n) {
	    if (n == 0) return 0;
	    
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        result <<= 1;
	        if ((n & 1) == 1) result++;
	        n >>= 1;
	    }
	    return result;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案，利用位运算
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public static int reverseBits2(int n) {
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        result += n & 1;
	        n >>>= 1;   // CATCH: must do unsigned shift
	        if (i < 31) // CATCH: for last digit, don't shift!
	            result <<= 1;
	    }
	    return result;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案，优化版
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
	public int reverseBits3(int n) {
	    byte[] bytes = new byte[4];
	    for (int i = 0; i < 4; i++) // convert int into 4 bytes
	        bytes[i] = (byte)((n >>> 8*i) & 0xFF);
	    int result = 0;
	    for (int i = 0; i < 4; i++) {
	        result += reverseByte(bytes[i]); // reverse per byte
	        if (i < 3)
	            result <<= 8;
	    }
	    return result;
	}

	private int reverseByte(byte b) {
	    Integer value = cache.get(b); // first look up from cache
	    if (value != null)
	        return value;
	    value = 0;
	    // reverse by bit
	    for (int i = 0; i < 8; i++) {
	        value += ((b >>> i) & 1);
	        if (i < 7)
	            value <<= 1;
	    }
	    cache.put(b, value);
	    return value;
	}
	
	public static void main(String[] args) {
		//int n = 43261596;
		int n = 1;
		//int n = 0;
		System.out.println(reverseBits1(n));
	}

}

package solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-05-09
 * Easy
 * Question 1018:Binary Prefix Divisible By 5.
 * Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)
 * Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
 * Example 1:
 * Input: [0,1,1]
 * Output: [true,false,false]
 * Explanation: 
 * The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
 * Example 2:
 * Input: [1,1,1]
 * Output: [false,false,false]
 * Example 3:
 * Input: [0,1,1,1,1,1]
 * Output: [true,false,false,false,true,false]
 * Example 4:
 * Input: [1,1,1,0,1]
 * Output: [false,false,false,false,false]
 * Note:
 * 1 <= A.length <= 30000
 * A[i] is 0 or 1.
 * Hint:
 * 1. If X is the first i digits of the array as a binary number, then 2X + A[i] is the first i+1 digits.
 */
public class BinaryPrefixDivisibleBy5 {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public static List<Boolean> prefixesDivBy5(int[] A) {
		List<Boolean> result = new ArrayList<Boolean>();
		int num = 0;
		for(int n:A){
			num = num*2 + n;
			if(num%5==0){
				result.add(true);
			}else{
				result.add(false);
			}
			num %= 5;
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public List<Boolean> prefixesDivBy51(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int current = 0;
        for (int i:A){
            current = (current*2+i)%10;
            result.add(current%5==0);
        }
        return result;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public List<Boolean> prefixesDivBy52(int[] A) {
        int currSum = 0;
        List<Boolean> result = new ArrayList<>();
        
        for (int binaryDigit : A) {
            currSum = ((currSum << 1) + binaryDigit) % 5;
            result.add(currSum == 0);
        }
        
        return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public List<Boolean> prefixesDivBy53(int[] A){
		List<Boolean>  resp = new ArrayList<Boolean>();
		int total=0;
		for(int i=0;i<A.length;i++){
			total=total*2+A[i];
			if(total%5==0){
				resp.add(true);
			}else{
				resp.add(false);
			}
            total%=5;
		}	
		return resp; 
	}
	
	public static void main(String[] args) {
		int[] A = {1,1,1,0,1};
		System.out.println(prefixesDivBy5(A));
	}
}

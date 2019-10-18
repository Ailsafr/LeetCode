package solution.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-10-18
 * Medium
 * Question 137:Single Number II.
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Example 1:
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 * Input: [0,1,0,1,0,1,99]
 * Output: 99.
 */
public class SingleNumberII {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		int three = 0;
		for (int n : nums) {
			sum += n;
			if (set.contains(n)) {
				three += n;
			}
			set.add(n);
		}
		return sum - (three/2)*3;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static int singleNumber1(int[] nums) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < nums.length; i++){
	        ones = (ones ^ nums[i]) & ~twos;
	        twos = (twos ^ nums[i]) & ~ones;
	    }
	    return ones;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int singleNumber2(int[] nums) {
	    int ans = 0;
	    for(int i = 0; i < 32; i++) {
	        int sum = 0;
	        for(int j = 0; j < nums.length; j++) {
	            if(((nums[j] >> i) & 1) == 1) {
	                sum++;
	                sum %= 3;
	            }
	        }
	        if(sum != 0) {
	            ans |= sum << i;
	        }
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,2,3,2};
		System.out.println(singleNumber1(nums));
	}

}

package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2018-11-01
 * Easy
 * Question 561:Array Partition I.
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) 
 * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * Example 1:
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * 1.n is a positive integer, which is in the range of [1, 10000].
 * 2.All the integers in the array will be in the range of [-10000, 10000].
 * Hint:
 * 1.Obviously, brute force won't help here. Think of something else, take some example like 1,2,3,4.
 * 2.How will you make pairs to get the result? There must be some pattern.
 * 3.Did you observe that- Minimum element gets add into the result in sacrifice of maximum element.
 * 4.Still won't able to find pairs? Sort the array and try to find the pattern.
 */
public class ArrayPartitionI {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		int result = 0;
		if(len==0){
			return result;
		}
		for(int i=0;i<len;i+=2){
			result += nums[i];
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int arrayPairSum1(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
	 
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public int arrayPairSum2(int[] nums) {
		int[] exist = new int[20001];
		for (int i = 0; i < nums.length; i++) {
			exist[nums[i] + 10000]++;
		}
		int sum = 0;
		boolean odd = true;
		for (int i = 0; i < exist.length; i++) {
			while (exist[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				odd = !odd;
				exist[i]--;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,4,3,2};
		System.out.println(arrayPairSum(nums));
	}
}

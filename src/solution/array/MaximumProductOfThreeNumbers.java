package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2018-11-27
 * Easy
 * Question 628:Maximum Product of Three Numbers.
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * Note:
 * 1.The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * 2.Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class MaximumProductOfThreeNumbers {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(nlog(n))
	 * 空间复杂度：O(log(n))
	 * @param nums
	 * @return
	 */
	public static int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		return Math.max(nums[len-1]*nums[len-2]*nums[len-3], nums[0]*nums[1]*nums[len-1]);
    }
	
	/**
	 * 答案1--Using Sorting[Accepted]
	 * 时间复杂度：O(nlog(n))
	 * 空间复杂度：O(log(n))
	 * @param nums
	 * @return
	 */
	 public int maximumProduct1(int[] nums) {
		 Arrays.sort(nums);
		 return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
     }
	
	/**
	 * 答案2--Single Scan[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	 public int maximumProduct2(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(maximumProduct(nums));
	}
}

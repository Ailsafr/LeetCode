package solution.dynamicprogramming;

/**
 * @author By RuiCUI
 * 2019-11-04
 * Medium
 * Question 152:Maximum Product Subarray.
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums[0];
		int min = nums[0];
		int result = nums[0];
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			int tmp = max;
			max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
			min = Math.min(Math.min(tmp*nums[i], min*nums[i]), nums[i]);
			if (max > result) {
				result = max;
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public int maxProduct1(int[] A) {
	    if (A.length == 0) {
	        return 0;
	    }
	    
	    int maxherepre = A[0];
	    int minherepre = A[0];
	    int maxsofar = A[0];
	    int maxhere, minhere;
	    
	    for (int i = 1; i < A.length; i++) {
	        maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
	        minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
	        maxsofar = Math.max(maxhere, maxsofar);
	        maxherepre = maxhere;
	        minherepre = minhere;
	    }
	    return maxsofar;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public int maxProduct2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

	public static void main(String[] args) {
		int[] nums = {-2,0,-1};
		System.out.println(maxProduct(nums));
	}

}

package solution.array;

/**
 * @author By RuiCUI
 * 2018-12-12
 * Easy
 * Question 674:Longest Continuous Increasing Subsequence.
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
 * Note: Length of the array will not exceed 10,000.
 */
public class LongestContinuousIncreasingSubsequence {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static int findLengthOfLCIS(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		int result = 1;
		int max = 1;
		for(int i=0;i<nums.length-1;i++){
			if(nums[i+1]>nums[i]){
				max++;
			}else{
				if(result<max){
					result = max;
				}
				max = 1;
			}
		}
		if(result<max){
			result = max;
		}
		return result;
    }
	
	/**
	 * 答案--Sliding Window[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int findLengthOfLCIS1(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
	
	public static void main(String[] args) {
		//int[] nums = {2,2,2,2,2};
		//int[] nums = {7, 1, 5, 3, 6, 4};
		//int[] nums = {7, 6, 4, 3, 1};
		int[] nums = {1,3,5,4,7};
		System.out.println(findLengthOfLCIS(nums));
	}

}

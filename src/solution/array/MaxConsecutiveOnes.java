package solution.array;

/**
 * @author By RuiCUI
 * 2018-09-28
 * Easy
 * Question 485:Max Consecutive Ones.
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000.
 */
public class MaxConsecutiveOnes {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static int findMaxConsecutiveOnes(int[] nums) {
		int result = 0;
		int tmp = -1;
		int len = nums.length;
		for(int i=0;i<len;i++){
			if(nums[i]==0){
				result = i-tmp-1>result?i-1-tmp:result;
				tmp = i;
			}
		}
		result = len-1-tmp>result?len-1-tmp:result;
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int findMaxConsecutiveOnes1(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max; 
    } 
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int findMaxConsecutiveOnes2(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
	        	count++;
	        	result = Math.max(count, result);
            }
            else count = 0;
        }
        return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,很巧妙
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int findMaxConsecutiveOnes3(int[] nums) {
        int maxSum = 0, sum = 0;
        for (int n : nums) {
            sum *= n;
            sum += n;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
	
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(findMaxConsecutiveOnes(nums));
	}
}

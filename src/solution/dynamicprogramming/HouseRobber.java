package solution.dynamicprogramming;

/**
 * @author By RuiCUI
 * 2018-05-15
 * Easy
 * Question 198:House Robber.
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Example 1:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

	/**
	 * 我自己写的方法--Time Limit Exceeded
	 * 时间复杂度：O(2^n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static int rob(int[] nums) {
		int len = nums.length;
		if(len==0){
			return 0;
		}
		if(len==1){
			return nums[0];
		}
		if(len==2){
			return Math.max(nums[0], nums[1]);
		}
		int[] nums1 = new int[len-2];
		int[] nums2 = new int[len-3];
		for(int i=0;i<len-3;i++){
			nums1[i] = nums[i];
			nums2[i] = nums[i];
		}
		nums1[len-3] = nums[len-3];
		return Math.max(nums[len-1]+rob(nums1), nums[len-2]+rob(nums2));
    }
	
	/**
	 * 官网没有solution,这是其他人的答案--dp[i][1] means we rob the current house and dp[i][0] means we don't.
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public int rob1(int[] nums) {
	    int[][] dp = new int[nums.length + 1][2];
	    for (int i = 1; i <= nums.length; i++) {
	        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
	        dp[i][1] = nums[i - 1] + dp[i - 1][0];
	    }
	    return Math.max(dp[nums.length][0], dp[nums.length][1]);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案--上面方法的简化版
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int rob2(int[] nums) {
	    int prevNo = 0;
	    int prevYes = 0;
	    for (int n : nums) {
	        int temp = prevNo;
	        prevNo = Math.max(prevNo, prevYes);
	        prevYes = n + temp;
	    }
	    return Math.max(prevNo, prevYes);
	}
    
	/**
	 * 官网没有solution,这是其他人的答案--动态规划
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static int rob3(int[] nums) {  
	    if(nums.length==0) return 0;
	    if(nums.length==1) return nums[0];

		int[] mark = new int[nums.length];

		mark[0] = nums[0];
		mark[1] = Math.max(nums[0], nums[1]);

	    //Using Dynamic Programming to mark the max money in loop.
		for(int i=2;i<nums.length;i++){
			mark[i] = Math.max(nums[i]+mark[i-2], mark[i-1]);
		}
		return mark[nums.length-1];
	}
	
	public static void main(String[] args) {
		//int[] nums = {1,2,3,1};
		//int[] nums = {2,7,9,3,1};
		int[] nums = {2,1,1,2};
		System.out.println(rob3(nums));
	}

}

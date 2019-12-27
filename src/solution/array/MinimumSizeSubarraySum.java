package solution.array;

/**
 * @author By RuiCUI
 * 2019-12-27
 * Medium
 * Question 209:Minimum Size Subarray Sum.
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead.
 * Example: 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 */
public class MinimumSizeSubarraySum {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param s
	 * @param nums
	 * @return
	 */
	public static int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
	    int ans = Integer.MAX_VALUE;
	    int left = 0;
	    int sum = 0;
	    for (int i = 0; i < n; i++) {
	        sum += nums[i];
	        while (sum >= s) {
	            ans = Math.min(ans, i + 1 - left);
	            sum -= nums[left++];
	        }
	    }
	    return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
	
	/**
	 * 答案1--Brute force [Time Limit Exceeded]
	 * 时间复杂度：O(n^3) 
	 * 空间复杂度：O(1)
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen1(int s, int[] nums)
	{
	    int n = nums.length;
	    int ans = Integer.MAX_VALUE;
	    for (int i = 0; i < n; i++) {
	        for (int j = i; j < n; j++) {
	            int sum = 0;
	            for (int k = i; k <= j; k++) {
	                sum += nums[k];
	            }
	            if (sum >= s) {
	                ans = Math.min(ans, (j - i + 1));
	                break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
	            }
	        }
	    }
	    return (ans != Integer.MAX_VALUE) ? ans : 0;
	}
	
	/**
	 * 答案2--A better brute force [Accepted]
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen2(int s, int[] nums)
	{
	    int n = nums.length;
	    if (n == 0)
	        return 0;
	    int ans = Integer.MAX_VALUE;
	    int[] sums = new int[n];
	    sums[0] = nums[0];
	    for (int i = 1; i < n; i++)
	        sums[i] = sums[i - 1] + nums[i];
	    for (int i = 0; i < n; i++) {
	        for (int j = i; j < n; j++) {
	            int sum = sums[j] - sums[i] + nums[i];
	            if (sum >= s) {
	                ans = Math.min(ans, (j - i + 1));
	                break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
	            }
	        }
	    }
	    return (ans != Integer.MAX_VALUE) ? ans : 0;
	}
	
	/**
	 * 答案3--Using Binary search [Accepted]
	 * 时间复杂度：O(nlogn) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen3(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    private int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
           int mid = (lo + hi) / 2;
           if (sums[mid] >= key){
               hi = mid - 1;
           } else {
               lo = mid + 1;
           }
        }
        return lo;
    }
	
	/**
	 * 答案4--Using 2 pointers [Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen4(int s, int[] nums)
	{
	    int n = nums.length;
	    int ans = Integer.MAX_VALUE;
	    int left = 0;
	    int sum = 0;
	    for (int i = 0; i < n; i++) {
	        sum += nums[i];
	        while (sum >= s) {
	            ans = Math.min(ans, i + 1 - left);
	            sum -= nums[left++];
	        }
	    }
	    return (ans != Integer.MAX_VALUE) ? ans : 0;
	}
	
	public static void main(String[] args) {
		int s = 7;
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(s, nums));
	}

}

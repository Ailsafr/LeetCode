package solution.array;

/**
 * @author By RuiCUI
 * 2018-11-30
 * Easy
 * Question 643:Maximum Average Subarray I.
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. 
 * And you need to output the maximum average value.
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * Note:
 * 1.1 <= k <= n <= 30,000.
 * 2.Elements of the given array will be in the range [-10,000, 10,000].
 */
public class MaximumAverageSubarrayI {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param k
	 * @return
	 */
	public static double findMaxAverage(int[] nums, int k) {
		int len = nums.length;
		int sum = 0;
		for(int i=0;i<k;i++){
			sum += nums[i];
		}
		int result = sum;
		for(int i=0;i<len-k;i++){
			int num = sum - nums[i] + nums[i+k];
			sum = num;
			if(num>result){
				result = num;
			}
		}
		return (double)result/k;
    }
	
	/**
	 * 答案1--Cumulative Sum[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param k
	 * @return
	 */
	public double findMaxAverage1(int[] nums, int k) {
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
		sum[i] = sum[i - 1] + nums[i];
		double res = sum[k - 1] * 1.0 / k;
		for (int i = k; i < nums.length; i++) {
			res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
		}
		return res;
	}
	
	/**
	 * 答案2--Sliding Window[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param k
	 * @return
	 */
	public double findMaxAverage2(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++)
            sum+=nums[i];
        double res=sum;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
                res=Math.max(res,sum);
        }
        return res/k;
    }
	
	public static void main(String[] args) {
		//int[] nums = {1,12,-5,-6,50,3};
		int[] nums = {4,2,1,3,3};
		int k = 2;
		System.out.println(findMaxAverage(nums,k));
	}

}

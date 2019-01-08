package solution.array;

/**
 * @author By RuiCUI
 * 2019-01-08
 * Easy
 * Question 724:Find Pivot Index.
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 * If no such index exists, we should return -1. 
 * If there are multiple pivot indexes, you should return the left-most pivot index.
 * Example 1:
 * Input: 
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation: 
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * Example 2:
 * Input: 
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation: 
 * There is no index that satisfies the conditions in the problem statement.
 * Note:
 * 1.The length of nums will be in the range [0, 10000].
 * 2.Each element nums[i] will be an integer in the range [-1000, 1000].
 * Hint:
 * We can precompute prefix sums P[i] = nums[0] + nums[1] + ... + nums[i-1]. 
 * Then for each index, the left sum is P[i], and the right sum is P[P.length - 1] - P[i] - nums[i].
 */
public class FindPivotIndex {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static int pivotIndex(int[] nums) {
		if(nums==null||nums.length<2){
			return -1;
		}
		int len = nums.length;
		int[] sum = new int[len];
		sum[0] = nums[0];
		for(int i=1;i<len;i++){
			sum[i] = sum[i-1]+nums[i];
		}
		if(sum[len-1]-sum[0]==0){
			return 0;
		}
		for(int i=1;i<len;i++){
			if(sum[i-1]==sum[len-1]-sum[i]){
				return i;
			}
		}
		return -1;
    }
	
	/**
	 * 答案1--Prefix Sum[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int pivotIndex1(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
	
	public static void main(String[] args) {
		//int[] nums = {1, 7, 3, 6, 5, 6};
		//int[] nums = {1, 2, 3};
		int[] nums = {-1,-1,-1,0,1,1};
		System.out.println(pivotIndex(nums));
	}

}

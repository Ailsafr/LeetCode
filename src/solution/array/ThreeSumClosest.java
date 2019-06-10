package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2019-06-10
 * Medium
 * Question 16:3Sum Closest.
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		boolean plus = true;
		for(int i=0;i<len-2;i++){
			int start = i + 1;
			int end = len - 1;
			while(start<end){
				if(nums[i]+nums[start]+nums[end]==target){
					return target;
				}else if(nums[i]+nums[start]+nums[end]>target){
					if(nums[i]+nums[start]+nums[end]-target<min){
						min = nums[i]+nums[start]+nums[end]-target;
						plus = true;
					}
					end--;
				}else{
					if(target-(nums[i]+nums[start]+nums[end])<min){
						min = target-(nums[i]+nums[start]+nums[end]);
						plus = false;
					}
					start++;
				}
			}
		}
		return plus?target+min:target-min;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest1(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,2};
		int target = 3;
		System.out.println(threeSumClosest(nums, target));
	}
}

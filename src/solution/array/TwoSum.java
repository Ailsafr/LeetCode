package solution.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2017-12-26
 * Question:Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
	
	/**
	 * 我自己写的方法（跟方法1思想一致，细节少了异常抛出和返回处理）
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if((nums[i]+nums[j])==target){
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
    }
	
	/**
	 * 答案1--循环遍历
	 * 时间复杂度：O(n2) n的平方
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum1(int[] nums, int target) {
	    for (int i = 0; i < nums.length; i++) {
	        for (int j = i + 1; j < nums.length; j++) {
	            if (nums[j] == target - nums[i]) {
	                return new int[] { i, j };
	            }
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	/**
	 * 答案2--遍历两次哈希表
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	/**
	 * 答案3--遍历一次哈希表
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	/**
	 * 注意Array的打印方法Arrays.toString(array)
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] nums = {2, 7, 11, 15};
		//int target = 9;
		//int[] nums = {3,2,4};
		//int target = 6;
		//int[] nums = {0,4,3,0};
		//int target = 0;
		int[] nums = {-1,-2,-3,-4,-5};
		int target = -8;
		int[] result = twoSum(nums,target);
		System.out.println(Arrays.toString(result));
	}

}

package solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-06-06
 * Medium
 * Question 15:3Sum.
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 *	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
 */
public class ThreeSum {
	
	/**
	 * 我自己写的方法--Time Limit Exceeded
	 * 时间复杂度：O(n^3)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		int len = nums.length;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				for(int k=j+1;k<len;k++){
					if(nums[i]+nums[j]+nums[k]==0){
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						if(!set.contains(list)){
							set.add(list);
							result.add(list);
						}
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum1(int[] nums) {
		Set<List<Integer>> res  = new HashSet<>();
	    if(nums.length==0) return new ArrayList<>(res);
	    Arrays.sort(nums);
	    for(int i=0; i<nums.length-2;i++){
	        int j =i+1;
	        int  k = nums.length-1;
	        while(j<k){
	            int sum = nums[i]+nums[j]+nums[k];
	            if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
	            else if (sum>0) k--;
	            else if (sum<0) j++;
	        }
        }
        return new ArrayList<>(res);
    }
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
	}
}

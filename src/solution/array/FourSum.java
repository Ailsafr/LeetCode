package solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2019-06-12
 * Medium
 * Question 18:4Sum.
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
	[
	  [-1,  0, 0, 1],
	  [-2, -1, 1, 2],
	  [-2,  0, 0, 2]
	]
 */
public class FourSum {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n^3)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int n:nums){
			map.put(n, map.getOrDefault(n, 0)+1);
		}
		Arrays.sort(nums);
		int len = nums.length;
		for(int i=0;i<len-2;i++){
			for(int j=i+1;j<len-1;j++){
				int start = j + 1;
				int end = len - 1;
				while(start<end){
					if(nums[i]+nums[start]+nums[end]+nums[j]==target){
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[start]);
						list.add(nums[end]);
						if(!result.contains(list)){
							result.add(list);
						}
						start++;
						end--;
					}else if(nums[i]+nums[start]+nums[end]+nums[j]>target){
						end--;
					}else{
						start++;
					}
				}
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n^3)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum1(int[] num, int target) {
	    ArrayList<List<Integer>> ans = new ArrayList<>();
	    if(num.length<4)return ans;
	    Arrays.sort(num);
	    for(int i=0; i<num.length-3; i++){
	        if(num[i]+num[i+1]+num[i+2]+num[i+3]>target)break; //first candidate too large, search finished
	        if(num[i]+num[num.length-1]+num[num.length-2]+num[num.length-3]<target)continue; //first candidate too small
	        if(i>0&&num[i]==num[i-1])continue; //prevents duplicate result in ans list
	        for(int j=i+1; j<num.length-2; j++){
	            if(num[i]+num[j]+num[j+1]+num[j+2]>target)break; //second candidate too large
	            if(num[i]+num[j]+num[num.length-1]+num[num.length-2]<target)continue; //second candidate too small
	            if(j>i+1&&num[j]==num[j-1])continue; //prevents duplicate results in ans list
	            int low=j+1, high=num.length-1;
	            while(low<high){
	                int sum=num[i]+num[j]+num[low]+num[high];
	                if(sum==target){
	                    ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
	                    while(low<high&&num[low]==num[low+1])low++; //skipping over duplicate on low
	                    while(low<high&&num[high]==num[high-1])high--; //skipping over duplicate on high
	                    low++; 
	                    high--;
	                }
	                //move window
	                else if(sum<target)low++; 
	                else high--;
	            }
	        }
	    }
	    return ans;
	}
	 
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n^3)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int second = 0, third = 0, nexti = 0, nextj = 0;
        for(int i=0, L=nums.length; i<L-3; i++) {
            if(nums[i]<<2 > target) return list; // return immediately
            for(int j=L-1; j>i+2; j--) {
                if(nums[j]<<2 < target) break; // break immediately
                int rem = target-nums[i]-nums[j];
                int lo = i+1, hi=j-1;
                while(lo<hi) {
                    int sum = nums[lo] + nums[hi];
                    if(sum>rem) --hi;
                    else if(sum<rem) ++lo;
                    else {
                        list.add(Arrays.asList(nums[i],nums[lo],nums[hi],nums[j]));
                        while(++lo<=hi && nums[lo-1]==nums[lo]) continue; // avoid duplicate results
                        while(--hi>=lo && nums[hi]==nums[hi+1]) continue; // avoid duplicate results
                    }
                }
                while(j>=1 && nums[j]==nums[j-1]) --j; // skip inner loop
            }
            while(i<L-1 && nums[i]==nums[i+1]) ++i; // skip outer loop
        }
        return list;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n^3)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	int len = 0;
    public List<List<Integer>> fourSum3(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
   private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(index >= len) {
            return res;
        }
        if(k == 2) {
        	int i = index, j = len - 1;
        	while(i < j) {
                //find a pair
        	    if(target - nums[i] == nums[j]) {
        	    	List<Integer> temp = new ArrayList<>();
                	temp.add(nums[i]);
                	temp.add(target-nums[i]);
                    res.add(temp);
                    //skip duplication
                    while(i<j && nums[i]==nums[i+1]) i++;
                    while(i<j && nums[j-1]==nums[j]) j--;
                    i++;
                    j--;
                //move left bound
        	    } else if (target - nums[i] > nums[j]) {
        	        i++;
                //move right bound
        	    } else {
        	        j--;
        	    }
        	}
        } else{
            for (int i = index; i < len - k + 1; i++) {
                //use current number to reduce ksum into k-1sum
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                if(temp != null){
                    //add previous results
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		System.out.println(fourSum(nums,target));
	}
}

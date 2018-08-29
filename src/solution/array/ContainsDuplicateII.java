package solution.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2018-05-25
 * Easy
 * Question 219:Contains Duplicate II.
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * Example 1:
 * Input: [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * Input: [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 * Input: [1,2,1], k = 0
 * Output: false
 */
public class ContainsDuplicateII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(map.get(nums[i])==null){
				map.put(nums[i], i);
			}else{
				int temp = map.put(nums[i],i);
				if(i-temp<=k){
					return true;
				}
			}
		}
		return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,利用Set，元素不可重复集合，对于已经存在的元素，则返回false
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的答案差不多
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        if (map.containsKey(nums[i])) {
	            if (i - map.get(nums[i]) <= k) return true;
	        }
	        map.put(nums[i], i);
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,1};
		int k = 1;
		System.out.println(containsNearbyDuplicate(nums,k));
	}

}

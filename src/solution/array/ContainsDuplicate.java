package solution.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2018-05-24
 * Easy
 * Question 118:Contains Duplicate.
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * Example 1:
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {

	/**
	 * 我自己写的方法--跟答案3差不多
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static boolean containsDuplicate(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(map.get(nums[i])==null){
				map.put(nums[i], nums[i]);
			}else{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 答案1--Naive Linear Search [Time Limit Exceeded]
	 * 时间复杂度：O(n2) n的平方 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate1(int[] nums) {
	    for (int i = 0; i < nums.length; ++i) {
	        for (int j = 0; j < i; ++j) {
	            if (nums[j] == nums[i]) return true;  
	        }
	    }
	    return false;
	}
	
	/**
	 * 答案2--Sorting
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate2(int[] nums) {
	    Arrays.sort(nums);
	    for (int i = 0; i < nums.length - 1; ++i) {
	        if (nums[i] == nums[i + 1]) return true;
	    }
	    return false;
	}
	
	/**
	 * 答案3--Hash Table
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate3(int[] nums) {
	    Set<Integer> set = new HashSet<>(nums.length);
	    for (int x: nums) {
	        if (set.contains(x)) return true;
	        set.add(x);
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(containsDuplicate(nums));
	}

}

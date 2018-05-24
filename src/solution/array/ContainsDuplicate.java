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
	 * ���Լ�д�ķ���--����3���
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
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
	 * ��1--Naive Linear Search [Time Limit Exceeded]
	 * ʱ�临�Ӷȣ�O(n2) n��ƽ�� 
	 * �ռ临�Ӷȣ�O(1)
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
	 * ��2--Sorting
	 * ʱ�临�Ӷȣ�O(nlogn)
	 * �ռ临�Ӷȣ�O(1)
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
	 * ��3--Hash Table
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
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

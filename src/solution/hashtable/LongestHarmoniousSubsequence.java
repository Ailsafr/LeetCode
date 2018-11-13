package solution.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-11-13
 * Easy
 * Question 594:Longest Harmonious Subsequence.
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 * Now, given an integer array, 
 * you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Note: The length of the input array will not exceed 20,000.
 */
public class LongestHarmoniousSubsequence {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static int findLHS(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		Arrays.sort(nums);
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int len = nums.length;
		for(int i=0;i<len;i++){
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		int result = 0;
		for(int key:map.keySet()){
			if(map.containsKey(key+1)){
				result = Math.max(result,map.get(key)+map.get(key+1));
			}
		}
		return result;
    }
	
	/**
	 * 答案1--Brute Force[Time Limit Exceeded]
	 * 时间复杂度：O(2^n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int findLHS1(int[] nums) {
        int res = 0;
        for (int i = 0; i < (1 << nums.length); i++) {
            int count = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    count++;
                }
            }
            if (max - min == 1)
                res = Math.max(res, count);
        }
        return res;
    }
	
	/**
	 * 答案2--Better Brute Force[Time Limit Exceeded]
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int findLHS2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i])
                    count++;
                else if (nums[j] + 1 == nums[i]) {
                    count++;
                    flag = true;
                }
            }
            if (flag)
                res = Math.max(count, res);
        }
        return res;
    }
    
    /**
	 * 答案3--Using Sorting[Accepted]
	 * 时间复杂度：O(nlogn) 
	 * 空间复杂度：O(logn)
	 * @param nums
	 * @return
	 */
	public int findLHS3(int[] nums) {
        Arrays.sort(nums);
        int prev_count = 1, res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (i > 0 && nums[i] - nums[i - 1] == 1) {
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                res = Math.max(res, count + prev_count);
                prev_count = count;
            } else {
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                prev_count = count;
            }
        }
        return res;
    }
    
    /**
	 * 答案4--Using HashMap[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public int findLHS4(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }
	
	/**
	 * 答案5--In single loop[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public int findLHS5(int[] nums) {
        HashMap < Integer, Integer > map = new HashMap < > ();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1))
                res = Math.max(res, map.get(num) + map.get(num + 1));
            if (map.containsKey(num - 1))
                res = Math.max(res, map.get(num) + map.get(num - 1));
        }
        return res;
    }
	
	public static void main(String[] args) {
		//int[] nums = {1,3,2,2,5,2,3,7};
		int[] nums = {1,3,5,7};
		System.out.println(findLHS(nums));
	}

}

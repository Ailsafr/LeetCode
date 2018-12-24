package solution.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-12-24
 * Easy
 * Question 697:Degree of an Array.
 * Given a non-empty array of non-negative integers nums, 
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, 
 * that has the same degree as nums.
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation: 
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * 1.nums.length will be between 1 and 50,000.
 * 2.nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfAnArray {

	/**
	 * 我自己写的方法-Time Limit Exceeded
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static int findShortestSubArray(int[] nums) {
		int max = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int len = nums.length;
		String str = "";
		for(int i=0;i<len;i++){
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
			if(map.get(nums[i])>map.getOrDefault(max, 0)){
				max = nums[i];
			}
			str += nums[i] + "";
		}
		int first = -1;
		int last = 0;
		for(int i=0;i<len;i++){
			if(nums[i]==max){
				if(first==-1){
					first = i;
				}
				last = i;
			}
		}
		return last-first+1;
    }
	
	/**
	 * 答案--Left and Right Index[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public int findShortestSubArray1(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
            right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		//int[] nums = {1, 2, 2, 3, 1};
		//int[] nums = {1,2,2,3,1,4,2};
		//int[] nums = {1,1,2,2,2,1};
		int[] nums = {49999,100,2,100,100,4,100};
		System.out.println(findShortestSubArray(nums));
	}

}

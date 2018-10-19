package solution.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-10-19
 * Easy
 * Question 532:K-diff Pairs in an Array.
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. 
 * Here a k-diff pair is defined as an integer pair (i, j), 
 * where i and j are both numbers in the array and their absolute difference is k.
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * 1.The pairs (i, j) and (j, i) count as the same pair.
 * 2.The length of the array won't exceed 10,000.
 * 3.All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class KDiffPairsInAnArray {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findPairs(int[] nums, int k) {
		int len = nums.length;
		int result = 0;
		if(nums==null||len<2||k<0){
			return result;
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<len;i++){
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		for(int i:map.keySet()){
			if(k==0){
				if(map.getOrDefault(i,0)>1){
					result += 1;
				}
			}else{
				if(map.getOrDefault(i+k,0)!=0){
					result += 1;
				}
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的思路一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findPairs1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findPairs2(int[] nums, int k) {
	    int ans = 0;
	    Arrays.sort(nums);
	    for (int i = 0, j = 0; i < nums.length; i++) {
	        for (j = Math.max(j, i + 1); j < nums.length && (long) nums[j] - nums[i] < k; j++) ;
	        if (j < nums.length && (long) nums[j] - nums[i] == k) ans++;
	        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
	    }
	    return ans;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param k
	 * @return
	 */
	public  int findPairs3(int[] nums, int k) {
		if(k<0 || nums.length<=1){
		    return 0;
		}
			 
		Arrays.sort(nums);
		int count = 0;
		int left = 0;
		int right = 1;
 
		while(right<nums.length){
		    int firNum = nums[left];
		    int secNum = nums[right];
		    // If less than k, increase the right index
			if(secNum-firNum<k){
			    right++;
			}
			// If larger than k, increase the left index
			else if(secNum - firNum>k){
			    left++;   
			}
			// If equal, move left and right to next different number
			else{
			    count++;
			    while(left<nums.length && nums[left]==firNum){
			        left++;
			    }
			    while(right<nums.length && nums[right]==secNum){
			        right++;
			    }
			}
			//left and right should not be the same number
			if(right==left){
			  	right++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		int k = -1;
		System.out.println(findPairs(nums,k));
	}
}

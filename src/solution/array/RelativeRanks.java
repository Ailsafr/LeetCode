package solution.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-10-11
 * Easy
 * Question 506:Relative Ranks.
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, 
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * 1.N is a positive integer and won't exceed 10,000.
 * 2.All the scores of athletes are guaranteed to be unique.
 */
public class RelativeRanks {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static String[] findRelativeRanks(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int len = nums.length;
		String[] result = new String[len];
		for(int i=0;i<len;i++){
			map.put(nums[i], i+1);
		}
		Arrays.sort(nums);
		for(int i=len-1;i>=0;i--){
			if(i==len-1){
				result[map.get(nums[i])-1] = "Gold Medal";
			}else if(i==len-2){
				result[map.get(nums[i])-1] = "Silver Medal";
			}else if(i==len-3){
				result[map.get(nums[i])-1] = "Bronze Medal";
			}else{
				result[map.get(nums[i])-1] = len - i + "";
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的思路一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public String[] findRelativeRanks1(int[] nums) {
        Integer[] index = new Integer[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        
        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            }
            else if (i == 1) {
                result[index[i]] = "Silver Medal";
            }
            else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            }
            else {
                result[index[i]] = (i + 1) + "";
            }
        }

        return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public String[] findRelativeRanks2(int[] nums) {
        String[] result = new String[nums.length];
        int max = 0;
        for (int i : nums) {
            if (i > max) max = i;
        }
        int[] hash = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] = i + 1;
        }
        int place = 1;
        for (int i = hash.length - 1; i >= 0; i--) {
            if (hash[i] != 0) {
                if (place == 1) {
                    result[hash[i] - 1] = "Gold Medal";
                } else if (place == 2) {
                    result[hash[i] - 1] = "Silver Medal";
                } else if (place == 3) {
                    result[hash[i] - 1] = "Bronze Medal";
                } else {
                    result[hash[i] - 1] = String.valueOf(place);
                }
                place++;
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 4, 3, 2, 5};
		String[] ss = findRelativeRanks(nums);
		System.out.println(ss);
	}
}

package solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-04-11
 * Easy
 * Question 167:Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSumIIInputArrayIsSorted {

	/**
	 * 我自己写的方法，没有好好利用排好序这个条件
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] numbers, int target) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[] result = new int[2];
		for(int i=0;i<numbers.length;i++){
			int rest = target - numbers[i];
			if(map.containsKey(rest)){
				result[0] = map.get(rest);
				result[1] = i+1;
				return result;
			}
			map.put(numbers[i], i+1);
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,好巧妙啊
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum1(int[] numbers, int target) {
		int l = 0, r = numbers.length - 1;
	    while (numbers[l] + numbers[r] != target) {
	        if (numbers[l] + numbers[r] > target) r--;
	        else l++;
	    }
	    return new int[]{l + 1, r + 1};
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] num, int target) {
	    int[] indice = new int[2];
	    if (num == null || num.length < 2) return indice;
	    int left = 0, right = num.length - 1;
	    while (left < right) {
	        int v = num[left] + num[right];
	        if (v == target) {
	            indice[0] = left + 1;
	            indice[1] = right + 1;
	            break;
	        } else if (v > target) {
	            right --;
	        } else {
	            left ++;
	        }
	    }
	    return indice;
	}
	
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		System.out.println(twoSum(numbers,target));
	}

}

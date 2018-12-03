package solution.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-12-03
 * Easy
 * Question 645:Set Mismatch.
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, 
 * one of the numbers in the set got duplicated to another number in the set, 
 * which results in repetition of one number and loss of another number.
 * Given an array nums representing the data status of this set after the error. 
 * Your task is to firstly find the number occurs twice and then find the number that is missing. 
 * Return them in the form of an array.
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * 1.The given array size will in the range [2, 10000].
 * 2.The given array's numbers won't have any order.
 */
public class SetMismatch {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static int[] findErrorNums(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[] result = new int[2];
		int len = nums.length;
		for(int i=0;i<len;i++){
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		for(int i=0;i<len;i++){
			if(!map.containsKey(i+1)){
				result[1] = i+1;
			}
			if(map.get(nums[i])==2){
				result[0] = nums[i];
			}
		}
		return result;
    }
	
	/**
	 * 答案1--Brute Force[Time Limit Exceeded]
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums1(int[] nums) {
        int dup = -1, missing = -1;
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i)
                    count++;
            }
            if (count == 2)
                dup = i;
            else if (count == 0)
                missing = i;
        }
        return new int[] {dup, missing};
    }
	
	/**
	 * 答案2--Better Brute Force[Time Limit Exceeded]
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums2(int[] nums) {
        int dup = -1, missing = -1;;
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i)
                    count++;
            }
            if (count == 2)
                dup = i;
            else if (count == 0)
                missing = i;
            if (dup > 0 && missing > 0)
                break;
        }
        return new int[] {dup, missing};
    }
	
	/**
	 * 答案3--Using Sorting[Accepted]
	 * 时间复杂度：O(nlogn) 
	 * 空间复杂度：O(logn)
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums3(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                dup = nums[i];
            else if (nums[i] > nums[i - 1] + 1)
                missing = nums[i - 1] + 1;
        }
        return new int[] {dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }
	
	/**
	 * 答案4--Using map[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums4(int[] nums) {
        Map <Integer, Integer> map = new HashMap<Integer,Integer>();
        int dup = -1, missing = 1;
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2)
                    dup = i;
            } else
                missing = i;
        }
        return new int[]{dup, missing};
    }
	
	/**
	 * 答案5--Using Extra Array[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums5(int[] nums) {
        int[] arr = new int[nums.length + 1];
        int dup = -1, missing = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                missing = i;
            else if (arr[i] == 2)
                dup = i;
        }
        return new int[]{dup, missing};
    }
	
	/**
	 * 答案6--Using Constant Space[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums6(int[] nums) {
        int dup = -1, missing = 1;
        for (int n: nums) {
            if (nums[Math.abs(n) - 1] < 0)
                dup = Math.abs(n);
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{dup, missing};
    }
	
	/**
	 * 答案7--Using XOR[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums7(int[] nums) {
        int xor = 0, xor0 = 0, xor1 = 0;
        for (int n: nums)
            xor ^= n;
        for (int i = 1; i <= nums.length; i++)
            xor ^= i;
        int rightmostbit = xor & ~(xor - 1);
        for (int n: nums) {
            if ((n & rightmostbit) != 0)
                xor1 ^= n;
            else
                xor0 ^= n;
        }
        for (int i = 1; i <= nums.length; i++) {
            if ((i & rightmostbit) != 0)
                xor1 ^= i;
            else
                xor0 ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == xor0)
                return new int[]{xor0, xor1};
        }
        return new int[]{xor1, xor0};
    }
    
	public static void main(String[] args) {
		int[] nums = {1,2,2,4};
		System.out.println(findErrorNums(nums));
	}

}

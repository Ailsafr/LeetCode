package solution.bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-03-29
 * Easy
 * Question 136:Single Number.
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
	
	/**
	 * 我自己写的方法,利用HashMap
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(map.get(nums[i])!=null&&map.get(nums[i])==nums[i]){
				map.remove(nums[i]);
			}else{
				map.put(nums[i], nums[i]);
			}
		}
		return map.keySet().iterator().next();
    }
	
	/**
	 * 我自己写的方法,利用排序
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(0)
	 * @param nums
	 * @return
	 */
	public static int singleNumber1(int[] nums) {
		Arrays.parallelSort(nums);
		for(int i=0;i<nums.length-1;i+=2){
			if(nums[i]!=nums[i+1]){
				return nums[i];
			}
		}
		return nums[nums.length-1];
    }
	
	/**
	 * 答案--位运算  异或  xor运算  ^ (相同位相同为0，不同为1)
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int singleNumber2(int[] nums) {
	    int ans =0;
	    int len = nums.length;
	    for(int i=0;i!=len;i++)
	        ans ^= nums[i];
	    return ans;
	}
	
	public static void main(String[] args) {
		//int[] nums = {1};
		int[] nums = {2,1,2,3,1};
		System.out.println(singleNumber1(nums));
	}

}

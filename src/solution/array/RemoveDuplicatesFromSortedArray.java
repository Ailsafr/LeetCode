package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2018-01-11
 * Easy
 * Question 026:Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArray {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n2) n的平方
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		int num = 0;
		if(nums==null){
			return 0;
		}
		for(int i=0;i<nums.length-num-1;i++){
			if(nums[i]==nums[i+1]){
				for(int j=i+1;j<nums.length-1;j++){
					nums[j] = nums[j+1];
				}
				num += 1;
				i--;
			}
		}
		nums = Arrays.copyOf(nums, nums.length-num);
		System.out.println(Arrays.toString(nums));
		return nums.length;
    }
	
	/**
	 * 答案--两个指针
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates1(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}
	
	public static void main(String[] args) {
		//int[] nums = {1,1,2};
		int[] nums = {1,1,1,1,2};
		System.out.println(removeDuplicates1(nums));
	}

}

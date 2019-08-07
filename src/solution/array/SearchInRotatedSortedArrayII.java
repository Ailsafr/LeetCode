package solution.array;

/**
 * @author By RuiCUI
 * 2019-08-07
 * Medium
 * Question 81:Search in Rotated Sorted Array II.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedSortedArrayII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static boolean search(int[] nums, int target) {
		for(int n:nums){
			if(n==target){
				return true;
			}
		}
		return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean search1(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean search2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == target) return true;
            if(nums[m] == nums[i]) i++;   //"duplicate", jump
            else if(nums[m] > nums[i]) {
                if(nums[m] > target && nums[i] <= target) j = m - 1; 
                else i = m + 1;
            } else {
                if(nums[m] < target && nums[j] >= target) i = m + 1;
                else j = m - 1;
            }
        }
        return false;
    }
	 
	public static void main(String[] args) {
		int[] nums = {2,5,6,0,0,1,2};
		int target = 0;
		System.out.println(search(nums,target));
	}

}

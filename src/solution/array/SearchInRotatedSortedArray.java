package solution.array;

/**
 * @author By RuiCUI
 * 2019-06-27
 * Easy
 * Question 561:Search in Rotated Sorted Array.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1.
 */
public class SearchInRotatedSortedArray {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int search(int[] nums, int target) {
		int len = nums.length;
		return helper(nums,0,len-1,target);
    }
	private static int helper(int[]nums, int start, int end, int target){
		int mid = start + (end-start)/2;
		while(start<=end){
			if(nums[mid]==target){
				return mid;
			}else{
				return Math.max(helper(nums,start,mid-1,target),helper(nums,mid+1,end,target));
			}
		}
		return -1;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,比我的答案好
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
        
            if (nums[start] <= nums[mid]){
                 if (target < nums[mid] && target >= nums[start]) 
                    end = mid - 1;
                 else
                    start = mid + 1;
            } 
        
            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                 else
                    end = mid - 1;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {5,1,3};
		int target = 5;
		System.out.println(search(nums, target));
	}
}

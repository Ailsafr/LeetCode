package solution.binarysearch;

/**
 * @author By RuiCUI
 * 2018-12-27
 * Easy
 * Question 704:Binary Search.
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. 
 * If target exists, then return its index, otherwise return -1.
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * Note:
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 */
public class BinarySearch {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int search(int[] nums, int target) {
		int len = nums.length-1;
		return help(0,len,target,nums);
    }
	
	public static int help(int left,int right,int target,int[] nums){
		if(left<=right){
			int mid = left+(right-left)/2;
			if(nums[mid]==target){
				return mid;
			}else if(nums[mid]<target){
				return help(mid+1,right,target,nums);
			}else{
				return help(left,mid-1,target,nums);
			}
		}
		return -1;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search1(int[] nums, int target) {
	    int lo = 0;
	    int hi = nums.length - 1;
	    while(lo <= hi){
	    	int mid = (lo + hi) >>> 1;
	    	if(nums[mid] < target)
	    		lo = mid + 1;
	    	else if(nums[mid] > target)
	    		hi = mid - 1;
	    	else
	    		return mid;
	    }
	    return -1;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search2(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target = 9;
		System.out.println(search(nums,target));
	}
	
}

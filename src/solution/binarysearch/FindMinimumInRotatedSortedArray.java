package solution.binarysearch;

/**
 * @author By RuiCUI
 * 2019-11-05
 * Medium
 * Question 153:Find Minimum in Rotated Sorted Array.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * Example 1:
 * Input: [3,4,5,1,2] 
 * Output: 1
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * Hint:
 * 1. Array was originally in ascending order. Now that the array is rotated, there would be a point in the array where there is a small deflection from the increasing sequence. eg. The array would be something like [4, 5, 6, 7, 0, 1, 2].
 * 2. You can divide the search space into two and see which direction to go. Can you think of an algorithm which has O(logN) search complexity?
 * 3. All the elements to the left of inflection point > first element of the array.
 *    All the elements to the right of inflection point < first element of the array.
 */
public class FindMinimumInRotatedSortedArray {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		int res = nums[0];
		return helper(left, right, nums, res);
    }
	private static int helper(int left, int right, int[] nums, int res) {
		while(left <= right) {
			int mid = left + (right - left)/2;
			if (nums[mid] < res) {
				res = nums[mid];
			}
			if (nums[mid] > nums[left]) {
				if (nums[mid] < nums[right]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] < nums[right]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return res;
	}
	
	/**
	 * 答案--Binary Search
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int findMin1(int[] nums) {
	    // If the list has just one element then return that element.
	    if (nums.length == 1) {
	    	return nums[0];
	    }
	    // initializing left and right pointers.
	    int left = 0, right = nums.length - 1;
	    // if the last element is greater than the first element then there is no rotation.
	    // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
	    // Hence the smallest element is first element. A[0]
	    if (nums[right] > nums[0]) {
	    	return nums[0];
	    }
	    // Binary search way
	    while (right >= left) {
	    	// Find the mid element
	    	int mid = left + (right - left) / 2;
	    	// if the mid element is greater than its next element then mid+1 element is the smallest
	    	// This point would be the point of change. From higher to lower value.
	    	if (nums[mid] > nums[mid + 1]) {
	    		return nums[mid + 1];
	    	}
	    	// if the mid element is lesser than its previous element then mid element is the smallest
	    	if (nums[mid - 1] > nums[mid]) {
	    		return nums[mid];
	    	}
	    	// if the mid elements value is greater than the 0th element this means
	    	// the least value is still somewhere to the right as we are still dealing with elements
	    	// greater than nums[0]
	    	if (nums[mid] > nums[0]) {
	    		left = mid + 1;
	    	} else {
	    		// if nums[0] is greater than the mid value then this means the smallest value is somewhere to
	    		// the left
	    		right = mid - 1;
	    	}
	    }
	    return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,4,5,1,2};
		System.out.println(findMin(nums));
	}
	
}

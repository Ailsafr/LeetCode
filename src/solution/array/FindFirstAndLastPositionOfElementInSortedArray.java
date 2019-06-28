package solution.array;

/**
 * @author By RuiCUI
 * 2019-06-28
 * Medium
 * Question 34:Find First and Last Position of Element in Sorted Array.
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1].
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(logn) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange(int[] nums, int target) {
		int[] targetRange = {-1, -1};
        int leftIdx = helper(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = helper(nums, target, false)-1;

        return targetRange;
    }
	private static int helper(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }
        return lo;
    }
	
	/**
	 * 答案1--Linear Scan
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1) 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange1(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }

        if (targetRange[0] == -1) {
            return targetRange;
        }

        for (int j = nums.length-1; j >= 0; j--) {
            if (nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }

        return targetRange;
    }
	
	/**
	 * 答案2--Binary Search
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1) 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange2(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIdx = extremeInsertionIndex(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
	private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }
        return lo;
    }
	
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		System.out.println(searchRange(nums,target));
	}

}

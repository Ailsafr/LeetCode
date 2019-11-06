package solution.binarysearch;

/**
 * @author By RuiCUI
 * 2019-11-06
 * Medium
 * Question 162:Find Peak Element.
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] �� nums[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -��.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5 
 * Explanation: Your function can return either index number 1 where the peak element is 2, 
 * or index number 5 where the peak element is 6.
 * Note:
 * Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(logn)
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @return
	 */
	public static int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int len = nums.length;
		if (len == 1 || nums[0] > nums[1]) {
			return 0;
		}
		if (nums[len-1] > nums[len-2]) {
			return len - 1;
		}
		int left = 1;
		int right = len - 2;
		return helper(left, right, nums);
    }
	private static int helper(int left, int right, int[] nums) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
				return mid;
			}
			int n = helper(left, mid - 1, nums);
			return n != -1 ? n : helper(mid + 1, right, nums);
		}
		return -1;
	}
	
	/**
	 * ��1--Linear Scan
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @return
	 */
	public int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
	
	/**
	 * ��2--Recursive Binary Search
	 * ʱ�临�Ӷȣ�O(logn)
	 * �ռ临�Ӷȣ�O(logn)
	 * @param nums
	 * @return
	 */
	public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
	
	/**
	 * ��3--Iterative Binary Search
	 * ʱ�临�Ӷȣ�O(logn)
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @return
	 */
    public int findPeakElement3(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,1,3,5,6,4};
		System.out.println(findPeakElement(nums));
	}
	
}

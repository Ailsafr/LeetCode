package solution.array;

/**
 * @author By RuiCUI
 * 2019-01-17
 * Easy
 * Question 747:Largest Number At Least Twice of Others.
 * In a given integer array nums, there is always exactly one largest element.
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * If it is, return the index of the largest element, otherwise return -1.
 * Example 1:
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 * Note:
 * 1.nums will have a length in the range [1, 50].
 * 2.Every nums[i] will be an integer in the range [0, 99].
 * Hint:
 * Scan through the array to find the unique largest element `m`, keeping track of it's index `maxIndex`. 
 * Scan through the array again. If we find some `x != m` with `m < 2*x`, we should return `-1`. 
 * Otherwise, we should return `maxIndex`.
 */
public class LargestNumberAtLeastTwiceOfOthers {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static int dominantIndex(int[] nums) {
		int max = nums[0];
		int second = Integer.MIN_VALUE;
		int index = 0;
		int len = nums.length;
		if(len==1){
			return 0;
		}
		for(int i=1;i<len;i++){
			if(nums[i]>max){
				second = max;
				max = nums[i];
				index = i;
			}else if(nums[i]>second){
				second = nums[i];
			}
		}
		if(max>=second*2){
			return index;
		}
		return -1;
    }
	
	/**
	 * 答案1--Linear Scan[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int dominantIndex1(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }
	
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(dominantIndex(nums));
	}

}

package solution.array;

/**
 * @author By RuiCUI
 * 2019-07-30
 * Medium
 * Question 75:Sort Colors.
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
 * then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static void sortColors(int[] nums) {
		if(nums==null||nums.length<2){
			return;
		}
		int len = nums.length;
		int first = 0;
		int last = len - 1;
		int tmp = 0;
		while(tmp<=last){
			if(nums[tmp]==0){
				nums[tmp] = nums[first];
				nums[first] = 0;
				first++;
			}else if(nums[tmp]==2){
				nums[tmp] = nums[last];
				nums[last] = 2;
				last--;
				tmp--;
			}
			tmp++;
		}
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public void sortColors1(int[] nums) {
	    int p1 = 0, p2 = nums.length - 1, index = 0;
	    while (index <= p2) {
	        if (nums[index] == 0) {
	            nums[index] = nums[p1];
	            nums[p1] = 0;
	            p1++;
	        }
	        if (nums[index] == 2) {
	            nums[index] = nums[p2];
	            nums[p2] = 2;
	            p2--;
	            index--;
	        }
	        index++;
	    }
	}
	
	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		sortColors(nums);
		System.out.println(nums);
	}
}

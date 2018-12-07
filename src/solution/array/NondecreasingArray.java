package solution.array;

/**
 * @author By RuiCUI
 * 2018-12-07
 * Easy
 * Question 665:Non-decreasing Array.
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * Note: The n belongs to [1, 10,000].
 */
public class NondecreasingArray {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1) 
	 * @param nums
	 * @return
	 */
	public static boolean checkPossibility(int[] nums) {
		int cnt = 0;                                                                   
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];                    
                else nums[i] = nums[i-1];                                                
            }
        }
        return cnt<=1; 
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1) 
	 * @param nums
	 * @return
	 */
	public boolean checkPossibility1(int[] nums) {
        int cnt = 0;                                                                  
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];                    
                else nums[i] = nums[i-1];                                                
            }
        }
        return cnt<=1; 
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1) 
	 * @param nums
	 * @return
	 */
	public boolean checkPossibility2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++)
            if (!(nums[i] <= nums[i + 1])) {
                if (count > 0)
                    return false;
                if (i - 1 >= 0 && i + 2 < nums.length && (nums[i] > nums[i + 2] && nums[i + 1] < nums[i - 1]))
                    return false;
                count++;
            }
        return true;
    }
	
	public static void main(String[] args) {
		//int[] nums = {3,4,2,3};
		//int[] nums = {4,2,3};
		int[] nums = {-1,4,2,3};
		System.out.println(checkPossibility(nums));
	}

}

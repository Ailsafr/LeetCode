package solution.array;

/**
 * @author By RuiCUI
 * 2018-7-13
 * Easy
 * Question 283:Move Zeroes.
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

	/**
	 * 我自己写的方法--跟我的方法一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int j = 0;
        for(int i=0;i<len;i++){
        	if(nums[i]!=0){
        		result[j] = nums[i];
        		j++;
        	}
        }
        for(int i=0;i<len;i++){
        	nums[i] = result[i];
        }
    }
	
	/**
	 * 答案1--Space Sub-Optimal
	 * 时间复杂度：O(n)  
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static void moveZeroes1(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int j = 0;
        for(int i=0;i<len;i++){
        	if(nums[i]!=0){
        		result[j] = nums[i];
        		j++;
        	}
        }
        for(int i=0;i<len;i++){
        	nums[i] = result[i];
        }
    }
	
	/**
	 * 答案2--Space Optimal, Operation Sub-Optimal--思维不错
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public void moveZeroes2(int[] nums) {
	    int lastNonZeroFoundAt = 0;
	    // If the current element is not 0, then we need to
	    // append it just in front of last non 0 element we found. 
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] != 0) {
	            nums[lastNonZeroFoundAt++] = nums[i];
	        }
	    }
	    // After we have finished processing new elements,
	    // all the non-zero elements are already at beginning of array.
	    // We just need to fill remaining array with 0's.
	    for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
	        nums[i] = 0;
	    }
	}
	
	/**
	 * 答案3--Optimal--思维很巧妙
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public void moveZeroes3(int[] nums) {
	    for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
	        if (nums[cur] != 0) {
	            swap(nums[lastNonZeroFoundAt++], nums[cur]);
	        }
	    }
	}
	
	private void swap(int a, int b){
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		System.out.println(nums[4]);
	}

}

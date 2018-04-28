package solution.array;

/**
 * @author By RuiCUI
 * 2018-04-28
 * Easy
 * Question 189:Rotate Array.
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

	public static void rotate1(int[] nums, int k) {
		int len = nums.length;
        for(int i=0;i<k;i++){
        	int num = nums[len-1];
        	for(int j=len-1;j>0;j--){
        		nums[j] = nums[j-1];
        	}
        	nums[0] = num;
        }
    }
	
	public static void rotate2(int[] nums, int k) {
		int len = nums.length;
		int[] n = new int[len];
		for(int i=0;i<len;i++){
			n[i] = nums[i];
		}
        for(int i=0;i<len-k;i++){
        	nums[i] = n[len-k-1+i];
        }
        int j = 0;
        for(int i=len-k;i<len;i++){
        	nums[i] = n[j];
        	j++;
        }
    }
	
	public static void rotate3(int[] nums, int k) {
        
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k=3;
		rotate2(nums,k);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}

}

package solution.array;

/**
 * @author By RuiCUI
 * 2018-05-04
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

	/**
	 * 我自己写的方法 不太优
	 * 时间复杂度：O(n*k) n的平方
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param k
	 * @return
	 */
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
	
	/**
	 * 我自己写的方法 不对  没有考虑到k大于n的情况
	 * 时间复杂度：O(n*n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param k
	 * @return
	 */
	public static void rotate2(int[] nums, int k) {
		int len = nums.length;
		int[] n = new int[len];
		for(int i=0;i<len;i++){
			n[i] = nums[i];
		}
		if(k>len){
			
		}
		if(len>1&&k!=0&&k!=len){
	        for(int i=0;i<len-k-1;i++){
	        	nums[i] = n[len-k+i];
	        }
	        int j = 0;
	        for(int i=len-k-1;i<len;i++){
	        	nums[i] = n[j];
	        	j++;
	        }
		}
    }
	
	/**
	 * 答案1--循环 [Time Limit Exceeded]
	 * 时间复杂度：O(n*k) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param k
	 * @return
	 */
	public void rotate3(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
	
	/**
	 * 答案2--Using Extra Array
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums
	 * @param k
	 * @return
	 */
	public void rotate4(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
	
	/**
	 * 答案3--Using Cyclic Replacements
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param k
	 * @return
	 */
	public void rotate5(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
	
	/**
	 * 答案4--Using Reverse
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param k
	 * @return
	 */
	public void rotate6(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
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

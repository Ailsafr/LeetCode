package solution.array;

/**
 * @author By RuiCUI
 * 2018-02-11
 * Easy
 * Question 053:Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
	
	/**
	 * 我自己写的方法  错误的  试一个例子对了发现还有一种情况没考虑到  反复循环 
	 * 看完答案想到一个东西，我一直在考虑从哪个到哪个，其实根本不需要，人家只要一个数字结果啊
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
		if(nums.length==0){
			return 0;
		}
		int result = nums[0];
		int resultN = 0;
		if(nums[0]<0){
			resultN = nums[0];
		}
		for(int j=1;j<nums.length;j++){
			if(nums[j]>0){
				if(nums[j]>Math.abs(resultN)){
					if(nums[j]>result+resultN){
						if(resultN==0){
							result += nums[j];
						}else{
							result = nums[j];
						}
					}else{
						result += resultN + nums[j];
					}
					resultN = 0;
				}else if(nums[j]>result){
					result = nums[j];
					resultN = 0;
				}else{
					
				}
			}else{
				if(nums[j]>result){
					result = nums[j];
					resultN = 0;
				}else{
					resultN += nums[j];
				}
			}
		}
		return result;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,DP动态规划算法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int maxSubArray1(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int maxSubArray2(int[] A) {
	    int max = Integer.MIN_VALUE, sum = 0;
	    for (int i = 0; i < A.length; i++) {
	        if (sum < 0) 
	            sum = A[i];
	        else 
	            sum += A[i];
	        if (sum > max)
	            max = sum;
	    }
	    return max;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案--分治法
	 * Step1. Select the middle element of the array.
	 * So the maximum subarray may contain that middle element or not.
	 * Step 2.1 If the maximum subarray does not contain the middle element, then we can apply the same algorithm to the the subarray to the left of the middle element and the subarray to the right of the middle element.
	 * Step 2.2 If the maximum subarray does contain the middle element, then the result will be simply the maximum suffix subarray of the left subarray plus the maximum prefix subarray of the right subarray
	 * Step 3 return the maximum of those three answer.
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int maxSubArray3(int A[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(n==0) return 0;
        return maxSubArrayHelperFunction(A,0,n-1);
    }
    
    public static int maxSubArrayHelperFunction(int A[], int left, int right) {
        if(right == left) return A[left];
        int middle = (left+right)/2;
        int leftans = maxSubArrayHelperFunction(A, left, middle);
        int rightans = maxSubArrayHelperFunction(A, middle+1, right);
        int leftmax = A[middle];
        int rightmax = A[middle+1];
        int temp = 0;
        for(int i=middle;i>=left;i--) {
            temp += A[i];
            if(temp > leftmax) leftmax = temp;
        }
        temp = 0;
        for(int i=middle+1;i<=right;i++) {
            temp += A[i];
            if(temp > rightmax) rightmax = temp;
        }
        return Math.max(Math.max(leftans, rightans),leftmax+rightmax);
    }

	public static void main(String[] args) {
		//int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		//int[] nums = {1,2};
		//int[] nums = {-2};
		//int[] nums = {-2,-1};
		//int[] nums = {-2,1};
		int[] nums = {8,-19,5,-4,20};
		System.out.println(maxSubArray(nums));
	}

}

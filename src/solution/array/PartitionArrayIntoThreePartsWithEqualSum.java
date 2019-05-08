package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2019-05-08
 * Easy
 * Question 1013:Partition Array Into Three Parts With Equal Sum.
 * Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
 * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j+1] + ... + A[A.length - 1])
 * Example 1:
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * Example 2:
 * Input: [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 * Example 3:
 * Input: [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * Note:
 * 1. 3 <= A.length <= 50000
 * 2. -10000 <= A[i] <= 10000.
 * Hint:
 * 1. If we have three parts with the same sum, what is the sum of each? If you can find the first part, can you find the second part?
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public static boolean canThreePartsEqualSum(int[] A) {
		int sum = 0;
		for(int n:A){
			sum += n;
		}
		if(sum%3!=0){
			return false;
		}
		int value = sum/3;
		int temp = 0;
		int len = A.length;
		int num = 0;
		for(int i=0;i<len;i++){
			temp += A[i];
			if(temp==value){
				if(i==len-1||num==2){
					return true;
				}else{
					temp = 0;
					num++;
				}
			}
		}
		return false;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public boolean canThreePartsEqualSum1(int[] A) {
        int n = A.length;
        if(n < 3) return false;
        int sum = Arrays.stream(A).sum();
        int average = sum / 3;
        if(average * 3 != sum) return false;
        boolean doesFirstPartFound = false;
        int i = 0, presum = 0;
        while(i < n) {
            presum += A[i];
            if(presum == average * 2 && doesFirstPartFound) return true;
            if(presum == average) doesFirstPartFound = true;
            ++i;
        }
        return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public boolean canThreePartsEqualSum2(int[] A) {
        if(A==null || A.length<3) 
            return false;
        
        int sum=0;
        for(int i=0;i<A.length;i++)
            sum+=A[i];
        
        if(sum%3!=0) 
            return false;
        
        sum /= 3;
        
        int t = 0;
        int count=0;
        for(int i=0;i<A.length; i++){
            t+=A[i];
            if(t==sum){
                t=0;
                count++;
            }
        }
        
        return t==0 && count==3;   
    }
	
	public static void main(String[] args) {
		int[] A = {12,-4,16,-5,9,-3,3,8,0};
		System.out.println(canThreePartsEqualSum(A));
	}
}

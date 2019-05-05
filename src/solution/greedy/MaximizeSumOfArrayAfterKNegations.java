package solution.greedy;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2019-05-05
 * Easy
 * Question 1005:Maximize Sum Of Array After K Negations.
 * Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], 
 * and we repeat this process K times in total.  (We may choose the same index i multiple times.)
 * Return the largest possible sum of the array after modifying it in this way.
 * Example 1:
 * Input: A = [4,2,3], K = 1
 * Output: 5
 * Explanation: Choose indices (1,) and A becomes [4,-2,3].
 * Example 2:
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 * Example 3:
 * Input: A = [2,-3,-1,5,-4], K = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 * Note:
 * 1. 1 <= A.length <= 10000
 * 2. 1 <= K <= 10000
 * 3. -100 <= A[i] <= 100.
 */
public class MaximizeSumOfArrayAfterKNegations {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @param K
	 * @return
	 */
	public static int largestSumAfterKNegations(int[] A, int K) {
		Arrays.sort(A);
		for(int i=0;i<K;i++){
			A[0] = -A[0];
			Arrays.sort(A);
		}
		int sum = 0;
		for(int n:A){
			sum += n;
		}
        return sum;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @param K
	 * @return
	 */
	public int largestSumAfterKNegations1(int[] A, int K) {
        // at each step always flip the smallest number in the array
        // but before flipping, could pre-flip all negatives
        int negCount = 0;
        for(int a : A) negCount += a < 0 ? 1 : 0;
        if(K <= negCount){
            Arrays.sort(A);
            int sum = 0;
            for(int i = 0; i < A.length; i++)
                sum += i < K ? -A[i] : A[i];
            return sum;
        }else{// negCount < K
            Arrays.sort(A);
            int sum = 0;
            for(int i = 0; i < A.length; i++)
                sum += i < negCount ? -A[i] : A[i];
            if((K - negCount) % 2 == 0) return sum;
            else{
                // with all values in A non-negative, just flip the smallest one.
                int minVal = Integer.MAX_VALUE;
                for(int a : A) minVal = Math.min(minVal, Math.abs(a));
                return sum - minVal * 2;
            }
        }
        
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @param K
	 * @return
	 */
	public int largestSumAfterKNegations2(int[] A, int K) {
        Arrays.sort(A);
        int i=0;
        for(;i<A.length;i++)
        {
            if(K==0) break;
            if(A[i]<0)
            {    
                A[i]=-A[i];
                K--;
            }
            else 
                break;
        }
        if(K!=0)
        {
            if(K%2!=0)
            {
               if(i-1>=0&&A[i-1]<A[i])
                   i=i-1;
               A[i]=-A[i];
            }
        }
        int sum=0;
        for(int x:A)
            sum+=x;
        return sum;
    }
	
	public static void main(String[] args) {
		int[] A = {2,-3,-1,5,-4};
		int K = 2;
		System.out.println(largestSumAfterKNegations(A,K));
	}

}

package solution.math;

/**
 * @author By RuiCUI
 * 2019-03-26
 * Easy
 * Question 908:Smallest Range I.
 * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 * After this process, we have some array B.
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 * Example 1:
 * Input: A = [1], K = 0
 * Output: 0
 * Explanation: B = [1]
 * Example 2:
 * Input: A = [0,10], K = 2
 * Output: 6
 * Explanation: B = [2,8]
 * Example 3:
 * Input: A = [1,3,6], K = 3
 * Output: 0
 * Explanation: B = [3,3,3] or B = [4,4,4]
 * Note:
 * 1. 1 <= A.length <= 10000
 * 2. 0 <= A[i] <= 10000
 * 3. 0 <= K <= 10000.
 */
public class SmallestRangeI {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @param K
	 * @return
	 */
	public static int smallestRangeI(int[] A, int K) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int n:A){
			if(n>max){
				max = n;
			}
			if(n<min){
				min = n;
			}
		}
		int maxDiff = max - min;
		if(K*2>=maxDiff){
			return 0;
		}
		return maxDiff-K*2;
	}
	
	/**
	 * 答案--Mathematical
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @param K
	 * @return
	 */
	public int smallestRangeI1(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int x: A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return Math.max(0, max - min - 2*K);
    }
    
	public static void main(String[] args) {
		int[] A = {3,1,10};
		int K = 4;
		System.out.println(smallestRangeI(A,K));
	}

}

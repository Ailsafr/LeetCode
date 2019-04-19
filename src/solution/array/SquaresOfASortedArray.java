package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2019-04-19
 * Easy
 * Question 977:Squares of a Sorted Array.
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * Example 1:
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * Note:
 * 1. 1 <= A.length <= 10000
 * 2. -10000 <= A[i] <= 10000
 * 3. A is sorted in non-decreasing order.
 */
public class SquaresOfASortedArray {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public static int[] sortedSquares(int[] A) {
		int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(nlogn) 
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public static int[] sortedSquares1(int[] A) {
		int len = A.length;
		for(int i=0;i<len;i++){
			A[i] = A[i]*A[i];
		}
		Arrays.sort(A);
		return A;
    }
	
	/**
	 * 答案1--Sort
	 * 时间复杂度：O(nlogn) 
	 * 空间复杂度：O(n) 
	 * @param A
	 * @return
	 */
	public int[] sortedSquares2(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);
        return ans;
    }
	
	/**
	 * 答案2--Two Pointer
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n) 
	 * @param A
	 * @return
	 */
	public int[] sortedSquares3(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }
	
	public static void main(String[] args) {
		int[] A = {-3,-3,-2,1};
		System.out.println(Arrays.toString(sortedSquares(A)));
	}

}

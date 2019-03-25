package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2019-03-25
 * Easy
 * Question 905:Sort Array By Parity.
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * Note:
 * 1. 1 <= A.length <= 5000
 * 2. 0 <= A[i] <= 5000.
 */
public class SortArrayByParity{

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public static int[] sortArrayByParity(int[] A) {
		int len = A.length;
		int[] result = new int[len];
		int i = 0;
		int j = len-1;
		for(int n:A){
			if(n%2==0){
				result[i] = n;
				i++;
			}else{
				result[j] = n;
				j--;
			}
		}
		return result;
    }
	
	/**
	 * 答案1--Sort
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public int[] sortArrayByParity1(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];

        Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));

        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];
        return A;

        /* Alternative:
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
    }
	
	/**
	 * 答案2--Two Pass
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public int[] sortArrayByParity2(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;
    }
	
	/**
	 * 答案3--In-Place
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public int[] sortArrayByParity3(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
	
	public static void main(String[] args) {
		int[] A = {3,1,2,4};
		System.out.println(sortArrayByParity(A));
	}

}

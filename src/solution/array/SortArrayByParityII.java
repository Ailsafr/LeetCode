package solution.array;

/**
 * @author By RuiCUI
 * 2019-03-29
 * Easy
 * Question 922:Sort Array By Parity II.
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * You may return any answer array that satisfies this condition.
 * Example 1:
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * Note:
 * 1. 2 <= A.length <= 20000
 * 2. A.length % 2 == 0
 * 3. 0 <= A[i] <= 1000.
 */
public class SortArrayByParityII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public static int[] sortArrayByParityII(int[] A) {
		int j = 1;
        for (int i = 0; i < A.length; i += 2){
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1){
                    j += 2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
	
	/**
	 * 答案1--Two Pass
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public int[] sortArrayByParityII1(int[] A) {
        int N = A.length;
        int[] ans = new int[N];

        int t = 0;
        for (int x: A) if (x % 2 == 0) {
            ans[t] = x;
            t += 2;
        }

        t = 1;
        for (int x: A) if (x % 2 == 1) {
            ans[t] = x;
            t += 2;
        }

        return ans;
    }
	
	/**
	 * 答案2--Read/Write Heads
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public int[] sortArrayByParityII2(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2){
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2;

                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
	
	public static void main(String[] args) {
		int[] A = {2,3,1,1,4,0,0,4,3,3};
		System.out.println(sortArrayByParityII(A));
	}

}

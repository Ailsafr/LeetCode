package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2019-04-23
 * Easy
 * Question 985:Sum of Even Numbers After Queries.
 * We have an array A of integers, and an array queries of queries.
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  
 * Then, the answer to the i-th query is the sum of the even values of A.
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 * Example 1:
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation: 
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 * Note:
 * 1. 1 <= A.length <= 10000
 * 2. -10000 <= A[i] <= 10000
 * 3. 1 <= queries.length <= 10000
 * 4. -10000 <= queries[i][0] <= 10000
 * 5. 0 <= queries[i][1] < A.length.
 */
public class SumOfEvenNumbersAfterQueries {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(m*n) 
	 * 空间复杂度：O(n)
	 * @param A
	 * @param queries
	 * @return
	 */
	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int len = queries.length;
		int n = A.length;
		int[] result = new int[len];
		for(int i=0;i<len;i++){
			int num = queries[i][0];
			int index = queries[i][1];
			A[index] = A[index] + num;
			int res = 0;
			for(int j=0;j<n;j++){
				if(A[j]%2==0){
					res += A[j];
				}
			}
			result [i] = res;
		}
		return result;
    }
	
	/**
	 * 答案--Maintain Array Sum
	 * 时间复杂度：O(N+Q), where N is the length of A and Q is the number of queries.
	 * 空间复杂度：O(Q) 
	 * @param A
	 * @param queries
	 * @return
	 */
	public int[] sumEvenAfterQueries1(int[] A, int[][] queries) {
        int S = 0;
        for (int x: A)
            if (x % 2 == 0)
                S += x;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) S -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) S += A[index];
            ans[i] = S;
        }

        return ans;
    }
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
		System.out.println(Arrays.toString(sumEvenAfterQueries(A,queries)));
	}

}

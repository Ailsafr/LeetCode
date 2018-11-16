package solution.math;

/**
 * @author By RuiCUI
 * 2018-11-16
 * Easy
 * Question 598:Range Addition II.
 * Given an m * n matrix M initialized with all 0's and several update operations.
 * Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, 
 * which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
 * You need to count and return the number of maximum integers in the matrix after performing all the operations.
 * Example 1:
 * Input: 
 * m = 3, n = 3
 * operations = [[2,2],[3,3]]
 * Output: 4
 * Explanation: 
 * Initially, M = 
	[[0, 0, 0],
	 [0, 0, 0],
	 [0, 0, 0]]
 * After performing [2,2], M = 
	[[1, 1, 0],
	 [1, 1, 0],
	 [0, 0, 0]]
 * After performing [3,3], M = 
	[[2, 2, 1],
	 [2, 2, 1],
	 [1, 1, 1]]
 * So the maximum integer in M is 2, and there are four of it in M. So return 4.
 * Note:
 * 1.The range of m and n is [1,40000].
 * 2.The range of a is [1,m], and the range of b is [1,n].
 * 3.The range of operations size won't exceed 10,000.
 */
public class RangeAdditionII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(x) x refers to the number of operations.
	 * 空间复杂度：O(1)
	 * @param m
	 * @param n
	 * @param ops
	 * @return
	 */
	public static int maxCount(int m, int n, int[][] ops) {
		if(ops==null||ops.length==0){
			return m*n;
		}
		int min1 = m;
		int min2 = n;
		int len = ops.length;
		for(int i=0;i<len;i++){
			int[] num = ops[i];
			min1 = Math.min(min1, num[0]);
			min2 = Math.min(min2, num[1]);
		}
		return min1*min2;
    }
	
	/**
	 * 答案1--Brute Force[Time Limit Exceeded]
	 * 时间复杂度：O(x*m*n) where x represents number of times operation is preformed i.e. ops.length. 
	 * 空间复杂度：O(m*n)
	 * @param m
	 * @param n
	 * @param ops
	 * @return
	 */
	public int maxCount1(int m, int n, int[][] ops) {
        int[][] arr = new int[m][n];
        for (int[] op: ops) {
            for (int i = 0; i < op[0]; i++) {
                for (int j = 0; j < op[1]; j++) {
                    arr[i][j] += 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == arr[0][0])
                    count++;
            }
        }
        return count;
    }

	
	/**
	 * 答案2--Single Pass[Accepted]
	 * 时间复杂度：O(x) x refers to the number of operations.
	 * 空间复杂度：O(1)
	 * @param m
	 * @param n
	 * @param ops
	 * @return
	 */
	public int maxCount2(int m, int n, int[][] ops) {
        for (int[] op: ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
	
	
	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		int[][] ops = {{2,2},{3,3}};
		System.out.println(maxCount(m,n,ops));
	}

}

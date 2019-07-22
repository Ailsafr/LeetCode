package solution.array;

/**
 * @author By RuiCUI
 * 2019-07-22
 * Medium
 * Question 62:Unique Paths.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * Note: m and n will be at most 100.
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28.
 */
public class UniquePaths {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param m
	 * @param n
	 * @return
	 */
	public static int uniquePaths(int m, int n) {
		int N = n + m - 2;
	    int k = m - 1;
	    double res = 1;
	    for (int i = 1; i <= k; i++)
	        res = res * (N - k + i) / i;
	    return (int)res;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths1(int m, int n) {
		int N = n + m - 2;// how much steps we need to do
	    int k = m - 1; // number of steps that need to go down
	    double res = 1;
	    // here we calculate the total possible path number 
	    // Combination(N, k) = n! / (k!(n - k)!)
	    // reduce the numerator and denominator and get
	    // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
	    for (int i = 1; i <= k; i++)
	        res = res * (N - k + i) / i;
	    return (int)res;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n*m)
	 * 空间复杂度：O(n*m)
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths2(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
	
	public static void main(String[] args) {
		int m = 7;
		int n = 3;
		System.out.println(uniquePaths(m,n));
	}
}

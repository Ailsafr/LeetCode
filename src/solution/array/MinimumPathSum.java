package solution.array;

/**
 * @author By RuiCUI
 * 2019-07-24
 * Medium
 * Question 64:Minimum Path Sum.
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * Example:
 * Input:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(m*n)
	 * @param grid
	 * @return
	 */
	public static int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		if(row==0&&col==0){
			return 0;
		}else if(row==1&&col==1){
			return grid[0][0];
		}
		int[][] result = new int[row][col];
		result[0][0] = grid[0][0];
		for(int i=1;i<row;i++){
			result[i][0] = grid[i][0] + result[i-1][0];
		}
		for(int j=1;j<col;j++){
			result[0][j] = grid[0][j] + result[0][j-1];
		}
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				result[i][j] = grid[i][j] + Math.min(result[i-1][j], result[i][j-1]);
			}
		}
		return result[row-1][col-1];
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(1)
	 * @param grid
	 * @return
	 */
	public int minPathSum1(int[][] grid) {
		int m = grid.length;// row
		int n = grid[0].length; // column
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j != 0) {
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				} else if (i != 0 && j == 0) {
					grid[i][j] = grid[i][j] + grid[i - 1][j];
				} else if (i == 0 && j == 0) {
					grid[i][j] = grid[i][j];
				} else {
					grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
							+ grid[i][j];
				}
			}
		}
		return grid[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));
	}
}

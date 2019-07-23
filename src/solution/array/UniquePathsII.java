package solution.array;

/**
 * @author By RuiCUI
 * 2019-07-23
 * Medium
 * Question 63:Unique Paths II.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * Note: m and n will be at most 100.
 * Example 1:
 * Input:
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right.
 * Hint:
 * 1. The robot can only move either down or right. Hence any cell in the first row can only be reached from the cell left to it. 
 *    However, if any cell has an obstacle, you don't let that cell contribute to any path. 
 *    So, for the first row, the number of ways will simply be 
 *    if obstacleGrid[i][j] is not an obstacle
 *         obstacleGrid[i,j] = obstacleGrid[i,j - 1] 
 *    else
 *         obstacleGrid[i,j] = 0
 *    You can do a similar processing for finding out the number of ways of reaching the cells in the first column.
 * 2. For any other cell, we can find out the number of ways of reaching it, 
 *    by making use of the number of ways of reaching the cell directly above it and the cell to the left of it in the grid. 
 *    This is because these are the only two directions from which the robot can come to the current cell.
 * 3. Since we are making use of pre-computed values along the iteration, this becomes a dynamic programming problem.
 *    if obstacleGrid[i][j] is not an obstacle
 *         obstacleGrid[i,j] = obstacleGrid[i,j - 1]  + obstacleGrid[i - 1][j]
 *    else
 *         obstacleGrid[i,j] = 0.
 */
public class UniquePathsII {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(1)
	 * @param obstacleGrid
	 * @return
	 */
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		if(row==1&&col==1){
			if(obstacleGrid[0][0]==0){
				return 1;
			}else{
				return 0;
			}
		}
		for(int i=1;i<row;i++){
			if(obstacleGrid[i-1][0]!=1&&obstacleGrid[i][0]!=1){
				obstacleGrid[i][0] = -1;
			}else{
				obstacleGrid[i][0] = 1;
			}
		}
		for(int j=1;j<col;j++){
			if(obstacleGrid[0][j-1]!=1&&obstacleGrid[0][j]!=1){
				obstacleGrid[0][j] = -1;
			}else{
				obstacleGrid[0][j] = 1;
			}
		}
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				if(obstacleGrid[i][j]==0){
					if(obstacleGrid[i-1][j]<0&&obstacleGrid[i][j-1]<0){
						obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
					}else if(obstacleGrid[i-1][j]==1&&obstacleGrid[i][j-1]==1){
						obstacleGrid[i][j] = 1;
					}else{
						obstacleGrid[i][j] = Math.min(obstacleGrid[i-1][j], obstacleGrid[i][j-1]);
					}
				}
			}
		}
		return obstacleGrid[row-1][col-1]>0?0:-obstacleGrid[row-1][col-1];
	}
	
	/**
	 * 答案--Dynamic Programming
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(1)
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles1(int[][] obstacleGrid) {

        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }

	public static void main(String[] args) {
		//int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		//int[][] obstacleGrid = {{0,1}};
		int[][] obstacleGrid = {{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
}

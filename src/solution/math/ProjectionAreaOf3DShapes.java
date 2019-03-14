package solution.math;

/**
 * @author By RuiCUI
 * 2019-03-14
 * Easy
 * Question 883:Projection Area of 3D Shapes.
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane. 
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
 * Return the total area of all three projections.
 * Example 1:
 * Input: [[2]]
 * Output: 5
 * Example 2:
 * Input: [[1,2],[3,4]]
 * Output: 17
 * Explanation: 
 * Here are the three projections ("shadows") of the shape made with each axis-aligned plane.
 * Example 3:
 * Input: [[1,0],[0,2]]
 * Output: 8
 * Example 4:
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 14
 * Example 5:
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 21
 * Note:
 * 1. 1 <= grid.length = grid[0].length <= 50
 * 2. 0 <= grid[i][j] <= 50.
 */
public class ProjectionAreaOf3DShapes {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(n)
	 * @param grid
	 * @return
	 */
	public static int projectionArea(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		int result = 0;
		int[] array = new int[r];
		for(int i=0;i<r;i++){
			int max = 0;
			for(int j=0;j<c;j++){
				int n = grid[i][j];
				if(n!=0){
					result += 1;
				}
				if(n>max){
					max = n;
				}
				array[j] = Math.max(array[j], n);
			}
			result += max;
		}
		for(int n:array){
			result += n;
		}
		return result;
    }
	
	/**
	 * 答案--Mathematical
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(1)
	 * @param grid
	 * @return
	 */
	public int projectionArea1(int[][] grid) {
        int N = grid.length;
        int ans = 0;

        for (int i = 0; i < N;  ++i) {
            int bestRow = 0;  // largest of grid[i][j]
            int bestCol = 0;  // largest of grid[j][i]
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] > 0) ans++;  // top shadow
                bestRow = Math.max(bestRow, grid[i][j]);
                bestCol = Math.max(bestCol, grid[j][i]);
            }
            ans += bestRow + bestCol;
        }

        return ans;
    }
    
	public static void main(String[] args) {
		int[][] grid = {{2,2,2},{2,1,2},{2,2,2}};
		System.out.println(projectionArea(grid));
	}

}

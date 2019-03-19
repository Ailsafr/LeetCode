package solution.math;

/**
 * @author By RuiCUI
 * 2019-03-19
 * Easy
 * Question 892:Surface Area of 3D Shapes.
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * Return the total surface area of the resulting shapes.
 * Example 1:
 * Input: [[2]]
 * Output: 10
 * Example 2:
 * Input: [[1,2],[3,4]]
 * Output: 34
 * Example 3:
 * Input: [[1,0],[0,2]]
 * Output: 16
 * Example 4:
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * Example 5:
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 * Note:
 * 1. 1 <= N <= 50
 * 2. 0 <= grid[i][j] <= 50.
 */
public class SurfaceAreaOf3DShapes {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(1)
	 * @param grid
	 * @return
	 */
	public static int surfaceArea(int[][] grid) {
		int R = grid.length;
		int C = grid[0].length;
		int result = 0;
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				int n = grid[i][j];
				if(n!=0){
					result += n*6-(n-1)*2;
				}
				if(i==0){
					if(R!=1){
						result -= Math.min(grid[i+1][j],n);
					}
				}else if(i==R-1){
					result -= Math.min(grid[i-1][j], n);
				}else{
					result -= Math.min(grid[i+1][j],n);
					result -= Math.min(grid[i-1][j], n);
				}
				if(j==0){
					if(C!=1){
						result -= Math.min(grid[i][j+1],n);
					}
				}else if(j==C-1){
					result -= Math.min(grid[i][j-1], n);
				}else{
					result -= Math.min(grid[i][j+1],n);
					result -= Math.min(grid[i][j-1], n);
				}
			}
		}
		return result;
    }
	
	/**
	 * 答案--Square by Square
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(1)
	 * @param grid
	 * @return
	 */
	public int surfaceArea1(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int N = grid.length;
        int ans = 0;

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; ++k) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr < N && 0 <= nc && nc < N)
                            nv = grid[nr][nc];

                        ans += Math.max(grid[r][c] - nv, 0);
                    }
                }

        return ans;
    }
    
	public static void main(String[] args) {
		int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
		System.out.println(surfaceArea(grid));
	}

}

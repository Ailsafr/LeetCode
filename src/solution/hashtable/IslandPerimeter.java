package solution.hashtable;

/**
 * @author By RuiCUI
 * 2018-09-14
 * Easy
 * Question 463:Island Perimeter.
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
 * Grid cells are connected horizontally/vertically (not diagonally). 
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). 
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * Example:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class IslandPerimeter {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(mn) 
	 * 空间复杂度：O(n)
	 * @param grid
	 * @return
	 */
	public static int islandPerimeter(int[][] grid) {
		int result = 0;
		for(int i=0;i<grid.length;i++){
			int[] g = grid[i];
			for(int j=0;j<g.length;j++){
				if(g[j]==1){
					result += getNum(grid,i,j);
				}
			}
		}
		return result;
    }
	
	private static int getNum(int[][] grid, int i, int j){
		int top,bottom,left,right;
		try{
			top = grid[i-1][j];
			if(top==1){
				top = 0;
			}else{
				top = 1;
			}
		}catch(Exception e){
			top = 1;
		}
		try{
			bottom = grid[i+1][j];
			if(bottom==1){
				bottom = 0;
			}else{
				bottom = 1;
			}
		}catch(Exception e){
			bottom = 1;
		}
		try{
			left = grid[i][j-1];
			if(left==1){
				left = 0;
			}else{
				left = 1;
			}
		}catch(Exception e){
			left = 1;
		}
		try{
			right = grid[i][j+1];
			if(right==1){
				right = 0;
			}else{
				right = 1;
			}
		}catch(Exception e){
			right = 1;
		}
		return top+bottom+left+right;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(mn) 
	 * 空间复杂度：O(n)
	 * @param grid
	 * @return
	 */
	public int islandPerimeter1(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(mn) 
	 * 空间复杂度：O(n)
	 * @param grid
	 * @return
	 */
	public static int islandPerimeter2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(mn) 
	 * 空间复杂度：O(n)
	 * @param grid
	 * @return
	 */
	public int islandPerimeter3(int[][] grid) {
        if (grid == null) return 0;
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if (grid[i][j] == 1) {
                    return getPerimeter(grid,i,j);
                }
            }
        }
        return 0;
    }
    
    public int getPerimeter(int[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {return 1;}
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == -1) return 0;
        
        int count = 0;
        grid[i][j] = -1;
        
        count += getPerimeter(grid, i-1, j);
        count += getPerimeter(grid, i, j-1);
        count += getPerimeter(grid, i, j+1);
        count += getPerimeter(grid, i+1, j);
        
        return count;
        
    }
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println(islandPerimeter(grid));
	}

}

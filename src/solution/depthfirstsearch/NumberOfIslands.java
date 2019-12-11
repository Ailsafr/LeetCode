package solution.depthfirstsearch;

import java.util.LinkedList;

/**
 * @author By RuiCUI
 * 2019-12-11
 * Medium
 * Question 200:Number of Islands.
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 */
public class NumberOfIslands {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n) 
	 * @param grid
	 * @return
	 */
	private static char[][] gc;
    public static int numIslands(char[][] grid) {
        int islands = 0;
        gc = grid;
        for (int i=0; i<gc.length; i++)
            for (int j=0; j<gc[i].length; j++)
                islands += helper(i, j);
        return islands;
    }
    private static int helper(int i, int j) {
        if (i < 0 || i == gc.length || j < 0 || j == gc[i].length || gc[i][j] == '0')
            return 0;
        gc[i][j] = '0';
        helper(i+1, j); helper(i-1, j); helper(i, j+1); helper(i, j-1);
        return 1;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param grid
	 * @return
	 */
	private int n;
	private int m;
	public int numIslands1(char[][] grid) {
	    int count = 0;
	    n = grid.length;
	    if (n == 0) return 0;
	    m = grid[0].length;
	    for (int i = 0; i < n; i++){
	        for (int j = 0; j < m; j++)
	            if (grid[i][j] == '1') {
	                DFSMarking(grid, i, j);
	                ++count;
	            }
	    }    
	    return count;
	}
	private void DFSMarking(char[][] grid, int i, int j) {
	    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
	    grid[i][j] = '0';
	    DFSMarking(grid, i + 1, j);
	    DFSMarking(grid, i - 1, j);
	    DFSMarking(grid, i, j + 1);
	    DFSMarking(grid, i, j - 1);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param grid
	 * @return
	 */
	char[][] g;
    public int numIslands2(char[][] grid) {
        int islands = 0;
        g = grid;
        for (int i=0; i<g.length; i++)
            for (int j=0; j<g[i].length; j++)
                islands += sink(i, j);
        return islands;
    }
    int sink(int i, int j) {
        if (i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0')
            return 0;
        g[i][j] = '0';
        sink(i+1, j); sink(i-1, j); sink(i, j+1); sink(i, j-1);
        return 1;
    }
	
    /**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param grid
	 * @return
	 */
    public int numIslands3(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfsFill(grid,i,j);
                    count++;
                }
            }
        return count;
    }
    private void bfsFill(char[][] grid,int x, int y){
        grid[x][y]='0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<Integer>();  
        int code = x*m+y;  
        queue.offer(code);  
        while(!queue.isEmpty())  
        {  
            code = queue.poll();  
            int i = code/m;  
            int j = code%m;  
            if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
            {  
                queue.offer((i-1)*m+j);  
                grid[i-1][j]='0';  
            }  
            if(i<n-1 && grid[i+1][j]=='1')  //down
            {  
                queue.offer((i+1)*m+j);  
                grid[i+1][j]='0';  
            }  
            if(j>0 && grid[i][j-1]=='1')  //left
            {  
                queue.offer(i*m+j-1);  
                grid[i][j-1]='0';  
            }  
            if(j<m-1 && grid[i][j+1]=='1')  //right
            {  
                queue.offer(i*m+j+1);  
                grid[i][j+1]='0';  
            }
        } 
    }
    
	public static void main(String[] args) {
		char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		System.out.println(numIslands(grid));
	}

}

package solution.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2019-09-24
 * Medium
 * Question 130:Surrounded Regions.
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * Example:
	X X X X
	X O O X
	X X O X
	X O X X
 * After running your function, the board should be:
	X X X X
	X X X X
	X X X X
	X O X X
 * Explanation:
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param board
	 * @return
	 */
	public static void solve(char[][] board) {
		if(board == null || board.length == 0) return;
	    for(int i = 0; i < board.length; i++){
	        for(int j = 0; j < board[0].length; j++){
	            if(i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1){
	                if(board[i][j] == 'O') helper(i,j,board);
	            }
	        }
	    }
	    for(int i = 0; i < board.length; i++){
	        for(int j = 0; j < board[0].length; j++){
	            if(board[i][j] == '*') board[i][j] ='O';
	            else board[i][j] = 'X';
	        }
	    }
	    return;
	}
	private static void helper(int i,int j,char[][] board){
	    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
	    if(board[i][j] == 'X' || board[i][j] == '*') return;
	    board[i][j] = '*';
	    if(i+1 < board.length)
	    	helper(i+1,j,board);
	    if(i-1 > 0)
	    	helper(i-1,j,board);
	    if(j+1 < board[0].length)
	    	helper(i,j+1,board);
	    if(j-1 > 0)
	    	helper(i,j-1,board);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param board
	 * @return
	 */
	class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public void solve1(char[][] board) {
		if (board == null || board.length == 0)
			return;
		int rows = board.length, columns = board[0].length;
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if ((i == 0 || i == rows - 1 || j == 0 || j == columns - 1) && board[i][j] == 'O') {
					Queue<Point> queue = new LinkedList<>();
					board[i][j] = 'B';
					queue.offer(new Point(i, j));
					while (!queue.isEmpty()) {
						Point point = queue.poll();
						for (int k = 0; k < 4; k++) {
							int x = direction[k][0] + point.x;
							int y = direction[k][1] + point.y;
							if (x >= 0 && x < rows && y >= 0 && y < columns && board[x][y] == 'O') {
								board[x][y] = 'B';
								queue.offer(new Point(x, y));
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (board[i][j] == 'B')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}

	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param board
	 * @return
	 */
	public void solve2(char[][] board) {
	    if(board == null || board.length == 0) return;
	    for(int i = 0; i < board.length; i++){
	        for(int j = 0; j < board[0].length; j++){
	            if(i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1){
	                if(board[i][j] == 'O') dfs(i,j,board);
	            }
	        }
	    }
	    for(int i = 0; i < board.length; i++){
	        for(int j = 0; j < board[0].length; j++){
	            if(board[i][j] == '*') board[i][j] ='O';
	            else board[i][j] = 'X';
	        }
	    }
	    return;
	}
	private void dfs(int i,int j,char[][] board){
	    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
	    if(board[i][j] == 'X' || board[i][j] == '*') return;
	    board[i][j] = '*';
	    if(i+1 < board.length)
	        dfs(i+1,j,board);
	    if(i-1 > 0)
	        dfs(i-1,j,board);
	    if(j+1 < board[0].length)
	        dfs(i,j+1,board);
	    if(j-1 > 0)
	        dfs(i,j-1,board);
	}

	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		solve(board);
		System.out.println(board);
	}

}

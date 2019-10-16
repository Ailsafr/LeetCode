package solution.backtracking;

/**
 * @author By RuiCUI
 * 2019-08-05
 * Medium
 * Question 79:Word Search.
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * Example:
 * board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param board
	 * @param word
	 * @return
	 */
	static boolean[][] visited;
	public static boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && helper(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean helper(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        if(helper(board, word, i-1, j, index+1) || 
        		helper(board, word, i+1, j, index+1) ||
        		helper(board, word, i, j-1, index+1) || 
        		helper(board, word, i, j+1, index+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist1(char[][] board, String word) {
	    char[] w = word.toCharArray();
	    for (int y=0; y<board.length; y++) {
	    	for (int x=0; x<board[y].length; x++) {
	    		if (helper1(board, y, x, w, 0)) return true;
	    	}
	    }
	    return false;
	}
	private boolean helper1(char[][] board, int y, int x, char[] word, int i) {
		if (i == word.length) return true;
		if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
		if (board[y][x] != word[i]) return false;
		board[y][x] ^= 256;
		boolean exist = helper1(board, y, x+1, word, i+1)
			|| helper1(board, y, x-1, word, i+1)
			|| helper1(board, y+1, x, word, i+1)
			|| helper1(board, y-1, x, word, i+1);
		board[y][x] ^= 256;
		return exist;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param board
	 * @param word
	 * @return
	 */
	static boolean[][] visited1;
    public boolean exist2(char[][] board, String word) {
    	visited1 = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        visited1[i][j] = true;
        if(search(board, word, i-1, j, index+1) || 
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) || 
           search(board, word, i, j+1, index+1)){
            return true;
        }
        visited1[i][j] = false;
        return false;
    }
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(exist(board,word));
	}

}

package solution.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-07-01
 * Medium
 * Question 36:Valid Sudoku.
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * A partially filled sudoku which is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Example 1:
 * Input:
	[
	  ["5","3",".",".","7",".",".",".","."],
	  ["6",".",".","1","9","5",".",".","."],
	  [".","9","8",".",".",".",".","6","."],
	  ["8",".",".",".","6",".",".",".","3"],
	  ["4",".",".","8",".","3",".",".","1"],
	  ["7",".",".",".","2",".",".",".","6"],
	  [".","6",".",".",".",".","2","8","."],
	  [".",".",".","4","1","9",".",".","5"],
	  [".",".",".",".","8",".",".","7","9"]
	]
 * Output: true
 * Example 2:
 * Input:
	[
	  ["8","3",".",".","7",".",".",".","."],
	  ["6",".",".","1","9","5",".",".","."],
	  [".","9","8",".",".",".",".","6","."],
	  ["8",".",".",".","6",".",".",".","3"],
	  ["4",".",".","8",".","3",".",".","1"],
	  ["7",".",".",".","2",".",".",".","6"],
	  [".","6",".",".",".",".","2","8","."],
	  [".",".",".","4","1","9",".",".","5"],
	  [".",".",".",".","8",".",".","7","9"]
	]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being 
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 * 1. A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * 2. Only the filled cells need to be validated according to the mentioned rules.
 * 3. The given board contain only digits 1-9 and the character '.'.
 * 4. The given board size is always 9x9.
 */
public class ValidSudoku {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(1) 
	 * 空间复杂度：O(1)
	 * @param board
	 * @return
	 */
	public static boolean isValidSudoku(char[][] board) {
		Set[] setHorizontal = new HashSet[9];
		Set[] setVertical = new HashSet[9];
		for(int i=0;i<9;i++){
			setHorizontal[i] = new HashSet<Character>();
			for(int j=0;j<9;j++){
				if(setVertical[j]==null){
					setVertical[j] = new HashSet<Character>();
				}
				char c = board[i][j];
				if(i%3==0&&j%3==0){
					Set<Character> set = new HashSet<Character>();
					for(int m=i;m<i+3;m++){
						for(int n=j;n<j+3;n++){
							char s = board[m][n];
							if('.'!=s){
								if(set.contains(s)){
									return false;
								}
								set.add(s);
							}
						}
					}
				}
				if('.'!=c){
					if(setHorizontal[i].contains(c)||setVertical[j].contains(c)){
						return false;
					}
					setHorizontal[i].add(c);
					setVertical[j].add(c);
				}
			}
		}
		return true;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(1) 
	 * 空间复杂度：O(1)
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku1(char[][] board) {
	    Set seen = new HashSet();
	    for (int i=0; i<9; ++i) {
	        for (int j=0; j<9; ++j) {
	            if (board[i][j] != '.') {
	                String b = "(" + board[i][j] + ")";
	                if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
	                    return false;
	            }
	        }
	    }
	    return true;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(1) 
	 * 空间复杂度：O(1)
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku2(char[][] board) {
	    for(int i = 0; i<9; i++){
	        HashSet<Character> rows = new HashSet<Character>();
	        HashSet<Character> columns = new HashSet<Character>();
	        HashSet<Character> cube = new HashSet<Character>();
	        for (int j = 0; j < 9;j++){
	            if(board[i][j]!='.' && !rows.add(board[i][j]))
	                return false;
	            if(board[j][i]!='.' && !columns.add(board[j][i]))
	                return false;
	            int RowIndex = 3*(i/3);
	            int ColIndex = 3*(i%3);
	            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
	                return false;
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		char[][] board1 = {
				  {'5','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				  };
		char[][] board2 = {
				  {'8','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				  };
		char[][] board3 = {
				{'.','.','4','.','.','.','6','3','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','9','.'},
				{'.','.','.','5','6','.','.','.','.'},
				{'4','.','3','.','.','.','.','.','1'},
				{'.','.','.','7','.','.','.','.','.'},
				{'.','.','.','5','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'}
				};
		char[][] board4 = {
				{'.','.','.','.','5','.','.','1','.'},
				{'.','4','.','3','.','.','.','.','.'},
				{'.','.','.','.','.','3','.','.','1'},
				{'8','.','.','.','.','.','.','2','.'},
				{'.','.','2','.','7','.','.','.','.'},
				{'.','1','5','.','.','.','.','.','.'},
				{'.','.','.','.','.','2','.','.','.'},
				{'.','2','.','9','.','.','.','.','.'},
				{'.','.','4','.','.','.','.','.','.'}
				};
		System.out.println(isValidSudoku(board1));
	}

}

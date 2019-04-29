package solution.array;

/**
 * @author By RuiCUI
 * 2019-04-29
 * Easy
 * Question 999:Available Captures for Rook.
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  
 * These are given as characters 'R', '.', 'B', and 'p' respectively. 
 * Uppercase characters represent white pieces, and lowercase characters represent black pieces.
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), 
 * then moves in that direction until it chooses to stop, reaches the edge of the board, 
 * or captures an opposite colored pawn by moving to the same square it occupies.  
 * Also, rooks cannot move into the same square as other friendly bishops.
 * Return the number of pawns the rook can capture in one move.
 * Example 1:
 * Input: {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}}
 * Output: 3
 * Explanation: 
 * In this example the rook is able to capture all the pawns.
 * Example 2:
 * Input: {{'.','.','.','.','.','.','.','.'},{'.','p','p','p','p','p','.','.'},{'.','p','p','B','p','p','.','.'},{'.','p','B','R','B','p','.','.'},{'.','p','p','B','p','p','.','.'},{'.','p','p','p','p','p','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}}
 * Output: 0
 * Explanation: 
 * Bishops are blocking the rook to capture any pawn.
 * Example 3:
 * Input: {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}}
 * Output: 3
 * Explanation: 
 * The rook can capture the pawns at positions b5, d6 and f5.
 * Note:
 * 1. board.length == board{i}.length == 8
 * 2. board{i}{j} is either 'R', '.', 'B', or 'p'
 * 3. There is exactly one cell with board{i}{j} == 'R'.
 */
public class AvailableCapturesForRook {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param board
	 * @return
	 */
	public static int numRookCaptures(char[][] board) {
		int result = 0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(board[i][j]=='R'){
					int north = i-1;
					int south = i+1;
					int east = j+1;
					int west = j-1;
					while(north>=0){
						if(board[north][j]=='p'){
							result += 1;
							break;
						}else if(board[north][j]=='B'){
							break;
						}
						north--;
					}
					while(south<8){
						if(board[south][j]=='p'){
							result += 1;
							break;
						}else if(board[south][j]=='B'){
							break;
						}
						south++;
					}
					while(west>=0){
						if(board[i][west]=='p'){
							result += 1;
							break;
						}else if(board[i][west]=='B'){
							break;
						}
						west--;
					}
					while(east<8){
						if(board[i][east]=='p'){
							result += 1;
							break;
						}else if(board[i][east]=='B'){
							break;
						}
						east++;
					}
				}
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param board
	 * @return
	 */
	public int numRookCaptures1(char[][] board) {
        int count = 0;
        int[][] oper = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    for (int k = 0; k < 4; k++) {
                        int a = i + oper[k][0];
                        int b = j + oper[k][1];
                        while (0 <= a && a < 8 && 0 <= b && b < 8) {
                            if (board[a][b] == 'B') {
                                break;
                            }
                            if (board[a][b] == 'p') {
                                count++;
                                break;
                            }
                            a += oper[k][0];
                            b += oper[k][1];
                        }
                    }
                }
            }
        }

        return count;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param board
	 * @return
	 */
	private static final int RS[] = new int[]{-1, 0, 0, 1};
    private static final int CS[] = new int[]{ 0,-1, 1, 0};
    
    public int numRookCaptures2(char[][] board) {
        boolean done[] = new boolean[4];
        int pawns = 0;
        if(board.length == 0 || board[0].length == 0)
            return 0;
        int r = 0, c = 0;
        find:
        for(r = 0; r < board.length; r++)
            for(c = 0; c < board.length; c++)
                if(board[r][c]=='R')
                    break find;
        for(int i = 1; i < 7; i++) {
            for(int j = 0; j < 4; j++) {
                if(done[j]) 
                    continue;
                int rr = r + RS[j] * i;
                int cc = c + CS[j] * i;
                if(rr >= 0 && rr < 8 && cc >= 0 && cc < 8)
                    switch(board[rr][cc]) {
                        case '.': break;
                        case 'p':
                            pawns++;
                        default:
                            done[j] = true;
                    }
            }
        }
        return pawns;
    }
	
	public static void main(String[] args) {
		char[][] board = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
		System.out.println(numRookCaptures(board));
	}
}

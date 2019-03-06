package solution.array;

/**
 * @author By RuiCUI
 * 2019-03-06
 * Easy
 * Question 867:Transpose Matrix.
 * Given a matrix A, return the transpose of A.
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 * Example 1:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 * Note:
 * 1. 1 <= A.length <= 1000.
 * 2. 1 <= A[0].length <= 1000.
 */
public class TransposeMatrix {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(m*n)
	 * @param A
	 * @return
	 */
	public static int[][] transpose(int[][] A) {
		int r = A.length;
		int c = A[0].length;
		int[][] result = new int[c][r];
		for(int i=0;i<c;i++){
			for(int j=0;j<r;j++){
				result[i][j] = A[j][i];
			}
		}
		return result;
    }
	
	/**
	 * 答案--Copy Directly
	 * 时间复杂度：O(R*C) where R and C are the number of rows and columns in the given matrix A.
	 * 空间复杂度：O(R*C) where R and C are the number of rows and columns in the given matrix A.
	 * @param A
	 * @return
	 */
	public int[][] transpose1(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;
    }
	
	public static void main(String[] args) {
		int[][] A = {{1,2,3},{4,5,6}};
		System.out.println(transpose(A));
	}

}

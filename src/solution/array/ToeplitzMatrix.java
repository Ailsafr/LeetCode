package solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2019-01-23
 * Easy
 * Question 766:Toeplitz Matrix.
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * Example 1:
 * Input:
	matrix = [
	  [1,2,3,4],
	  [5,1,2,3],
	  [9,5,1,2]
	]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * Example 2:
 * Input:
	matrix = [
	  [1,2],
	  [2,2]
	]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * Note:
 * 1.matrix will be a 2D array of integers.
 * 2.matrix will have a number of rows and columns in range [1, 20].
 * 3.matrix[i][j] will be integers in range [0, 99].
 * Follow up:
 * 1.What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
 * 2.What if the matrix is so large that you can only load up a partial row into the memory at once?
 * Hint:
 * Check whether each value is equal to the value of it's top-left neighbor.
 */
public class ToeplitzMatrix {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(1)
	 * @param matrix
	 * @return
	 */
	public static boolean isToeplitzMatrix(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		if(m==1||n==1){
			return true;
		}
		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				if(matrix[i][j]!=matrix[i-1][j-1]){
					return false;
				}
			}
		}
		return true;
    }
	
	/**
	 * 答案1--Group by Category[Accepted]
	 * 时间复杂度：O(m*n) 
	 * 空间复杂度：O(m+n)
	 * @param matrix
	 * @return
	 */
	public boolean isToeplitzMatrix1(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r-c))
                    groups.put(r-c, matrix[r][c]);
                else if (groups.get(r-c) != matrix[r][c])
                    return false;
            }
        }
        return true;
    }
	
	/**
	 * 答案2--Compare With Top-Left Neighbor[Accepted]
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(1)
	 * @param matrix
	 * @return
	 */
	public boolean isToeplitzMatrix2(int[][] matrix){
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		System.out.println(isToeplitzMatrix(matrix));
	}

}

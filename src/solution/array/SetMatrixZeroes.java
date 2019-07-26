package solution.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-07-26
 * Medium
 * Question 73:Set Matrix Zeroes.
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * Example 1:
 * Input: 
	[
	  [1,1,1],
	  [1,0,1],
	  [1,1,1]
	]
 * Output: 
	[
	  [1,0,1],
	  [0,0,0],
	  [1,0,1]
	]
 * Example 2:
 * Input: 
	[
	  [0,1,2,0],
	  [3,4,5,2],
	  [1,3,1,5]
	]
 * Output: 
	[
	  [0,0,0,0],
	  [0,4,5,0],
	  [0,3,1,0]
	]
 * Follow up:
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * Hint:
 * 1. If any cell of the matrix has a zero we can record its row and column number using additional memory. 
 * 	  But if you don't want to use extra memory then you can manipulate the array instead. i.e. simulating exactly what the question says.
 * 2. Setting cell values to zero on the fly while iterating might lead to discrepancies. What if you use some other integer value as your marker? 
 *    There is still a better approach for this problem with 0(1) space.
 * 3. We could have used 2 sets to keep a record of rows/columns which need to be set to zero. 
 *    But for an O(1) space solution, you can use one of the rows and and one of the columns to keep track of this information.
 * 4. We can use the first cell of every row and column as a flag. This flag would determine whether a row or column has been set to zero.
 */
public class SetMatrixZeroes {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(m+n)
	 * @param matrix
	 * @return
	 */
	public static void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[] rowzero = new boolean[row];
		boolean[] colzero = new boolean[col];
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
        		if(matrix[i][j]==0){
        			rowzero[i] = true;
        			colzero[j] = true;
        		}
        	}
        }
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
        		if(rowzero[i]||colzero[j]){
        			matrix[i][j] = 0;
        		}
        	}
        }
    }
	
	/**
	 * 答案1--Additional Memory Approach
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(m+n)
	 * @param matrix
	 * @return
	 */
	public void setZeroes1(int[][] matrix) {
	    int R = matrix.length;
	    int C = matrix[0].length;
	    Set<Integer> rows = new HashSet<Integer>();
	    Set<Integer> cols = new HashSet<Integer>();
	    // Essentially, we mark the rows and columns that are to be made zero
	    for (int i = 0; i < R; i++) {
	    	for (int j = 0; j < C; j++) {
	    		if (matrix[i][j] == 0) {
	    			rows.add(i);
	    			cols.add(j);
	    		}
	    	}
	    }
	    // Iterate over the array once again and using the rows and cols sets, update the elements.
	    for (int i = 0; i < R; i++) {
	    	for (int j = 0; j < C; j++) {
	    		if (rows.contains(i) || cols.contains(j)) {
	    			matrix[i][j] = 0;
	    		}
	    	}
	    }
	}
	
	/**
	 * 答案2--Brute O(1) space
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(1)
	 * @param matrix
	 * @return
	 */
	public void setZeroes2(int[][] matrix) {
	    int MODIFIED = -1000000;
	    int R = matrix.length;
	    int C = matrix[0].length;
	    for (int r = 0; r < R; r++) {
	    	for (int c = 0; c < C; c++) {
		        if (matrix[r][c] == 0) {
			    	// We modify the corresponding rows and column elements in place.
			    	// Note, we only change the non zeroes to MODIFIED
			    	for (int k = 0; k < C; k++) {
				    	if (matrix[r][k] != 0) {
				        	matrix[r][k] = MODIFIED;
				        }
			        }
			        for (int k = 0; k < R; k++) {
			            if (matrix[k][c] != 0) {
			                matrix[k][c] = MODIFIED;
			            }
			        }
			    }
	    	}
	    }
	    for (int r = 0; r < R; r++) {
	    	for (int c = 0; c < C; c++) {
	    		// Make a second pass and change all MODIFIED elements to 0 """
	    		if (matrix[r][c] == MODIFIED) {
	    			matrix[r][c] = 0;
	    		}
	    	}
	    }
	}
	
	/**
	 * 答案3--O(1) Space, Efficient Solution
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(1)
	 * @param matrix
	 * @return
	 */
	public void setZeroes3(int[][] matrix) {
	    Boolean isCol = false;
	    int R = matrix.length;
	    int C = matrix[0].length;

	    for (int i = 0; i < R; i++) {

	    	// Since first cell for both first row and first column is the same i.e. matrix[0][0]
	    	// We can use an additional variable for either the first row/column.
	    	// For this solution we are using an additional variable for the first column
	    	// and using matrix[0][0] for the first row.
	    	if (matrix[i][0] == 0) {
	    		isCol = true;
	    	}

	    	for (int j = 1; j < C; j++) {
	    		// If an element is zero, we set the first element of the corresponding row and column to 0
	    		if (matrix[i][j] == 0) {
	    			matrix[0][j] = 0;
	    			matrix[i][0] = 0;
	    		}
	    	}
	    }

	    // Iterate over the array once again and using the first row and first column, update the elements.
	    for (int i = 1; i < R; i++) {
	    	for (int j = 1; j < C; j++) {
	    		if (matrix[i][0] == 0 || matrix[0][j] == 0) {
	    			matrix[i][j] = 0;
	    		}
	    	}
	    }

	    // See if the first row needs to be set to zero as well
	    if (matrix[0][0] == 0) {
	    	for (int j = 0; j < C; j++) {
	    		matrix[0][j] = 0;
	    	}
	    }

	    // See if the first column needs to be set to zero as well
	    if (isCol) {
	    	for (int i = 0; i < R; i++) {
	    		matrix[i][0] = 0;
	    	}
	    }
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		setZeroes(matrix);
		System.out.println(matrix);
	}

}

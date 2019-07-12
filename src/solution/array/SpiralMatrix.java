package solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-07-12
 * Medium
 * Question 54:Spiral Matrix.
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * Example 1:
 * Input:
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * Input:
	[
	  [1, 2, 3, 4],
	  [5, 6, 7, 8],
	  [9,10,11,12]
	]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7].
 */
public class SpiralMatrix {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param matrix
	 * @return
	 */
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		int row = matrix.length;
		if(row==0){
			return result;
		}
		int columns = matrix[0].length;
		boolean[][] array = new boolean[row][columns];
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		int r = 0;
		int c = 0;
		int di = 0;
		for(int i=0;i<row*columns;i++){
			result.add(matrix[r][c]);
			array[r][c] = true;
			int cr = r + dr[di];
			int cc = c + dc[di];
			if(cr<row&&cc<columns&&cr>=0&&cc>=0&&!array[cr][cc]){
				r = cr;
				c = cc;
			}else{
				di = (di+1)%4;
				r = r + dr[di];
				c = c + dc[di];
			}
		}
		return result;
    }
	
	/**
	 * 答案1--Simulation
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n) 
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder1(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
	
	/**
	 * 答案2--Layer-by-Layer
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n) 
	 * @param matrix
	 * @return
	 */
	public List < Integer > spiralOrder2(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println(spiralOrder(matrix));
	}

}

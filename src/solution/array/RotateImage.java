package solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-07-09
 * Medium
 * Question 48:Rotate Image.
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
 * DO NOT allocate another 2D matrix and do the rotation.
 * Example 1:
 * Given input matrix = 
	[
	  [1,2,3],
	  [4,5,6],
	  [7,8,9]
	],
 * rotate the input matrix in-place such that it becomes:
	[
	  [7,4,1],
	  [8,5,2],
	  [9,6,3]
	]
 * Example 2:
 * Given input matrix =
	[
	  [ 5, 1, 9,11],
	  [ 2, 4, 8,10],
	  [13, 3, 6, 7],
	  [15,14,12,16]
	], 
 * rotate the input matrix in-place such that it becomes:
	[
	  [15,13, 2, 5],
	  [14, 3, 4, 1],
	  [12, 6, 8, 9],
	  [16, 7,10,11]
	]
 */
public class RotateImage {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param matrix
	 * @return
	 */
	public static void rotate(int[][] matrix) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = matrix.length;
		for(int j=0;j<len;j++){
			List<Integer> row = new ArrayList<Integer>();
			for(int i=len-1;i>=0;i--){
				row.add(matrix[i][j]);
			}
			result.add(row);
		}
		for(int i=0;i<len;i++){
			List<Integer> list = result.get(i);
			for(int j=0;j<len;j++){
				matrix[i][j] = list.get(j);
			}
		}
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param matrix
	 * @return
	 */
	public void rotate1(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param matrix
	 * @return
	 */
	public void rotate2(int[][] matrix) {
	    int n=matrix.length;
	    for (int i=0; i<n/2; i++) {
	        for (int j=i; j<n-i-1; j++) {
	            int tmp=matrix[i][j];
	            matrix[i][j]=matrix[n-j-1][i];
	            matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
	            matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
	            matrix[j][n-i-1]=tmp;
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		System.out.println(matrix);
	}

}

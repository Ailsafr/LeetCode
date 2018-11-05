package solution.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2018-11-05
 * Easy
 * Question 566:Reshape the Matrix.
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * You're given a matrix represented by a two-dimensional array, 
 * and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * Example 1:
 * Input: 
 * nums = 
		[[1,2],
		 [3,4]]
 * r = 1, c = 4
 * Output: 
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 * Example 2:
 * Input: 
 * nums = 
		[[1,2],
		 [3,4]]
 * r = 2, c = 4
 * Output: 
		[[1,2],
		 [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * Note:
 * 1.The height and width of the given matrix is in range [1, 100].
 * 2.The given r and c are all positive.
 * Hint:
 * 1.Do you know how 2d matrix is stored in 1d memory? Try to map 2-dimensions into one.
 * 2.M[i][j]=M[n*i+j] , where n is the number of cols. This is the one way of converting 2-d indices into one 1-d index. Now, how will you convert 1-d index into 2-d indices?
 * 3.Try to use division and modulus to convert 1-d index into 2-d indices.
 * 4.M[i] => M[n/i][n%i] Will it result in right mapping? Take some example and check this formulae.
 */
public class ReshapeTheMatrix {

	/**
	 * 我自己写的方法 
	 * 时间复杂度：O(m*n) 
	 * 空间复杂度：O(m*n)
	 * @param nums
	 * @param r
	 * @param c
	 * @return
	 */
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		if(nums==null||nums.length==0){
			return nums;
		}
		int[] num = nums[0];
		int l = nums.length;
		int g = num.length;
		if(l*g!=r*c){
			return nums;
		}
		int[][] result = new int[r][c];
		int n=0;
		for(int i=0;i<l;i++){
			for(int j=0;j<g;j++){
				result[n/c][n%c] = nums[i][j];
				n++;
			}
		}
		return result;
	}
	
	/**
	 * 答案1--Using queue [Accepted]
	 * 时间复杂度：O(m*n) 
	 * 空间复杂度：O(m*n)
	 * @param nums
	 * @param r
	 * @param c
	 * @return
	 */
	 public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        Queue < Integer > queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }
	
	/**
	 * 答案2--Without using extra Space [Accepted]
	 * 时间复杂度：O(m*n) 
	 * 空间复杂度：O(m*n)
	 * @param nums
	 * @param r
	 * @param c
	 * @return
	 */
	 public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int rows = 0, cols = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[rows][cols] = nums[i][j];
                cols++;
                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }
        return res;
    }
	
	/**
	 * 答案3--Using division and modulus [Accepted],跟我的答案一样
	 * 时间复杂度：O(m*n) 
	 * 空间复杂度：O(m*n)
	 * @param nums
	 * @param r
	 * @param c
	 * @return
	 */
	 public int[][] matrixReshape3(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[][] nums = {{1,2},{3,4}};
		int r=1;
		int c=4;
		System.out.println(matrixReshape(nums,r,c));
	}

}

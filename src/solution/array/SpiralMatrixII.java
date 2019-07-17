package solution.array;

/**
 * @author By RuiCUI
 * 2019-07-17
 * Medium
 * Question 59:Spiral Matrix II.
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * Example:
 * Input: 3
 * Output:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	].
 */
public class SpiralMatrixII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(n^2)
	 * @param n
	 * @return
	 */
	public static int[][] generateMatrix(int n) {
		int num = n * n;
		int i = 0;
		int j = 0;
		int[][] result = new int[n][n];
		int direction = 0;
		for(int k=1;k<=num;k++){
			result[i][j] = k;
			if(direction==0){
				j++;
				if(j==n||result[i][j]!=0){
					direction = 1;
					i++;
					j--;
				}
			}else if(direction==1){
				i++;
				if(i==n||result[i][j]!=0){
					direction = 2;
					i--;
					j--;
				}
			}else if(direction==2){
				j--;
				if(j==-1||result[i][j]!=0){
					direction = 3;
					i--;
					j++;
				}
			}else{
				i--;
				if(i==-1||result[i][j]!=0){
					direction = 0;
					i++;
					j++;
				}
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(n^2) 
	 * @param n
	 * @return
	 */
	public int[][] generateMatrix1(int n) {
        // Declaration
        int[][] matrix = new int[n][n];
        // Edge Case
        if (n == 0) {
            return matrix;
        }
        // Normal Case
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num = 1; //change
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = num ++; //change
            }
            rowStart ++;
            
            for (int i = rowStart; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num ++; //change
            }
            colEnd --;
            
            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num ++; //change
            }
            rowEnd --;
            
            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num ++; //change
            }
            colStart ++;
        }
        return matrix;
    }
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(generateMatrix(n));
	}

}
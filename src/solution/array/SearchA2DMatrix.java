package solution.array;

/**
 * @author By RuiCUI
 * 2019-07-29
 * Medium
 * Question 74:Search a 2D Matrix.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * Input:
 * matrix = [
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
 * target = 3
 * Output: true
 * Example 2:
 * Input:
 * matrix = [
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
 * target = 13
 * Output: false.
 */
public class SearchA2DMatrix {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		if(row==0){
			return false;
		}
		int col = matrix[0].length;
		if(col==0){
			return false;
		}
		int num = -1;
		if(matrix[0][0]>target||matrix[row-1][col-1]<target){
			return false;
		}
		for(int i=0;i<row;i++){
			if(matrix[i][0]==target){
				return true;
			}else if(matrix[i][0]>target){
				num = i - 1;
				break;
			}
		}
		if(num==-1){
			num = row - 1;
		}
		for(int i=0;i<col;i++){
			if(matrix[num][i]==target){
				return true;
			}
		}
		return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix1(int[][] matrix, int target) {
		int row_num = matrix.length;
		int col_num = matrix[0].length;
		int begin = 0, end = row_num * col_num - 1;
		while(begin <= end){
			int mid = (begin + end) / 2;
			int mid_value = matrix[mid/col_num][mid%col_num];
			
			if( mid_value == target){
				return true;
			
			}else if(mid_value < target){
				//Should move a bit further, otherwise dead loop.
				begin = mid+1;
			}else{
				end = mid-1;
			}
		}
		return false;
	}
	 
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10, 11, 16, 20},{23, 30, 34, 50}};
		int target = 13;
		System.out.println(searchMatrix(matrix, target));
	}
}

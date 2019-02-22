package solution.array;

/**
 * @author By RuiCUI
 * 2019-02-22
 * Easy
 * Question 832:Flipping an Image.
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * Example 1:
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 * 1. 1 <= A.length = A[0].length <= 20.
 * 2. 0 <= A[i][j] <= 1.
 */
public class FlippingAnImage {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n^2) n��A�ĳ��� 
	 * �ռ临�Ӷȣ�O(n^2)
	 * @param A
	 * @return
	 */
	public static int[][] flipAndInvertImage(int[][] A) {
		int len = A.length;
		int[][] result = new int[len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				result[i][j] = A[i][len-j-1]==0?1:0;
			}
		}
		return result;
    }
	
	/**
	 * ��--Direct[Accepted]
	 * ʱ�临�Ӷȣ�O(n) where n is the total number of elements in A.
	 * �ռ临�Ӷȣ�O(1) 
	 * @param A
	 * @return
	 */
	public int[][] flipAndInvertImage1(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }
        return A;
    }
	
	public static void main(String[] args) {
		int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
		System.out.println(flipAndInvertImage(A));
	}

}

package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2018-12-06
 * Easy
 * Question 661:Image Smoother.
 * Given a 2D integer matrix M representing the gray scale of an image, 
 * you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) 
 * of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
 * Example 1:
 * Input:
	[[1,1,1],
	 [1,0,1],
	 [1,1,1]]
 * Output:
	[[0, 0, 0],
	 [0, 0, 0],
	 [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * 1.The value in the given matrix is in the range of [0, 255].
 * 2.The length and width of the given matrix are in the range of [1, 150].
 */
public class ImageSmoother {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) n is the number of pixels in our image.
	 * 空间复杂度：O(n) n is the number of pixels in our image.
	 * @param M
	 * @return
	 */
	public static int[][] imageSmoother(int[][] M) {
		int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r-1; nr <= r+1; ++nr)
                    for (int nc = c-1; nc <= c+1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }
	
	/**
	 * 答案1--Iterate Through Grid
	 * 时间复杂度：O(n) n is the number of pixels in our image.
	 * 空间复杂度：O(n) n is the number of pixels in our image.
	 * @param M 
	 * @return
	 */
	public int[][] imageSmoother1(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r-1; nr <= r+1; ++nr)
                    for (int nc = c-1; nc <= c+1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }
	
	public static void main(String[] args) {
		int[][] M = {{1,1,1},{1,0,1},{1,1,1}};
		System.out.println(Arrays.toString(imageSmoother(M)));
	}

}

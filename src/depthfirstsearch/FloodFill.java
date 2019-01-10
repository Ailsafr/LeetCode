package depthfirstsearch;

/**
 * @author By RuiCUI
 * 2019-01-10
 * Easy
 * Question 733:Flood Fill.
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, 
 * and a pixel value newColor, "flood fill" the image.
 * To perform a "flood fill", consider the starting pixel, 
 * plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
 * plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. 
 * Replace the color of all of the aforementioned pixels with the newColor.
 * At the end, return the modified image.
 * Example 1:
 * Input: 
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: 
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 * 1.The length of image and image[0] will be in the range [1, 50].
 * 2.The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * 3.The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 * Hint:
 * Write a recursive function that paints the pixel if it's the correct color, then recurses on neighboring pixels.
 */
public class FloodFill {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) where n is the number of pixels in the image. 
	 * 空间复杂度：O(n) where n is the number of pixels in the image. 
	 * @param image
	 * @param sr
	 * @param sc
	 * @param newColor
	 * @return
	 */
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int color = image[sr][sc];
        if (color != newColor) helper(image, sr, sc, color, newColor);
        return image;
    }
    public static void helper(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) helper(image, r-1, c, color, newColor);
            if (c >= 1) helper(image, r, c-1, color, newColor);
            if (r+1 < image.length) helper(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) helper(image, r, c+1, color, newColor);
        }
	}
	
	/**
	 * 答案1--Depth-First Search[Accepted]
	 * 时间复杂度：O(n) where n is the number of pixels in the image. 
	 * 空间复杂度：O(n) where n is the number of pixels in the image. 
	 * @param image
	 * @param sr
	 * @param sc
	 * @param newColor
	 * @return
	 */
	public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }

	public static void main(String[] args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		//int[][] image = {{0,0,0},{0,0,0}};
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		System.out.println(floodFill(image,sr,sc,newColor));
	}

}

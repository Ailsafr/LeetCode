package solution.array;

/**
 * @author By RuiCUI
 * 2019-06-04
 * Medium
 * Question 11:Container With Most Water.
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
 * In this case, the max area of water (blue section) the container can contain is 49.
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49.
 */
public class ContainerWithMostWater {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(1)
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int result = 0;
		for(int i=0;i<height.length;i++){
			for(int j=i+1;j<height.length;j++){
				result = Math.max(result, (j-i)*Math.min(height[i], height[j]));
			}
		}
		return result;
    }
	
	/**
	 * 答案1--Brute Force
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(1)
	 * @param height
	 * @return
	 */
	public int maxArea1(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }
	
	/**
	 * 答案2--Two Pointer Approach
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param height
	 * @return
	 */
	public int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
	
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}

}

package solution.math;

/**
 * @author By RuiCUI
 * 2019-02-25
 * Easy
 * Question 836:Rectangle Overlap.
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, 
 * and (x2, y2) are the coordinates of its top-right corner.
 * Two rectangles overlap if the area of their intersection is positive.  
 * To be clear, two rectangles that only touch at the corner or edges do not overlap.
 * Given two (axis-aligned) rectangles, return whether they overlap.
 * Example 1:
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Notes:
 * 1.Both rectangles rec1 and rec2 are lists of 4 integers.
 * 2.All coordinates in rectangles will be between -10^9 and 10^9.
 */
public class RectangleOverlap {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param rec1
	 * @param rec2
	 * @return
	 */
	public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }
	
	/**
	 * 答案1--Check Position[Accepted]
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param rec1
	 * @param rec2
	 * @return
	 */
	public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                 rec1[3] <= rec2[1] ||   // bottom
                 rec1[0] >= rec2[2] ||   // right
                 rec1[1] >= rec2[3]);    // top
    }
	
	/**
	 * 答案2--Check Area[Accepted]
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param rec1
	 * @param rec2
	 * @return
	 */
	public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
    }
    
	public static void main(String[] args) {
		int[] rec1 = {0,0,1,1};
		int[] rec2 = {1,0,2,1};
		System.out.println(isRectangleOverlap(rec1,rec2));
	}

}

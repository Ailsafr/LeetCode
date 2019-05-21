package solution.math;

/**
 * @author By RuiCUI
 * 2019-05-20
 * Easy
 * Question 1037:Valid Boomerang.
 * A boomerang is a set of 3 points that are all distinct and not in a straight line.
 * Given a list of three points in the plane, return whether these points are a boomerang.
 * Example 1:
 * Input: [[1,1],[2,3],[3,2]]
 * Output: true
 * Example 2:
 * Input: [[1,1],[2,2],[3,3]]
 * Output: false
 * Note:
 * 1. points.length == 3
 * 2. points[i].length == 2
 * 3. 0 <= points[i][j] <= 100.
 * Hint:
 * 3 points form a boomerang if and only if the triangle formed from them has non-zero area.
 */
public class ValidBoomerang {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param points
	 * @return
	 */
	public static boolean isBoomerang(int[][] points) {
		double l1 = Math.sqrt(Math.abs(points[0][1]-points[1][1])*Math.abs(points[0][1]-points[1][1])+Math.abs(points[0][0]-points[1][0])*Math.abs(points[0][0]-points[1][0]));
		double l2 = Math.sqrt(Math.abs(points[0][1]-points[2][1])*Math.abs(points[0][1]-points[2][1])+Math.abs(points[0][0]-points[2][0])*Math.abs(points[0][0]-points[2][0]));
		double l3 = Math.sqrt(Math.abs(points[1][1]-points[2][1])*Math.abs(points[1][1]-points[2][1])+Math.abs(points[1][0]-points[2][0])*Math.abs(points[1][0]-points[2][0]));
		
		return l1+l2>l3&&l1+l3>l2&&l2+l3>l1;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param points
	 * @return
	 */
	public boolean isBoomerang1(int[][] points) {
        int[] a, b, c;
        a = points[0];
        b = points[1];
        c = points[2];
        if (a == b || b == c || c == a)
            return false;
        return !((b[1] - a[1]) * (c[0] - a[0]) == (c[1] - a[1]) * (b[0] - a[0]));
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param points
	 * @return
	 */
	public boolean isBoomerang2(int[][] points) {
        return (points[0][1] - points[1][1]) * (points[0][0] - points[2][0]) != (points[0][1] - points[2][1]) * (points[0][0] - points[1][0]);
    }
	
	public static void main(String[] args) {
		int[][] points = {{1,1},{2,2},{3,3}};
		System.out.println(isBoomerang(points));
	}

}

package solution.math;

/**
 * @author By RuiCUI
 * 2019-02-03
 * Easy
 * Question 812:Largest Triangle Area.
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation: 
 * The five points are show in the figure below. The red triangle is the largest.
 * Notes:
 * 1.3 <= points.length <= 50.
 * 2.No points will be duplicated.
 * 3.-50 <= points[i][j] <= 50.
 * 4.Answers within 10^-6 of the true value will be accepted as correct.
 */
public class LargestTriangleArea {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n^3)
	 * 空间复杂度：O(1)
	 * @param points
	 * @return
	 */
	public static double largestTriangleArea(int[][] points) {
		int N = points.length;
        double ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                for (int k = j+1; k < N; ++k)
                    ans = Math.max(ans, helper(points[i], points[j], points[k]));
        return ans;
    }
	public static double helper(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                             -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }
	
	
	/**
	 * 答案--Brute Force[Accepted]
	 * 时间复杂度：O(n^3)
	 * 空间复杂度：O(1)
	 * @param points
	 * @return
	 */
	public double largestTriangleArea1(int[][] points) {
        int N = points.length;
        double ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                for (int k = j+1; k < N; ++k)
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
        return ans;
    }

    public double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                             -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }
    
	public static void main(String[] args) {
		int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
		System.out.println(largestTriangleArea(points));
	}

}

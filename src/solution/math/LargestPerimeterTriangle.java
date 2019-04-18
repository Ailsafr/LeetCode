package solution.math;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2019-04-18
 * Easy
 * Question 976:Largest Perimeter Triangle.
 * Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
 * If it is impossible to form any triangle of non-zero area, return 0.
 * Example 1:
 * Input: [2,1,2]
 * Output: 5
 * Example 2:
 * Input: [1,2,1]
 * Output: 0
 * Example 3:
 * Input: [3,2,3,4]
 * Output: 10
 * Example 4:
 * Input: [3,6,2,3]
 * Output: 8
 * Note:
 * 1. 3 <= A.length <= 10000
 * 2. 1 <= A[i] <= 10^6.
 */
public class LargestPerimeterTriangle {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public static int largestPerimeter(int[] A) {
		Arrays.sort(A);
		int len = A.length;
		for(int i=len-1;i>1;i--){
			if(A[i]+A[i-1]>A[i-2]&&A[i]+A[i-2]>A[i-1]&&A[i-2]+A[i-1]>A[i]){
				return A[i]+A[i-1]+A[i-2];
			}
		}
		return 0;
    }
	
	/**
	 * 答案--Sort
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public int largestPerimeter1(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }
    
	public static void main(String[] args) {
		int[] A = {3,6,2,3};
		System.out.println(largestPerimeter(A));
	}

}

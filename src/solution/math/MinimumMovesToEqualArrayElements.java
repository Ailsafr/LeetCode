package solution.math;

import java.util.stream.IntStream;

/**
 * @author By RuiCUI
 * 2018-08-30
 * Easy
 * Question 453:Minimum Moves to Equal Array Elements.
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, 
 * where a move is incrementing n - 1 elements by 1.
 * Example:
 * Input:
 * [1,2,3]
 * Output:
 * 3
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinimumMovesToEqualArrayElements {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @return
	 */
	public static int minMoves(int[] nums) {
		if (nums.length == 0) return 0;
		int min = nums[0];
		for (int n : nums) min = Math.min(min, n);
		int res = 0;
		for (int n : nums) res += n - min;
		return res;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @return
	 */
	public int minMoves1(int[] nums) {
		if (nums.length == 0) return 0;
		int min = nums[0];
		for (int n : nums) min = Math.min(min, n);
		int res = 0;
		for (int n : nums) res += n - min;
		return res;
	}
	 
	/**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @return
	 */
	public int minMoves2(int[] nums) {
	    return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
	} 
	 
	public static void main(String[] args) {
		//int[] nums = {1,2,3};
		//int[] nums = {1,1,2147483647};
		int[] nums = {5,6,8,8,5};
		System.out.println(minMoves(nums));
	}

}

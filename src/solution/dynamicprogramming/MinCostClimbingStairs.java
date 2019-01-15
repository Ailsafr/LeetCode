package solution.dynamicprogramming;

/**
 * @author By RuiCUI
 * 2019-01-15
 * Easy
 * Question 746:Min Cost Climbing Stairs.
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps. 
 * You need to find minimum cost to reach the top of the floor, 
 * and you can either start from the step with index 0, or the step with index 1.
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * 1.cost will have a length in the range [2, 1000].
 * 2.Every cost[i] will be an integer in the range [0, 999].
 * Hint:
 * Say f[i] is the final cost to climb to the top from step i. Then f[i] = cost[i] + min(f[i+1], f[i+2]).
 */
public class MinCostClimbingStairs {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param cost
	 * @return
	 */
	public static int minCostClimbingStairs(int[] cost) {
		int len = cost.length;
		int[] result = new int[len];
		result[0] = cost[0];
		result[1] = cost[1];
		for(int i=2;i<len;i++){
			result[i] = cost[i] + Math.min(result[i-1], result[i-2]);
		}
		return Math.min(result[len-1],result[len-2]);
    }
	
	/**
	 * 答案1--Dynamic Programming[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param cost
	 * @return
	 */
	public int minCostClimbingStairs1(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
    
	public static void main(String[] args) {
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(cost));
	}

}

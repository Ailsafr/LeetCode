package solution.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author By RuiCUI
 * 2019-05-15
 * Easy
 * Question 1029:Two City Scheduling.
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], 
 * and the cost of flying the i-th person to city B is costs[i][1].
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 * Example 1:
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation: 
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 * Note:
 * 1. 1 <= costs.length <= 100
 * 2. It is guaranteed that costs.length is even.
 * 3. 1 <= costs[i][0], costs[i][1] <= 1000.
 */
public class TwoCityScheduling {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(1)
	 * @param costs
	 * @return
	 */
	public static int twoCitySchedCost(int[][] costs) {
	    Arrays.sort(costs, new Comparator<int[]>() {
	      @Override
	      public int compare(int[] o1, int[] o2) {
	        return o1[0] - o1[1] - (o2[0] - o2[1]);
	      }
	    });

	    int total = 0;
	    int n = costs.length / 2;
	    for (int i = 0; i < n; ++i) total += costs[i][0] + costs[i + n][1];
	    return total;
    }
	
	/**
	 * 答案--Greedy
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(1)
	 * @param costs
	 * @return
	 */
	public int twoCitySchedCost1(int[][] costs) {
	    // Sort by a gain which company has 
	    // by sending a person to city A and not to city B
	    Arrays.sort(costs, new Comparator<int[]>() {
	      @Override
	      public int compare(int[] o1, int[] o2) {
	        return o1[0] - o1[1] - (o2[0] - o2[1]);
	      }
	    });

	    int total = 0;
	    int n = costs.length / 2;
	    // To optimize the company expenses,
	    // send the first n persons to the city A
	    // and the others to the city B
	    for (int i = 0; i < n; ++i) total += costs[i][0] + costs[i + n][1];
	    return total;
	}
	
	public static void main(String[] args) {
		int[][] costs = {{33,135},{849,791},{422,469},{310,92},{253,489},{995,760},{852,197},{658,216},{679,945},{197,341},{362,648},{22,324},{408,25},{505,734},{463,279},{885,512},{922,850},{784,500},{557,860},{528,367},{877,741},{554,545},{598,888},{558,104},{426,427},{449,189},{113,51},{201,221},{251,62},{981,897},{392,519},{115,70},{961,109},{512,678},{476,708},{28,902},{763,282},{787,774},{925,475},{253,532},{100,502},{110,857},{822,942},{231,186},{869,491},{651,344},{239,806},{651,193},{830,360},{427,69},{776,875},{466,81},{520,959},{798,775},{875,199},{110,396}};
		System.out.println(twoCitySchedCost(costs));
	}

}

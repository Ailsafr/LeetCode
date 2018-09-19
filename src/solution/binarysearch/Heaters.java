package solution.binarysearch;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author By RuiCUI
 * 2018-09-19
 * Easy
 * Question 475:Heaters.
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * Now, you are given positions of houses and heaters on a horizontal line, 
 * find out minimum radius of heaters so that all houses could be covered by those heaters.
 * So, your input will be the positions of houses and heaters seperately, 
 * and your expected output will be the minimum radius standard of heaters.
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */
public class Heaters {

	/**
	 * 我自己写的方法，用的二分法
	 * 时间复杂度：O（nlogn）
	 * 空间复杂度：O(1)
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public static int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
            	index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
        
            result = Math.max(result, Math.min(dist1, dist2));
        }
        
        return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(1)
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public static int findRadius1(int[] houses, int[] heaters) {
		Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
        	index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
        
            result = Math.max(result, Math.min(dist1, dist2));
        }
        
        return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟上面的答案思路一样,只不过用了TreeSet
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(1)
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public int findRadius2(int[] houses, int[] heaters) {
        TreeSet<Integer> treeset = new TreeSet<>();
        for (int heater : heaters) treeset.add(heater);
        int res = 0;
        for (int house : houses) {
            Integer upper = treeset.ceiling(house); 
            Integer lower = treeset.floor(house);
            res = Math.max(res, Math.min(upper == null ? Integer.MAX_VALUE : upper - house, lower == null ? Integer.MAX_VALUE : house - lower));
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] houses = {1,2,3};
		int[] heaters = {2};
		System.out.println(findRadius(houses,heaters));
	}
	
}

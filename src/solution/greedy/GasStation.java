package solution.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-10-17
 * Medium
 * Question 134:Gas Station.
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * Note:
 * 1. If there exists a solution, it is guaranteed to be unique.
 * 2. Both input arrays are non-empty and have the same length.
 * 3. Each element in the input arrays is a non-negative integer.
 * Example 1:
 * Input: 
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * Example 2:
 * Input: 
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * Output: -1
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 */
public class GasStation {

	/**
	 * 我自己写的方法--Time Limit Exceeded
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param gas
	 * @param cost
	 * @return
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		Set<Integer> set = new HashSet<Integer>();
		int totalGas = 0;
		int totalCost = 0;
		for (int i=0;i<len;i++) {
			totalGas += gas[i];
			totalCost += cost[i];
			if (cost[i]<=gas[i]) {
				set.add(i);
			}
		}
		if (totalCost>totalGas) {
			return -1;
		}
		for (int i : set) {
			int start = i;
			int left = gas[i] - cost[i];
			while (true) {
				if (left<0) {
					break;
				}
				i++;
				if (i==len) {
					i = 0;
				} else if(i==start) {
					return i;
				}
				left = left + gas[i] - cost[i];
			}
		}
		return -1;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit1(int[] gas, int[] cost) {
	    int tank = 0;
	    for(int i = 0; i < gas.length; i++)
	        tank += gas[i] - cost[i];
	    if(tank < 0)
	        return - 1;
	        
	    int start = 0;
	    int accumulate = 0;
	    for(int i = 0; i < gas.length; i++){
	        int curGain = gas[i] - cost[i];
	        if(accumulate + curGain < 0){
	            start = i + 1;
	            accumulate = 0;
	        }
	        else accumulate += curGain;
	    }
	    
	    return start;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit2(int[] gas, int[] cost) {
	    for(int i = 0; i < gas.length; i++) {
	        gas[i] -= cost[i];
	    }
	    int sum = 0;
	    int result = 0;
	    int n = gas.length;
	    for(int i = 0; i < n * 2 - 1; i++) {
	        sum += gas[i % n];
	        if(sum < 0) {
	            result = i + 1;
	            if(result >= n) {
	                return -1;
	            }
	            sum = 0;
	        }
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		System.out.println(canCompleteCircuit(gas,cost));
	}

}

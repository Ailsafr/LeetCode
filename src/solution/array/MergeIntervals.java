package solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-07-16
 * Medium
 * Question 56:Merge Intervals.
 * Given a collection of intervals, merge all overlapping intervals.
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class MergeIntervals {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param intervals
	 * @return
	 */
	public static int[][] merge(int[][] intervals) {
		int len = intervals.length;
		if(len<2){
			return intervals;
		}
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		List<int[]> result = new ArrayList<int[]>();
		int[] tmp = new int[2];
		if(intervals[0][1]>=intervals[1][0]){
			tmp[0] = Math.min(intervals[0][0], intervals[1][0]);
			tmp[1] = Math.max(intervals[0][1], intervals[1][1]);
			result.add(tmp);
		}else{
			tmp[0] = intervals[0][0];
			tmp[1] = intervals[0][1];
			result.add(tmp);
			int[] tmp1 = new int[2];
			tmp1[0] = intervals[1][0];
			tmp1[1] = intervals[1][1];
			result.add(tmp1);
		}
		for(int i=1;i<len-1;i++){
			int[] temp = new int[2];
			int[] temp1 = new int[2];
			temp = result.get(result.size()-1);
			if(temp[1]>=intervals[i+1][0]){
				temp1[0] = Math.min(temp[0], intervals[i+1][0]);
				temp1[1] = Math.max(temp[1], intervals[i+1][1]);
				result.remove(result.size()-1);
			}else{
				temp1[0] = intervals[i+1][0];
				temp1[1] = intervals[i+1][1];
			}
			result.add(temp1);
		}
		
		return result.toArray(new int[result.size()][]);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n) 
	 * @param intervals
	 * @return
	 */
	public int[][] merge1(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;
		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}
	
	public static void main(String[] args) {
		//int[][] intervals = {{1,4},{2,6},{8,10},{15,18}};
		//int[][] intervals = {{1,4},{5,6},{8,10},{15,18}};
		int[][] intervals = {{1,4},{0,2},{3,5}};
		System.out.println(merge(intervals));
	}

}
package solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2019-05-07
 * Easy
 * Question 1010:Pairs of Songs With Total Durations Divisible by 60.
 * In a list of songs, the i-th song has a duration of time[i] seconds.
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
 * Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.
 * Example 1:
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 * Note:
 * 1. 1 <= time.length <= 60000
 * 2. 1 <= time[i] <= 500.
 * Hint:
 * 1. We only need to consider each song length modulo 60.
 * 2. We can count the number of songs with (length % 60) equal to r, and store that in an array of size 60.
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param time
	 * @return
	 */
	public static int numPairsDivisibleBy60(int[] time) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int n:time){
			map.put(n%60, map.getOrDefault(n%60, 0)+1);
		}
		int result = 0;
		for(int n:map.keySet()){
			int num = map.get(n);
			int rest = map.getOrDefault(60-n, 0);
			if(n==0||n==30){
				if(num>1){
					result += num*(num-1);
				}
			}else{
				result += num * rest;
			}
		}
		return result/2;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param time
	 * @return
	 */
	public int numPairsDivisibleBy601(int[] time) {
		int [] moduloDuration = new int[60];
		for(int i : time){
			moduloDuration[i % 60]++;
		}
		int count = 0;
		for(int i = 0; i <= moduloDuration.length / 2; i++){
			if(moduloDuration[i] == 0)
				continue;
			if(i == 0 || i == 30){
				int value = moduloDuration[i];
				count = count + ((value * (value - 1)) / 2);
			}
			else{
				count = count + (moduloDuration[i] * moduloDuration[60 - i]);
			}
				
		}
		return count;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param time
	 * @return
	 */
	public int numPairsDivisibleBy602(int[] time) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        for(int t:time)
        {
            int r=t%60;
            int f=(60-r)%60;
            res+=map.getOrDefault(f,0);
            map.put(r,map.getOrDefault(r,0)+1);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] time = {14,161,302,232,270,428,155,64,499,400,25,349,434,427,5,265,20,346,463,10,1,163,189,345,390,212,498,281,308,482,447,217,318,239,374,449,298,213,2,230,5,500,300,390,139,484,464,477,111,88,93,198,181,113,393,283,383,205,42,292,335,392,384,268,361,462,413,176,118,111,143,242,166,286,177,52,126,342,415,302,210,48,369,148,209,87,212,53,296,95,97,45,467,47,373,404,43,439,19,64,289,218,268,460,238,456,490,155,429,218,301,225,228,237,453,267,259,327,427,169,176,322,216,451,29,327,404,177,225,44,248,174,287,326,441,354,110,4,226,324,331,158,454,469,354,383,336,211,133,500,233,330,471,327,426,478,195,232,163,312,126,51,161,248,433,348,464,206,480,478,98,354,304,424,338,382,431,379,194,488,6,494,394,469,430,1,207,307,172,47,269,472,415,163,309,68,213,175,343,187,15,232,429,389,373,143,146,88,58,320,116,82,482,125,343,329,115,116,183,389,112,294,74,89,62};
		System.out.println(numPairsDivisibleBy60(time));
	}
}
